# Design Document



**Author**: Joseph Dadic and LongCheng Cai

## 1 Design Considerations



### 1.1 Assumptions

One design assumption for this application is that it will run on any semi-modern Android device. It is an application for reminders, so it should not be heavily taxing on the phones internal resources. Another design assumption in which we will follow in the actual implementation of the application is that the user will be using a touch-screen device. A significant issue to be assumed is managing if a user provides a certain reminder they want that interferes with the pre-set reminder type in the database. This will cause more work for the user as they will not only have to add a reminder name but also create a new type as the applications attempts to put their reminder in its own subset of types.

### 1.2 Constraints

One constraint on the system is whether the user or if the device itself has location capabilities so the user could tie in a particular location to their reminder.  Another constraint is whether or not the user is using a modern day time or if they are on military time. The last constraint between the system and the application is the internal storage of the individuals device, and how many possible reminders and other features within the app they can use before it reaches its capacity.

### 1.3 System Environment

The hardware in which the application will reside in is any Android phone with the recommendation of using the most modern possible software update to the given device. The application will also need to interact with the phones internal memory, storage, internal phone clock, phone audio, and ability to collaborate with another GPS software in the phone itself. The application will NOT run on any IOS devices or software. The application is designed in Android Studio.

## 2 Architectural Design

### 2.1 Component Diagram
![Component Diagram](https://github.com/qc-se-fall2021/370Fall21Sec37Team4/blob/main/GroupProject/Design-Team/Component%20Diagram.JPG)

User(Phone or Android Studio) connecting with the Application. And through the Application we saving the data whenever the User working on with the Application. Also the Map will connected with the Database. When ever User have login with their own account, it will call the database we have saved.   

### 2.2 Deployment Diagram

![Component Diagram](https://github.com/qc-se-fall2021/370Fall21Sec37Team4/blob/main/GroupProject/Design-Team/DeploymentDiagram.JPG)

This diagram conveys how the app interacts with the actual phone device. The app itself will be interact with the phone's display to show the user the GUI and also to act functionally as a touch screen device for user input. The App will use the phone's hardware in terms of storage and memory to store the preset reminders and the users custom reminders. The app will interact with the phone's internal map system based on the users preference if they have a reminder that they need a location to go along with it. The phone's internal clock will be used by the application as a time displayed on the application itself and to use as a trigger to set off the reminder the user has put inside for themselves in the application.

## 3 Low-Level Design

### 3.1 Class Diagram

![Class Diagram](https://github.com/qc-se-fall2021/370Fall21Sec37Team4/blob/main/GroupProject/Design-Team/LowLevelDesign.png)

1. User: Within Android Studio will reside a Java class called User. This will be where the UserName and Password is created and stored locally. It will also be where functions reside for the user to select, create, delete, and rename reminders and directly interacts with the Reminder List class.
2. Reminder List: This class will reside at the hierarchy of the Low-Level design and all things will inevitably reflect off of this. It will locally contain a dynamic Reminder List with the ability to add a reminder, remove one, modify, check off, and clear all of them as well and will contain information available for the user to see and interact with.
3. Reminder: The Reminder class is where a single individual reminder will be created and is separate from the entire entity of the reminder list itself. It is connected to the Reminder List and also interacts with the database and the Day and Time.
4. Day and Time: This class gives the ability for the user to add their own date and time to their reminder and whether or not they wish to repeat the reminder itself and is directly connected to the Reminder class as the Reminder class obtains the ability to utilize the Day and Time class to add increased optimzation to the application.
5. Database: The Data base will store only the ReminderType and ReminderName. It is utilized in a way so the information about reminders can be stored and archived within the application itself so a user can retrieve an older reminder, add a new one, and it directly associates with the Reminder class itself.

### 3.2 Other Diagrams
![Use Case Diagram](https://github.com/qc-se-fall2021/370Fall21Sec37Team4/blob/041e2ed79cec53fbf4e1ef3ea5cca001e47b722a/GroupProject/Design-Team/UseCaseModelUML.jpg)



## 4 User Interface Design
![Class Diagram](https://github.com/qc-se-fall2021/370Fall21Sec37Team4/blob/main/GroupProject/Design-Team/UserInterfaceDesign.png)

