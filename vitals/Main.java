package vitals;


public class Main {
	public static final int PERCENTAGE = 5;
	public static final float LOWER_TEMPERATURE = 0;
	public static final float HIGHER_TEMPERATURE = 45;
	public static final float LOWER_SOC = 20;
	public static final float HIGHER_SOC = 80;
	public static final float HIGHER_CHARGERATE = 0.8f;
	public static final float NORMAL_CHARGERATE = 0;
	public static final int SINGLELIMIT = 1;
	public static final int DOUBLELIMIT = 2;
	
    static boolean batteryIsOk(float temperature, float soc, float chargeRate, String measurementUnit) {
    	if(measurementUnit.equalsIgnoreCase("F"))
    		temperature = convertingTemperatureToCelius(temperature) ;
    	
    	MeasurementProcessor temperatureProcessor = new MeasurementProcessor(PERCENTAGE, HIGHER_TEMPERATURE, LOWER_TEMPERATURE, DOUBLELIMIT);
    	temperatureProcessor.setTemperatureMessage();
    	printMessage(temperatureProcessor.singleLimitMessage(chargeRate), "Temperature");
    	MeasurementProcessor socProcessor = new MeasurementProcessor(PERCENTAGE, HIGHER_SOC, LOWER_SOC, DOUBLELIMIT);
    	socProcessor.setSOCMessage();
    	printMessage(socProcessor.singleLimitMessage(chargeRate), "State of Charge");
    	MeasurementProcessor chargeRateProcessor = new MeasurementProcessor(PERCENTAGE, HIGHER_CHARGERATE, NORMAL_CHARGERATE, SINGLELIMIT);
    	chargeRateProcessor.setChargeRateMessage();
    	printMessage(chargeRateProcessor.singleLimitMessage(chargeRate), "Charge Rate");
    	
   		return (temperatureProcessor.isStatus() && socProcessor.isStatus() && chargeRateProcessor.isStatus());    	   	
    }
    
    static void printMessage(String message, String type) {
    	System.out.println(type + " : " +message);
    }
    
    static float convertingTemperatureToCelius(float temperatureInFahrenheit ) {
    	temperatureInFahrenheit = (temperatureInFahrenheit - 32) * 5/9 ;
    	return temperatureInFahrenheit;
    }
   
    public static void main(String[] args) {
    	System.out.println(batteryIsOk(25, 70, 0.6f,"C") == true);
    	System.out.println(batteryIsOk(44, 24, 0.0f,"C") == false);
    	System.out.println(batteryIsOk(25,10,0.78f,"C") == true);
    	System.out.println(batteryIsOk(25,70,1.0f,"F") == false);
    	System.out.println(batteryIsOk(-25,10,0.7f,"F") == true);    	
    	System.out.println(batteryIsOk(25,70,1,"F") == false);
    }
}
