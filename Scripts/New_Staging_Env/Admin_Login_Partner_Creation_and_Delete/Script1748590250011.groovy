import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://staging-admin.parkengage.com')

WebUI.waitForElementPresent(findTestObject('Login_Page_Objects/Email_Password_Field'), 10)

WebUI.setText(findTestObject('Login_Page_Objects/Email_Input_Field'), GlobalVariable.G_Email)

WebUI.setEncryptedText(findTestObject('Login_Page_Objects/Email_Password_Field'), 'Cqo1foBX0qbZ3A82kE6k0A==')

WebUI.click(findTestObject('Login_Page_Objects/Login_Submit_Button'))

WebUI.delay(15)

def dashboard_url = WebUI.getUrl()

print(dashboard_url)

WebUI.verifyEqual(dashboard_url, 'https://staging-admin.parkengage.com/admin/partners')

WebUI.waitForElementPresent(findTestObject('Login_Page_Objects/ParkEngage_Logo'), 20)

WebUI.waitForElementVisible(findTestObject('Add_Partner/Add_New_Partner_BTN'), 10)

WebUI.click(findTestObject('Add_Partner/Add_New_Partner_BTN'))

WebUI.verifyElementPresent(findTestObject('Add_Partner/Create_New_Partner_Label'), 10)

// Function to generate random 5-letter company name
// Generate name
String companyName = generateCompanyName()

// Set text into the input field
WebUI.setText(findTestObject('Add_Partner/input_FirstName'), 'Park')

WebUI.setText(findTestObject('Add_Partner/input_LastName'), 'Auto')

// Generate a random 5-digit number
// Build email string
String randomEmail = generateRandomEmail()

WebUI.setText(findTestObject('Add_Partner/inputEmail'), randomEmail)

// Generate 6 random digits
String randomDigits = RandomStringUtils.randomNumeric(6)

// Create phone number starting with 1122
String phoneNumber = '1122' + randomDigits

// Set value in phone number field
WebUI.setText(findTestObject('Add_Partner/inputPhoneNumber'), phoneNumber)

WebUI.setText(findTestObject('Add_Partner/inputSlug'), 'parkauto')

WebUI.setText(findTestObject('Add_Partner/input_Company'), companyName)

WebUI.setText(findTestObject('Add_Partner/input_City'), 'Vegas')

WebUI.click(findTestObject('Add_Partner/select_Country_Drop_Down'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Add_Partner/Select_Country_USA'), 20)

WebUI.click(findTestObject('Add_Partner/Select_Country_USA'))

WebUI.click(findTestObject('Add_Partner/Select_Services_Drop_Dwn'))

WebUI.click(findTestObject('Add_Partner/Select_Touchless_Parking'))

WebUI.delay(2)

WebUI.click(findTestObject('Add_Partner/Select_Plan'))

WebUI.delay(2)

WebUI.click(findTestObject('Add_Partner/Select_Advance_Plan'))

WebUI.delay(2)

WebUI.click(findTestObject('Add_Partner/Select_Pay_At_Check_Out'))

WebUI.delay(3)

WebUI.click(findTestObject('Add_Partner/Garage_Type_Drop_Down'))

WebUI.waitForElementPresent(findTestObject('Add_Partner/Select_Facility_Type'), 10)

WebUI.click(findTestObject('Add_Partner/Select_Facility_Type'))

WebUI.delay(2)

WebUI.click(findTestObject('Add_Partner/Select_Notification_Type_Both'))

WebUI.click(findTestObject('Add_Partner/Add_Partner_Submit_BTN'))

WebUI.waitForElementPresent(findTestObject('Add_Partner/Partner_Create_Alert_Text'), 20)

def partnercreate_Alert_Text = WebUI.getText(findTestObject('Add_Partner/Partner_Create_Alert_Text'))

print(partnercreate_Alert_Text)

WebUI.delay(10)

WebUI.click(findTestObject('Add_Partner/Partner_Menu_Option'))

WebUI.delay(1)

WebUI.click(findTestObject('Add_Partner/Delete_Partner_Menu_Option'))

WebUI.delay(1)

WebUI.click(findTestObject('Add_Partner/Delete_Confirm_Button'))

def partner_Delete_Alert = WebUI.getText(findTestObject('Add_Partner/Partner_Delete_Alert_Text'), FailureHandling.CONTINUE_ON_FAILURE)

println(partner_Delete_Alert)

def generateCompanyName() {
    String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'

    StringBuilder name = new StringBuilder()

    Random rand = new Random()

    for (int i = 0; i < 5; i++) {
        name.append(chars.charAt(rand.nextInt(chars.length())))
    }
    
    return name.toString()
}

def generateRandomEmail() {
    int randomNum = (Math.random() * 100).toInteger()

    return ('autopark1' + randomNum) + '@yopmail.com'
}

