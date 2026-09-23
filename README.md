# BarakaAnly

BarakaAnly is a Java 17 console application for managing and analyzing bank transactions.

The project uses JDBC to connect to MySQL. It includes the basic structure for clients, accounts, transactions, and reports.

## Features

- Record deposits, withdrawals, and transfers
- View an account's transaction history
- Manage clients and accounts
- Analyze transactions and show alerts

## Technologies

- Java 17
- MySQL
- JDBC

## Running the project

1. Create a MySQL database called `Testing`.
2. Check the connection details in `src/database/DB.java`.
3. Add the MySQL JDBC driver to the project.
4. Run `src/Main.java`.

The application starts in the console and displays the main menu.

## Project structure

- `src/DAO` - database access classes
- `src/database` - database connection
- `src/entity` - clients, accounts, and transactions
- `src/Services` - application logic
- `src/Presentation` - console menus
