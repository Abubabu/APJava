package CSV;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class CSVReader {
	public static void main(String[] args) throws IOException
	{
	/*	Path pathToFile = Paths.get("book.csv");
		BufferedReader buff = Files.newBufferedReader(pathToFile);
		String line = buff.readLine();
		while (line != null) { 
			line = buff.readLine();
			String[] attributes = null;
			if (line != null) {
				attributes = line.split(",");
			} 
			if (attributes != null) {
				for (String x : attributes) {
					System.out.println(x);
				} 
			}
		} */
		String[] yes = {"apple","potat","mom","what","do","you"};
		FileWriter fileWriter = new FileWriter("result1.csv");
		BufferedWriter bw = new BufferedWriter(fileWriter);
		for (String x : yes) {
			bw.write(x);
			bw.write(",");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		Path pathToFile = Paths.get("result1.csv");
		BufferedReader buff = Files.newBufferedReader(pathToFile);
		String linez = buff.readLine();
		while (linez != null) { 
		linez = buff.readLine();
		String[] attributes = linez.split(","); 
			for (String x : attributes) {
				System.out.println(x);
			} 
		}
	}
}
