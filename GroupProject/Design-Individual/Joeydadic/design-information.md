1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list. 

   I have shown in the UML design list a class named ReminderList, which has methods within this class itself to add, delete, and edit said reminders with attributes of reminderListName, reminderListType, reminderId and reminderTypeId. This class is associated with the database





2. The application must contain a database (DB) of reminders and corresponding data.

   I have created a class in the UML design specifically to act as a database which stores the data as an ArrayList so it can be dynamic.



3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).

   In the UML design I have created a User class, which is a subclass of the reminderList class. Since the reminderList is a hierarchical list and contains reminder type and the whole name of the reminder itself, the User can add and interact with that list.



 4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.

    The user class has a method called reminderSearch which will search the database for specific names and call upon methods in the database itself that will search the database and interact with the user, and save the data of the reminder in the database.

5. The reminders must be saved automatically and immediately after they are modified. 

   reminders are saved automatically within the dbAdd() method

6. Users must be able to check off reminders in the list (without deleting them). 

   the method reminderCheckOff() in the user UML design allows users to check off reminders without deleting them.

7. Users must also be able to clear all the check-off marks in the reminder list at once.

   the method reminderCheckoffClear() allows users to check-off marks in the reminder list all at once. 

8. Check-off marks for the reminder list are persistent and must also be saved immediately.

   both methods interact with the database directly to be saved immediately and the database uses an arraylist for the data to handle it dynamically and in time.

   9. The application must present the reminders grouped by type.

      The application will do it within itself.

      

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists. 

    The User class has methods in it to allow this. reminderListSelect(), reminderListCreate(), reminderListAdd() and reminderListDelete() allow the user to perform these functions.

    11. The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior. 

        the class Date is a subclass of the User. If they use this option they can inherit all of the methods the user has along with its own methods of setters and getters for the current time and date in association to their reminders.

    12. Extra Credit: Option to set up reminder based on location. 

        My UML design does not include this function.

    13.  The User Interface (UI) must be intuitive and responsive.

        It is not possible for me to display the fact that the UI must be intuitive and responsive within this UML design.