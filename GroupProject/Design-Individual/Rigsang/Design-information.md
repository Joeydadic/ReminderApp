1.	A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list edit and reminder the reminder from the list.
•	ClassName : listReminders
All the method’s names allow users to add, delete and edit.
	addreminderName
	reminderName
	reminderName
	reminderName
2.	We have a database that contains reminders and corresponding data.
a.	Implemented in the UML guidelines.
3.	Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment
a.	When the user goes to invoke the reminders methods of a class called ReminderType which has a predefined type.
4.	Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.
a.	In our listView class there is a method called searchRemindes where users can search for a reminder by directly requesting to the database across multiple lists. This is handled by reachReminder method. We also have another method called the addReminderType method where the user can add reminder type when creating new reminders in the typeset class.
5.	The reminders must be saved automatically and immediately after they are modified.
a.	We automatically update the database once the reminder is created in list of reminders
6.	 Users must be able to check off reminders in the list (without deleting them).
a.	We have primitive type Boolean that will identify the crossed off or not part of the isCheckedOff attribute.
7.	Users must also be able to clear all the check-off marks in the reminder list at once.
a.	The listReminder class is responsible for getting all the reminders in the database. It makes sure that the list of items is known by the items that are shared the values of each attribute in the reminder object and reset there by the Boolean value of isCheckOff.
8.	Check-off marks for the reminder list are persistent and must also be saved immediately.
a.	isCheckOff attribute in the reminders main class is carried with the object to the database as soon as the object is finished and saved.
9.	The application must present the reminders grouped by type.
a.	Each reminder type of attribute that is saved with reminder making each reminder to be grouped by their reminder type when needed.
10.	The application must support multiple reminder lists at a time (e.g., Weekly, Monthly, Kid's Reminders). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.
a.	The class called listviews is a collection of objects the list Reminder we have access to all the methods.
11.	The application should have the option to set up reminders with day and time alerts. If this option is selected allow the option to repeat the behavior.
a.	The Reminder classes have three attributes. IsAllDay Boolean determines whether the reminder is an instance of all day and sets the dateTime to zero but the isAllday is set to false which will take date Time to be entered and the repeadsRemnder to execute the Reminder class. We also have endingDate attribute for all the series to repeats.
12.	Extra Credit: Option to set up reminders based on location.
a.	The setLocation function/method of reminder calls invokes the google maps API class.
13.	The User Interface (UI) must be intuitive and responsive.
a.	The aim is to design the guidelines of google material but is not displayed or model in UML.

