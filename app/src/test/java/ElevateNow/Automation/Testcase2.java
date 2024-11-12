package ElevateNow.Automation;
// package org.example;

// import java.time.Duration;
// import java.util.List;
// import java.util.Random;

// import org.openqa.selenium.Alert;
// import org.openqa.selenium.By;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.Test;

// import com.relevantcodes.extentreports.ExtentReports;
// import com.relevantcodes.extentreports.ExtentTest;
// import com.relevantcodes.extentreports.LogStatus;

// public class Testcase2 {
//      WebDriver driver;
//     static ExtentReports report;
//     static ExtentTest test;

 
//     public void setup(){
//         System.out.println("Initializing the driver");
//         //WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//                   // Extent Reports configuration
//                   report=new ExtentReports("/Users/indianrenters/Downloads/ElevateNow_Automationscripts/report/index.html",true);
//                  // test =report.startTest("ElevateNow Test Suite");
//        driver.manage().window().maximize();
//     }

//     public void tearDown(){
//         if (driver != null) {
//             driver.quit();
//         }
//         report.endTest(test);
//         report.flush();
//     }
//         private static final String[] QUESTIONS = {
//             "How often do you eat diet or healthy food?",
//             "What is your favorite type of exercise?",
//             "How many hours do you sleep on average?",
//             "Do you prefer home-cooked meals or eating out?",
//             "How often do you drink water throughout the day?",
//             "What is your go-to snack?",
//             "How do you manage stress in your daily life?",
//             "What motivates you to stay healthy?",
//             "How often do you visit a healthcare professional?",
//             "What is your favorite way to stay active?"
//         };
    
//         public static String getRandomQuestion() {
//             Random random = new Random();
//             int index = random.nextInt(QUESTIONS.length);
//             return QUESTIONS[index];
//         }
    
//     public void login() throws InterruptedException {
//         String mobileNumber="9643243200";
//         test = report.startTest("Login"); // Start the test
//         System.out.println("Start TestCase");
//     test.log(LogStatus.INFO,"Start testcase");
//         String loginUrl = "https://preweb.joinelevatenow.co.in/";
    
//           // Login phone number (consider using test data management)
       
      
//           test.log(LogStatus.INFO, "Navigating to Login URL: " + loginUrl);
//           driver.get(loginUrl);
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        
//         WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='form-control coreInput   undefined ']")));
//         phoneInput.sendKeys(mobileNumber);

//         // Wait for 30 seconds to manually enter the OTP
            
//             Thread.sleep(35000);
//             WebElement sendOtp=driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white false']"));
//             sendOtp.click();
//             Thread.sleep(3000);
//       WebElement Number1=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[1]"));
//                 Number1.sendKeys("5");
//                 WebElement Number2=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[2]"));  
//                 Number2.sendKeys("9");
//                 WebElement Number3=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[3]"));
//                 Number3.sendKeys("6");
//                 WebElement Number4=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[4]"));
//                 Number4.sendKeys("9");
//                 WebElement Number5=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[5]"));
//                 Number5.sendKeys("2");
//                 WebElement Number6=driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/input[6]"));
//                 Number6.sendKeys("1");
            
//             WebElement SignIn=driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white undefined']"));
//             SignIn.click();


// Thread.sleep(3000);

//         System.out.println("Login performed successfully");
//     }
//  public void RegimeQuestions() throws InterruptedException {
//         // Initialize the test report

//         test = report.startTest("add Regime Question"); // Start the test
//         test.log(LogStatus.INFO, "Starting the RegimeQuestions test");
    
//         driver.get("https://preweb.joinelevatenow.co.in/dashboard");
//         test.log(LogStatus.INFO, "Navigated to Dashboard");
//         Thread.sleep(3000);
    
//         driver.get("https://preweb.joinelevatenow.co.in/settings");
//         test.log(LogStatus.INFO, "Navigated to Settings");
//         Thread.sleep(3000);
    
