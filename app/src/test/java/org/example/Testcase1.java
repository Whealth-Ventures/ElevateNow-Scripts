package org.example;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Testcase1 {
     WebDriver driver;
    String randomUsername;
    String patientID;
    String adjustedPatientID="889";
    static ExtentReports report;
    static ExtentTest test;

 
    public void setup(){
        System.out.println("Initializing the driver");
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
                  // Extent Reports configuration
                  report=new ExtentReports("/Users/indianrenters/Downloads/ElevateNow_Automationscripts/report/index.html",true);
                 // test =report.startTest("ElevateNow Test Suite");
       driver.manage().window().maximize();
    }

    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
        report.endTest(test);
        report.flush();
    }
     private String generateRandomString() {
        String[] firstNames = {
            "John", "Jane", "Alex", "Emily", "Michael", "Sarah", 
            "David", "Laura", "Robert", "Sophia", "James", "Olivia"
        };
        
        String[] lastNames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", 
            "Miller", "Davis", "Martinez", "Hernandez", "Lopez", "Gonzalez"
        };
        
        Random random = new Random();
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        
        return firstName + " " + lastName;
    }

    private String generateandomDoctor(){
        String[] name={"Dr.Testdoctor","Dr. test1","Dr. SampleTest","testignDoc","Dr.Testdoctor","Dr. SampleTest","NewDoctor"};

      
        Random random=new Random();
        String doctorName=name[random.nextInt(name.length)];
        return doctorName;
    }
 private String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        while (email.length() < 10) { // length of the random email string
            int index = random.nextInt(characters.length());
            email.append(characters.charAt(index));
        }
        return email.append("@gmail.com").toString();
    }

private String generateRandomMobileNumber() {
    Random random = new Random();
    StringBuilder mobileNumber = new StringBuilder("9"); // start with 9 for a 10 digit mobile number
    while (mobileNumber.length() < 10) {
        int digit = random.nextInt(10);
        mobileNumber.append(digit);
    }
    return mobileNumber.toString();
}
private static String generateRandomWeight() {
    Random random = new Random();
    int weight = 50 + random.nextInt(51); // Random weight between 50 and 100
    return String.valueOf(weight);
}
private static String generateRandomGender() {
    Random random = new Random();
    // Array of possible genders
    String[] genders = {"Male", "Female", "Other"};
    // Select a random gender from the array
    int index = random.nextInt(genders.length);
    return genders[index];
}
private static String generateRandomHeight() {
    Random random = new Random();
    int height = 150 + random.nextInt(51); // Random height between 150 and 200
    return String.valueOf(height);
}
private static String generateRandomText(int length) {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    Random random = new Random();
    StringBuilder randomText = new StringBuilder();

    while (randomText.length() < length) {
        int index = random.nextInt(characters.length());
        randomText.append(characters.charAt(index));
    }

    return randomText.toString();
}
private static String generateRandomAge() {
    Random random = new Random();
    int age = 18 + random.nextInt(48); // Random age between 18 and 65
    return String.valueOf(age);
}
    public void login() throws InterruptedException {
        String mobileNumber="9643243200";
        test = report.startTest("Login"); // Start the test
        System.out.println("Start TestCase");
    test.log(LogStatus.INFO,"Start testcase");
        String loginUrl = "https://staging.joinelevatenow.co.in/";
    
          // Login phone number (consider using test data management)
       
      
          test.log(LogStatus.INFO, "Navigating to Login URL: " + loginUrl);
          driver.get(loginUrl);
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='form-control coreInput   undefined ']")));
        phoneInput.sendKeys(mobileNumber);

        // Wait for 30 seconds to manually enter the OTP
            
            
            WebElement sendOtp=driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white false']"));
            sendOtp.click();
            Thread.sleep(3000);
      WebElement Number1=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[1]"));
                Number1.sendKeys("5");
                WebElement Number2=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[2]"));  
                Number2.sendKeys("9");
                WebElement Number3=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[3]"));
                Number3.sendKeys("6");
                WebElement Number4=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[4]"));
                Number4.sendKeys("9");
                WebElement Number5=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[5]"));
                Number5.sendKeys("2");
                WebElement Number6=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[6]"));
                Number6.sendKeys("1");
            
            WebElement SignIn=driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white undefined']"));
            SignIn.click();


