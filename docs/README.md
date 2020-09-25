# User Guide

## Features 

### Add tasks to a list - `todo` `deadline` `event`
Allows the user to add tasks to their list
  1. ToDos: tasks without any date/time attached to it e.g., visit the Zoo
  2. Deadlines: tasks that need to be done before a specific date/time e.g., submit report by 20/10/2020 12am
  3. Events: tasks that start at a specific time and ends at a specific time e.g., team project meeting on 20/10/2020 3-5pm

### List tasks - `list`
Allows the user to store text entered and display back to them when requested

### find tasks - `find`
Allows the user to find tasks in the list by searching using keywords

### Mark as Done - `done`
Allows the user to mark tasks as done

### delete tasks in a list - `delete`
Allows the user to delete tasks from the list

### Exit Duke - `bye`
Allows the user to exit Duke

## Usage

### `todo` `deadline` `event`
Adds a task to the list
Format - `todo {DESCRIPTION}`, `deadline {DESCRIPTION} /by {DATE/TIME}`, `event {DESCRIPTION} /at {DATE/TIME}`

#### Example of usage: 
```
todo visit the Zoo
deadline submit report /by 20/10/2020 12am
event team project meeting /at 20/10/2020 3-5pm
```

#### Expected outcome:
```
____________________________________________________________
Got it. I've added this task:
  [T][✘] visit the Zoo
Now you have 1 task in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][✘] submit report (by: 20/10/2020 12am)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][✘] team project meeting (at: 20/10/2020 3-5pm)
Now you have 3 tasks in the list.
____________________________________________________________
```

#### Important notes:
An error will occur if the user does not enter a `DATE/TIME` for deadline and event tasks.
```
____________________________________________________________
 ☹ OOPS!!! The description of a deadline/event cannot be empty.
__________________________________________________________
```

### `list`
Prints the tasks in the list

#### Example of usage:
`list`

#### Expected outcome:
```
____________________________________________________________
Here are the task(s) in your list:
1.[T][✘] visit the Zoo
2.[D][✘] submit report (by: 20/10/2020 12am)
3.[E][✘] team project meeting (at: 20/10/2020 3-5pm)
____________________________________________________________
```

### `find`
Finds all tasks in the list that contains the keywords that the user inputs
Format - `find {KEYWORD}`

#### Example of usage:
`find team`

#### Expected outcome:
```
____________________________________________________________
 Here are the matching task(s) in your list:
[E][✘] team project meeting (at: 20/10/2020 3-5pm)
____________________________________________________________
```
#### Important notes:
An error will occur if the `KEYWORD` cannot be found in the list
```
____________________________________________________________
Sorry! I could not find any task with {KEYWORD} in the list
____________________________________________________________
```
### `done`
Marks a task in the list at the index provided by the user
format - `done {INDEX}`

#### Example of usage:
`done 3`

#### Expected outcome:
```
____________________________________________________________
 Nice! I've marked this task as done:
   [E][✓] team project meeting (at: 20/10/2020 3-5pm)
____________________________________________________________
```

#### important notes:
An error will occur if the `INDEX` is not an integer
```
____________________________________________________________
 ☹ OOPS!!! Invalid index format entered
____________________________________________________________
```

### `delete` 
Deletes the task in the list at the index provided by the user
format - `delete {INDEX}` 

#### Example of usage:
`Delete 2`
```

```
####
