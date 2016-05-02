#CS 320 Software Engineering
Green Team HIMA Application
##Members:
- Andrew Raleigh
- Jacob Downs
- Diane Tam
- Supriya Kankure
- Paul Cho
- Pandi Rrapo
- Jianyi Huang

##Background Information:
This repository represents the code for the semester long project for the course CS 320 Software Engineering at Umass Amherst. 
> In this course, students learn and gain practical experience with software engineering principles and techniques. The practical experience centers on a semester-long team project in which a software development project is carried through all the stages of the software life cycle. Topics in this course include requirements analysis, specification, design, abstraction, programming style, testing, maintenance, communication, teamwork, and software project management. Particular emphasis is placed on communication and negotiation skills and on designing and developing maintainable software.

##Product Overview:
Our software engineering project was to create a system that would allow a health inspector to conduct and perform health inspections
for food establishments efficiently and digitally. Currently, the health inspector manually inputs data from health inspections on paper,
and would like a system where he can perform inspections via tablet, be able to print inspections real time, and view inspection data via
desktop. Our system works the following way. The health inspector receives a tablet running the android operating system. We install our
android application onto the tablet. The health inspector uses the android application to either create a new inspection, or update a previous inspection, and print this inspection using a portable bluetooth printer. Then the inspector can connect the tablet via usb to his desktop, and sync the inspections to the desktop application. From the desktop application, the health inspector can view past inspections, and download them as pdfs.

##Installation:
lorem ipsum

##Architecture:
The architecture is as followed. Our code is organized into two categories: android and desktop. The android folder contains all code that allows the android application to run. We have used android studio to create our application. Currently the data is hardcoded into the application, and eventually will be replaced with a local SQLlite database. The desktop category refers to the code that creates the desktop application, and database that the desktop application is using. The database is coded in SQLite while, the desktop application is a java gui.


##Android Application:
The android application works the following way. The android application consists of a home screen where the health inspector can do the following:

- Create Inspection
- Search Inspection
- View MA Food Codes
- View Federal Food Codes


##Desktop Application:
The desktop application works the following way. The desktop application is installed on the health inspectors computer. The health inspector must login in with the correct credentials (user name is Steve, and password is foods). Once the health inspector is logged in, he can search past inspections, or sync his tablet to the desktop to retrieve inspections stored on the tablet that have not been updated to the desktop database.

##Database:
Currently there is a database set up for the java gui desktop application. The database is coded in SQL Lite. This database is connected to the java gui application as of right now.

##Existing Issues and Future Functionality:
The following are issues that are currently pending in our application:

 1. Android application currently has no local database, all methods are using mock data
 2. Android application UI needs to be fixed to look more professional
 3. Desktop java gui application needs PDF generator method
 4. Desktop java gui needs authentication
 5. Desktop java gui needs minor style changes
 6. Syncing currently does not work. Research needs to be done on how to set up this part of the application
 7.  Remote Printing has not been set up or tested.
 8. Federal and state food codes are not parsed from PDFs and placed in a searchable database

 For the future we would like to fix all the existing issues to make the project work how it should. In the future we would like to make more advanced search functions both on the tablet and desktop to make it easier for the health inspector to search for records.
