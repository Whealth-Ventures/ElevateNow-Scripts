# ElevateNow-Scripts



Overview


This project is a Selenium-based automation suite designed to test the admin functionalities of the ElevateNow web application. The main functionalities covered include login, navigation to the dashboard, adding a new patient, and clicking on patient entries. The automation tests are implemented in Java using TestNG as the testing framework.



Prerequisites

Before you can run the tests, ensure you have the following installed on your machine:

Java Development Kit (JDK) 8 or higher
Gradle
Google Chrome browser
ChromeDriver executable compatible with your version of Chrome
Internet connection
Setup Instructions
Clone the Repository

git clone https://github.com/Whealth-Ventures/ElevateNow_Automation

cd ElevateNow

Install Dependencies

This project uses Gradle to manage dependencies. Ensure you have Gradle installed, then run:

bash

gradle clean build

This command will download and install the required dependencies.

WebDriver Manager

This project utilizes WebDriverManager to manage browser drivers automatically. No manual setup is needed for the ChromeDriver.

Project Structure

src/test/java/ElevateNow/AdminLoginPage.java: The main test class containing the automation scripts.

build.gradle: The Gradle configuration file containing dependencies and build configurations.

Test Descriptions
1. login()
Description: Verifies the login functionality.

Opens the login page.
Enters the phone number and waits for manual OTP input.
Asserts that the login redirects to the dashboard.


2. navigationToDashboard()
Description: Verifies navigation to the dashboard.

Directly navigates to the dashboard URL.


Asserts that the navigation was successful by checking the URL.
3. AddNewPatient()
Description: Adds a new patient entry.

Navigates to the patient addition page.
Fills out the form with patient details.
Submits the form and saves the details.

4. UserDetails()
Description: Verifies the newly added patient details.

Navigates to the patient list.
Selects the newly added patient and verifies their details.
Edits patient details and saves them.

5. AddPrescription()
Description: Adds prescription details for a patient.

Navigates to a patient's dashboard.
Adds new prescription details.


Running Tests
To run the tests, use the following command:
gradle clean test
Assertions and Wait Conditions
The code uses WebDriverWait to handle synchronization issues and ensure elements are available before interactions. Assertions are used to verify the expected outcomes at various steps:

WebDriverWait: Ensures elements are clickable or URLs are as expected.
Assertions: Verifies URLs and element states to ensure the correctness of each test step

