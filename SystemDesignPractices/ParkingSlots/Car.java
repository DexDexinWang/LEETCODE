
public class Car extends Vehicle {

	public Car(int num) {
		this.plate = num;
	}
	
	@Override
	public VehicleSize getSize() {
		return VehicleSize.Compact;
	}
	
}
