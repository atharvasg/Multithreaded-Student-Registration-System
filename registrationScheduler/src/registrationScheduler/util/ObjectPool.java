/**
 * @author Atharva
 *
 */
 
  package registrationScheduler.util;
public class ObjectPool {
	private static volatile ObjectPool pool;
	Subject subject=null;
	private ObjectPool()
	{}
	public static ObjectPool getInstance()
	{
		ObjectPool temp=pool;
		if(temp==null)
		{
			synchronized (ObjectPool.class) 
			{
				temp=pool;
				if(temp==null)
				{
					pool=temp=new ObjectPool();
				}
			}
		}
		return temp;
	}
	/**This method allocates the course to specific student.
	 * @param className
	 * @return Subject 
	 * 
	 */

	public synchronized Subject borrowObject()
	{
		if(subject==null)
		{
			subject=new Subject();
			//subject.updateSeats(className);
		}
		return subject;
	}
	/**This method checks availability of subject.
	 * @param subject,className
	 * @return boolean 
	 */
	public synchronized boolean chkAvailability(Subject sub,char className)
	{
	   boolean isAvailable=false;
	   if(sub.spacesLeft(className)>=1)
	   {
		   isAvailable=true;
	   }
	   return isAvailable;
	}

	/**This method return number of available courses.
	 * @param subject
	 * @return Integer 
	 */
	public synchronized int getNumActive(Subject sub)
	{
		int counter=sub.getAvailableCourses();
		return counter;
	}
	/**This method return number of filled courses.
	 * @param subject
	 * @return Integer 
	 */
	public synchronized int getNumIdle(Subject sub)
	{
		int counter=sub.getFilledCourses();
		return counter;
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
