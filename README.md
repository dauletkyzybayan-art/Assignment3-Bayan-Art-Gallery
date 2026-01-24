# Art Gallery Management System (Java + JDBC)

## A. Project Overview

### Purpose of the Application
Art Gallery Management System is a **console-based Java application** designed to manage artworks, customers, balances, and sales in an art gallery.  
The system allows administrators to add, remove, sell artworks, manage customer balances, and view purchase history using a PostgreSQL database via JDBC.

### Summary of Entities and Their Relationships
The system is based on the following entities:
- **Artworks** – represent art pieces available for sale
- **Customers** – represent gallery customers
- **Sales** – represent completed purchases
- **Purchase History** – displays customer purchase records

Relationships:
- One **Customer** can make **many Sales**
- One **Artwork** can be sold **only once**
- Each **Sale** links exactly one Customer and one Artwork

### OOP Design Overview
The project follows a **layered design**:
- `Main` acts as the controller (menu-driven UI)
- `Model` package contains business logic and database access
- JDBC is used for persistence
- Each entity has a dedicated class handling its operations

---

## B. OOP Design Documentation

### Classes
- `Arts` – manages artworks (CRUD operations)
- `Customers` – manages customers
- `Balance` – handles customer balance updates
- `Sales` – processes selling logic and transactions
- `PurchaseHistory` – retrieves customer purchase history
- `DatabaseConnection` – manages JDBC connection

### Interfaces and Abstract Classes
- Not used in this version of the project
- Design focuses on **procedural service classes with static methods**

### Composition / Aggregation
- `Sales` class **uses** `Arts`, `Customers`, and database tables together
- `PurchaseHistory` aggregates data from `sales1` and `artworks1`

### Polymorphism Examples
- JDBC interfaces (`Connection`, `PreparedStatement`, `ResultSet`)
- Runtime polymorphism through JDBC driver implementation

### UML Diagram (Textual Representation)
```
Main
|
|-- Arts
|-- Customers
|-- Balance
|-- Sales
|-- PurchaseHistory
|
DatabaseConnection
```

---

## C. Database Description

### Database: PostgreSQL

### Tables

#### artworks1
- `art_id` (PK)
- `art_name`
- `art_author`
- `art_date`
- `art_price`
- `art_status` ('F' = Free, 'T' = Taken)

#### customers1
- `customer_id` (PK)
- `customer_name`
- `customer_balance`

#### sales1
- `sale_id` (PK)
- `art_id` (FK → artworks1)
- `customer_id` (FK → customers1)
- `sale_date`
- `sale_price`

### Constraints
- Primary keys on all ID fields
- Foreign keys in `sales1`
- Artwork can only be sold once (`art_status`)

### Sample SQL Inserts
```sql
INSERT INTO artworks1 VALUES (1, 'MonaLisa', 'Leonardo', '1503-01-01', 5000, 'F');
INSERT INTO customers1 VALUES (1, 'John', 10000);
```
## D. Controller (CRUD Operations)
### Artworks

Create: Add new art

Read: List arts, view art info

Delete: Remove art

### Customers

Create: Add customer

Read: View customer info

Update: Add/remove balance

### Sales

Create: Sell art

Includes validation:

Art exists

Art not sold

Customer exists

Sufficient balance

Example Flow
```
User selects Sell Art
→ Enters customer ID
→ Enters art ID
→ System validates data
→ Sale completed or error displayed
```

E. Instructions to Compile and Run
Requirements

Java 17 or higher

PostgreSQL

JDBC Driver

Compile
javac Main.java

Run
java Main

F. Screenshots

Screenshots should demonstrate:

Adding a new artwork

Selling an artwork successfully

Handling insufficient balance error

Viewing purchase history

(Screenshots are attached separately)

G. Reflection Section
What I Learned

Working with JDBC and PostgreSQL

Implementing transaction management

Structuring Java applications using multiple classes

Validating business logic before database operations

Challenges Faced

Preventing duplicate artwork sales

Managing SQL transactions correctly

Handling user input and exceptions

Benefits of JDBC and Multi-layer Design

Clear separation of responsibilities

Secure and reliable database operations

Scalable and maintainable code structure

Conclusion

This project demonstrates a complete Java-based art gallery management system using JDBC and PostgreSQL. It applies OOP principles, transaction handling, and layered architecture to ensure data integrity and maintainability.