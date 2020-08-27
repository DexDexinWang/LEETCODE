import java.awt.Button;

public class Main2 {

	public interface GUIFactory{
		public Button createButton();
	}
	
	class WinFactory implements GUIFactory{

		@Override
		public Button createButton() {
			return null;
		}
		
	}
	
	class OSXFactory implements GUIFactory{

		@Override
		public Button createButton() {
			return null;
		}
		
	}
	
	class Application {
		private final GUIFactory factory;
		Application(GUIFactory f) {
			this.factory = f;
		}
		void run() {
			Button button = factory.createButton();
			//....
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Read the configuration if Windows create WinFactory with given application otherwise create OSXFactory 
		 * */
	}

}
