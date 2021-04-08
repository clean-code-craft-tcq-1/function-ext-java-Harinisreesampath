package vitals;

public class MessageGenerator {
	public String outputMessage[] = new String[5];
	public String[] getOutputMessage() {
		return outputMessage;
	}

	public MessageGenerator(String measurementType) {
		if(measurementType.equalsIgnoreCase("Temperature") ) {
	    	outputMessage[0] = "LOW_TEMPERATURE_BREACH";
	    	outputMessage[1] = "LOW_TEMPERATURE_WARNING";
	    	outputMessage[2] = "NORMAL";
	    	outputMessage[3] = "HIGH_TEMPERATURE_WARNING";
	    	outputMessage[4] = "HIGH_TEMPERATURE_BREACH";
		}
		else if(measurementType.equalsIgnoreCase("SOC")) {
			outputMessage[0] = "LOW_SOC_BREACH";
	    	outputMessage[1] = "LOW_SOC_WARNING";
	    	outputMessage[2] = "NORMAL";
	    	outputMessage[3] = "HIGH_SOC_WARNING";
	    	outputMessage[4] = "HIGH_SOC_BREACH";
		}
		else {
	    	outputMessage[0] = "NORMAL";
	    	outputMessage[1] = "HIGH_CHARGERATE_WARNING";
	    	outputMessage[2] = "HIGH_CHARGERATE_BREACH";
		}
	}

}

