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

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

import groovy.json.JsonSlurper



def testData = TestDataFactory.findTestData('Data Files/arrival_data1')

// Define number of threads (concurrent users)
int threadCount = 12
List<Thread> threads = []

for (int i = 1; i <= threadCount; i++) {

	String arrivalValue = testData.getValue(1, i)  // Column 1
	String nonceValue   = testData.getValue(2, i)  // Column 2
	String totalValue   = testData.getValue(3, i)  // Column 3
	String lengthValue  = testData.getValue(4, i)  // Column 4

	Thread t = new Thread({
		def response = WS.sendRequest(
			findTestObject(
				'Create_Reservation',
				[
					('arrival') : arrivalValue,
					('nonce')   : nonceValue,
					('total')   : totalValue,
					('length')  : lengthValue
				]
			)
		)

		println "Thread ${Thread.currentThread().name} | Arrival: ${arrivalValue} | Nonce: ${nonceValue} | Total: ${totalValue} | Length: ${lengthValue} | Status: ${response.getStatusCode()}"
	})

	threads.add(t)
}

// Start threads
threads*.start()

// Wait for all to finish
threads*.join()

println "✅ All ${threadCount} API requests completed."


