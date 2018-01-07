package Lab4_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Lab4_2.CSVUtilities;

public class BackEnd {
	public static void csvWriter(String file,String name, int score) throws IOException
	{	
		final String comma = ",";
		final String l = "\n";
		final String header = "Name,Score";
		
		FileWriter fileWriter = null;

		 try {
			             fileWriter = new FileWriter(file);
			             fileWriter.append(header.toString());
			             fileWriter.append(l);
			             
			             fileWriter.append(name);
			             fileWriter.append(comma);
			             fileWriter.append(String.valueOf(score));
			             fileWriter.append(l);
		 }
	     catch (Exception e) {
		            System.out.println("Error");
		            e.printStackTrace();
		        } finally {
		            try {
		                fileWriter.flush();
		                fileWriter.close();
		            } catch (IOException e) {
		                System.out.println("Error");
		                e.printStackTrace();
		            }
		        }

	}
	
}
