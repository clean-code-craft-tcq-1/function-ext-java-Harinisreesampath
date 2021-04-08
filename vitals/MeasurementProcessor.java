package vitals;

import java.util.Arrays;

public class MeasurementProcessor {
	public boolean status = true;

	public boolean isStatus() {
		return status;
	}
	
	public void islowBreach(float value, float limitHolder[], String messageList[]) {
		if(value > limitHolder[1] && value <= limitHolder[2])
			ParameterCheckMessage.breachMessage = messageList[1];
			//ParameterCheckMessage.breachMessage = value > limitHolder[0] && value <= limitHolder[1]? messageList[0]  : (value > limitHolder[1] && value <= limitHolder[2]?messageList[1]:null);
	 }
	 
	 public void isHighBreach(float value, float limitHolder[], String messageList[]) {
		 if(value > limitHolder[3] && value <= limitHolder[4])
			 ParameterCheckMessage.breachMessage = messageList[3];
		 //ParameterCheckMessage.breachMessage = value > limitHolder[4] ? messageList[4] : (value > limitHolder[3] && value <= limitHolder[4]?messageList[3]:messageList[2]);		
	 }
	 
	 public void isViolates(float value, float limitHolder[], String messageList[]) {
		 if(value > limitHolder[0] && value <= limitHolder[1]) {
			 ParameterCheckMessage.breachMessage = messageList[0];
			 this.status = false;
		 }
		 if(value > limitHolder[4]) {
			 ParameterCheckMessage.breachMessage = messageList[4];
			 this.status = false;
		 }
		 
	 }
			
			public void singleLimitMessage(float value, float limitHolder[], String messageList[]) {
				if(value > limitHolder[1]) {
					this.status = false;
					ParameterCheckMessage.breachMessage = messageList[2];
					}
				else if(value > limitHolder[0])
					ParameterCheckMessage.breachMessage =  messageList[1];
				else
					ParameterCheckMessage.breachMessage = messageList[0];

			}
}
