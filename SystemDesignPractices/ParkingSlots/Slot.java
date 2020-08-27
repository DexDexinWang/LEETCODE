
public class Slot {
	private VehicleSize size;
	private Vehicle vehicle;
	private int slotNo;
	private boolean isFull;
	
	public Slot (int slotNo, VehicleSize size) {
		this.slotNo = slotNo;
		this.size = size;
		isFull =false;
	}
	
	public int getSlotID() {
		return this.slotNo;
	}
	
	public boolean isFit(Vehicle v) {
		return this.isFull ? false : v.size == VehicleSize.Compact ? true : this.size == v.size; 
	}
	
	public boolean fit(Vehicle v) {
		this.vehicle = v;
		this.isFull = true; 
		return true;
	}
	
	public boolean isVehicle(int num) {
		return this.vehicle.plate == num;
	}
	
	public void leave() {
		this.isFull = false;
	}
}
