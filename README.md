# automationChallenge
Automation Framework
 
I have used maven as my build tool use the below command

If using Eclipse:

1) compile test exec:java@generateCucumberReport -Dbrowser=firefox
2) compile test exec:java@generateCucumberReport -Dbrowser=chrome

If using command prompt:

Get in to the folder and use the below command

1) mvn compile test exec:java@generateCucumberReport -Dbrowser=firefox
2) mvn compile test exec:java@generateCucumberReport -Dbrowser=chrome

Inside target folder you can get the complete cucumber report

Reports:
automationChallenge/target/feature-overview/cucumber-html-reports/

Logs:
automationChallenge/logs/
