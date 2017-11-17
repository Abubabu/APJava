package ApQuestion;

public class Mustang implements Horse {

	private String name;
	private int weight;
	public Mustang(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public String getName()
	{
		return name;
	}
	public int getWeight()
	{
		return weight;
	}
	public String toString()
	{
		return name;
	}
}
