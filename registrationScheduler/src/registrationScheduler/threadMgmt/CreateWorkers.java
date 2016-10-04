package registrationScheduler.threadMgmt;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.StdoutDisplayInterfce;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.util.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Subject;
import registrationScheduler.util.CourseAllocator;
import registrationScheduler.threadMgmt.WorkerThreads;


public class CreateWorkers {
	FileProcessor processor;
	Thread[] thread;
	FileDisplayInterface fileDisplay;
	StdoutDisplayInterfce stdoutDisplay;
	Student student;
	CourseAllocator allocate;
	WorkerThreads worker;
	Subject subject;
	
	public CreateWorkers(FileProcessor fpIn,FileDisplayInterface fdisplayIn,Student studIn,CourseAllocator allocatorIn)
	{
		processor=fpIn;
		fileDisplay=fdisplayIn;
		student=studIn;
		allocate=allocatorIn;
		Logger.writeMessage("Constructor of CreateWorker is called\n", Logger.Level.CONSTRUCTOR_CALL);
	}
	
	/**This method creates the multiple threads depending on numThreads and start them and join on them.
	 * @param numThreads
	 * @return Nothing
	*/
	public void startWorkers(int numThreads)
	{
		int counter;
		thread=new Thread[numThreads];
		try
		{
			for(counter=0;counter<numThreads;counter++)
			{
				worker = new WorkerThreads(processor,fileDisplay,student,allocate);
				thread[counter]=new Thread(worker);
			}
			for(counter=0;counter<numThreads;counter++)
			{
				thread[counter].start();
			}
			for(counter=0;counter<numThreads;counter++)
			{
				thread[counter].join();
			}
		}catch(InterruptedException e)
			{
				System.err.println("Already joined on thread.");
				System.out.println("Already joined on thread.");
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
