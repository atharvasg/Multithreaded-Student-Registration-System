package registrationScheduler.threadMgmt;

import java.util.Map;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.util.Student;
import registrationScheduler.util.Subject;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.CourseAllocator;
import registrationScheduler.util.Logger;


public class WorkerThreads implements Runnable
{
	FileProcessor processor;
	String outputFile;
	Student student;
	int requiredSubjects;
	char className;
	FileDisplayInterface fileDisplay;
	ObjectPool pool;
	Subject subject;
	String[] words= new String[7];
	CourseAllocator allocate;
	Map<Character, Integer> preferences;
	String record=new String();
	int priority;
	public WorkerThreads(FileProcessor fpIn, FileDisplayInterface fDisplayIn,Student studIn,CourseAllocator allocatorIn)
	{
		processor=fpIn;
		fileDisplay=fDisplayIn;
		student=studIn;
		allocate=allocatorIn;
		Logger.writeMessage("Constructor of WorkerThread is called\n", Logger.Level.CONSTRUCTOR_CALL);
	}
	/**This method overrides the run method of thread class.
	 * @param Nothing
	 * @return Nothing
	*/
		@Override
	public void run() 
	{
		Logger.writeMessage("run method is called by "+Thread.currentThread().getName()+"\n", Logger.Level.RUN_CALL);
		record=processor.readRecord();
		while(record!=null)
		{
			words=record.split(" ");
			preferences=allocate.setHashMap(words);
			allocate.allocateCourses(words,preferences);
			record=processor.readRecord();
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

