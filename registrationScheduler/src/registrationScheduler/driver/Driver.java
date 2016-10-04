/**
 * 
 */
 
package registrationScheduler.driver;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterfce;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Student;
import registrationScheduler.util.CourseAllocator;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.Logger;

import java.security.InvalidParameterException;
/**
 * @author Atharva
 *
 */
public class Driver 
{
	/**
	 * @param args
	 * @return Nothing
	 */
	public static void main(String[] args) 
	{
		FileProcessor processor;
		Results result;
		FileDisplayInterface fileDisplay;
		StdoutDisplayInterfce stdoutDisplay;
		CreateWorkers worker;
		CourseAllocator allocate;
		Student student;
		String inputFile;
		String outputFile;
		int noOfThreads=0;
		int debugValue=0;
		try 
	    {
			if(args.length>4 || args.length<0)
			{
				throw new InvalidParameterException(); 
			}
			else
			{
				inputFile= new String();
				outputFile=new String();
				inputFile=args[0];
				outputFile=args[1];
				student=new Student();
				noOfThreads=Integer.parseInt(args[2]);
		    	debugValue=Integer.parseInt(args[3]);
		    	if(debugValue>4 || debugValue<0)
		    	{
		    	  throw new Exception();
		    	}
		    	Logger.setDebugLevel(debugValue);
		    	processor=new FileProcessor(inputFile);
		    	result=new Results(outputFile,student);
				fileDisplay=result;
				stdoutDisplay=result;
				allocate=new CourseAllocator(fileDisplay,student);
				worker=new CreateWorkers(processor,fileDisplay,student,allocate);
				worker.startWorkers(noOfThreads);
				stdoutDisplay.writeSchedulesToScreen();		
				fileDisplay.writeSchedulestoFile();
				
			}
	    }catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Index out of bounds");
			System.err.println("Index out of bounds");
	    	e.printStackTrace();
			System.exit(0);
		}
		catch(InvalidParameterException r)
		{
			System.out.println("Invalid Number of parameter");
			System.err.println("Invalid Number of parameter");
			r.printStackTrace();
			System.exit(0);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid Value of parameter");
			System.err.println("Invalid Value of parameter");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Value of parameter");
			System.err.println("Invalid Value of parameter");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	/**This method displays the string representation of object.
	 * @return String 
	 */
	@Override
	public String toString()
	{
		return "";
	}
}
