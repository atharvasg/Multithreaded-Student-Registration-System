package registrationScheduler.store;

import registrationScheduler.util.Student;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import registrationScheduler.util.Logger;

public class Results implements StdoutDisplayInterfce,FileDisplayInterface 
{

	//ArrayList<String> Names=new ArrayList<String>();
	BufferedWriter writer;
	File file;
	String outputFile;
	FileWriter fwriter;
	int totalPreferenceScore;
	float averagePreferenceScore=0;
	Student student;
	StringBuilder output=new StringBuilder();
	ArrayList<Student> students= new ArrayList<Student>();
	ArrayList<String> subjectA=new ArrayList<String>();
	ArrayList<String> subjectB=new ArrayList<String>();
	ArrayList<String> subjectC=new ArrayList<String>();
	ArrayList<String> subjectD=new ArrayList<String>();
	ArrayList<String> subjectE=new ArrayList<String>();
	ArrayList<String> subjectF=new ArrayList<String>();
	ArrayList<String> subjectG=new ArrayList<String>();
	
	public Results(String outFile,Student stud)
	{
		outputFile=outFile;
		student=stud;
		Logger.writeMessage("Constructor of Result is called\n", Logger.Level.CONSTRUCTOR_CALL);
	}
	
	/**This method adds new student to result structure and returns that reference.
	 * @param student,Name
	 * @return Student
	 */	
	public synchronized Student addNewStudent(Student student,String Name)
	{
		student.setName(Name);
		students.add(student);
		return student;
	}
	
	/**This method adds details of student to result structure.
	 * @param student,Name
	 * @return Nothing
	 */
	public synchronized void updateRecord(Student student,int preferenceScore)
	{
		student.setNoOfAllocatedCourses(student.getNoOfAllocatedCourses()+1);
		student.setPreferenceScore(student.getPreferenceScore()+preferenceScore);
	}
	
	/**This method allocated courses for each student record.
	 * @param Name, className
	 * @return Nothing
	 */
	public synchronized void allocateCourses(String Name,char className)
	{
		switch(className)
		{
			case 'A':
				subjectA.add(Name);
				break;
			case 'B':
				subjectB.add(Name);
				break;
			case 'C':
				subjectC.add(Name);
				break;
			case 'D':
				subjectD.add(Name);
				break;
			case 'E':
				subjectE.add(Name);
				break;
			case 'F':
				subjectF.add(Name);
				break;
			case 'G':
				subjectG.add(Name);
				break;
		}
	
	}
	/**This method prints result structure to output file.
	 * @param Nothing
	 * @return Nothing
	*/
	@Override
	public synchronized void writeSchedulestoFile() 
	{
		 totalPreferenceScore=0;
		 file=new File(outputFile/*"Resources/output.txt"*/);
	  	  try
	  	  {
	  		  if(!file.exists())
	  		  {
	  			  file.createNewFile();
	  		  }
	  		  fwriter=new FileWriter(file);
	  		  writer=new BufferedWriter(fwriter);
			  for(int iterator=0;iterator<80;iterator++)
			  {
				  student=students.get(iterator);
				  output.append(student.getName()+" ");
				  if(subjectA.contains(student.getName()))
				  {
					  output.append('A'+" ");
				  }
				  if(subjectB.contains(student.getName()))
				  {
					  output.append('B'+" ");
				  }
				  if(subjectC.contains(student.getName()))
				  {
					  output.append('C'+" ");
				  }
				  if(subjectD.contains(student.getName()))
				  {
					  output.append('D'+" ");
				  }
				  if(subjectE.contains(student.getName()))
				  {
					  output.append('E'+" ");
				  }
				  if(subjectF.contains(student.getName()))
				  {
					  output.append('F'+" ");
				  }
				  if(subjectG.contains(student.getName()))
				  {
					  output.append('G'+" ");
				  }
				  output.append(Integer.toString(student.getPreferenceScore())+'\n');
				  totalPreferenceScore+=student.getPreferenceScore();
				  writer.write(output.toString());
				  output.setLength(0);
			  }
			  averagePreferenceScore=calculateAveragePreferenceScore(totalPreferenceScore);   
			  writer.write("Average preference score is:"+ averagePreferenceScore);
			  writer.close();

	  	  }catch(IOException e)
	  	  {
	  		  e.printStackTrace();
	  	  }
	}

	/**This method prints result structure on stdout.
	 * @param Nothing
	 * @return Nothing
	*/
	@Override
	public synchronized void writeSchedulesToScreen() 
	{
		totalPreferenceScore=0;
		for(int iterator=0;iterator<80;iterator++)
		  {
			  student=students.get(iterator);
			  output.append(student.getName()+" ");
			  if(subjectA.contains(student.getName()))
			  {
				  output.append('A'+" ");
			  }
			  if(subjectB.contains(student.getName()))
			  {
				  output.append('B'+" ");
			  }
			  if(subjectC.contains(student.getName()))
			  {
				  output.append('C'+" ");
			  }
			  if(subjectD.contains(student.getName()))
			  {
				  output.append('D'+" ");
			  }
			  if(subjectE.contains(student.getName()))
			  {
				  output.append('E'+" ");
			  }
			  if(subjectF.contains(student.getName()))
			  {
				  output.append('F'+" ");
			  }
			  if(subjectG.contains(student.getName()))
			  {
				  output.append('G'+" ");
			  }
			  output.append(Integer.toString(student.getPreferenceScore()));
			  output.append("\n");
			  totalPreferenceScore+=student.getPreferenceScore();
		  }
		
		  averagePreferenceScore=calculateAveragePreferenceScore(totalPreferenceScore);
		  if(Logger.getLevel()==Logger.Level.NO_OUTPUT)
		  {
			  System.out.print("Average preference score is:"+ averagePreferenceScore);
		  }
		  else if(Logger.getLevel()==Logger.Level.DATA)
		  {
			  output.append("Average preference score is:"+ averagePreferenceScore);
			  System.out.println(output);
			  output.setLength(0);

		  }
		  
	}
	
	/**This method calculates average preference score.
	 * @param score
	 * @return float
	*/
	private synchronized float calculateAveragePreferenceScore(int score)
  	{	
  		try
  		{
	  		float averageScore;
	  		averageScore=(float)score/students.size();
	  		return averageScore;
  		}
  		catch(Exception e)
  		{
  			System.err.println("Error while calculating average");
  			System.out.println("Error while calculating average");
  			e.printStackTrace();
  			System.exit(0);
  		}
  		return 0;
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
	