Thread.sleep(3000);

        System.out.println("Login performed successfully");
    }
public void navigationToDashboard() throws InterruptedException {
    // Login URL (assuming successful login from previous test)
    test = report.startTest("navigation to patient dashboard"); // Start the test
    String dashboardUrl = "https://staging.joinelevatenow.co.in/dashboard";

    test.log(LogStatus.INFO, "Verifying navigation to dashboard: " + dashboardUrl);
    driver.get(dashboardUrl);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(dashboardUrl));
    test.log(LogStatus.PASS, "URL verified: " + dashboardUrl);

    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, dashboardUrl, "Navigation failed");
    test.log(LogStatus.PASS, "Assertion passed. Navigated to dashboard successfully");

    System.out.println("Navigated to the dashboard successfully"); // Can be removed if using ExtentReports logs
    }
    public void AddNewPatient()throws InterruptedException{
        randomUsername=generateRandomString();
        String randomEmail = generateRandomEmail();
        String randomMobileNumber = generateRandomMobileNumber();
        String randomgender=generateRandomGender();
        test = report.startTest("Adding new Patient entry"); // Start the test
    test.log(LogStatus.INFO, "Generating random patient details:");
    test.log(LogStatus.INFO, "- Username: " + randomUsername);
    test.log(LogStatus.INFO, "- Email: " + randomEmail);
    test.log(LogStatus.INFO, "- Mobile Number: " + randomMobileNumber);
        System.out.println("Navigating to patient url");
        Thread.sleep(3000);
 // Navigate to Patients page
 String patientUrl = "https://staging.joinelevatenow.co.in/patient";
 test.log(LogStatus.INFO, "Navigating to Patients URL: " + patientUrl);
 driver.get(patientUrl);
    
      Thread.sleep(5000);
      System.out.println("Clicking on add patient button");
      WebElement nElement=driver.findElement(By.xpath("//*[@class='reusableBtnActive  reusableBtn']"));
      nElement.click();
    driver.get("https://staging.joinelevatenow.co.in/patient/new");
    System.out.println("Adding new  patient entry");

    WebElement fullname=driver.findElement(By.xpath("//*[@placeholder='Full Name']"));
    fullname.sendKeys(randomUsername);
    test.log(LogStatus.INFO, "Entered Full Name: " + randomUsername);
    WebElement MobileNo=driver.findElement(By.xpath("//*[@placeholder='10 Digit Mobile Number']"));
    MobileNo.sendKeys(randomMobileNumber);
    test.log(LogStatus.INFO, "Entered Mobile Number: " + randomMobileNumber);
    WebElement Email=driver.findElement(By.xpath("//*[@placeholder='Email Address']"));
    Email.sendKeys(randomEmail);
    test.log(LogStatus.INFO, "Entered Email Address: " + randomEmail);
    WebElement gender=driver.findElement(By.xpath("//*[@class='rs-picker-toggle rs-btn rs-btn-default']"));
    gender.click();
    Thread.sleep(3000);
   
    test.log(LogStatus.INFO, "Opened Gender dropdown");

    List<WebElement> genders=driver.findElements(By.xpath("//*[@class='rs-picker-select-menu-item']"));
    for(WebElement elem:genders){
        if(elem.getText().contains(randomgender));
        elem.click();
        test.log(LogStatus.INFO, "Selected Male gender");
        break;
    }
    System.out.println("male selected");
    WebElement SaveDetails=driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white undefined']"));
    SaveDetails.submit();
    test.log(LogStatus.INFO, "Clicked Save Details button");
    Thread.sleep(5000);
    }
     public void UserDetails() throws InterruptedException{
        String patientAge=generateRandomAge();
        String patientheight=generateRandomHeight();
        String patientWeight=generateRandomWeight();

        System.out.println("Verifying the details of new added patient");
        String patientListUrl = "https://staging.joinelevatenow.co.in/patient";

        test.log(LogStatus.INFO, "Navigating to Patients page: " + patientListUrl);
        driver.get(patientListUrl);
       
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(patientListUrl));
    test = report.startTest("verify newly added patient"); // Start the test
    test.log(LogStatus.PASS, "Reached Patients page successfully");
     Thread.sleep(3000);
    // Extract patient count from UI (replace XPath if needed)
    WebElement patientCountElement = driver.findElement(By.xpath("//div[contains(text(),'all patients (')]"));
    String patientCountText = patientCountElement.getText();
    String extractedPatientID = patientCountText.replaceAll("\\D+", ""); // Extracts the number only
    try {
        int patientIDInt = Integer.parseInt(extractedPatientID);
        adjustedPatientID = String.valueOf(patientIDInt + 5); // Adjust logic as needed
        test.log(LogStatus.INFO, "Extracted patient ID: " + extractedPatientID);
        test.log(LogStatus.INFO, "Calculated adjusted patient ID: " + adjustedPatientID);
    } catch (NumberFormatException e) {
        test.log(LogStatus.ERROR, "Failed to extract patient ID from UI: " + e.getMessage());
    }
    List<WebElement> patients = driver.findElements(By.xpath("//a[@class='userName']"));
    if (patients != null && !patients.isEmpty()) {
        test.log(LogStatus.INFO, "Number of patients found: " + patients.size());
        for (WebElement patient : patients) {
            String patientText = patient.getText();
            
            if (randomUsername != null && patientText != null && patientText.contains(randomUsername)) {
                test.log(LogStatus.INFO, "Random Username: " + randomUsername);
                wait.until(ExpectedConditions.elementToBeClickable(patient)).click();
                test.log(LogStatus.INFO, "Clicked on patient: " + randomUsername);
                break;
            } else {
                if (patientText == null) {
                    test.log(LogStatus.ERROR, "Patient text is null.");
                }
                if (randomUsername == null) {
                    test.log(LogStatus.ERROR, "Random username is null.");
                }
            }
        }
    } else {
        test.log(LogStatus.ERROR, "No patients found or WebElement list is null.");
    }
        
    String patientDashboardUrl = "https://staging.joinelevatenow.co.in/patient/" + adjustedPatientID + "/dashboard";
    test.log(LogStatus.INFO, "Verifying navigation to patient dashboard: " + patientDashboardUrl);
    driver.get(patientDashboardUrl);
    wait.until(ExpectedConditions.urlToBe(patientDashboardUrl));
    test.log(LogStatus.PASS, "Reached patient dashboard successfully");

