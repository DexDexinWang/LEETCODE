
public class Truck extends Vehicle{
	
	public Truck(int num) {
		this.plate = num;
	}
	@Override
	public VehicleSize getSize() {
		return VehicleSize.Large;
	}
}
