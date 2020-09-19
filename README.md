# Log-Analyser
Software Construction Assignment 2 - Simple Log Analyser Application
Thiluxan
Elankumaran
Mohanatheesan
Sachchithananthan
Sajeesan
Jeyanthiran




For the Second Year, 1st Semester we were assigned to do a group project
(Assignment - 2) for the Software Construction Course.The task is to create
a command-line log analyzer application using an object-oriented
language (We used java oop).
Package: database
DataRepository.java - Interface for retrieving data from mysql database
DabaseConnection.java - Connect our database
EmailRepository - Get email accounts in database by implementing
DataRepository interface.
package: timeStamp
SavedTimeStamp - Return the saved timeStamp in the output text file
TimesStampRepository - Return the list of timeStamps in the log file
Package: operations
FileExistOperation - Check for ERROR in log file, if it is already read and
ERROR found in previous instance.
FileNotExitOperation - Check for ERROR in log file, if it is read for first time in
the application
OperationFactory - select the operation based on weather the log file is
already read or not
Package: fileoperations
FileExit -returns true if file contains any data
FileRead -Read the file
FileWrite -Write the file
package: input
Input.java - Interface for getting user input
CommandLineInput.java - Implementing Input Interface and getting user input
from command line
package: email
MainConfiguration.java - Configure mail sending using the smtp server of
mailgun
MailSending.java - Sending mail to the email list passed into the class
LogAnalyserApp.java - For making interconnections between classes using
their instances
Main.java - Creating instances of classes and executing LogAnalyserApp