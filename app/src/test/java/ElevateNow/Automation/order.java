package ElevateNow.Automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class order {
 ChromeDriver driver= new ChromeDriver();
 

String mobileNumber="9643243200";
String fullText="";

 @Test(priority=1)
public void setup() throws InterruptedException{
    driver=new ChromeDriver();
    driver.manage().window().maximize(); 
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
}
@Test(priority=2,groups="initialise")
public void login() throws InterruptedException{
    driver.get("https://preweb.joinelevatenow.co.in/");
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       
     WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='form-control coreInput   undefined ']")));
       phoneInput.sendKeys(mobileNumber);

       // Wait for 30 seconds to manually enter the OTP
           Thread.sleep(30000);
           
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

 
}

@Test(priority=3,dependsOnGroups="initialise")
public void addPrescription() throws InterruptedException{
    driver.get("https://preweb.joinelevatenow.co.in/patient");
    Thread.sleep(5000);
    // driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[1]/div/div[2]/a")).click();
    // Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@placeholder='Search a patient by name or mobile number']")).sendKeys("Jane Austen");
    Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"Patients-item-0\"]")).click();
Thread.sleep(4000);

    WebElement nameElement = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[1]/h5"));

// Get the full text, e.g., "Sophia Jones (53 Yrs)"
fullText = nameElement.getText();

// Extract just the name part before the parenthesis
String name = fullText.split(" \\(")[0];

// Print the name
System.out.println("Extracted Name: " + name);
 WebElement prescription=driver.findElement(By.xpath("//div[text()='Prescription']"));
                    // Create instance of Javascript executor
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("arguments[0].scrollIntoView(true);", prescription);
        Thread.sleep(2000);
        prescription.click();
      
        WebElement newPresElement=driver.findElement(By.xpath("//*[@class='btn mt-3 btn-outline-primary']"));
        Thread.sleep(2000);
        // js.executeScript("arguments[0].scrollIntoView(true);", newPresElement);
        newPresElement.click();

        Thread.sleep(5000);

     // Select Doctor
    WebElement selectDoctorElement = driver.findElement(By.xpath("//span[text()='Select Doctor']"));
    selectDoctorElement.click();
    Thread.sleep(2000);


    WebElement selectDoctor = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span"));
    Thread.sleep(2000);
    selectDoctor.click();

     
      // Enter Diagnosis
    WebElement diagnosisField = driver.findElement(By.xpath("//*[@placeholder='Diagnosis']"));
    Thread.sleep(2000);
    diagnosisField.sendKeys("obesity");


    // Select Medicine (consider using provided methods for selecting medicine)
    WebElement selectMedicineElement = driver.findElement(By.xpath("//span[text()='Search Medicine Name']"));
selectMedicineElement.click();
Thread.sleep(2000);

    WebElement searchMedicineField = driver.findElement(By.xpath("//*[@placeholder='Search']"));
    String medicineName = "Tablet Ayaan";
    searchMedicineField.sendKeys(medicineName);
    Thread.sleep(2000);
    // searchMedicineField.sendKeys(Keys.ENTER);
     Thread.sleep(4000);
//    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/span")).click();
    // **Select medicine from search results (modify logic as needed)**
    Thread.sleep(2000);
    // Select Frequency (consider using provided methods for selecting frequency)
    driver.findElement(By.xpath("//*[@placeholder='Course Duration ']")).sendKeys("30");
    Thread.sleep(2000);
    WebElement frequencyElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/select"));
    Select frequencySelect = new Select(frequencyElement);
    frequencySelect.selectByVisibleText("Daily");

driver.findElement((By.xpath("//label[text()='Morning']"))).click();

Thread.sleep(2000);
    // Select Dosage (consider using provided methods for selecting dosage)
    WebElement dosageElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[4]/div/select"));
    Select dosageSelect = new Select(dosageElement);
    dosageSelect.selectByVisibleText("1");
  



    WebElement moreDetails= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[4]/div/div/textarea"));
    moreDetails.sendKeys("details");
    
 
