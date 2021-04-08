package vitals;

import java.util.Arrays;

public class MeasurementProcessor {
/*	public boolean status = true;

	public boolean isStatus() {
		return status;
	}*/
	
	public void islowBreach(float value, float limitHolder[], String messageList[]) {
		if(value > limitHolder[1] && value <= limitHolder[2])
			ParameterCheckMessage.breachMessage = messageList[1];
	 }
	 
	 public void isHighBreach(float value, float limitHolder[], String messageList[]) {
		 if(value > limitHolder[3] && value <= limitHolder[4])
			 ParameterCheckMessage.breachMessage = messageList[3];
	 }
	 
	 public boolean isViolates(float value, float limitHolder[], String messageList[]) {
		 if(value < limitHolder[0]) {
			 ParameterCheckMessage.breachMessage = messageList[0];
			 return false;
		 }
		 if(value > limitHolder[4]) {
			 ParameterCheckMessage.breachMessage = messageList[4];
			 return false;
		 }
		 return true;
		 
	 }
			
			public boolean singleLimitMessage(float value, float limitHolder[], String messageList[]) {
				if(value > limitHolder[1]) {					
					ParameterCheckMessage.breachMessage = messageList[2];
					return false;
					}
				else if(value > limitHolder[0])
					ParameterCheckMessage.breachMessage =  messageList[1];
				else
					ParameterCheckMessage.breachMessage = messageList[0];
				return true;
			}
}
