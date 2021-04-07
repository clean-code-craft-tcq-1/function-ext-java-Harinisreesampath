package vitals;

import java.util.Arrays;

public class MeasurementProcessor {
	public boolean status = true;

	public boolean isStatus() {
		return status;
	}
	
	public String islowBreach(float value, float limitHolder[], String messageList[]) {
		String breachMessage = value > limitHolder[0] && value <= limitHolder[1]? messageList[0]  : (value > limitHolder[1] && value <= limitHolder[2]?messageList[1]:null);
			return breachMessage;
	 }
	 
	 public String isHighBreach(float value, float limitHolder[], String messageList[]) {
		 String breachMessage = value > limitHolder[4] ? messageList[4] : (value > limitHolder[3] && value <= limitHolder[4]?messageList[3]:messageList[2]);		
				return breachMessage;
	 }
			
			public String singleLimitMessage(float value, float limitHolder[], String messageList[]) {
				if(value > limitHolder[1]) {
					this.status = false;
					return messageList[2];}
				else if(value > limitHolder[0])
					return messageList[1];
				else
					return messageList[0];
			}
}