String doctorname=generateandomDoctor();
  WebElement assignDoctor=driver.findElement(By.xpath("//*[@placeholder='Assign Doctor/Health Coach']"));
  assignDoctor.sendKeys(doctorname);
  Thread.sleep(2000);
  WebElement doctor= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div[2]/div[1]/div[1]"));
  doctor.click();

Thread.sleep(3000);

  
    WebElement edit= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div[3]/div[1]/div/div"));
    edit.click();

driver.get("https://staging.joinelevatenow.co.in/patient/"+adjustedPatientID+"/baselining");
Thread.sleep(5000);
    //Navigation to the patient details
    WebElement patientdetails=driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div[1]/div[2]/div[2]/div[2]/div"));
    patientdetails.click();
   
    WebElement age=driver.findElement(By.xpath("//*[@placeholder='age']"));
    age.clear();
    age.sendKeys(patientAge);
    age.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Age");
    WebElement height=driver.findElement(By.xpath("//*[@placeholder='height']"));
    height.clear();
    height.sendKeys(patientheight);
    age.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Height");
   
    WebElement targetWeight=driver.findElement(By.xpath("//*[@placeholder='target weight']"));
    targetWeight.clear();
    targetWeight.sendKeys(patientWeight);
    age.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Weight");
    WebElement weight=driver.findElement(By.xpath("//*[@placeholder='start weight']"));
    weight.clear();
    weight.sendKeys(generateRandomWeight());
    test.log(LogStatus.INFO, "Weight");
  
    WebElement SaveDetails=driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white undefined']"));
    SaveDetails.submit();
    test.log(LogStatus.INFO, "Clicked Save Details button");
    Thread.sleep(5000);
    
}
 public void AddPrescription() throws InterruptedException, AWTException{
       // Login URL (assuming successful login from previous tests)
       String str1=generateRandomText(6);
       String str2=generateRandomText(10);
    String patientDashboardUrl = "https://staging.joinelevatenow.co.in/patient/" + adjustedPatientID + "/dashboard";
    test = report.startTest("add prescription"); // Start the test

    test.log(LogStatus.INFO, "Verifying navigation to patient dashboard: " + patientDashboardUrl);
    driver.get(patientDashboardUrl);


    //verify patient details
    WebElement patientName=driver.findElement(By.xpath("//*[@class='card-title capitalize']"));
    String patientNameText=patientName.getText();
    test.log(LogStatus.INFO, "Patient Name: " + patientNameText);
    System.out.println(patientNameText);
    Thread.sleep(2000);
    WebElement patientAge=driver.findElement(By.xpath("//*[@class='card-text capitalize']"));
    String patientAgeText=patientAge.getText();
    System.out.println(patientAgeText);
    Thread.sleep(2000);
    WebElement mobiledetails=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[2]/div[3]"));
    String mobileNumber= mobiledetails.getText();
    System.out.println(mobileNumber);
    Thread.sleep(2000);
    WebElement email=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[2]/div[4]"));
    String emailId=email.getText();
    System.out.println(emailId);
    Thread.sleep(2000);


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(patientDashboardUrl));
    test.log(LogStatus.PASS, "Reached patient dashboard successfully");
        WebElement prescription=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div[3]/div"));
                    // Create instance of Javascript executor
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("arguments[0].scrollIntoView(true);", prescription);
        Thread.sleep(2000);
        prescription.click();
        test.log(LogStatus.INFO, "Clicked on Prescriptions tab");
        WebElement newPresElement=driver.findElement(By.xpath("//*[@class='btn mt-3 btn-outline-primary']"));
        Thread.sleep(2000);
        // js.executeScript("arguments[0].scrollIntoView(true);", newPresElement);
        newPresElement.click();
        test.log(LogStatus.INFO, "Clicked on New Prescriptions tab");
        Thread.sleep(5000);

     // Select Doctor
    WebElement selectDoctorElement = driver.findElement(By.xpath("//span[text()='Select Doctor']"));
    Thread.sleep(2000);
    selectDoctorElement.click();
    test.log(LogStatus.INFO, "Clicked on Select Doctor dropdown");

    WebElement selectDoctor = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span"));
    Thread.sleep(2000);
    selectDoctor.click();
    test.log(LogStatus.INFO, "Selected doctor:");
     
      // Enter Diagnosis
    WebElement diagnosisField = driver.findElement(By.xpath("//*[@placeholder='Diagnosis']"));
    Thread.sleep(2000);
    diagnosisField.sendKeys(str1);
    test.log(LogStatus.INFO, "Entered Diagnosis: " +str1);

    // Select Medicine (consider using provided methods for selecting medicine)
    WebElement selectMedicineElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div/div"));
