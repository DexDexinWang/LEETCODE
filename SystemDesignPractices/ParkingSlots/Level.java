import java.util.LinkedList;
import java.util.List;

public class Level {
	private int levelNo;
	final List<Slot> slots;
	public Level(int levelNo, int big, int small) {
		this.levelNo = levelNo; 
		slots = new LinkedList<>();
		int id = 0;
		for(int i = 0; i < big; i++) {
			slots.add(new Slot(id++, VehicleSize.Large));
		}
		for(int i = 0; i < small; i++) {
			slots.add(new Slot(id++, VehicleSize.Compact));
		}
	}
	
	public int getLevelNo() {
		return this.levelNo;
	}
	
	public Slot hasSlot(Vehicle v) {
		for(Slot s : slots) {
			if(s.isFit(v)) return s;
		}
		return null;
	}
}
