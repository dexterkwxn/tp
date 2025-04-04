---
layout: page
title: User Guide
---

TAbby Dabby is a **desktop app designed for teaching assistants, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, it can get your administrative tasks done faster than traditional GUI apps.
At a glance, TAbby Dabby allows teaching assistants to:

- Manage contacts of students in their tutorial groups
- Track student attendance
- Track students' assignment scores

- Table of Contents
{:toc}

---

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest `TAbbyDabby.jar` file from [here](https://github.com/AY2425S2-CS2103T-T12-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your TAbby Dabby.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar TAbbyDabby.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   - `list` : Lists all contacts.

   - `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the list of contacts.

   - `delete 3` : Deletes the 3rd contact shown in the current list.

   - `clear` : Deletes all contacts.

   - `exit` : Exits the app.

   - `add-group n/CS2106 T10` : Adds a new group named `CS2106 T10` to the list of groups.

6. Refer to the [Features](#features) below for details of each command.

---

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

- Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

- Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

- Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

- Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a person: `add`

Adds a person to the contact list.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:

- `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
- `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Listing all persons : `list`

Shows a list of all persons in the contact list.

Format: `list`

### Editing a person : `edit`

Edits an existing person in the contact list.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

- Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
- You can remove all the person’s tags by typing `t/` without
  specifying any tags after it.

Examples:

- `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
- `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

- The search is case-insensitive. e.g `hans` will match `Hans`
- The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
- Only the name is searched.
- Only full words will be matched e.g. `Han` will not match `Hans`
- Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:

- `find John` returns `john` and `John Doe`
- `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a person : `delete`

GroupResults.png
Deletes the specified person from the contact list.

Format: `delete INDEX`

- Deletes the person at the specified `INDEX`.
- The index refers to the index number shown in the last displayed person list.
- The index **must be a positive integer** 1, 2, 3, …​

Examples:

- `list` followed by `delete 2` deletes the 2nd person in the contact list.
- `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the contact list.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Adding a new group : `add-group`

Adds a new group to the list of groups.

Format: `add-group n/GROUP_NAME`

Examples:

- `add-group n/CS2106 T10` creates a group with name `CS2106 T10`.

### Listing all groups : `list-group`

Shows a list of all existing groups along with their information, i.e., indices and names.

Format: `list-group`

Examples:
![ResultOfList](images/listGroupResults.png)

### Editing a group : `edit-group`

Edits an existing group.

Format: `edit-group INDEX [n/GROUP_NAME] [t/TAG]…​`

- Edits the group at the specified `INDEX`. The index refers to the index number shown in the last displayed group list. The index **must be a positive integer** 1, 2, 3, …​
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- When editing tags, the existing tags of the group will be removed i.e adding of tags is not cumulative.
- You can remove all the group’s tags by typing `t/` without specifying any tags after it.

Examples:

- `edit-group 1 n/G13` Edits the name of the first group to be `G13`.
- `edit-group 2 n/CS2101 G12 t/` Edits the name of the second group to be `CS2101 G12` and clears all existing tags.

### Locating a group by name : `find-group`

Finds groups whose names contain any of the given keywords.

Format: `find-group KEYWORD [MORE_KEYWORDS]`

- The search is case-insensitive. e.g `hans` will match `Hans`
- The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
- Only the name is searched.
- Only full words will be matched e.g. `Han` will not match `Hans`
- Groups matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:

- `find G13` could return groups with names like `G13`, `g13`, and `CS2101 g13`.

### Deleting an existing group : `delete-group`

Deletes the specified group from the list of groups.

Format: `delete-group INDEX`

- The index refers to the index number shown in the last displayed group list.

Examples:

- `delete-group 1` deletes the group with index `1` in the last shown group list.

### Adding a person to a group: `add-to-group`

Adds a specified person to a specified group.

Format: `add-to-group P/PERSON_NAME g/GROUP_NAME`

- `PERSON_NAME` and `GROUP_NAME` are strings representing the names of a person and a group respectively.

Examples:

- `add-to-group P/Alex Yeoh g/CS2101 T12` adds the person named `Alex Yeoh` to the group named `CS2101 T12`.

### Removing a person from a group: `delete-from-group`

Removes a specified person from a specified group.

Format: `delete-from-group P/PERSON_NAME g/GROUP_NAME`

- `PERSON_NAME` and `GROUP_NAME` are strings representing the names of a person and a group respectively.

Examples:

- `delete-from-group P/Alex Yeoh g/CS2101 T12` removes the person named `Alex Yeoh` from the group named `CS2101 T12`.

### Showing group details: `show-group-details`

Shows all the main details regarding a group.

Format: `show-group-details INDEX`

- Details include:
  - Group Name and tags
  - Number of group members
  - Name, role, and attendance of every group member
- The index refers to the index number shown in the last displayed group list.

Examples:

- `show-group-details 1` shows all the details of the group with index `1` in the last shown group list.

### Marking attendance: `mark-attendance`
Marks the attendance of the specified person in a given group for a particular week.

Format: `mark-attendance P/NAME g/GROUP_NAME w/WEEK_NUMBER`
- `NAME` is the name of the student.
- `GROUP_NAME` is the name of the group.
- `WEEK_NUMBER` must be a positive integer between 1 and 13 (inclusive).

Example:  
- `mark-attendance P/Jensen Huang g/CS2103T T12 w/10` marks the attendance for Jensen Huang in CS2103T T12 for week 10.

### Unmarking attendance: `unmark-attendance`
Removes the attendance record of the specified person in a given group for a particular week.

Format: `unmark-attendance P/NAME g/GROUP_NAME w/WEEK_NUMBER`
- `NAME` is the name of the student.
- `GROUP_NAME` is the name of the group.
- `WEEK_NUMBER` must be a positive integer between 1 and 13 (inclusive).

Example:  
- `unmark-attendance P/Jensen Huang g/CS2103T T12 w/10` unmarks the attendance for Jensen Huang in CS2103T T12 for week 10.

### Showing attendance: `show-attendance`
Displays the attendance record of the specified person in a given group.

Format: `show-attendance P/NAME g/GROUP_NAME`
- `NAME` is the name of the student.
- `GROUP_NAME` is the name of the group.

Example:  
- `show-attendance P/Jensen Huang g/CS2103T T12` displays the attendance for Jensen Huang in CS2103T T12.

---

### Saving the data

TAbby Dabby data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

TAbby Dabby data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, TAbby Dabby will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the TAbby Dabby to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

---

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous TAbby Dabby home folder.

---

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

---

## Command summary

| Action                 | Format, Examples                                                                                                                                                      |
|------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**                | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague` |
| **Clear**              | `clear`                                                                                                                                                               |
| **Delete**             | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                   |
| **Edit**               | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                           |
| **Find**               | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`                                                                                                            |
| **List**               | `list`                                                                                                                                                                |
| **Add Group**          | `add-group n/GROUP_NAME` <br> e.g., `add-group n/G13`                                                                                                                 |
| **Delete Group**       | `delete-group INDEX` <br> e.g., `delete-group 1`                                                                                                                      |
| **Edit Group**         | `edit-group INDEX [n/GROUP_NAME] [t/TAG]…​` <br> e.g., `edit-group 1 n/G13 t/ABC`                                                                                     |
| **Find Group**         | `find-group KEYWORD [MORE_KEYWORDS]` <br> e.g., `find-group G13`                                                                                                      |
| **List Group**         | `list-group`                                                                                                                                                          |
| **Add to Group**       | `add-to-group P/PERSON_NAME g/GROUP_NAME` <br> e.g., `add-to-group P/Alex Yeoh g/CS2101 T12`                                                                          |
| **Delete from Group**  | `delete-from-group P/PERSON_NAME g/GROUP_NAME` <br> e.g., `delete-from-group P/Alex Yeoh g/CS2101 T12`                                                                |
| **Show Group Details** | `show-group-details INDEX` <br> e.g., `show-group-details 1`                                                                                                          |
| **Mark Attendance**    | `mark-attendance P/NAME g/GROUP_NAME w/WEEK_NUMBER` <br> e.g., `mark-attendance P/Jensen Huang g/CS2103T T12 w/10`                                                    |
| **Unmark Attendance**  | `unmark-attendance P/NAME g/GROUP_NAME w/WEEK_NUMBER` <br> e.g., `unmark-attendance P/Jensen Huang g/CS2103T T12 w/10`                                                |
| **Show Attendance**    | `show-attendance P/NAME g/GROUP_NAME`  <br> e.g., `show-attendance P/Jensen Huang g/CS2103T T12`                                                                 |
| **Help**               | `help`                                                                                                                                                                |
