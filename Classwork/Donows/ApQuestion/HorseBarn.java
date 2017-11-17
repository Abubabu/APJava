package ApQuestion;

public class HorseBarn {
	
	private Horse[] spaces;
	
	public HorseBarn(Horse[] array)
	{
		this.spaces = array;
	}

	public void consolidate() {
		Horse[] consolidated = new Horse[this.spaces.length];
		int counter = 0;
		for(Horse x : this.spaces)
		{
			if(x != null)
			{
				consolidated[counter] = x;
				counter++;
			}
		}
		this.spaces = consolidated;
	}

	public int findHorseSpace(String name) {
		for(int i = 0; i < this.spaces.length; i++)
		{
			if(this.spaces[i] != null && this.spaces[i].getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	public  String toString() {
		String enter = "";
		for(int i = 0; i < spaces.length; i++)
		{
			enter += "[" + spaces[i] + "] ";
		}
		return enter;
	}

}
