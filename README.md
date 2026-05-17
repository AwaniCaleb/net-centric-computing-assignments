# Net-Centric Computing Assignment

This is a Java-based web application built to demonstrate database connectivity and data retrieval using Java Servlets, JSP (JavaServer Pages), and a remote MySQL database.

## Architecture: The DAO Pattern
This project is structured using the **Data Access Object (DAO) Pattern** to keep the code clean, modular, and easy to modify. It is divided into three main parts:

1. **The Model (`com.models.Patient`)**: A standard Java class that acts as a container for a single row of database data.
2. **The DAO (`com.dao.PatientDAO`)**: The bridge to the database. This file contains the SQL queries, connects to the database, and packs the results into a list of Model objects.
3. **The View (`index.jsp`)**: The front-end HTML page. It calls the DAO, receives the data, and loops through it to display an HTML table.

## Tech Stack
* **Language:** Java 21
* **Web Server:** Apache Tomcat 10.1
* **Database:** MySQL (Hosted remotely)
* **IDE:** Eclipse IDE for Enterprise Java and Web Developers

*If you are looking to run this project on your own machine or fork it for your own assignment, please read the `SETUP.md` file for step-by-step instructions!*