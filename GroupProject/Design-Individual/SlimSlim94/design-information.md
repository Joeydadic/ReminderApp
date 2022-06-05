  1. A list consisting of reminders the users want to be aware of. The application must allow
users to add reminders to a list, delete reminders from a list, and edit the reminders in
the list.
  --I created a few classes such as ReminderList that would be an array-list of reminders that were
set for a specific list. The user would be able to amend the list according to their needs by using
the methods, addReminder()(adds a new reminder), removeReminder()(removes a reminder from list),
modifyReminder()(modifies and existing reminder).

2. The application must contain a database (DB) of reminders and corresponding data.
  -- the database would contain reminders that the user could choose from. The user could then
decide to add a new type of reminder via the addNewReminderType() method if they decide they
would like to make their own.


3. Users must be able to add reminders to a list by picking them from a hierarchical list,
where the first level is the reminder type (e.g., Appointment), and the second level is the
name of the actual reminder (e.g., Dentist Appointment).
  --when adding a reminder to the ReminderList the user would have to choose from a list what type of
reminder they would like to use and then they would have to name the reminder whatever they would like.
the Reminder class would have the classifications of reminder that the user could choose from.

4. Users must also be able to specify a reminder by typing its name. In this case, the
application must look in its DB for reminders with similar names and ask the user
whether that is the item they intended to add. If a match (or nearby match) cannot be
found, the application must ask the user to select a reminder type for the reminder, or
add a new one, and then save the new reminder, together with its type, in the DB.
  --using the findReminder() method we would compare reminders from the DB in order to
  find any reminders with a similar name. if the search results in a similar reminder then the
  user will be asked if they want to proceed with adding it. if not then it proceeds to ask them for
  the type and will ask them if they would like to create a new type. if yes, the new type will be added
  to the DB via the addNewReminderType() method.

5. The reminders must be saved automatically and immediately after they are modified.
  --this will be done via the modifyReminder() method that I created.


6. Users must be able to check off reminders in the list (without deleting them).
  --The checkoff() method in ReminderList will give the user the option to choose which reminder they
  want to check off from that specific list.

7. Users must also be able to clear all the check-off marks in the reminder list at once.
  --the clearAll() method will allow the user to remove all checks from previously selected
  reminders. this will only alter the current list that is selected.


8. Check-off marks for the reminder list are persistent and must also be saved immediately.
 --the checkoff() method will ensure that the marks are persistent and saved immediately.

9. The application must present the reminders grouped by type.
 --When prompted to view the list. the reminders will be displayed in Alphabetical order based on
 reminder type.

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
“Kid’s Reminders”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete reminder lists.
--the user has the option to create multiple reminder lists via the createReminderList() method.
this gives the user the ability to make a list for Weekly, Monthly or Kid's. The user has the
option to choose which list to view by using the selectReminderList() method. In addition they
can rename existing lists via the renameReminderList() method. If they choose,  they can also
remove a list via the removeReminderlist() method.


11. The application should have the option to set up reminders with day and time alert. If this
option is selected allow option to repeat the behavior.
-- Once the user has selected the reminder name and reminder type. Either from the database or creating
their own. they will be asked to select the time and date of their reminder. this will be done by using
the setDateAndTime() method in the Reminder class.

12. Extra Credit: Option to set up reminder based on location.
13. The User Interface (UI) must be intuitive and responsive
