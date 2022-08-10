package apiScenarios;

import java.util.ArrayList;

import org.json.JSONObject;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywordsAPI;

public class ProfileAPI  extends ApplicationKeywordsAPI {
	BaseClass obj;

	public ProfileAPI(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	//Need to make dynamic for creating a profile
	public void createProfile()
	{
		try
		{
			testStepPassed("Test Case Name: " + currentTestCaseName);// Test Case Info
			testStepPassed("API Method Name: " + retrieve("API Method Name"));
			testStepPassed("Data Row Name: " + retrieve("Data Row Name"));
			testStepInfo(""); // to give a line spacing in the output file

			String dateTimeFormat = "ddMMMyyyyhhmmssSSa"; // 14Nov201810455720AM
			String currentDateTime = returnFormattedDate("Today", dateTimeFormat);// Dynamic Values // The 'RRN' value in the 'Clear JSON' would be uniquely generated by adding the

			//retrieving saveAuditCall Datas
			String createProfileURI = retrieve("createProfile URI");
			String createProfileHeader = retrieve("createProfile Header");
			String createProfileBody = retrieve("createProfile Body"); 
			String expectedValues = retrieve("Expected Values In Response Body");

			ArrayList<String> inputParameterHeadersArray = new ArrayList<>();

			//Saving the input parameters to a file
			testStepInfo("About to save the Input Parameters of the method to a file");

			// Creating input parameters file
			String inputParametersFolder = suiteResultsDir + "/Input";
			createInputParametersFolder(inputParametersFolder);

			inputParameterHeadersArray.add("Input Parameters:");
			inputParameterHeadersArray.add("URI: " + createProfileURI);
			inputParameterHeadersArray.add("Header" + createProfileHeader);
			inputParameterHeadersArray.add("Body" + createProfileBody);

		
			//Creating Input Folder to add Input Datas and Encrypted JSON
			String inputParametersFileName = suiteResultsDir + "/Input/" + currentTestCaseName + "_Params_" + currentDateTime + ".txt";
			saveInputParametersToFile(inputParametersFileName, inputParameterHeadersArray);

			//Creating link in the report to access the input data text file
			String inputParametersFileNameRelativePath = "../Input/" + currentTestCaseName + "_Params_"+ currentDateTime + ".txt";
			testStepLink(inputParametersFileNameRelativePath, "Click to open input parameters of the method createProfile");
			testStepInfo("");

			//Execution of API Command
			testStepInfo("About to execute the 'API' command");
			executeAPIMethod(createProfileURI, null, createProfileHeader,createProfileBody);
			//executeGetAPIMethod(URI,Parameters,Header(AuthKey,Token));

			testStepInfo("");

			//Verifying the response expected vs actual
			String responseBody = response.getBody().asString();
			testStepInfo("Successfully got the response ");
			
			JSONObject jsonObject = new JSONObject(responseBody);
			verifyResponse(jsonObject, expectedValues);
			
			// Creating output Responses Folder to add the 'Output Responses' to a file
			testStepInfo("About to save the Output Responses to a file");
			String outputResponsesFileName = suiteResultsDir + "/Responses/" + currentTestCaseName + "_Responses_"+ currentDateTime + ".txt";
			saveOutputResponsesToFile(outputResponsesFileName, responseBody);

			//Linking it to the test result
			String outputResponsesFileNameRelativePath = "../Responses/" + currentTestCaseName + "_Responses_"
					+ currentDateTime + ".txt";
			testStepLink(outputResponsesFileNameRelativePath, "Click to open output responses of the method createProfile");
			testStepInfo(""); // to give a line spacing in the output file
		}
		catch (Exception e) // In case of exception in the test step, printing the exception message as a failure in the report
		{
			stepFailed("Exception in test case - '" + e.getClass().getName() + "'");
			testStepInfo(""); // one line spacing
			testStepInfo("About to write 'Exception' for certain values in the Test Report Summary");
			testStepInfo(""); // to give a line spacing in the output file
		}
		finally
		{
			if (this.testFailure)
			{
				testFailure = true;
			}
		}
	}
	
	public void getProfileById() {
		try {
			testStepPassed("Test Case Name: " + currentTestCaseName);// Test Case Info
			testStepPassed("API Method Name: " + retrieve("API Method Name"));
			testStepPassed("Data Row Name: " + retrieve("Data Row Name"));
			testStepInfo(""); // to give a line spacing in the output file

			String dateTimeFormat = "ddMMMyyyyhhmmssSSa"; // 14Nov201810455720AM
			String currentDateTime = returnFormattedDate("Today", dateTimeFormat);// Dynamic Values // The 'RRN' value
																					// in the 'Clear JSON' would be
																					// uniquely generated by adding the

			// retrieving saveAuditCall Datas
			String getProfileByIdURI = retrieve("getProfileById URI");
			String getProfileByIdParams = retrieve("getProfileById Params");
			String getProfileByIdHeader = retrieve("getProfileById Header");
			String expectedValues = retrieve("Expected Values In Response Body");

			ArrayList<String> inputParameterHeadersArray = new ArrayList<>();

			// Saving the input parameters to a file
			testStepInfo("About to save the Input Parameters of the method to a file");

			// Creating input parameters file
			String inputParametersFolder = suiteResultsDir + "/Input";
			createInputParametersFolder(inputParametersFolder);

			inputParameterHeadersArray.add("Input Parameters:");
			inputParameterHeadersArray.add("URI: " + getProfileByIdURI);
			inputParameterHeadersArray.add("Header" + getProfileByIdParams);
			inputParameterHeadersArray.add("Header" + getProfileByIdHeader);

			// Creating Input Folder to add Input Datas and Encrypted JSON
			String inputParametersFileName = suiteResultsDir + "/Input/" + currentTestCaseName + "_Params_"
					+ currentDateTime + ".txt";
			saveInputParametersToFile(inputParametersFileName, inputParameterHeadersArray);

			// Creating link in the report to access the input data text file
			String inputParametersFileNameRelativePath = "../Input/" + currentTestCaseName + "_Params_"
					+ currentDateTime + ".txt";
			testStepLink(inputParametersFileNameRelativePath, "Click to open input parameters of the method getProfileById");
			testStepInfo("");

			// Execution of API Command
			testStepInfo("About to execute the 'API' command");
			executeGetAPIMethod(getProfileByIdURI, getProfileByIdParams, getProfileByIdHeader);
			testStepInfo("");

			// Verifying the response expected vs actual
			String responseBody = response.getBody().asString();
			testStepInfo("Successfully got the response ");
			JSONObject jsonObject = new JSONObject(responseBody);
			verifyResponse(jsonObject, expectedValues);

			// Creating output Responses Folder to add the 'Output Responses' to a file
			testStepInfo("About to save the Output Responses to a file");
			String outputResponsesFileName = suiteResultsDir + "/Responses/" + currentTestCaseName + "_Responses_"
					+ currentDateTime + ".txt";
			saveOutputResponsesToFile(outputResponsesFileName, responseBody);

			// Linking it to the test result
			String outputResponsesFileNameRelativePath = "../Responses/" + currentTestCaseName + "_Responses_"
					+ currentDateTime + ".txt";
			testStepLink(outputResponsesFileNameRelativePath, "Click to open output responses of the method getProfileById");
			testStepInfo(""); // to give a line spacing in the output file
		} catch (Exception e) // In case of exception in the test step, printing the exception message as a
								// failure in the report
		{
			stepFailed("Exception in test case - '" + e.getClass().getName() + "'");
			testStepInfo(""); // one line spacing
			testStepInfo("About to write 'Exception' for certain values in the Test Report Summary");
			testStepInfo(""); // to give a line spacing in the output file
		} finally {
			if (this.testFailure) {
				testFailure = true;
			}
		}
	}
	
	public void getProfileByEmail() {
		try {
			testStepPassed("Test Case Name: " + currentTestCaseName);// Test Case Info
			testStepPassed("API Method Name: " + retrieve("API Method Name"));
			testStepPassed("Data Row Name: " + retrieve("Data Row Name"));
			testStepInfo(""); // to give a line spacing in the output file

			String dateTimeFormat = "ddMMMyyyyhhmmssSSa"; // 14Nov201810455720AM
			String currentDateTime = returnFormattedDate("Today", dateTimeFormat);// Dynamic Values // The 'RRN' value
																					// in the 'Clear JSON' would be
																					// uniquely generated by adding the

			// retrieving saveAuditCall Datas
			String getProfileByEmailURI = retrieve("getProfileByEmail URI");
			String getProfileByEmailParams = retrieve("getProfileByEmail Params");
			String getProfileByEmailHeader = retrieve("getProfileByEmail Header");
			String expectedValues = retrieve("Expected Values In Response Body");

			ArrayList<String> inputParameterHeadersArray = new ArrayList<>();

			// Saving the input parameters to a file
			testStepInfo("About to save the Input Parameters of the method to a file");

			// Creating input parameters file
			String inputParametersFolder = suiteResultsDir + "/Input";
			createInputParametersFolder(inputParametersFolder);

			inputParameterHeadersArray.add("Input Parameters:");
			inputParameterHeadersArray.add("URI: " + getProfileByEmailURI);
			inputParameterHeadersArray.add("Header" + getProfileByEmailParams);
			inputParameterHeadersArray.add("Header" + getProfileByEmailHeader);

			// Creating Input Folder to add Input Datas and Encrypted JSON
			String inputParametersFileName = suiteResultsDir + "/Input/" + currentTestCaseName + "_Params_"
					+ currentDateTime + ".txt";
			saveInputParametersToFile(inputParametersFileName, inputParameterHeadersArray);

			// Creating link in the report to access the input data text file
			String inputParametersFileNameRelativePath = "../Input/" + currentTestCaseName + "_Params_"
					+ currentDateTime + ".txt";
			testStepLink(inputParametersFileNameRelativePath, "Click to open input parameters of the method getProfileByEmail");
			testStepInfo("");

			// Execution of API Command
			testStepInfo("About to execute the 'API' command");
			executeGetAPIMethod(getProfileByEmailURI, getProfileByEmailParams, getProfileByEmailHeader);
			testStepInfo("");

			// Verifying the response expected vs actual
			String responseBody = response.getBody().asString();
			testStepInfo("Successfully got the response ");
			JSONObject jsonObject = new JSONObject(responseBody);
			verifyResponse(jsonObject, expectedValues);

			// Creating output Responses Folder to add the 'Output Responses' to a file
			testStepInfo("About to save the Output Responses to a file");
			String outputResponsesFileName = suiteResultsDir + "/Responses/" + currentTestCaseName + "_Responses_"
					+ currentDateTime + ".txt";
			saveOutputResponsesToFile(outputResponsesFileName, responseBody);

			// Linking it to the test result
			String outputResponsesFileNameRelativePath = "../Responses/" + currentTestCaseName + "_Responses_"
					+ currentDateTime + ".txt";
			testStepLink(outputResponsesFileNameRelativePath, "Click to open output responses of the method getProfileByEmail");
			testStepInfo(""); // to give a line spacing in the output file
		} catch (Exception e) // In case of exception in the test step, printing the exception message as a
								// failure in the report
		{
			stepFailed("Exception in test case - '" + e.getClass().getName() + "'");
			testStepInfo(""); // one line spacing
			testStepInfo("About to write 'Exception' for certain values in the Test Report Summary");
			testStepInfo(""); // to give a line spacing in the output file
		} finally {
			if (this.testFailure) {
				testFailure = true;
			}
		}
	}
	
	public void getProfileByPrimaryContactNumber() {
		try {
			testStepPassed("Test Case Name: " + currentTestCaseName);// Test Case Info
			testStepPassed("API Method Name: " + retrieve("API Method Name"));
			testStepPassed("Data Row Name: " + retrieve("Data Row Name"));
			testStepInfo(""); // to give a line spacing in the output file

			String dateTimeFormat = "ddMMMyyyyhhmmssSSa"; // 14Nov201810455720AM
			String currentDateTime = returnFormattedDate("Today", dateTimeFormat);// Dynamic Values // The 'RRN' value
																					// in the 'Clear JSON' would be
																					// uniquely generated by adding the

			// retrieving saveAuditCall Datas
			String getProfileByPrimaryContactNumberURI = retrieve("getProfileByPrimaryContactNumber URI");
			String getProfileByPrimaryContactNumberParams = retrieve("getProfileByPrimaryContactNumber Params");
			String getProfileByPrimaryContactNumberHeader = retrieve("getProfileByPrimaryContactNumber Header");
			String expectedValues = retrieve("Expected Values In Response Body");

			ArrayList<String> inputParameterHeadersArray = new ArrayList<>();

			// Saving the input parameters to a file
			testStepInfo("About to save the Input Parameters of the method to a file");

			// Creating input parameters file
			String inputParametersFolder = suiteResultsDir + "/Input";
			createInputParametersFolder(inputParametersFolder);

			inputParameterHeadersArray.add("Input Parameters:");
			inputParameterHeadersArray.add("URI: " + getProfileByPrimaryContactNumberURI);
			inputParameterHeadersArray.add("Header" + getProfileByPrimaryContactNumberParams);
			inputParameterHeadersArray.add("Header" + getProfileByPrimaryContactNumberHeader);

			// Creating Input Folder to add Input Datas and Encrypted JSON
			String inputParametersFileName = suiteResultsDir + "/Input/" + currentTestCaseName + "_Params_"
					+ currentDateTime + ".txt";
			saveInputParametersToFile(inputParametersFileName, inputParameterHeadersArray);

			// Creating link in the report to access the input data text file
			String inputParametersFileNameRelativePath = "../Input/" + currentTestCaseName + "_Params_"
					+ currentDateTime + ".txt";
			testStepLink(inputParametersFileNameRelativePath, "Click to open input parameters of the method getProfileByPrimaryContactNumber");
			testStepInfo("");

			// Execution of API Command
			testStepInfo("About to execute the 'API' command");
			executeGetAPIMethod(getProfileByPrimaryContactNumberURI, getProfileByPrimaryContactNumberParams, getProfileByPrimaryContactNumberHeader);
			testStepInfo("");

			// Verifying the response expected vs actual
			String responseBody = response.getBody().asString();
			testStepInfo("Successfully got the response ");
			JSONObject jsonObject = new JSONObject(responseBody);
			verifyResponse(jsonObject, expectedValues);

			// Creating output Responses Folder to add the 'Output Responses' to a file
			testStepInfo("About to save the Output Responses to a file");
			String outputResponsesFileName = suiteResultsDir + "/Responses/" + currentTestCaseName + "_Responses_"
					+ currentDateTime + ".txt";
			saveOutputResponsesToFile(outputResponsesFileName, responseBody);

			// Linking it to the test result
			String outputResponsesFileNameRelativePath = "../Responses/" + currentTestCaseName + "_Responses_"
					+ currentDateTime + ".txt";
			testStepLink(outputResponsesFileNameRelativePath, "Click to open output responses of the method getProfileByPrimaryContactNumber");
			testStepInfo(""); // to give a line spacing in the output file
		} catch (Exception e) // In case of exception in the test step, printing the exception message as a
								// failure in the report
		{
			stepFailed("Exception in test case - '" + e.getClass().getName() + "'");
			testStepInfo(""); // one line spacing
			testStepInfo("About to write 'Exception' for certain values in the Test Report Summary");
			testStepInfo(""); // to give a line spacing in the output file
		} finally {
			if (this.testFailure) {
				testFailure = true;
			}
		}
	}

}
