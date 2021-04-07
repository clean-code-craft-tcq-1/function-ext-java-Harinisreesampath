package vitals;


public class Main {
	public static final int PERCENTAGE =5;
	public static final float LOWER_TEMPERATURE = 0;
	public static final float HIGHER_TEMPERATURE = 45;
	public static final float LOWER_SOC = 20;
	public static final float HIGHER_SOC = 80;
	public static final float HIGHER_CHARGERATE = 0.8f;
	public static final float NORMAL_CHARGERATE = 0;
	public static final int SINGLE_LIMIT = 1;
	public static final int DOUBLE_LIMIT = 2;
	
    static boolean batteryIsOk(float temperature, float soc, float chargeRate, String measurementUnit) {
    	if(measurementUnit.equalsIgnoreCase("C"))
    		temperature = TemperatureUnitConverter.convertingTemperatureToFahrenheit(temperature) ;
    	
    	MeasurementProcessor temperatureProcessor = new MeasurementProcessor();
    	float temperatureLimitHolder[] = new LimitCalculator(PERCENTAGE, HIGHER_TEMPERATURE, LOWER_TEMPERATURE, DOUBLE_LIMIT).getLimitHolder();
    	String temperatureMessageList[] = new MessageGenerator("Temperature").getOutputMessage();
    	//String temperatureBreachMessage = temperatureProcessor.islowBreach(temperature, temperatureLimitHolder, temperatureMessageList);
    	String temperatureBreachMessage = temperatureProcessor.islowBreach(temperature, temperatureLimitHolder, temperatureMessageList)==null? temperatureProcessor.isHighBreach(temperature, temperatureLimitHolder, temperatureMessageList) : null;
    	/*if(temperatureBreachMessage == null) {
    		temperatureBreachMessage = WarningMessageSelector.isWarning(temperature, temperatureLimitHolder, temperatureMessageList);
    		if(temperatureBreachMessage ==  null)
     		temperatureBreachMessage = temperatureProcessor.isHighBreach(temperature, temperatureLimitHolder, temperatureMessageList);
    	}*/
    	printMessage(temperatureBreachMessage, "Temperature");
    	
    	MeasurementProcessor socProcessor = new MeasurementProcessor();
    	float socLimitHolder[] = new LimitCalculator(PERCENTAGE, HIGHER_SOC, LOWER_SOC, DOUBLE_LIMIT).getLimitHolder();
    	String socMessageList[] = new MessageGenerator("SOC").getOutputMessage();
    	//String socBreachMessage = socProcessor.islowBreach(soc, socLimitHolder, socMessageList);
    	String socBreachMessage = socProcessor.islowBreach(soc, socLimitHolder, socMessageList)==null? socProcessor.isHighBreach(soc, socLimitHolder, socMessageList) : null;
    	/*if(socBreachMessage == null) {
    		socBreachMessage = WarningMessageSelector.isWarning(soc, socLimitHolder, socMessageList);
    		if(socBreachMessage == null)
    		socBreachMessage = socProcessor.isHighBreach(soc, socLimitHolder, socMessageList);
    	}*/
    	printMessage(socBreachMessage, "State of Charge");
    	
    	MeasurementProcessor chargeRateProcessor = new MeasurementProcessor();
    	float chargeRateLimitHolder[] = new LimitCalculator(PERCENTAGE, HIGHER_CHARGERATE, NORMAL_CHARGERATE, SINGLE_LIMIT).getLimitHolder();
    	String chargeRateMessageList[] = new MessageGenerator("ChargeRate").getOutputMessage();
    	printMessage(chargeRateProcessor.singleLimitMessage(chargeRate, chargeRateLimitHolder, chargeRateMessageList), "Charge Rate");
    	boolean temperatureCheck = temperatureProcessor.isStatus();
    	boolean socCheck = socProcessor.isStatus();
    	boolean chargeRateCheck = chargeRateProcessor.isStatus();
    	
    	BreachHandler.isActionNeeded(temperatureCheck, "Temperature");
    	BreachHandler.isActionNeeded(socCheck, "Charge State");
    	BreachHandler.isActionNeeded(chargeRateCheck, "Charge Rate");
    	
   		return (temperatureCheck && socCheck && chargeRateCheck);    	   	
    }
    
    
    static void printMessage(String message, String type) {
    	System.out.println(type + " : " +message);
    }
    
    public static void main(String[] args) {
    	assert(batteryIsOk(25, 70, 0.6f,"F") == true);
    	assert(batteryIsOk(1, 24, 0.0f,"C") == true);
    	assert(batteryIsOk(25,10,0.78f,"F") == true);
    }
}
