
public class Main {

	public interface Shape {
		void draw();
	}

	public class Rectangle implements Shape{
		public Rectangle() {}
		@Override
		public void draw() {
			System.out.println("Inside Ractangle::draw() method");
		}
	}
	
	public class Square implements Shape{
		public Square() {}
		@Override
		public void draw() {
			System.out.println("Inside Square::draw() method");
		}
	}
	
	public class Cycle implements Shape{
		public Cycle() {}
		@Override
		public void draw() {
			System.out.println("Inside Cycle::draw() method");
		}
	}
	
	public class ShapeFactory{
		public Shape getShape(String shapeType) {
			if(shapeType == null) {
				return null;
			} else if (shapeType.equals("SQUARE")) {
				return new Square();
			} else if (shapeType.equals("RECTANGLE")) {
				return new Rectangle();
			} else if (shapeType.equals("CYCLE")) {
				return new Cycle();
			} 
			return null;
		}
	}
	
	public class FactoryPatternDemo{
		private final ShapeFactory shapeFactory = new ShapeFactory();
		
		public void demo(String[] args) {
			Shape shape1 = shapeFactory.getShape("CYCLE");
			shape1.draw();
			Shape shape2 = shapeFactory.getShape("RECTANGLE");
			shape2.draw();
			Shape shape3 = shapeFactory.getShape("SQUARE");
			shape3.draw();
		}
		
	}
	
	/*
    	1.	Separate instance/object creation logic from its usage
		2.	More clean especially when we have complicated instance creation logic
		3.	Easier to extend the instance creation logic (extend the factory only)
		4.	Provide chances to have different object allocation strategies. (e.g., what if we want to reuse shape objects)

	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
