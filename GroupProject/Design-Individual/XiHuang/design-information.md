CreateNew(): void

Ask all information to create a new travel plan. Place, number of people, date, time, spend and services.
Save these information in database, and create a new list to store it. Total_task plus one.
Ask workers if they want to make a reminder. If yes, go SetReminder() function. Or close the system.

Edit(): void

Show all information from database which is based on the list id provided from workers. Give a form to office workers to input new information such as place, number of people, date, time, spend and services to refresh the database.

delete(): void

delete the information which is based on the list id provided from workers. 

FindNew(): Object

Get arguments from input. If the arguments are date, place or number of people. System will show the tourist route in the database based on their input. The output could be a website.

check(): Object

Show all information from database which is based on the list id provided from workers.
Ask office workers if they want to edit, set reminder or delete.
If customers input place, show all travel information about the place.
If customers input date, show all travel information at that day.
If workers input place or date, show all trips get from Date_Task or Place_Task based on input.
If yes, go Edit(), Setreminder() or delete()  function based on his choices.
 
SetReminder(): void

Get list id from input, then set the reminder depends on the date of the travel.
Send a message to customers at the day before the trip.

