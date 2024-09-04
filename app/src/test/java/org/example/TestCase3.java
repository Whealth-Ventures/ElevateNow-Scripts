package org.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCase3 {
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
                  report=new ExtentReports("/Users/indianrenters/Downloads/ElevateNow_Automationscripts/report3/index.html",true);
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
 public void GoalCreations() throws InterruptedException{
        String settingsUrl = "https://staging.joinelevatenow.co.in/settings";
        Thread.sleep(3000);
        test = report.startTest("Goal Creation"); // Start the test
        test.log(LogStatus.INFO, "Verifying navigation to Settings: " + settingsUrl);
        driver.get(settingsUrl);
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(settingsUrl));
        test.log(LogStatus.PASS, "Reached Settings page successfully");
    
        // Click on Global Configuration
        WebElement globalConfigButton = driver.findElement(By.xpath("//div[text()='Global Configurations']"));
        Thread.sleep(2000);
        globalConfigButton.click();
        test.log(LogStatus.INFO, "Clicked on Global Configuration");
        Thread.sleep(3000);
        // Click on Goal Creation
        WebElement goalCreationButton = driver.findElement(By.xpath("//div[text()='Goal Creations']"));
        goalCreationButton.click();
        test.log(LogStatus.INFO, "Clicked on Goal Creation");

        Thread.sleep(3000);
    // Create a new Goal
    WebElement goalNameField = driver.findElement(By.xpath("//*[@placeholder='Goal Name']"));
    goalNameField.sendKeys("Test Goals New 1");
    test.log(LogStatus.INFO, "Entered Goal Name: Test Goals New 1");
    Thread.sleep(3000);
    WebElement goalTypeDropdown = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/select"));
    Select goalTypeSelect = new Select(goalTypeDropdown);
    goalTypeSelect.selectByVisibleText("Measuring");
    test.log(LogStatus.INFO, "Selected Goal Type: Measuring");
    Thread.sleep(3000);
    // Configure Goal details (measurement, frequency, time)
    WebElement measureEventButton = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[4]/div[1]/img"));
    measureEventButton.click();
    test.log(LogStatus.INFO, "Clicked on Measure Event button");
      
    WebElement valueField = driver.findElement(By.xpath("//*[@placeholder='Value']"));
    valueField.sendKeys("10");
    test.log(LogStatus.INFO, "Entered Value: 10");
    Thread.sleep(3000);
    WebElement frequencyDropdown = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[5]/div[3]/div/select"));
    Select frequencySelect = new Select(frequencyDropdown);
    frequencySelect.selectByVisibleText("Daily");
    test.log(LogStatus.INFO, "Selected Frequency: Daily");
    Thread.sleep(3000);
    WebElement timeDropdown =driver.findElement(By.xpath("//span[text()='Day Part']")); // Wait for dropdown
    Thread.sleep(3000);
    timeDropdown.click();
        // Wait for the dropdown options to be visible
        Thread.sleep(3000);   
    WebElement timeOption = driver.findElement(By.xpath("//span[text()='Morning Snacks (10:00 AM - 12:00 PM)']"));
    timeOption.click();
    test.log(LogStatus.INFO, "Selected Time: Morning Snacks (10:00 AM - 12:00 PM)");
    Thread.sleep(5000);

        WebElement save =driver.findElement(By.xpath("//div[text()='Save']"));
        Thread.sleep(1000);
        save.click();
        Thread.sleep(3000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/table/tr[1]/td[2]/div/div/div[2]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Update']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/table/tr[1]/td[2]/div/div/div[3]/div")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
     alert.dismiss();
     Thread.sleep(2000);


    }
//@Test(description = "Adding goal to patient dashboard",priority=7)
    public void addGoalToPatientDashboard() throws InterruptedException {
        test = report.startTest("addGoalToPatientDashboard"); // Start the test
        test.log(LogStatus.INFO, "Navigating to patient page");
        
        driver.get("https://staging.joinelevatenow.co.in/patient");
        Thread.sleep(3000);
        
        // Extract patient count from UI (replace XPath if needed)
        WebElement patientCountElement = driver.findElement(By.xpath("//div[contains(text(),'all patients (')]"));
        String patientCountText = patientCountElement.getText();
        String extractedPatientID = patientCountText.replaceAll("\\D+", ""); // Extracts the number only
        
        int patientIDInt = Integer.parseInt(extractedPatientID);
        String adjustedPatientID = String.valueOf(patientIDInt + 5); // Adjust logic as needed
        
        String patientDashboardUrl = "https://staging.joinelevatenow.co.in/patient/" + adjustedPatientID + "/dashboard";
        test.log(LogStatus.INFO, "Verifying navigation to patient dashboard: " + patientDashboardUrl);
        
        driver.get(patientDashboardUrl);
        Thread.sleep(4000);
        
        // Click to add a goal
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div[4]/div")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//button[text()=' Add Goal']")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//span[text()='Search Goal']")).click();
        Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Test_diet");
        List<WebElement> options = driver.findElements(By.className("rs-picker-select-menu-item"));
        boolean goalFound = false;
        for (WebElement option : options) {
            if (option.getText().contains("Test_diet")) {
                option.click();
                goalFound = true;
                test.log(LogStatus.INFO, "Selected goal: Test_diet");
                break;
            }
        }
        
        if (!goalFound) {
            test.log(LogStatus.FAIL, "Goal 'Test_diet' not found.");
        }
    

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div[5]/div")).click();
        Thread.sleep(3000);
        
        // Log success and end the test
        test.log(LogStatus.INFO, "Goal added successfully");
    }


 //@Test(description = "Adding diet plan",priority=8)
    public void addDietPlan() throws InterruptedException {
           // Login URL (assuming successful login from previous tests)
    String settingsUrl = "https://staging.joinelevatenow.co.in/settings";
    Thread.sleep(3000);
    test = report.startTest("addDietPlan"); // Start the test
    test.log(LogStatus.INFO, "Verifying navigation to Settings: " + settingsUrl);
    driver.get(settingsUrl);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(settingsUrl));
    test.log(LogStatus.PASS, "Reached Settings page successfully");
    WebElement mobileConfigButton = driver.findElement(By.xpath("//div[text()='Mobile Configurations']"));
    Thread.sleep(2000);
    mobileConfigButton.click();
    test.log(LogStatus.INFO, "Clicked on Mobile Configuration");
    Thread.sleep(3000);
         // Click on Diet Template
    WebElement dietTemplateButton = driver.findElement(By.xpath("//div[text()='Diet Templates']"));
    dietTemplateButton.click();
    test.log(LogStatus.INFO, "Clicked on Diet Template");
    Thread.sleep(3000);
    // Create a new Diet Plan
    WebElement dietPlanNameField = driver.findElement(By.xpath("//*[@placeholder='Diet Template Name']"));
    dietPlanNameField.sendKeys("Diet Plan Testing New one ");
    test.log(LogStatus.INFO, "Entered Diet Plan Name: Diet Plan Testing New one");
      // Configure Day Part 1 details (meal time, food, quantity, recipe)
    WebElement dayPart1Button = driver.findElement(By.xpath("//span[text()='Day Part']"));
    Thread.sleep(1000);
    dayPart1Button.click();
    test.log(LogStatus.INFO, "Clicked on Day Part 1 button");
    Thread.sleep(3000); 
    WebElement searchDayPartField = driver.findElement(By.xpath("//*[@placeholder='Search']"));
    searchDayPartField.sendKeys("Breakfast (6:30 AM - 10:00 AM)");
    searchDayPartField.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Searched for Day Part: Breakfast (6:30 AM - 10:00 AM)");
    Thread.sleep(3000);
    WebElement timeButton = driver.findElement(By.xpath("//span[text()='Time']"));
    timeButton.click();
    test.log(LogStatus.INFO, "Clicked on Time button");
    WebElement searchTimeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Search']")));  // Wait for search field
    searchTimeField.sendKeys("10:00 AM ");
    searchTimeField.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Searched for Time: 10:00 AM");
    Thread.sleep(3000);
    WebElement foodField = driver.findElement(By.xpath("//*[@placeholder='Food']"));
    foodField.sendKeys("Boiled eggs");
    foodField.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Added Food: Boiled eggs");
    Thread.sleep(3000);
    WebElement quantityField = driver.findElement(By.xpath("//*[@placeholder='Quantity']"));
    quantityField.sendKeys("2");
    quantityField.sendKeys(Keys.ENTER);
    test.log(LogStatus.INFO, "Entered Quantity: 2");
    Thread.sleep(3000);
