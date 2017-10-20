import java.util.Date;

public abstract class People {
	public String firstname, lastname;
	public Date DOB;
	public abstract int calculateAge();
	public abstract String toString();
	public People(Date DOB,String firstname,String lastname)
	{
		this.DOB = DOB;
		this.firstname = firstname;
		this.lastname = lastname;
	}
}
