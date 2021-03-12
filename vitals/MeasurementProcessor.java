package vitals;

public class MeasurementProcessor {
	public float limitHolder[] = new float[5];
	public String outputMessage[] = new String[5];
	public boolean status = true;

	public boolean isStatus() {
		return status;
	}

	public MeasurementProcessor( int percentageValue, float upper, float lower, int numberOfLimits){
		float deltaLimit = upper * percentageValue / 100;
		if(numberOfLimits == 2) {
			limitHolder[0] = 0;         
			limitHolder[1] = lower;   
			limitHolder[2] = lower + deltaLimit;
			limitHolder[3] = upper - deltaLimit-1;  
			limitHolder[4] = upper;
		}
		else {
			limitHolder[1] = upper;
			limitHolder[0] = upper - deltaLimit;
		}

		}

	    public void setTemperatureMessage(){
		
	    	outputMessage[0] = "LOW_TEMPERATURE_BREACH";
	    	outputMessage[1] = "LOW_TEMPERATURE_WARNING";
	    	outputMessage[2] = "NORMAL";
	    	outputMessage[3] = "HIGH_TEMPERATURE_WARNING";
	    	outputMessage[4] = "HIGH_TEMPERATURE_BREACH";
		}
	    
	    public void setSOCMessage(){
			
	    	outputMessage[0] = "LOW_SOC_BREACH";
	    	outputMessage[1] = "LOW_SOC_WARNING";
	    	outputMessage[2] = "NORMAL";
	    	outputMessage[3] = "HIGH_SOC_WARNING";
	    	outputMessage[4] = "HIGH_SOC_BREACH";
		}
	    
	    public void setChargeRateMessage(){
	    	outputMessage[0] = "NORMAL";
	    	outputMessage[1] = "HIGH_CHARGERATE_WARNING";
	    	outputMessage[2] = "HIGH_CHARGERATE_BREACH";
		}
		
		public String sendMessage(float value){
		if(value > limitHolder[0] && value <= limitHolder[1]) {
			this.status = false;
			return outputMessage[0];	
			}
		
		if(value > limitHolder[1] && value <= limitHolder[2]) {
		  return outputMessage[1];
		  }
		
		if(value > limitHolder[2] && value <= limitHolder[3]) {
		  return outputMessage[2];
		  }
		
		if(value > limitHolder[3] && value <= limitHolder[4]) {
		  return outputMessage[3];
		  }
		
		if(value > limitHolder[4]) {
			this.status = false;
			return outputMessage[4];
			}		  
		
		return null;
		
		}
		
		public String singleLimitMessage(float value) {
			if(value > limitHolder[1]) {
				this.status = false;
				return outputMessage[2];}
			else if(value > limitHolder[0])
				return outputMessage[1];
			else
				return outputMessage[0];
		}
		
}
