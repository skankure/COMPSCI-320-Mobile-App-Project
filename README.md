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
lorem ipsum
