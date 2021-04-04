package vitals;

public class WarningMessageSelector {
	static String isWarning(float value, float limitHolder[], String messageList[]) {		
		if(value > limitHolder[1] && value <= limitHolder[2]) {
			  return messageList[1];
			  }
			
			if(value > limitHolder[3] && value <= limitHolder[4]) {
				  return messageList[3];
				  }			
			
			return null;
	 } 
	
}