selectMedicineElement.click();

    WebElement searchMedicineField = driver.findElement(By.xpath("//*[@placeholder='Search']"));
    String medicineName = "Tablet Nida New Test";
    searchMedicineField.sendKeys(medicineName);
    searchMedicineField.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Entered medicine name: " + medicineName);
    // **Select medicine from search results (modify logic as needed)**
    Thread.sleep(2000);
    // Select Frequency (consider using provided methods for selecting frequency)
    WebElement frequencyElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/select"));
    Select frequencySelect = new Select(frequencyElement);
    frequencySelect.selectByVisibleText("Daily");
    test.log(LogStatus.INFO, "Selected Frequency: Daily");

    // Select Dosage (consider using provided methods for selecting dosage)
    WebElement dosageElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[4]/div/select"));
    Select dosageSelect = new Select(dosageElement);
    dosageSelect.selectByVisibleText("1");
    test.log(LogStatus.INFO, "Selected Dosage: 1");



    WebElement moreDetails= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[4]/div/div/textarea"));
    moreDetails.sendKeys(str2);
    test.log(LogStatus.INFO, "moredetails: "+ str2);
Thread.sleep(2000);
    WebElement SaveDetails = driver.findElement(By.xpath("//div[text()='Save Details']"));
    Thread.sleep(2000);
    SaveDetails.click();
    test.log(LogStatus.INFO, "click on the save button");
    Thread.sleep(5000);
   
   WebElement publiElement= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div[1]/div/div/div[1]/div[2]/div[5]/div/span"));
   Thread.sleep(2000);
   publiElement.click();
    //publish the report 
