package vitals;

import java.util.Arrays;

public class MeasurementProcessor {
	public boolean status = true;

	public boolean isStatus() {
		return status;
	}
	
/*	 public String processedMessage(float value, float limitHolder[], String messageList[]){
			if(value > limitHolder[0] && value <= limitHolder[1]) {
				this.status = false;
				return messageList[0];	
				}
			
			if(value > limitHolder[1] && value <= limitHolder[2]) {
			  return messageList[1];
			  }
			
			if(value > limitHolder[2] && value <= limitHolder[3]) {
			  return messageList[2];
			  }
			
			if(value > limitHolder[3] && value <= limitHolder[4]) {
			  return messageList[3];
			  }			
		
			if(value > limitHolder[4]) {
				this.status = false;
				return messageList[4];
				}
				
			return null;	
			
			
			
			}*/
	 
	 public String islowBreach(float value, float limitHolder[], String messageList[]) {
			if(value > limitHolder[0] && value <= limitHolder[1]) {
				this.status = false;
				return messageList[0];	
				}
			
			if(value > limitHolder[1] && value <= limitHolder[2]) {
			  return messageList[1];
			  }
			return null;
	 }
	 
	 public String isHighBreach(float value, float limitHolder[], String messageList[]) {
			if(value > limitHolder[3] && value <= limitHolder[4]) {
				  return messageList[3];
				  }			
			
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
