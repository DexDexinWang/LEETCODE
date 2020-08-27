
public class User{
		private final String firstName;// required;
		private final String lastName; // required
		private int age; // optimal
		private String phone;
		private String address;
		
		//Problem: so many constructions.
		public User(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public User(String firstName, String lastName, int age, String phone, String address) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.phone = phone;
			this.address = address;
		}
		
		public User(String firstName, String lastName, int age) {
			this( firstName,  lastName,  age,  "", "");
		}

		//Solution I, Get() Set() 
		//However the solution could work as below steps
		//   User user = new Users(firstName, lastName);   --> create an object that could be accessed with 0 age and empty address. 
		//   user.setAge(99);
		//   user.setAddress("111111");
		//   ....
		//   
		//Limitation Solution I
		//1. It requires multiple function calls to create an object. but first init step has already created an accessible object 
		//2. Do not want to expose setters for some data.
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
		//Solution 2 Create a Builder
		
		private User(UserBuilder builder) {
			this.firstName = builder.firstName;
			this.lastName = builder.lastName;
			this.age = builder.age;
			this.address = builder.address;
			this.phone = builder.phone;
		}
		
		public static class UserBuilder {
			private final String firstName;// required;
			private final String lastName; // required
			private int age; // optimal
			private String phone;
			private String address;
			
			public UserBuilder(String firstName, String lastName) {
				this.firstName = firstName;
				this.lastName = lastName;
			}
			
			public UserBuilder age(int age) {
				this.age = age;
				return this;
			}
			
			public UserBuilder address(String address) {
				this.address = address;
				return this;
			}
			
			public UserBuilder phone(String phone) {
				this.phone = phone;
				return this;
			}
			
			public User build() {
				return new User(this);
			}
		}
		
	}