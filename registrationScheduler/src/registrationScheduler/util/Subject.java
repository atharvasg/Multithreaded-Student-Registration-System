package registrationScheduler.util;
public class Subject
{
	public int AllocatedA=0;
	public int AllocatedB=0;
	public int AllocatedC=0;
	public int AllocatedD=0;
	public int AllocatedE=0;
	public int AllocatedF=0;
	public int AllocatedG=0;
	int capacity=60;
	int available=0;
	int filled=0;
	int numberOfSubjects=7;
	public Subject()
	{
		
	}
	/**This method returns number of courses that have capacity left.
	 * @param Nothing
	 * @return Integer
	*/
	public int getAvailableCourses()
	{
		if(capacity-AllocatedA>0)
		{
			available++;
		}
		else
		{
			available++;
		}
		if(capacity-AllocatedB>0)
		{
			available++;
		}
		if(capacity-AllocatedC>0)
		{
			available++;
		}
		if(capacity-AllocatedD>0)
		{
			available++;
		}
		if(capacity-AllocatedE>0)
		{
			available++;
		}
		if(capacity-AllocatedF>0)
		{
			available++;
		}
		if(capacity-AllocatedG>0)
		{
			available++;
		}
		return available;
	}
	
	/**This method returns number of courses that are full.
	 * @param Nothing
	 * @return Integer
	*/
	public int getFilledCourses()
	{
		int total=getAvailableCourses();
		filled=numberOfSubjects-total;
		return filled;
	}
	
	/**This method updates course allocations.
	 * @param className
	 * @return Integer
	*/
	public int updateSeats(char className)
	{
		switch(className)
		{
			case 'A':
				if(AllocatedA<capacity)
				{
					AllocatedA++;
				}
				break;
			case 'B':
				if(AllocatedB<capacity)
				{
					AllocatedB++;
				}
				break;
			case 'C':
				if(AllocatedC<capacity)
				{
					AllocatedC++;
				}
				break;
			case 'D':
				if(AllocatedD<capacity)
				{
					AllocatedD++;
				}
				break;
			case 'E':
				if(AllocatedE<capacity)
				{
					AllocatedE++;
				}
				break;
			case 'F':
				if(AllocatedF<capacity)
				{
					AllocatedF++;
				}
				break;
			case 'G':
				if(AllocatedG<capacity)
				{
					AllocatedG++;
				}
				break;
		}
		return 0;
	}
	
	/**This method returns number of remaining spaces in the particular course.
	 * @param className
	 * @return Integer
	*/
	public int spacesLeft(char className)
	{
		int available=0;
		switch(className)
		{
			case 'A':
				if(AllocatedA<capacity)
				{
					available = capacity - AllocatedA;
				}
				break;
			case 'B':
				if(AllocatedB<capacity)
				{
					available = capacity - AllocatedB;
				}
			
				break;
			case 'C':
				if(AllocatedC<capacity)
				{
					available = capacity - AllocatedC;
				}
				break;
			case 'D':
				if(AllocatedD<capacity)
				{
					available = capacity - AllocatedD;
				}
				break;
			case 'E':
				if(AllocatedE<capacity)
				{
					available = capacity - AllocatedE;
				}
				break;
			case 'F':
				if(AllocatedF<capacity)
				{
					available = capacity - AllocatedF;
				}
				break;
			case 'G':
				if(AllocatedG<capacity)
				{
					available = capacity - AllocatedG;
				}
				break;
		}
		return available;
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
