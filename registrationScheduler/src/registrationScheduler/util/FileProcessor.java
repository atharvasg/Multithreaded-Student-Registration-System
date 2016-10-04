
 package registrationScheduler.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import registrationScheduler.util.Logger;

public class FileProcessor {
		String record;
		String inputFile;
		BufferedReader reader=null;
		FileReader fp=null;
		public FileProcessor(String ipFile)
		{
			inputFile=ipFile;
			Logger.writeMessage("Constructor of FileProcessor is called\n", Logger.Level.CONSTRUCTOR_CALL);
		}
	/*
	 * Need to make sure that should behave correctly if end of line is reached.
	 * */
		public synchronized String readRecord()
		{
			try
			{
				if(fp==null)
				{
					fp=new FileReader(inputFile);
					reader=new BufferedReader(fp);
				}
				record=reader.readLine();
				
			}catch(FileNotFoundException e)
			{
				System.err.println("File not found");
				System.out.println("File not found");
				e.printStackTrace();
				System.exit(0);
			} catch (IOException e) 
				{
				System.err.println("Error while doing IO");
				System.out.println("Error while doing IO");
				e.printStackTrace();
				System.exit(0);
				}
			return record;
	}
	@Override
	public String toString() {
		return "";
	}
}
