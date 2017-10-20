import java.time.Period;
import java.util.Date;

public class Student extends People{
	private int osis;
	private String[] classes;
	private String schoolName;
	private double GPA;
	private int gradeLevel;
	public Student(int osis,String[] classes,String schoolName, double GPA, int gradeLevel,Date DOB,String firstname,String lastname)
	{
		super(DOB,firstname,lastname);
		this.osis = osis;
		this.classes = classes;
		this.schoolName = schoolName;
		this.GPA = GPA;
		this.gradeLevel = gradeLevel;
	}
	public int calculateAge()
	{
		Date date = new Date();
		return Period.between(this.DOB, date).getYears();
	}
	
}
