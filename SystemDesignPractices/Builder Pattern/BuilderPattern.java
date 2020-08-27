
public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User.UserBuilder("Test","Test").age(7).address("Test").phone("Test").build();
	}

}
