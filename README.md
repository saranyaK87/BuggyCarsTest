
# buggycarsrating
A test only project to perform automated testing on web application https://buggy.justtestit.org/

## Description

Buggy Cars Rating is an online web application that displays cars. Lets the user vote their favourite car and model. 
Popular Make, Popular Model and the Overall Rating and features for each model. 
User has a provision to rate the model that they like and add comments if need to. 
User needs to be registered to be able to login and cast their votes. User can vote for more than one model. 

Test automation has been performed using Selenium WebDriver and the scripts are written using Java.

## Technologies

Selenium Webdriver - Browser automation framework  
Java - Programming Language  
TestNG - Testing Framework  
Maven - Build automation tool  
SauceLab - Testing Platform
Jenkins - CICD Pipeline

## Design Patterns

Page Object Model  
Java Builder Pattern

## Maven Dependencies

selenium-java 4.9.0  
testng 7.7.1  

## Tools Installation

### 1. Java JDK  

Download and install latest JDK version (for windows 64-bit if using windows) from https://www.oracle.com/java/technologies/downloads/  

#### Environment variables:    
Set JAVA_HOME to the location of the jdk folder [example: C:\Java\jdk-20.0.1]  
Set PATH to %JAVA_HOME%\bin  

### 2. Intellij Community Edition

Download and install latest Intellij Community Edition version from https://www.jetbrains.com/idea/download/#section=windows  

### 3. Maven  

Download and extract latest Maven Binary zip archive version from https://maven.apache.org/download.cgi  

#### Environment variables:    
Set MAVEN_HOME to the location of the maven folder [example: C:\Maven\apache-maven-3.9.1]  
Set PATH to %MAVEN_HOME%\bin  

#### Cloning the project  

Clone this GitHub repository to your local machine using the following command:  

	$ git clone https://github.com/saranyaK87/buggycarsrating.git  

### Prerequisites to run the test 

Download chromedriver depending upon the chrome version from https://chromedriver.chromium.org/downloads  

Extract chromedriver.exe to the Intellij project folder "src/main/resources/drivers/chrome/"  

#### Configuration properties

Parameters required to run the tests are provided externally through a configuration file which is present in the Intellij Project folder under "config/config.properties"  

Example: appurl, username, password, firstname, lastname, gender, age, address, hobby etc.  

#### Running the test  

Execute the command to run all the tests in the project  

	$ mvn clean test  

Execute the command to run only one test in the project  

	$ mvn test -Dtest=RegisterPageTest    
  
#### View Test Results

Surfire Test reports gets generated in the following Intellij project folder "target\surefire-reports"  
 
Click on the "index.html" file in the above folder location to view the test report  
 
