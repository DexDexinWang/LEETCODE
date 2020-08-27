import java.util.LinkedList;
import java.util.List;

public class ParkingBuilding {
	final List<Level> levels;
	public ParkingBuilding(int levelNum) {
		levels = new LinkedList<>();
		int id = 0; 
		for(int i = 0; i < levelNum; i++) {
			levels.add(new Level(id++, 2, 10));
		}
	}
	
	public Slot hasSlot(Vehicle v) {
		for(Level l : levels) {
			Slot s = l.hasSlot(v);
			if(s != null) return s;
		}
		return null;
	}
	
	public Ticket park(Vehicle v) {
		Slot s = this.hasSlot(v);
		if(s == null) return null;
		s.fit(v);
		return new Ticket(v.plate);
	}
	
	public boolean leave(Ticket t) {
		for(Level l: levels) {
			for(Slot s : l.slots) {
				if(s.isVehicle(t.plate)) {
					s.leave();
					return true;
				}
			}
		}
		return false;
	}
}
