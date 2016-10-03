
CS542 Design Patterns
Fall 2016
PROJECT 2 README FILE
Author(s): Atharva S Ghaisas

PURPOSE:
Multithreaded Program for assigning the courses to students based on their preferences.

PERCENT COMPLETE:
I believe I have completed 90% of this project.

PARTS THAT ARE NOT COMPLETE:
Complete algorithm for rearranging students if all are not getting 5 courses allocated.

REGARDING DATA STRUCTURE USED IN FOR CREATING AND MAINTAINING RESULTS:

1.I am using set of arraylists for holding the participants in  each class. Arraylists are faster than general arrays and have worst case time complexity - 
O(n) for retrieval and O(1) for addition.

2. Also for reading and temporary storage I am using hasmap whose worst case complexity is O(n) for retrieval.

FILES:
Included with this project are 13 files.

Driver.java             file containing driver program for taking in input and also contains main.
CourseAllocaor.java     logic for assigning subject to students.
Student.java		file that holds student related information (used as a part of end data structure).
FileDisplayInterface    Interface for printing results to file.
StdoutDisplayInterfce	Interface for printing results on console.
Results			file containing logic for holding the student data and manipulation.
WorkerThreads		file containing the working of threads i.e. run method.
CreateWorkers		file for creating worker threads.
FileProcessor		file for reading the input file.
Logger			file containing logger logic for debugging.
ObjectPool		file that maintains and tracks the courses.
Subject			file maintaining all the information about courses.


README.txt		the Text file you are presently reading.


TO COMPILE:

ant -buildfile src/build.xml all

TO RUN:

ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -
Darg2=3 -Darg3=0