//         WebElement mobileConfiguration = driver.findElement(By.xpath("//div[text()='Mobile Configurations']"));
//         mobileConfiguration.click();
//         test.log(LogStatus.INFO, "Clicked on Mobile Configurations");
//         Thread.sleep(2000);
    
//         driver.findElement(By.xpath("//div[text()='Regime Questions']")).click();
//         test.log(LogStatus.INFO, "Clicked on Regime Questions");
//         Thread.sleep(2000);
    
//         String question = getRandomQuestion();
//         WebElement question1 = driver.findElement(By.xpath("//*[@placeholder='Question']"));
//         question1.sendKeys(question);
//         test.log(LogStatus.INFO, "Entered Question: " + question);
//         question1.sendKeys(Keys.ENTER);
    
//         WebElement type = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/select"));
//         Select select = new Select(type);
//         select.selectByVisibleText("Text");
//         test.log(LogStatus.INFO, "Selected Type: Text");
    
//         WebElement attachGoal = driver.findElement(By.xpath("//span[text()='Attach goal']"));
//         attachGoal.click();
//         test.log(LogStatus.INFO, "Clicked on Attach goal");
//         Thread.sleep(2000);
//          Thread.sleep(2000);
//     driver.findElement(By.xpath(("//*[@placeholder='Search']"))).sendKeys("Weight");
//         List<WebElement> goals = driver.findElements(By.className("rs-highlight"));
//         for (WebElement goal : goals) {
//             if (goal.getText().equals("Weight")) {
//                 Thread.sleep(2000);
//                 goal.click();
//                 test.log(LogStatus.INFO, "Selected Goal: Weight");
//                 break;
//             }
//         }
//     Thread.sleep(1000);
//         WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
//         category.click();
//         test.log(LogStatus.INFO, "Clicked on Category");
//         Thread.sleep(2000);
    
//         List<WebElement> categories = driver.findElements(By.className("rs-picker-select-menu-item"));
//         for (WebElement cat : categories) {
//             if (cat.getText().equals("Diet")) {
//                 cat.click();
//                 test.log(LogStatus.INFO, "Selected Category: Diet");
//                 break;
//             }
//         }
    
//         WebElement save = driver.findElement(By.xpath("//div[text()='Save']"));
//         save.click();
//         test.log(LogStatus.INFO, "Clicked on Save");
//         Thread.sleep(3000);
    
//         WebElement edit = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/table/tbody[1]/tr[1]/td[2]/div/div[2]/div"));
//         edit.click();
//         test.log(LogStatus.INFO, "Clicked on Edit");
//         Thread.sleep(2000);
    
//         WebElement update = driver.findElement(By.xpath("//div[text()='Update']"));
//         update.click();
//         test.log(LogStatus.INFO, "Clicked on Update");
//         Thread.sleep(4000);
    
//         WebElement delete = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/table/tbody[1]/tr[1]/td[2]/div/div[3]/div"));
//         delete.click();
//         test.log(LogStatus.INFO, "Clicked on Delete");
//         Thread.sleep(2000);
    
//         Alert alert = driver.switchTo().alert();
//         String alertText = alert.getText();
//         test.log(LogStatus.INFO, "Alert Text: " + alertText);
//         alert.accept();
//         test.log(LogStatus.INFO, "Accepted the alert");
//         Thread.sleep(3000);
    
//         String questionText = getRandomQuestion();
//         WebElement question2 = driver.findElement(By.xpath("//*[@placeholder='Question']"));
//         question2.sendKeys(questionText);
//         test.log(LogStatus.INFO, "Entered Question: " + questionText);
//         question2.sendKeys(Keys.ENTER);
    
//         WebElement type1 = driver.findElement(By.xpath("//*[@class='form-select coreInput capitalize pointer mb-1']"));
//         Select select1 = new Select(type1);
//         select1.selectByVisibleText("Text");
//         test.log(LogStatus.INFO, "Selected Type: Text");
    
