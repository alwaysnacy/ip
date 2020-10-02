# User Guide

## Starting Duke program

### Using Command Line

2. Open Command Prompt (on Windows) or Terminal (on Mac)
3. Change directory to the folder where `ip.jar` file are stored by `cd` into `ip\out\artifacts\ip_jar`
4. Change the font in Command Prompt to NSimSan by typing `chcp 65001` in Command Prompt
6. Type in `java -Dfile.encoding=UTF-8 -jar ip.jar`, then enter to run Duke. 

_________

## Viewing possible actions: `help`
Format `help`

## Adding a task to Duke
Words in `UPPERCASE` are the parameters

#### Adding a Todo: `todo` `event` `deadline`
Adds a Todo to the Duke

_Format_: `todo DESCRIPTION`

__Example:__

- `todo borrow The kite runner`
- `todo return the pen get from Jen`

#### Adding an Event
Adds an Event to the Duke

_Format_: `event DESCRIPTION /at YYYY-MM-DD HH:MM`

__Example:__

- `event project meeting /at 2020-09-23 12:00`
- `event join the BumbleBee Welcome Tea /at 2020-09-23 12:00`

#### Adding a Deadline
Adds a Deadline to the Duke

_Format_: `deadline DESCRIPTION /by YYYY-MM-DD HH:MM`

__Example:__

- `deadline project report /by 2020-09-23 12:00`
- `deadline join the BumbleBee First Evaluation /by 2020-09-23 12:00`

## Listing all tasks: `list`
Shows a list of all tasks in Duke, along with their details, status and ID

_Format_: `list`

## Marking task as done: `done`
Marks a task specified by its ID as done. You have to list all the tasks first using `list` before using `done`

_Format_: `done ID`

__Example__:

- `list` `done 1`: will mark the first task in the last shown list as done
- `list` `done 3`: will mark the third task in the last shown list as done

## Deleting task: `delete`
Deletes a task specified by its ID. You have to list all the tasks first using `list` before using `delete`

_Format_: `delete ID`

__Example__:

- `list` `delete 1`: will delete the first task in the last shown list
- `list` `delete 3`: will delete the third task in the last shown list

## Find task: `find`
Finds tasks containing a given keyword

_Format:_ `find KEYWORD`

__Example:__:

- `find book`: will return all tasks having _book_ in their description
- `find project`: will return all tasks having _project_ in their description

## Exiting the program: `bye`
Exits the Duke

_Format:_ `bye`


