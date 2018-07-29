package eyeroh.elementalmastery.machine.capacitor;

public class CapacitorDirection {
	
	String axis;
	int direction;
	
	public CapacitorDirection(String axis, int direction) {
		this.axis = axis;
		this.direction = direction;
	}
	
	public String getAxis() {
		return this.axis;
	}
	
	public int getDirection() {
		return this.direction;
	}
}