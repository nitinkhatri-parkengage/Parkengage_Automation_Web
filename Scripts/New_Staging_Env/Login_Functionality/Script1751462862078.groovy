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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://staging-admin.parkengage.com')

WebUI.setText(findTestObject('Login_Page_Objects/Email_Input_Field'), GlobalVariable.G_Email)

WebUI.waitForElementPresent(findTestObject('Login_Page_Objects/Email_Password_Field'), 20)

WebUI.setEncryptedText(findTestObject('Login_Page_Objects/Email_Password_Field'), 'Cqo1foBX0qbZ3A82kE6k0A==')

WebUI.click(findTestObject('Login_Page_Objects/Login_Submit_Button'))

WebUI.delay(10)

def dashboard_url = WebUI.getUrl()

print(dashboard_url)

WebUI.verifyEqual(dashboard_url, 'https://staging-admin.parkengage.com/admin/partners')

