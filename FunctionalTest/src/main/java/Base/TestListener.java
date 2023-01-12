package Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();

		// String username = CommonLib.readDataPropertyFile("USERNAME_EDIT");
		// String password = CommonLib.readDataPropertyFile("PASSWORD_EDIT");
		//
		// Properties props = new Properties();
		// props.put("mail.smtp.auth", true);
		// props.put("mail.smtp.starttls.enable", true);
		// props.put("mail.smtp.host", "smtp.office365.com");
		// props.put("mail.smtp.port", "587");
		//
		// Session session = Session.getInstance(props,
		// new javax.mail.Authenticator() {
		// protected PasswordAuthentication getPasswordAuthentication() {
		// return new PasswordAuthentication(username, password);
		// }
		// });
		//
		// try {
		//
		// Message message = new MimeMessage(session);
		// message.setFrom(new
		// InternetAddress(CommonLib.readDataPropertyFile("USERNAME_EDIT")));
		//// message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(CommonLib.readDataPropertyFile("USERNAME_EDIT")));
		//// message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(CommonLib.readDataPropertyFile("EMAIL1_EDIT")));
		//// message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(CommonLib.readDataPropertyFile("EMAIL2_EDIT")));
		//// message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(CommonLib.readDataPropertyFile("EMAIL3_EDIT")));
		//// message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(CommonLib.readDataPropertyFile("EMAIL4_EDIT")));
		// message.setSubject("Automation Test Report");
		// message.setText("PFA");
		//
		// MimeBodyPart messageBodyPart = new MimeBodyPart();
		//
		// Multipart multipart = new MimeMultipart();
		//
		// messageBodyPart = new MimeBodyPart();
		//
		// String reportFileName = "Automation Report - AIU Regression
		// "+".html";
		// String fileSeperator = System.getProperty("file.separator");
		// String reportFilepath = System.getProperty("user.dir")
		// +fileSeperator+ "ExtentReports";
		// File att = new File(new File(reportFilepath), reportFileName);
		// messageBodyPart.attachFile(att);
		// messageBodyPart.setFileName(reportFileName);
		// multipart.addBodyPart(messageBodyPart);
		//
		// message.setContent(multipart);
		//
		// System.out.println("Sending mail...");
		//
		//
		// Transport.send(message);
		//
		// System.out.println("Test Report mail has been sent. Please check your
		// inbox");
		// ExtentTestManager.getTest().log(Status.INFO, "Test Report mail has
		// been sent. Please check your inbox");
		//
		// } catch (MessagingException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