Thread.sleep(2000);
    WebElement SaveDetails = driver.findElement(By.xpath("//div[text()='Save Details']"));
    Thread.sleep(2000);
    SaveDetails.click();
    
    Thread.sleep(6000);
   
   WebElement publiElement= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div[1]/div/div/div[1]/div[2]/div[5]/div/span"));
   Thread.sleep(2000);
   publiElement.click();
   Thread.sleep(2000);
      WebElement publish =driver.findElement(By.xpath("//*[@class='rs-btn rs-btn-primary']"));
      Thread.sleep(2000);
    publish.click();
 
    //Alert handling
     // Switch the focus to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text of the alert (optional)
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
 
        // Accept the alert (click OK)
        alert.accept();
        Thread.sleep(10000);
}

@Test(priority=4,description="adding order for patient")
public void addOrder() throws InterruptedException{
    driver.get("https://preweb.joinelevatenow.co.in/orders");
    Thread.sleep(6000);
    driver.findElement(By.xpath("//div[text()='+ Add Order']")).click();
    Thread.sleep(4000);
    String name = fullText.split(" \\(")[0];
    driver.findElement(By.xpath("//input[@placeholder='Search a patient by name or mobile number']")).sendKeys(name);
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@id='Patients-item-0']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='addNewAddress']")).click();
     // Enter values in the Address fields
     driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/input")).sendKeys("1234 Elm Street");
   
     driver.findElement(By.xpath("//*[@placeholder='City']")).sendKeys("Metropolis");
     driver.findElement(By.xpath("//*[@placeholder='State']")).sendKeys("New York");
     driver.findElement(By.xpath("//*[@placeholder='Type Pincode']")).sendKeys("123456");

     // Select the address type (e.g., Home)
    //  WebElement homeType = driver.findElement(By.xpath("//button[text()='home']"));
    //  homeType.click();

     // Click on 'Save Address' button
     Thread.sleep(2000);
     WebElement saveAddressButton = driver.findElement(By.xpath("//button[text()='Save Address']"));
     saveAddressButton.click();

     System.out.println("New address added successfully!");
     Thread.sleep(2000);

     driver.findElement(By.xpath("//*[@name='address']")).click();
     Thread.sleep(2000);
     WebElement next=driver.findElement(By.xpath("//button[text()='Next']"));
     next.click();
     Thread.sleep(5000);
     String text="";
     text=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]")).getText();
     if(text.contains("Manual")){
        System.out.println("Source is manual");
     }
     else{
        System.out.println("Source is not manual");
     }

     driver.findElement(By.xpath("//div[text()='View Prescription']")).click();
     Thread.sleep(3000);
    String tabletName =driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[1]/div/div/div[5]/div/div[2]/div[1]/div[1]/span")).getText();
    System.out.println(tabletName);
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/button")).click();
    Thread.sleep(3000);
     driver.findElement(By.xpath("//span[text()='Select']")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/span")).click();
     Thread.sleep(3000);
     int previousQuantity = 0; // Track the last known quantity
     int currentQuantity;
     
     while (true) {
         // Click the "+" button to increment quantity
         driver.findElement(By.xpath("//button[text()='+']")).click();
         Thread.sleep(1000);
     

         // Get the updated quantity as an integer
         String quantity=driver.findElement(By.xpath("//span[@class='medicine-quant']")).getText();
         currentQuantity = Integer.parseInt(quantity);
     
         // Check if the quantity has stopped increasing
         if (currentQuantity == previousQuantity) {
             System.out.println("Limit reached: " + currentQuantity);
             break;
         }
     
         // Update previous quantity for the next iteration
         previousQuantity = currentQuantity;

}


Thread.sleep(4000);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement discountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Discount %']")));
discountInput.clear();
discountInput.sendKeys("20");
Thread.sleep(5000);
// String total=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[3]/div/div/div[5]/div[2]")).getText();
// System.out.println(total);
driver.findElement(By.xpath("//button[text()='Next']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//div[text()='Record Payment']")).click();
WebElement selectMode=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/select"));
Select select=new Select(selectMode);
select.selectByVisibleText("Online");
Thread.sleep(3000);
WebElement SelectForm=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/select"));
Select selectForm=new Select(SelectForm);
selectForm.selectByVisibleText("UPI");
Thread.sleep(3000);
WebElement paymentWith=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[4]/div/select"));
Select selectPayment=new Select(paymentWith);
selectPayment.selectByVisibleText("Elton");
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[6]/div/div")).click();
Thread.sleep(6000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[9]/button")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//span[text()='View Details']")).click();
Thread.sleep(5000);
String currentStatus=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/p/div/span")).getText();
System.out.println("Current Status: " +currentStatus);
String orderID=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[1]/div[1]")).getText();
System.out.println("Order ID: " +orderID);

Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[4]/table/tbody/tr/td[9]/div/div/div[1]/span")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[4]/table/tbody/tr/td[9]/div/div/div[2]/ul/li[3]/span")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[4]/table/tbody/tr/td[10]/button[1]")).click();
Thread.sleep(3000);
String UpdatedStatus=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/p/div/span")).getText();
System.out.println("Updated Status: "+UpdatedStatus);
Thread.sleep(8000);
driver.findElement(By.xpath("//button[text()='Download']")).click();
Thread.sleep(10000);
}

