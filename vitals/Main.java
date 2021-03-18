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
    	printMessage(temperatureProcessor.processedMessage(temperature, temperatureLimitHolder, temperatureMessageList), "Temperature");
    	
    	MeasurementProcessor socProcessor = new MeasurementProcessor();
    	float socLimitHolder[] = new LimitCalculator(PERCENTAGE, HIGHER_SOC, LOWER_SOC, DOUBLE_LIMIT).getLimitHolder();
    	String socMessageList[] = new MessageGenerator("SOC").getOutputMessage();
    	printMessage(socProcessor.processedMessage(soc, socLimitHolder, socMessageList), "State of Charge");
    	
    	MeasurementProcessor chargeRateProcessor = new MeasurementProcessor();
    	float chargeRateLimitHolder[] = new LimitCalculator(PERCENTAGE, HIGHER_CHARGERATE, NORMAL_CHARGERATE, SINGLE_LIMIT).getLimitHolder();
    	String chargeRateMessageList[] = new MessageGenerator("ChargeRate").getOutputMessage();
    	printMessage(chargeRateProcessor.singleLimitMessage(chargeRate, chargeRateLimitHolder, chargeRateMessageList), "Charge Rate");
    	
   		return (temperatureProcessor.isStatus() && socProcessor.isStatus() && chargeRateProcessor.isStatus());    	   	
    }
    
    static void printMessage(String message, String type) {
    	System.out.println(type + " : " +message);
    }
    
    public static void main(String[] args) {
    	assert(batteryIsOk(25, 70, 0.6f,"C") == true);
    	assert(batteryIsOk(44, 24, 0.0f,"C") == false);
    	assert(batteryIsOk(25,10,0.78f,"C") == true);
    	assert(batteryIsOk(25,70,1.0f,"F") == false);
    	assert(batteryIsOk(25,10,0.7f,"F") == false);    	
    	assert(batteryIsOk(25,70,1,"F") == false);
    }
}
