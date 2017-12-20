package Lab4_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVUtilities {
	ArrayList<String> CSVData;
	int rowLength;
	
	public CSVUtilities(File csv) throws IOException
	{
		boolean toggle = true;
		ArrayList<String> yes = new ArrayList<String>();
		Path pathToFile = Paths.get(csv.getAbsolutePath());
		BufferedReader buff = Files.newBufferedReader(pathToFile);
		String line = buff.readLine();
		while (line != null) { 
			line = buff.readLine();
			String[] attributes = null;
			if (line != null) {
				attributes = line.split(",");
				if(toggle)
				{
					toggle = ! toggle;
					this.rowLength = attributes.length;
				}
			} 
			if (attributes != null) {
				for (String x : attributes) {
					yes.add(x);
				} 
			}
		}
		this.CSVData = yes;
	}
	
	public List<String> getColumnHeaders()
	{
		ArrayList<String> yes = new ArrayList<String>();
		for(int i = 0; i < rowLength; i++)
		{
			yes.add(CSVData.get(i));
		}
		return yes;
	}
	
	public List<String> getColumnData(int column)
	{
		ArrayList<String> yes = new ArrayList<String>();
		for(int i = column; i < this.CSVData.size(); i = i + rowLength)
		{	String x = CSVData.get(i);
			if(!(x.equals("")))
			{
				yes.add(CSVData.get(i));
			}
			else
			{
				yes.add("NULL");
			}
		}
		return yes;
	}
	
	public List<Integer> getDataInt(int column)
	{
		ArrayList<Integer> yes = new ArrayList<Integer>();
		for(int i = column; i < this.CSVData.size(); i = i + rowLength)
		{
			String x =(CSVData.get(i));
			if(!(x.equals("")))
			{
				yes.add(Integer.parseInt(x));
			}
			else
			{
				yes.add(null);
			}
		}
		return yes;
	}
	
	public List<Double> getDataDouble(int column)
	{
		ArrayList<Double> yes = new ArrayList<Double>();
		for(int i = column; i < this.CSVData.size(); i = i + rowLength)
		{
			String x =(CSVData.get(i));
			if(!(x.equals("")))
			{
				yes.add(Double.parseDouble(x));
			}
			else
			{
				yes.add(null);
			}
		}
		return yes;
	}
	
}
