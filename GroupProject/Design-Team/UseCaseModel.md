# Use Case Model
**Author**: Sean Ramlall

## Use Case Diagram
![Use Case Diagram](https://github.com/qc-se-fall2021/370Fall21Sec37Team4/blob/041e2ed79cec53fbf4e1ef3ea5cca001e47b722a/GroupProject/Design-Team/UseCaseModelUML.jpg)

## Use Case Desciptions

#### Create Reminder List
- Requirements: This use case will allow the user to create a new list in which the user can then proceed to add, remove or modify reminders. Multiple Lists can be made.
- Pre-Conditions: The user must be logged in so we know which set of information to access.
- Post-Conditions: The user will be able to select the list they have created. This will allow them to modify the list as they see fit. They can select, modify or delete the list after this step.
- Scenarios: The user clicks the "Create list" button. After they name the list they have to option to choose this list via the "Select List" button.


#### Select Reminder List
- Requirements: This will allow the user to choose which Reminder List they would like to modify.
- Pre-Conditions:In order to be able to select a list, the user must be logged in and have at least one created list.
- Post-Conditions : Once a list is selected it allows the user to add or remove a reminder to the chosen list. Users will also be able to modify reminders that are on the list and choose to check off certain reminders or clear all the reminders on the list.  
- Scenarios: User has chosen a list. They can now add a reminder or remove/modify a previously made one. The user can decide if they would like to check off a reminder from the list or if they choose, clear all checks from selected reminders on the list.

#### Delete Reminder List
- Requirements: This will allow the user to delete a reminder list they have made previously.
- Pre-Conditions:There must be at least one reminder list available.
- Post-Conditions: Once this step is done the list will no longer be available to be selected because it has been deleted.
- Scenarios: The user has decided they no longer they need this reminder list or it has been made in error. they can select this button and now permanently remove this list.

#### Rename Reminder List
- Requirements: this will allow the user to rename a list they have made to whatever they see fit.
- Pre-Conditions: there must be at least one reminder list created.
- Post-Conditions: the reminder list that was renamed will now have a new name that replaced the pre existing name.
- Scenarios: The user has decided they want to change the name of one of their lists. they click the rename reminder list button and now have the option to choose which list they would like to change the name of. When they input a new name and click submit the list is renamed.

#### Add Reminder
- Requirements: this will allow the user to add a reminder to their list. They must choose a name, date and time along with the type of reminder. created reminders are stored in alphabetical order based on the type of reminders.
- Pre-Conditions: a valid reminder list must be selected.
- Post-Conditions: once a reminder is added it can be modified or checked off in the future. they will also be allowed to set the time and date for the reminder. They must choose a reminder type or create a new type.
- Scenarios: the user has chosen the reminder list they wish to use and now they will add a reminder for a future event. they can then set the time and date to their reminder and name it. the app will also ask them what type of reminder they want to make. it will pull previous types from a DB if they choose they can create a new type of reminder.

#### Remove Reminder
- Requirements: this will allow a user to remove a reminder from a list if they no longer wish to have it there.
- Pre-Conditions: there must be an existing and selected list to edit. The selected list must also contain at least one existing reminder to be deleted.
- Post-Conditions: when a reminder is deleted it is no longer found on the reminder list. The reminder has been permanently removed from the list.
- Scenarios: The user has decided to remove a reminder. they select a list and click the remove reminder button. Once they do that they choose which reminder they would like to delete from the list. Once they choose it is permanently removed.

#### Modify Reminder
- Requirements: this case will allow the user to modify a reminder from the selected list. they can edit the date, time or name of the reminder.
- Pre-Conditions: there must be a selected list with at least one available reminder.
- Post-Conditions: the changes that were implemented to the reminder must overwrite the previous data.
- Scenarios: the user has decided to change one of the reminders. they click the modify reminder button and choose which reminder to modify by using the check off box near its name. upon doing that they can change the name, time or date of the reminder they have chosen.

#### Check Off
- Requirements: this will allow the user to select one or multiple reminders without deleting them. This will be used in conjuntion with the remove reminders button. 
- Pre-Conditions: there must be a selected list with at least one or more reminders.
- Post-Conditions: once multiple reminders have been checked off they are all selected and the proceeding action effects all of them. They will be able to clear all the check offs if they use the clear all action. The user can also de select the reminder by checking off the list again.
- Scenarios: the user has decided to select two or more reminders from the list. once they click the check box near one or more existing reminders they can choose the proceeding action such as deletion or they can clear all the the check offs they have made.

#### Clear All
- Requirements: this will allow the user to clear all the check offs they have made to the selected reminders. 
- Pre-Conditions: there must be selected reminders that have been checked off previously
- Post-Conditions: the previously checked off reminders are no longer checked off. 
- Scenarios: the user has selected multiple reminders and wished to clear all of the selections they have made. they click the button for clear all and all selections have been de selected.

#### Find Reminder
- Requirements: This case is used so the database can be checked for previously used types of reminders. The application will look in the DB for reminders with similar names and try to help the user find the correct type.
- Pre-Conditions: the user must have a selected list and is in the process of creating a new reminder to add to that list.
- Post-Conditions: once the type has been found the new reminder will be attributed that type. if it has not been found the user can opt to create a new type and add it to the DB.
- Scenarios: the user has chosen their list to edit. if they want to add a reminder to this list they must choose a type. when choosing a type the DB will be searched for previously named reminders and use their types as a reccomendation. if none can be found the user will be able to add a new reminder type to the DB.

#### Add New Reminder Type
- Requirements: this case is used when the user would like to add a new type of reminder to the DB.
- Pre-Conditions: the user is creating a reminder and is in the FindReminder Process. 
- Post-Conditions: the new type of reminder is added to the DB and can be accessed by future reminders while they are being created.
- Scenarios: the user was unable to find a suitable reminder type so they have decided to make a new one. they click add a new reminder type and proceed to create a new one for current and future use.

#### Set Day and Time
- Requirements: this will allow the user to choose a day and time when creating their reminder. this will be when the reminder sends out its alert.
- Pre-Conditions: there must be a created list and the user must be in the process of creating or modifying their reminder. 
- Post-Conditions: Once the day and time has been set the reminder will be triggered at that specific point. this can be edited via the modify reminder case.
- Scenarios: The user has decided they want to make a reminder. they click on the list they want to add it to then they click add reminder. once they do that they can name it, choose its type and then set the day and time.

#### Repeat Reminder
- Requirements: this will give the user the option to repeat a reminder daily, weekly, monthly. if one is chosen the Reminder will trigger an alert at the same time each day, week, or month based on the selection chosen.
- Pre-Conditions: the reminder list has been chosen and a reminder is being added. once the day and time has been selected this option will be allowed. 
- Post-Conditions:Once a selection has been made the reminder will repeat regularly as decided until it is modified or deleted.
- Scenarios: the user needs a weekly reminder. they create the reminder and set the date and time. they decide that they want the reminder to repeat at the same time every week after the inital reminder. they will select the weekly reminder option which will set up the same reminder as a recurring reminder.