package registrationScheduler.util;
public class Logger {
	public static enum Level{NO_OUTPUT,DATA,DATA_INSERT,RUN_CALL,CONSTRUCTOR_CALL};
	public static Level setLevel;
	
	/**This method sets the debug level depending on the input supplied.
	 * @param debuglevel
	 * @return Nothing
	*/
	public static void setDebugLevel(int debugValue)
	 {
		 switch(debugValue)
		 {
		 	case 0:
		 		setLevel=Level.NO_OUTPUT;
		 		break;
		 	case 1:
		 		setLevel=Level.DATA;
		 		break;
		 	case 2:
		 		setLevel=Level.DATA_INSERT;
		 		break;
		 	case 3:
		 		setLevel=Level.RUN_CALL;
		 		break;
		 	case 4:
		 		setLevel=Level.CONSTRUCTOR_CALL;
		 		break;
		 }
	 }
	
	/**This method writes the custom message by the logger to stdout.
	 * @param message, level
	 * @return Nothing
	*/
	 public static void writeMessage (String message, Level level ) 
	 {
			if (level == setLevel)
			    System.out.println(message);
	 }
	 
	 /**This method returns current debug level.
		 * @param Nothing
		 * @return Level
		*/
	 public static Level getLevel()
	 {
		 return setLevel;
	 }
}