//         WebElement attachGoal1 = driver.findElement(By.xpath("//span[text()='Attach goal']"));
//         attachGoal1.click();
//         test.log(LogStatus.INFO, "Clicked on Attach goal");
//         Thread.sleep(2000);
//         driver.findElement(By.xpath(("//*[@placeholder='Search']"))).sendKeys("Post Meal Walk");
//         List<WebElement> goals1 = driver.findElements(By.className("rs-highlight"));
//         for (WebElement goal : goals1) {
//             if (goal.getText().contains("Post Meal Walk")) {
//                 Thread.sleep(2000);
//                 goal.click();
//                 test.log(LogStatus.INFO, "Selected Goal: Post Meal Walk");
//                 break;
//             }
//         }
//     Thread.sleep(2000);
//         WebElement category1 = driver.findElement(By.xpath("//span[text()='Category']"));
//         category1.click();
//         test.log(LogStatus.INFO, "Clicked on Category");
//         Thread.sleep(2000);
    
//         List<WebElement> categories1 = driver.findElements(By.className("rs-picker-select-menu-item"));
//         for (WebElement cat : categories1) {
//             if (cat.getText().equals("Diet")) {
//                 cat.click();
//                 test.log(LogStatus.INFO, "Selected Category: Diet");
//                 break;
//             }
//         }
    
//         WebElement save1 = driver.findElement(By.xpath("//div[text()='Save']"));
//         save1.click();
//         test.log(LogStatus.INFO, "Clicked on Save");
    
//         // Test completion log
//         test.log(LogStatus.INFO, "RegimeQuestions test completed successfully");
//     }
//     public void addRegimeTemplate() throws InterruptedException {
//         test = report.startTest("add Regime Template"); // Start the test
//         test.log(LogStatus.INFO, "Starting the addRegimeTemplate test");
    
//         driver.get("https://preweb.joinelevatenow.co.in/settings");
//         test.log(LogStatus.INFO, "Navigated to Settings");
//         Thread.sleep(3000);
    
//         driver.findElement(By.xpath("//div[text()='Mobile Configurations']")).click();
//         test.log(LogStatus.INFO, "Clicked on Mobile Configurations");
//         Thread.sleep(2000);
    
//         WebElement regimeTemplate = driver.findElement(By.xpath("//div[text()='Regime Templates']"));
//         regimeTemplate.click();
//         test.log(LogStatus.INFO, "Clicked on Regime Templates");
    
//         WebElement templateName = driver.findElement(By.xpath("//*[@placeholder='Regime Template Name']"));
//         templateName.sendKeys("Regime Template");
//         test.log(LogStatus.INFO, "Entered Regime Template Name: Regime Template");
//         templateName.sendKeys(Keys.ENTER);
    
//         WebElement selectQuestion = driver.findElement(By.xpath("//span[text()='Select Question']"));
//         selectQuestion.click();
//         test.log(LogStatus.INFO, "Clicked on Select Question");
//         Thread.sleep(2000);
    
//         WebElement search = driver.findElement(By.xpath("//*[@placeholder='Search']"));
//         search.sendKeys("Side Effects Faced by the Patient");
//         test.log(LogStatus.INFO, "Searched for Question: Side Effects Faced by the Patient");
//         search.sendKeys(Keys.ENTER);
//         Thread.sleep(2000);
    
//         WebElement add = driver.findElement(By.xpath("//div[text()='+ Add']"));
//         add.click();
//         test.log(LogStatus.INFO, "Added the selected question");
//         Thread.sleep(2000);
    
//         WebElement selectQuestion2 = driver.findElement(By.xpath("//*[@id='rs-:rb:-describe']"));
//         selectQuestion2.click();
//         test.log(LogStatus.INFO, "Clicked on the second Select Question");
//         Thread.sleep(2000);
    
