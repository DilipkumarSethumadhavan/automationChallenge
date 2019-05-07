# automationChallenge
Automation Framework


Step 1: 
I have used maven as my build tool use the below command

If using Eclipse:
compile test exec:java@generateCucumberReport -Dbrowser=firefox
compile test exec:java@generateCucumberReport -Dbrowser=chrome

If using command prompt:
Get in to the folder and use the below command
mvn compile test exec:java@generateCucumberReport -Dbrowser=firefox
mvn compile test exec:java@generateCucumberReport -Dbrowser=chrome

Inside target folder you can get the complete cucumber report
Reports:
automationChallenge/target/feature-overview/cucumber-html-reports/ 
Logs:
automationChallenge/logs/
