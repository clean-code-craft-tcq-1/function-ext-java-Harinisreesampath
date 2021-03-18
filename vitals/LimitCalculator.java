package vitals;

public class LimitCalculator {
	public float limitHolder[] = new float[5];
	
	public float[] getLimitHolder() {
		return limitHolder;
	}

	public LimitCalculator(int percentageValue, float upper, float lower, int numberOfLimits) {
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
}