//         WebElement search2 = driver.findElement(By.xpath("//*[@placeholder='Search']"));
//         search2.sendKeys("Water Intake Goal Achieved Last Week (# Days Last Week)");
//         test.log(LogStatus.INFO, "Searched for Question: Water Intake Goal Achieved Last Week (# Days Last Week)");
//         search2.sendKeys(Keys.ENTER);
//         Thread.sleep(2000);
    
//         driver.findElement(By.xpath("//div[text()='+ Add']")).click();
//         test.log(LogStatus.INFO, "Added the second selected question");
//         Thread.sleep(2000);
    
//         driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div/div[3]/div[2]/div/div/span")).click();
//         test.log(LogStatus.INFO, "Selected the regime template option");
//         Thread.sleep(2000);
    
//         WebElement save = driver.findElement(By.xpath("//div[text()='Save']"));
//         save.click();
//         test.log(LogStatus.INFO, "Clicked on Save");
//         Thread.sleep(6000);
    
//         WebElement edit = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/div[1]/div"));
//         edit.click();
//         test.log(LogStatus.INFO, "Clicked on Edit");
//         Thread.sleep(2000);
    
//         WebElement update = driver.findElement(By.xpath("//div[text()='Update']"));
//         update.click();
//         test.log(LogStatus.INFO, "Clicked on Update");
//         Thread.sleep(4000);
    
//         WebElement delete = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]/div[2]/div"));
//         delete.click();
//         test.log(LogStatus.INFO, "Clicked on Delete");
//         Thread.sleep(2000);
    
//         Alert alert = driver.switchTo().alert();
//         String alertText = alert.getText();
//         test.log(LogStatus.INFO, "Alert Text: " + alertText);
//         alert.dismiss();
//         test.log(LogStatus.INFO, "Dismissed the alert");
//         Thread.sleep(3000);
    
//         test.log(LogStatus.INFO, "addRegimeTemplate test completed successfully");
//     }
    


//     public void updateRegime() throws InterruptedException {
//         test = report.startTest("Update Regime Template"); // Start the test
//         test.log(LogStatus.INFO, "Starting the updateRegime test");
    
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
//         driver.get("https://preweb.joinelevatenow.co.in/dashboard");
//         test.log(LogStatus.INFO, "Navigated to Dashboard");
//         Thread.sleep(3000);
    
//         driver.get("https://preweb.joinelevatenow.co.in/patient");
//         test.log(LogStatus.INFO, "Navigated to Patient page");
//         Thread.sleep(3000);
    
//         // Extract patient count from UI (replace XPath if needed)
//         WebElement patientCountElement = driver.findElement(By.xpath("//div[contains(text(),'all patients (')]"));
//         String patientCountText = patientCountElement.getText();
//         String extractedPatientID = patientCountText.replaceAll("\\D+", ""); // Extracts the number only
//         test.log(LogStatus.INFO, "Extracted Patient ID: " + extractedPatientID);
    
//         int patientIDInt = Integer.parseInt(extractedPatientID);
//         String adjustedPatientID = String.valueOf(patientIDInt + 1953); // Adjust logic as needed
//         test.log(LogStatus.INFO, "Adjusted Patient ID: " + adjustedPatientID);
    
//         String patientDashboardUrl = "https://preweb.joinelevatenow.co.in/patient/" + adjustedPatientID + "/dashboard";
//         test.log(LogStatus.INFO, "Navigating to patient dashboard: " + patientDashboardUrl);
//         driver.get(patientDashboardUrl);
//         Thread.sleep(4000);
    
//         WebElement regime = driver.findElement(By.xpath("//div[text()='Regime Analysis/Report Card ']"));
//         regime.click();
//         test.log(LogStatus.INFO, "Clicked on Regime Analysis/Report Card");
//         Thread.sleep(2000);
    
//         WebElement report = driver.findElement(By.xpath("//button[text()=' Add Report Card']"));
//         report.click();
//         test.log(LogStatus.INFO, "Clicked on Add Report Card");
//         Thread.sleep(2000);
    
