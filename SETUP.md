# Local Environment Setup Guide

If you are forking this repository to build your own version of the assignment, follow these steps exactly to get your environment running.

## Phase 1: Prerequisites
Before you touch any code, you need three things downloaded on your computer:
1. **Eclipse IDE for Enterprise Java and Web Developers**: You MUST get the "Enterprise" version, or you won't be able to build web projects.
2. **Apache Tomcat v10.1**: Download the `.zip` file and extract it to a folder on your computer (e.g., `C:\Tomcat`).
3. **MySQL Connector/J**: Download the platform-independent `.zip`, extract it, and locate the `.jar` file inside.

## Phase 2: Cloning the Repo
1. Fork this repository to your own GitHub account.
2. Open Eclipse, go to **Window > Show View > Other...** and search for **Git Repositories**.
3. Click **Clone a Git repository** and paste your forked GitHub URL. Finish the cloning wizard.
4. Go to **File > New > Dynamic Web Project**. 
   * Give it the same name as the repo.
   * **Uncheck** "Use default location" and browse to the git folder you just cloned.
   * Under "Target runtime", click **New Runtime**, select **Apache Tomcat v10.1**, check the box to **Create a new local server**, and point it to your extracted Tomcat folder.

## Phase 3: The Secret Database File (CRITICAL)
For security reasons, database passwords are never uploaded to GitHub. You must create a local configuration file for your own database.

1. In Eclipse's Project Explorer, expand the project to `src/main/java`.
2. Right-click `src/main/java`, select **New > File**, and name it exactly `config.properties`.
3. Copy the text found in `example.config.properties` into the file and fill in your own remote MySQL details:


*(Note: If you are using a hosted database like Namecheap or cPanel, ensure you have added your computer's IP address to the **Remote MySQL** whitelist in your hosting dashboard, or the connection will be blocked! Contact me with your IP Address, I can help with that)*

## Phase 4: Add the MySQL Driver

1. Find that MySQL Connector `.jar` file you downloaded in Phase 1.
2. In Eclipse, expand the project down to `src/main/webapp/WEB-INF/lib`.
3. **Drag and drop** the `.jar` file directly into that `lib` folder inside Eclipse.

## Phase 5: Tweaking it for Your Assignment

To change this project to use your own database tables (e.g., a `Students` or `Cars` table instead of `Patients`):

1. **Update the Model:** Go to `src/main/java/com/models` and create a new Java class representing your table's columns (with variables, a constructor, and getters).
2. **Update the DAO:** Go to `src/main/java/com/dao`, copy how `PatientDAO` works, but change the SQL `SELECT` string to target your specific table.
3. **Update the View:** Open `index.jsp` and update the HTML table headers. Change the Java loop at the bottom to call your new DAO and display your new Model's getters.

## Phase 6: Run It!

Right-click your `index.jsp` file, select **Run As > Run on Server**, and select your Tomcat server.