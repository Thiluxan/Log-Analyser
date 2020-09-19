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
language (We used java oop).<br>
Package: database<br>
DataRepository.java - Interface for retrieving data from mysql database<br>
DabaseConnection.java - Connect our database<br>
EmailRepository - Get email accounts in database by implementing<br>
DataRepository interface.<br><br>
package: timeStamp
<br>SavedTimeStamp - Return the saved timeStamp in the output text file
<br>TimesStampRepository - Return the list of timeStamps in the log file
<br><br>Package: operations
<br>FileExistOperation - Check for ERROR in log file, if it is already read and
ERROR found in previous instance.
<br>FileNotExitOperation - Check for ERROR in log file, if it is read for first time in
the application
<br>OperationFactory - select the operation based on weather the log file is
already read or not
<br><br>Package: fileoperations
<br>FileExit -returns true if file contains any data
<br>FileRead -Read the file
<br>FileWrite -Write the file
<br><br>package: input
<br>Input.java - Interface for getting user input
<br>CommandLineInput.java - Implementing Input Interface and getting user input
from command line
<br><br>package: email
<br>MainConfiguration.java - Configure mail sending using the smtp server of
mailgun
<br>MailSending.java - Sending mail to the email list passed into the class
<br><br>LogAnalyserApp.java - For making interconnections between classes using
their instances
<br><br>Main.java - Creating instances of classes and executing LogAnalyserApp
