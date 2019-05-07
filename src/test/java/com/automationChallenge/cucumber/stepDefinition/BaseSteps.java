package com.automationChallenge.cucumber.stepDefinition;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automationChallenge.cucumber.pages.LoginPage;
import com.automationChallenge.cucumber.pages.OrderPage;
import com.automationChallenge.cucumber.pages.ViewOrderListPage;
import com.automationChallenge.cucumber.utility.WebDriverLibrary;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseSteps {
	public LoginPage loginPage = null;
	public OrderPage orderPage = null;
	public ViewOrderListPage viewOrderListPage = null;
	public WebDriverLibrary wdLibrary = new WebDriverLibrary();
	public WebDriver driver;
	public RuntimeOptions runtimeOptions = null;
	static final Logger logger = LogManager.getLogger(BaseSteps.class);

	public BaseSteps() {
		logger.info("Base steps constructor - started");
		driver = wdLibrary.getWebDriver();
		// Initialize page classes
		loginPage = new LoginPage(driver);
		orderPage = new OrderPage(driver);
		viewOrderListPage = new ViewOrderListPage(driver);
		RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(this.getClass());
		runtimeOptions = runtimeOptionsFactory.create();
		logger.info("Base steps constructor - finished");
	}	

	@Before
	public void logScenarioStartInfo(Scenario scenario) {
		logger.info("*********** Started running cucumber scenario -- " + scenario.getName() + " ***************");
	}
	
	@After
	public void embedScreenshot(Scenario scenario) throws IOException {
		logger.info("@After - started");
		if (scenario.isFailed()) {
			scenario.write("Current Page URL is: " + driver.getCurrentUrl());
			scenario.write(
					"Scenario '" + scenario.getName() + "' Failed on broswer : '" + wdLibrary.getBrowserName() + "'");
			try {
				BufferedImage bufferedImage = new AShot()// Library
						.shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver).getImage();
				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "png", byteOutputStream);
				byteOutputStream.flush();
				byte[] byteImage = byteOutputStream.toByteArray();
				byteOutputStream.close();
				scenario.embed(byteImage, "image/png");
			} catch (Exception e) {
				e.getMessage();
			}
			logger.info("@After - finished");
		}
		if (driver != null) {
			driver.quit();
		}
		logger.info("************* Finished running cucumber scenario -- " + scenario.getName() + " *****************");
	}
}