Thread.sleep(3000);
test.log(LogStatus.INFO, "click on publish element");
    WebElement publish =driver.findElement(By.xpath("//*[@class='rs-btn rs-btn-primary']"));
    publish.click();
    test.log(LogStatus.INFO, "click on publish button");
    //Alert handling
     // Switch the focus to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text of the alert (optional)
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);

        // Accept the alert (click OK)
        alert.accept();
        Thread.sleep(10000);
    
 driver.get("https://staging.joinelevatenow.co.in/patient/"+adjustedPatientID+"/dashboard");

    Thread.sleep(3000);
    }
    public void onboardingDate() throws Exception {
        test = report.startTest("onboardingDate"); // Start the test
        test.log(LogStatus.INFO, "Starting the onboardingDate test");
    
        Thread.sleep(3000);
        driver.get("https://staging.joinelevatenow.co.in/patient");
        test.log(LogStatus.INFO, "Navigated to the Patient page");
        Thread.sleep(3000);
    
        // Extract patient count from UI
        WebElement patientCountElement = driver.findElement(By.xpath("//div[contains(text(),'all patients (')]"));
        String patientCountText = patientCountElement.getText();
        test.log(LogStatus.INFO, "Extracted patient count text: " + patientCountText);
    
        String extractedPatientID = patientCountText.replaceAll("\\D+", ""); // Extracts the number only
        int patientIDInt = Integer.parseInt(extractedPatientID);
        String adjustedPatientID = String.valueOf(patientIDInt + 5); // Adjust logic as needed
    
        String patientDashboardUrl = "https://staging.joinelevatenow.co.in/patient/" + adjustedPatientID + "/dashboard";
        test.log(LogStatus.INFO, "Navigating to patient dashboard: " + patientDashboardUrl);
        driver.get(patientDashboardUrl);
        Thread.sleep(4000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div/div/span")).click();
        test.log(LogStatus.INFO, "Clicked on the calendar icon to select onboarding date");
        Thread.sleep(2000);
    
        List<WebElement> dates = driver.findElements(By.className("rs-calendar-table-cell-day"));
        for (WebElement element : dates) {
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
                test.log(LogStatus.INFO, "Selected onboarding date: " + element.getText());
                break;
            }
        }
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        test.log(LogStatus.INFO, "Clicked 'OK' to confirm the onboarding date");
    
        Alert alert = driver.switchTo().alert();
        alert.accept();
        test.log(LogStatus.INFO, "Accepted the alert confirming the onboarding date");
    
        Thread.sleep(2000);
        test.log(LogStatus.INFO, "onboardingDate test completed successfully");
    }

    @Test(description = "Testcase for adding prescription")
    public void testCase1() throws Exception{
    
Testcase1 test=new Testcase1();
test.setup();
test.login();
test.navigationToDashboard();
test.AddNewPatient();
test.UserDetails();
test.onboardingDate();
test.AddPrescription();
test.tearDown();
    }
}