//Adding order history from patient dashboard
@Test(description = "Adding order history from patient dashboard",priority = 5)
public void addOrderfromDashboard() throws InterruptedException{
    driver.get("https://preweb.joinelevatenow.co.in/patient");
    Thread.sleep(5000);
    // driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[1]/div/div[2]/a")).click();
    // Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@placeholder='Search a patient by name or mobile number']")).sendKeys("Jane Austen");
    Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"Patients-item-0\"]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//div[text()='Order']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//div[text()='Add Order']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//*[@name='address']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[text()='Next']")).click();
Thread.sleep(4000);
String text=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]")).getText();
System.out.println("Source is : "+text);
Thread.sleep(4000);
driver.findElement(By.xpath("//div[text()='View Prescription']")).click();
Thread.sleep(4000);
String medicineName=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[1]/div/div/div[5]/div/div[2]/div[1]/div[1]/span")).getText();
System.out.println("Medicine Name is : "+medicineName);
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/button")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//span[text()='Select']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/span")).click();
Thread.sleep(4000);
WebElement addnewMedicine=driver.findElement(By.xpath("//button[text()='+ Add Another Medicine']"));
addnewMedicine.click();
Thread.sleep(4000);
driver.findElement(By.xpath("//*[@placeholder='Search medicine']")).sendKeys("Tablet");
Thread.sleep(8000);
//driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]/div/div[1]/div[2]/a[1]")).click();
//Thread.sleep(4000);
driver.findElement(By.xpath("//span[text()='Select']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//*[@placeholder='Discount %']")).sendKeys("20");

//verify the count as zero
while(true){
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[5]/button[1]")).click();
    break;

}
Thread.sleep(4000);
Thread.sleep(4000);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement discountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Discount %']")));
discountInput.clear();
discountInput.sendKeys("20");
Thread.sleep(5000);
// String total=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[3]/div/div/div[5]/div[2]")).getText();
// System.out.println(total);
// driver.findElement(By.xpath("//button[text()='Next']")).click();
// Thread.sleep(10000);
driver.findElement(By.xpath("//div[text()='Generate Link']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[text()='Copy Pay Link']")).click();
Alert alert=driver.switchTo().alert();
alert.accept();
Thread.sleep(7000);
driver.findElement(By.xpath("//button[text()='Save Order']")).click();
Thread.sleep(2000);
String currentStatus=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/p/div/span")).getText();
System.out.println("Current Status: " +currentStatus);
String orderID=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div/div[1]/div[1]")).getText();
System.out.println("Order ID: " +orderID);

Thread.sleep(8000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[4]/table/tbody/tr/td[9]/div/div/div[1]/span")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[4]/table/tbody/tr/td[9]/div/div/div[2]/ul/li[3]/span")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[4]/table/tbody/tr/td[10]/button[1]")).click();
Thread.sleep(3000);
String UpdatedStatus=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/p/div/span")).getText();
System.out.println("Updated Status: "+UpdatedStatus);
Thread.sleep(8000);
Thread.sleep(8000);
driver.findElement(By.xpath("//button[text()='Download']")).click();
Thread.sleep(10000);

}
 @AfterClass
    public void tearDown() {
      driver.close();
        driver.quit();
    }
}


