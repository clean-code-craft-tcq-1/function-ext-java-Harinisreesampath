package vitals;


public class Main {
	public static final int PERCENTAGE =5;
	public static final float LOWER_TEMPERATURE = 0;
	public static final float HIGHER_TEMPERATURE = 45;
	public static final float LOWER_SOC = 20;
	public static final float HIGHER_SOC = 80;
	public static final float HIGHER_CHARGERATE = 0.8f;
	public static final float NORMAL_CHARGERATE = 0.0f;
	public static final int SINGLE_LIMIT = 1;
	public static final int DOUBLE_LIMIT = 2;
	static float temperatureLimitHolder[];
	static String temperatureMessageList[];
	static float socLimitHolder[];
	static String socMessageList[];
	static float chargeRateLimitHolder[];
	static String chargeRateMessageList[];
	
    static boolean batteryIsOk(float temperature, float soc, float chargeRate, String measurementUnit) {   	
    	temperatureLimitHolder = new LimitCalculator(PERCENTAGE, HIGHER_TEMPERATURE, LOWER_TEMPERATURE, DOUBLE_LIMIT).getLimitHolder();
    	temperatureMessageList = new MessageGenerator("Temperature").getOutputMessage();
    	boolean temperatureCheck = ParameterHandler.isTemperatureOk(temperature, measurementUnit);
    	printMessage(ParameterCheckMessage.breachMessage, "Temperature");
    	ParameterCheckMessage.breachMessage = "NORMAL";
    	
    	socLimitHolder = new LimitCalculator(PERCENTAGE, HIGHER_SOC, LOWER_SOC, DOUBLE_LIMIT).getLimitHolder();
    	socMessageList = new MessageGenerator("SOC").getOutputMessage();
    	boolean socCheck = ParameterHandler.isSOCOk(soc);
    	printMessage(ParameterCheckMessage.breachMessage, "State of Charge");
    	ParameterCheckMessage.breachMessage = "NORMAL";
    	
    	chargeRateLimitHolder = new LimitCalculator(PERCENTAGE, HIGHER_CHARGERATE, NORMAL_CHARGERATE, SINGLE_LIMIT).getLimitHolder();
    	chargeRateMessageList = new MessageGenerator("ChargeRate").getOutputMessage();
    	boolean chargeRateCheck = ParameterHandler.isChargeRateOk(chargeRate);
    	printMessage(ParameterCheckMessage.breachMessage, "Charge Rate");  	
    	ParameterCheckMessage.breachMessage = "NORMAL";

 	
    	BreachHandler.isActionNeeded(temperatureCheck, "Temperature");
    	BreachHandler.isActionNeeded(socCheck, "Charge State (SOC)");
    	BreachHandler.isActionNeeded(chargeRateCheck, "Charge Rate");
    	
   		return (temperatureCheck && socCheck && chargeRateCheck);    	   	
    }
    
    
    static void printMessage(String message, String type) {
    	System.out.println(type + " : " +message);
    }
    
    public static void main(String[] args) {
    	System.out.println(batteryIsOk(26, 66, 0.3f,"F") == true);
    	System.out.println(batteryIsOk(1, 84, 0.9f,"C") == false);
    	System.out.println(batteryIsOk(25,10,0.78f,"F") == true);
    }
}
