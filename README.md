# 📞 Java Console PhoneBook

A simple Java console-based PhoneBook application.

## Features
- Add new contacts
- Prevent duplicate names and phone numbers
- Delete contacts
- View all saved contacts
- Data persistence using `PhoneBook.txt`
- Automatic file loading on startup
- Error handling for invalid input

## How It Works
- Contacts are stored in a `HashMap`
- On startup, data is loaded from `PhoneBook.txt`
- After each modification, the file is rewritten to keep data consistent

## Technologies
- Java
- File Handling (BufferedWriter / BufferedReader)
- Collections (HashMap)
- Basic Exception Handling

## Run
Compile and run the `Main` class.
