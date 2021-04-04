package vitals;

import java.util.Arrays;

public class MeasurementProcessor {
	public boolean status = true;

	public boolean isStatus() {
		return status;
	}
	
	public String islowBreach(float value, float limitHolder[], String messageList[]) {
			if(value > limitHolder[0] && value <= limitHolder[1]) {
				this.status = false;
				return messageList[0];	
				}
			return null;
	 }
	 
	 public String isHighBreach(float value, float limitHolder[], String messageList[]) {
				if(value > limitHolder[4]) {
					this.status = false;
					return messageList[4];
					}
					
				return messageList[2];
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