//         WebElement select = driver.findElement(By.xpath("//span[text()='Patient Weekly Coach Call Log']"));
//         select.click();
//         test.log(LogStatus.INFO, "Clicked on Select to choose a template");
//         Thread.sleep(2000);
    
//         List<WebElement> options = driver.findElements(By.className("rs-picker-select-menu-item"));
//         for (WebElement option : options) {
//             if (option.getText().equals("Regime Template")) {
//                 option.click();
//                 test.log(LogStatus.INFO, "Selected Regime Template");
//                 break;
//             }
//         }
    
//         Thread.sleep(2000);
    
//         WebElement answer = driver.findElement(By.xpath("//*[@id='panel0-panel']/div/div/div[1]/div[1]/div[1]/div[2]/div/div/textarea"));
//         answer.sendKeys("Twice a week");
//         test.log(LogStatus.INFO, "Entered answer: Twice a week");
//         Thread.sleep(1000);
    
//         WebElement recommendation = driver.findElement(By.xpath("//*[@id='panel0-panel']/div/div/div[1]/div[1]/div[1]/div[3]/div/div/textarea"));
//         recommendation.sendKeys("Daily");
//         test.log(LogStatus.INFO, "Entered recommendation: Daily");
//         // WebElement attachGoal = driver.findElement(By.xpath("//*[@id='panel0-panel']/div/div/div[1]/div[1]/div[1]/div[4]/div/div/div/div/div"));
//         // attachGoal.click();
//         // test.log(LogStatus.INFO, "Clicked on Attach Goal");
//         // Thread.sleep(2000);
    
//         // WebElement answer2 = driver.findElement(By.xpath("//*[@id='panel0-panel']/div/div/div[1]/div[2]/div[1]/div[2]/div/div/textarea"));
//         // answer2.sendKeys("Daily");
//         // test.log(LogStatus.INFO, "Entered answer for second question: Daily");
    
//         // WebElement recommendation2 = driver.findElement(By.xpath("//*[@id='panel0-panel']/div/div/div[1]/div[2]/div[1]/div[3]/div/div/textarea"));
//         // recommendation2.sendKeys("Very rarely");
//         // test.log(LogStatus.INFO, "Entered recommendation for second question: Very rarely");
//         // Thread.sleep(1000);
    
//         // driver.findElement(By.xpath("//div[text()='Attach Goal']")).click();
//         // test.log(LogStatus.INFO, "Clicked on Attach Goal for the second question");
//         Thread.sleep(2000);
    
//         WebElement saveDetails = driver.findElement(By.xpath("//div[text()='Save Details']"));
//         saveDetails.click();
//         test.log(LogStatus.INFO, "Clicked on Save Details");
//         Thread.sleep(2000);
    
//         driver.get(patientDashboardUrl);
//         test.log(LogStatus.INFO, "Navigated back to patient dashboard");
//         Thread.sleep(3000);
    
//         driver.findElement(By.xpath("//div[text()='Regime Analysis/Report Card ']")).click();
//         test.log(LogStatus.INFO, "Clicked on Regime Analysis/Report Card again");
//         Thread.sleep(2000);
    
//         WebElement downloadRegime = driver.findElement(By.xpath("//button[text()=' Download Regime']"));
//         downloadRegime.click();
//         test.log(LogStatus.INFO, "Clicked on Download Regime");
//         Thread.sleep(10000);
    
//         test.log(LogStatus.INFO, "updateRegime test completed successfully");
//     }
//     @Test(description="Testcase for regime Template")
//     public void testCase2() throws InterruptedException{
    
//         Testcase2 test=new Testcase2();
//         test.setup();
//         Thread.sleep(2000);
//         test.login();
//         Thread.sleep(2000);
//         test.RegimeQuestions();
//         Thread.sleep(2000);
//         test.addRegimeTemplate();
//         Thread.sleep(2000);
//         test.updateRegime();
//         Thread.sleep(2000);
//         test.tearDown();
//             }
//         }
