package vitals;

public class ParameterHandler {
	public static boolean isTemperatureOk(float temperature, String measurementUnit) {
    	if(measurementUnit.equalsIgnoreCase("C"))
    		temperature = TemperatureUnitConverter.convertingTemperatureToFahrenheit(temperature) ;
    	
		MeasurementProcessor temperatureProcessor = new MeasurementProcessor();
		temperatureProcessor.islowBreach(temperature, Main.temperatureLimitHolder, Main.temperatureMessageList);
    	temperatureProcessor.isHighBreach(temperature, Main.temperatureLimitHolder, Main.temperatureMessageList);
    	return temperatureProcessor.isViolates(temperature, Main.temperatureLimitHolder, Main.temperatureMessageList);
	}
	public static boolean isSOCOk(float soc) {
		MeasurementProcessor socProcessor = new MeasurementProcessor();
		socProcessor.islowBreach(soc, Main.socLimitHolder, Main.socMessageList);
		socProcessor.isHighBreach(soc, Main.socLimitHolder, Main.socMessageList);
		return socProcessor.isViolates(soc, Main.socLimitHolder, Main.socMessageList);
	}
	public static boolean isChargeRateOk(float chargeRate) {
		MeasurementProcessor chargeRateProcessor = new MeasurementProcessor();
		return chargeRateProcessor.singleLimitMessage(chargeRate, Main.chargeRateLimitHolder, Main.chargeRateMessageList);
	}
}
