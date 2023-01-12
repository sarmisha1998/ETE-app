package Base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{

	private int retrycount = 0;
	private static final int maxretyrcount = 3;

	@Override
	public boolean retry(ITestResult result) {
	    // TODO Auto-generated method stub
	    if (retrycount<maxretyrcount){
	        System.out.println("Retrying test " + result.getName() + " with status "
	                + getResultStatusName(result.getStatus()) + " for the " + (retrycount+1) + " time(s).");
	        retrycount++;
	        return true;
	    }

	    return false;
	}

	 public String getResultStatusName(int status) {
	        String resultName = null;
	        if(status==1)
	            resultName = "SUCCESS";
	        if(status==2)
	            resultName = "FAILURE";
	        if(status==3)
	            resultName = "SKIP";
	        return resultName;
	    }
}