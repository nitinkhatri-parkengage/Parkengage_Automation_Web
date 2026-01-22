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

WebUI.navigateToUrl('https://staging-new.parkengage.com/')

WebUI.waitForElementPresent(findTestObject('Login_Page_Objects/Email_Password_Field'), 20)

WebUI.setText(findTestObject('Login_Page_Objects/Email_Input_Field'), GlobalVariable.G_Email)

WebUI.setEncryptedText(findTestObject('Login_Page_Objects/Email_Password_Field'), 'Cqo1foBX0qbZ3A82kE6k0A==')

WebUI.click(findTestObject('Login_Page_Objects/Login_Submit_Button'))

WebUI.delay(15)

WebUI.click(findTestObject('Create_Garrage/Product_Menu_Expand'))

WebUI.waitForElementClickable(findTestObject('Create_Garrage/Garage_Management_Menu'), 5)

WebUI.click(findTestObject('Create_Garrage/Garage_Management_Menu'))

WebUI.waitForElementPresent(findTestObject('Create_Garrage/Add_New_Button_Garage'), 10)

WebUI.click(findTestObject('Create_Garrage/Add_New_Button_Garage'))

String garageName = generateGarageName()

WebUI.setText(findTestObject('Create_Garrage/Garage_Name_Input_Field'), GarageName)

String garageShortName = generateGarageCode()

WebUI.setText(findTestObject('Create_Garrage/Garage_Short_Name'), Short_Garage_Name)

String garageCode = generateGarageCode()

WebUI.setText(findTestObject('Create_Garrage/Garage_Code_Input_Field'), garageCode)

// Generate 6 random digits
String randomDigits = RandomStringUtils.randomNumeric(6)

// Create phone number starting with 1122
String phoneNumber = '1122' + randomDigits

WebUI.setText(findTestObject('Create_Garrage/Garage_Phone_Number_Input'), Mobile_Number)

WebUI.delay(2)

WebUI.click(findTestObject('Create_Garrage/Select_Partner_Garage_Mngmnt_Drp_Dwn'))

WebUI.delay(2)

WebUI.click(findTestObject('Create_Garrage/Partner_Rev_Pass'))

WebUI.click(findTestObject('Create_Garrage/Garage_Type_Drp_Dwn'))

WebUI.delay(1)

WebUI.click(findTestObject('Create_Garrage/Ungated_Garage_Option'))

WebUI.click(findTestObject('Create_Garrage/Create_BTN_GRG'))

WebUI.delay(20)

def generateGarageCode() {
    String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'

    StringBuilder name = new StringBuilder()

    Random rand = new Random()

    for (int i = 0; i < 5; i++) {
        name.append(chars.charAt(rand.nextInt(chars.length())))
    }
    
    return name.toString()
}

def generateShortName() {
    String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'

    StringBuilder name = new StringBuilder()

    Random rand = new Random()

    for (int i = 0; i < 5; i++) {
        name.append(chars.charAt(rand.nextInt(chars.length())))
    }
    
    return name.toString()
}

def generateGarageName() {
    String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'

    StringBuilder name = new StringBuilder()

    Random rand = new Random()

    for (int i = 0; i < 5; i++) {
        name.append(chars.charAt(rand.nextInt(chars.length())))
    }
    
    return name.toString()
}

