 package registrationScheduler.util;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.store.Results;

/**
 * @author Atharva
 *
 */
public class CourseAllocator {
	Student student;
	ObjectPool pool;
	Subject subject;
	FileDisplayInterface fileDisplay;
	int requiredSubjects=0;
	char className;
	Map<Character, Integer> preferences;
	public CourseAllocator( FileDisplayInterface fDisplay,Student stud)
	{
		fileDisplay=fDisplay;
		student=stud;
		Logger.writeMessage("Constructor of CourseAllocator is called\n", Logger.Level.CONSTRUCTOR_CALL);
	}
	public synchronized void allocateCourses(String[] words,Map<Character,Integer> preferences)
	{
		student=new Student();
		pool=ObjectPool.getInstance();
		requiredSubjects=5;
		//int remainingOptions=7;
		student=((Results)fileDisplay).addNewStudent(student,words[0]);
		for(int counter=1;counter<=7;counter++)
		{
			for (Entry<Character, Integer> entry : preferences.entrySet()) 
			{
				  subject= pool.borrowObject();
				  className=entry.getKey();
				  if(counter==entry.getValue())
				  {
					  if(pool.chkAvailability(subject, entry.getKey()) && student.getNoOfAllocatedCourses()<requiredSubjects)
					  {
						   subject.updateSeats(className);  	
						  ((Results)fileDisplay).updateRecord(student, counter);
						  ((Results)fileDisplay).allocateCourses(words[0],className);
						  break;
					  }
				/*	  else
					  {
						  if(student.getNoOfAllocatedCourses() <= requiredSubjects && remainingOptions < requiredSubjects - student.getNoOfAllocatedCourses())
						  {
							  //pool.reassign();
						  }
						  //break;
					  }
					  remainingOptions--;
				  }*/
				  else
				  {
					  continue;
				  }	       
			}
	    }
	  }
		Logger.writeMessage("Entry added to Results:"+student.getName()+":"+student.getNoOfAllocatedCourses()+":"+student.getPreferenceScore(), Logger.Level.DATA_INSERT);
     }
	
	/**This method maps input string into hashmap with subjects as key and preferences as value.
	 * @param words[] - containing student record.
	 * @return Nothing
	*/
	public synchronized Map<Character,Integer> setHashMap(String[] words)
	{
		preferences=new HashMap<Character, Integer>();
		char first='A';
		try
		{
			for(int counter=1;counter<words.length;counter++)
			{
				preferences.put(first, Integer.parseInt(words[counter]));
				first=(char)((int)first+1);
			}
			return preferences;
		}catch(NumberFormatException e)
		{
			System.out.println("Problem in hashmap");
			System.err.println("Problem in hashmap");
			e.printStackTrace();
			System.exit(0);
		}
		return null;
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
