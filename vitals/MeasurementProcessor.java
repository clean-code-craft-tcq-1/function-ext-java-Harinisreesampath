package vitals;

public class MeasurementProcessor {
	public boolean status = true;

	public boolean isStatus() {
		return status;
	}
	
	 public String processedMessage(float value, float limitHolder[], String messageList[]){
		 String selectedMessage = "";
			if(value > limitHolder[0] && value <= limitHolder[1]) {
				this.status = false;
				selectedMessage = messageList[0];	
				}
			
			else if(value > limitHolder[1] && value <= limitHolder[2]) {
				selectedMessage = messageList[1];
			  }
			
			else if(value > limitHolder[2] && value <= limitHolder[3]) {
				selectedMessage = messageList[2];
			  }
			
			else if(value > limitHolder[3] && value <= limitHolder[4]) {
				selectedMessage = messageList[3];
			  }
			
			else if(value > limitHolder[4]) {
				this.status = false;
				selectedMessage = messageList[4];
				}		  
			else
				selectedMessage = null;
			
			return selectedMessage;
			
			}
			
			public String singleLimitMessage(float value, float limitHolder[], String messageList[]) {
				if(value > limitHolder[1]) {
					this.status = false;
					return messageList[2];}
				if(value > limitHolder[0])
					return messageList[1];
				
					return messageList[0];
			}
}
