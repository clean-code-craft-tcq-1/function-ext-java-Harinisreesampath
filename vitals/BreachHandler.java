package vitals;

public class BreachHandler {

	static void isActionNeeded(boolean measurementStatus, String breachedMeasurement) {
		System.out.println("measurementStatus : "+ measurementStatus);
		if(!measurementStatus) {
			System.out.println("Taking action for breached "+ breachedMeasurement);
		}
			
	}
	
}
