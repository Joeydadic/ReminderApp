# Test Plan

Group 3

## 1 Testing Strategy

### 1.1 Overall strategy

All functions we create.
Add
Modify
Delete
Rename
Select
Find_Reminder
Set_Time
Set_Day
Repeat

### 1.2 Test Selection

We will use JUnit to do the test.

### 1.3 Adequacy Criterion

All functions we create.
Add

parameters:
number of people	int
name of people		String
Place			String
Time			String
Event			String

Return:
time			String
Reminder_ID		int

Modify

parameters:
number of people	int
name of people		String
Place			String
Time			String
Event			String

Return:
time			String
Reminder_ID		int

Delete


parameters:
Reminder_ID		int

Select
Reminder_ID		int

Return:
List:{
number of people	int
name of people		String
Place			String
Time			String
Event			String
}

Find_Reminder
Reminder_ID		int

Return:
List:{
number of people	int
name of people		String
Place			String
Time			String
Event			String
}

### 1.4 Bug Tracking

If there have errors or failures, we can find that which test code didn't run succussfully. Check the test code And we will know which function has problem. Then we can try to fix the bug.

### 1.5 Technology

First of all, import JUnit 5 library.
Then write down the test code and result in the test file.
Run the code to check if the result is equal to answer which we give.
If there are no errors and failures, it means our project works.

## 2 Test Cases

Here is an example:

 private Reminder reminder1;
    
    @Before
    public void setUp() {
        reminder1 = new Reminder();
    }

    @After
    public void tearDown() {
        reminder1 = null;
    }

    @Test
    public void AddReminder() {
        assertEquals("12:00pm", reminder1.AddReminder("2,James,Jane,Queens,12:00pm,they have a meeting"));
    }

parameters:
number of people	int
name of people		String
Place			String
Time			String
Event			String

Return:
time			String