WebElement savElement=driver.findElement(By.xpath("//div[text()='Save']"));
Thread.sleep(4000);
savElement.click();
test.log(LogStatus.INFO, "Click on Save Button");
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/div[1]/div")).click();
test.log(LogStatus.INFO, "Click on Edit Button");
Thread.sleep(3000);
driver.findElement(By.xpath("//div[text()='Update']")).click();
test.log(LogStatus.INFO, "Click on Update Button");
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/div[2]/div")).click();
test.log(LogStatus.INFO, "Click on Delete Button");
Alert alert=driver.switchTo().alert();
test.log(LogStatus.INFO, "Alert is displayed");
alert.dismiss();

}
//@Test(description="Adding diet plan to patient dashboard",priority = 9)
public void addDietPlanToPatient() throws InterruptedException {
     test = report.startTest("addDietPlanToPatient"); // Start the test
        test.log(LogStatus.INFO, "Navigating to patient page");
        
        driver.get("https://staging.joinelevatenow.co.in/patient");
        Thread.sleep(3000);
        
        // Extract patient count from UI (replace XPath if needed)
        WebElement patientCountElement = driver.findElement(By.xpath("//div[contains(text(),'all patients (')]"));
        String patientCountText = patientCountElement.getText();
        String extractedPatientID = patientCountText.replaceAll("\\D+", ""); // Extracts the number only
        
        int patientIDInt = Integer.parseInt(extractedPatientID);
        String adjustedPatientID = String.valueOf(patientIDInt + 5); // Adjust logic as needed
        
        String patientDashboardUrl = "https://staging.joinelevatenow.co.in/patient/" + adjustedPatientID + "/dashboard";
        test.log(LogStatus.INFO, "Verifying navigation to patient dashboard: " + patientDashboardUrl);
        
        driver.get(patientDashboardUrl);
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//div[text()='Diet Plan']")).click();
        test.log(LogStatus.INFO, "Click on Diet Plan Button");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//button[text()=' Add Diet Plan']")).click();
        test.log(LogStatus.INFO, "Click on Add Diet Plan Button");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div/div[1]/div[1]/img")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//*[@placeholder='weight']")).clear();
        driver.findElement(By.xpath("//*[@placeholder='weight']")).sendKeys("55");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[text()='Update']")).click();
        test.log(LogStatus.INFO, "Click on Update Button for weight");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div/div[2]/div[1]/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@placeholder='medical Conditions']")).clear();
        driver.findElement(By.xpath("//*[@placeholder='medical Conditions']")).sendKeys("obesity");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[text()='Update']")).click();
        test.log(LogStatus.INFO, "Click on Update Button for medical conditions");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div/div[3]/div[3]/div[1]/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@placeholder='Food Allergies']")).clear();
        driver.findElement(By.xpath("//*[@placeholder='Food Allergies']")).sendKeys("Milk products");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[text()='Update']")).click();
        test.log(LogStatus.INFO, "Click on Update Button for food allergies");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//span[text()='Select']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(("//*[@placeholder='Search']"))).sendKeys("Diet Plan Testing ");
        List<WebElement> options = driver.findElements(By.className("rs-highlight"));
        for (WebElement option : options) {
            if (option.getText().contains("Diet Plan Testing ")) {
                option.click();
                test.log(LogStatus.INFO, "Selected diet plan: Diet Plan Testing");
                break;
            }
        }
        
        Thread.sleep(2000);
        
        List<WebElement> days = driver.findElements(By.xpath("//*[@class='day ']"));
        for (WebElement day : days) {
            day.click();
            Thread.sleep(1000);
        }
        
        test.log(LogStatus.INFO, "Selected days for diet plan");
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//button[text()=' & Publish']")).click();
        test.log(LogStatus.INFO, "Click on Save and Publish Button");
        Thread.sleep(3000);
        
        // Log success and end the test
        test.log(LogStatus.INFO, "Diet plan added successfully");
        Thread.sleep(2000);
    }
    public void addNoteTemplate() throws Exception {
        test = report.startTest("add Note template"); // Start the test
        test.log(LogStatus.INFO, "Starting the addNoteTemplate test");
    
        driver.get("https://staging.joinelevatenow.co.in/settings");
        test.log(LogStatus.INFO, "Navigated to Settings page");
        Thread.sleep(3000);
    
        driver.findElement(By.xpath("//div[text()='Notes Categories']")).click();
        test.log(LogStatus.INFO, "Clicked on Notes Categories");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/input")).sendKeys("Testing");
        test.log(LogStatus.INFO, "Entered 'Testing' in the Notes Categories input");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//div[text()='Save']")).click();
        test.log(LogStatus.INFO, "Clicked on Save button");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/td[2]/div/div[2]/div[1]/div")).click();
        test.log(LogStatus.INFO, "Clicked on the first edit button");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/td[2]/div/div[2]/div[1]")).click();
        test.log(LogStatus.INFO, "Clicked on the second edit button");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/td[2]/div/div[2]/div[2]/div")).click();
        test.log(LogStatus.INFO, "Clicked on the delete button");
        Thread.sleep(2000);
    
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        test.log(LogStatus.INFO, "Alert Text: " + alertText);
        alert.accept();
        test.log(LogStatus.INFO, "Accepted the alert");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/input")).sendKeys("Testing");
        test.log(LogStatus.INFO, "Re-entered 'Testing' in the Notes Categories input");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//div[text()='Save']")).click();
        test.log(LogStatus.INFO, "Clicked on Save button again");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//div[text()='Notes Templates']")).click();
        test.log(LogStatus.INFO, "Clicked on Notes Templates");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//span[text()='Select Category']")).click();
        test.log(LogStatus.INFO, "Clicked on Select Category dropdown");
        Thread.sleep(2000);
    
        List<WebElement> oElements = driver.findElements(By.className("rs-picker-select-menu-item"));
        for (WebElement element : oElements) {
            if (element.getText().equals("Testing")) {
                element.click();
                test.log(LogStatus.INFO, "Selected 'Testing' category");
                break;
            }
        }
    
        driver.findElement(By.xpath("//*[@placeholder='Title']")).sendKeys("Sample testing");
        test.log(LogStatus.INFO, "Entered 'Sample testing' in the Title field");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@class='form-control coreInput textArea undefined undefined']")).sendKeys("sample test notes");
        test.log(LogStatus.INFO, "Entered 'sample test notes' in the notes text area");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        test.log(LogStatus.INFO, "Clicked on Save button for Notes Template");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/div[1]/div")).click();
        test.log(LogStatus.INFO, "Clicked on the first edit button for Notes Template");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@class='rs-btn rs-btn-primary']")).click();
        test.log(LogStatus.INFO, "Clicked on the primary button (Save)");
        Thread.sleep(2000);
    
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/div[2]/div")).click();
        test.log(LogStatus.INFO, "Clicked on the delete button for Notes Template");
        Thread.sleep(2000);
    
        alert.dismiss();
        test.log(LogStatus.INFO, "Dismissed the alert");
    
        test.log(LogStatus.INFO, "addNoteTemplate test completed successfully");
    }
    
   
    
    @Test(description="Adding goals,diet plan and notes to patient dashboard")
    public void testCase3() throws Exception{
    
        TestCase3 test=new TestCase3();
        test.setup();
        test.login();
        test.GoalCreations();
        test.addGoalToPatientDashboard();
        test.addDietPlan();
        test.addDietPlanToPatient();

        test.tearDown();
            }
        }
