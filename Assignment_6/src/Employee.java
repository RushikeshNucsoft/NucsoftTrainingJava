
public class Employee {
	
	private long id;
	private String name;
	private int age;
	private String emailId;
	private String contact;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(long id, String name, int age, String emailId, String contact) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.contact=contact;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public boolean validateContact(String contact)
	{
		if (contact.length() != 10)  return false;
		else return true;
	}
	
	

}
