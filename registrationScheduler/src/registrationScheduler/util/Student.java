
/**This class will hold the information regarding students (Name, allocated courses, preference score).
 * @author Atharva
 *
 */
 package registrationScheduler.util;
 
public class Student 
{
	int noOfAllocatedCourses;
	int preferenceScore;
	String Name;
	public Student()
	{
		Name=null;
		preferenceScore=0;
		noOfAllocatedCourses=0;
		Logger.writeMessage("Constructor of Student is called\n", Logger.Level.CONSTRUCTOR_CALL);
	}
	public int getPreferenceScore() {
		return preferenceScore;
	}
	public void setPreferenceScore(int preferenceScore) {
		this.preferenceScore = preferenceScore;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getNoOfAllocatedCourses() {
		return noOfAllocatedCourses;
	}
	public void setNoOfAllocatedCourses(int noOfAllocatedCourses) {
		this.noOfAllocatedCourses = noOfAllocatedCourses;
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
