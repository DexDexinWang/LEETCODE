
public class Singleton {
	public static final Singleton INSTANCE = new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		return INSTANCE;
	}
}
