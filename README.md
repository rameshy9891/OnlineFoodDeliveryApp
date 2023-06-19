
# Online Food Delivery Application:

This is a README file for an Online Food Delivery Application that aims to create a bridge between restaurants and customers. The application is being developed using the Spring Boot framework for the backend and HTML, CSS, and JavaScript for the frontend.

## Problem Statement:

The main objective of this application is to provide a platform where restaurant owners can create and list their food items along with their prices. Customers can sign up, view nearby restaurants, and place orders. Customers can select a payment method and make payments for their orders. Restaurant owners can accept orders and deliver them to customers.

## Project Schema:
![Online Food Delivery Application ReadMe](https://github.com/rameshy9891/sharp-head-9647/assets/119414002/e7dc2a80-bfc4-4049-a51a-f36850f33b63)


## Entities:

The application consists of the following entities:

1. Restaurant: Represents a restaurant with information such as name, address, and contact details.

2. Customer: Represents a customer with information such as name, address, and contact details.

3. Address: Represents a physical address, associated with either a restaurant or a customer.

4. Food Cart: Represents the cart of a customer where food items are added for placing an order.

5. Food Item: Represents a food item available in a restaurant with details like name, description, and price.

6. Order Details: Represents the details of an order, including the customer, restaurant, food items, and total price.

7. Category: Represents a category for food items, such as "Appetizers," "Main Course," or "Desserts."

8. Login: Represents the authentication and authorization functionality for both restaurant owners and customers.

## Services:

The application provides several services to handle different functionalities. Here is an overview of the main services:

1. Bill Services: Provides operations for adding, updating, removing, and viewing bills. It also includes calculations related to billing.

2. Customer Services: Provides operations for adding, updating, removing, and viewing customer details. It includes methods to view all customers or retrieve details of a specific customer.

3. Category Services: Offers operations for adding, updating, removing, and viewing food item categories.

4. Restaurant Services: Provides operations for adding, updating, removing, and viewing restaurant details.

5. Login Services: Handles user authentication and authorization, including sign-in and sign-out functionality.

6. Order Services: Provides operations for adding, updating, removing, and viewing orders. It includes methods to retrieve orders for a specific customer or restaurant.

7. Item Services: Offers operations for adding, updating, removing, and viewing food items. It includes methods to retrieve items based on category or restaurant.

8. Cart Services: Handles operations related to the food cart, such as adding items, increasing or reducing item quantity, removing items, and clearing the cart.

## Repository:

The repository for this Online Food Delivery Application can be found on GitHub. You can access the repository using the following link: [GitHub Repository](https://github.com/rameshy9891/sharp-head-9647)

## Getting Started:

To set up and run the application locally, follow these steps:

1. Clone the repository from GitHub to your local machine.

2. Ensure you have the required software installed, including Spring Boot, a web server, and a database server.

3. Set up the database connection details in the application configuration files.

4. Run the application using the appropriate commands or tools for your chosen technology stack.

5. Access the application in a web browser by entering the appropriate URL.

## Tech Stacks:

The Online Food Delivery Application utilizes the following technologies:

- Backend Technologies: Java, Spring Boot, RESTful APIs
- Frontend Technologies: HTML, CSS, JavaScript
- Database: MySQL
- Additional Libraries: Spring Security, Hibernate, Maven

## Contributors:

This project is being developed and maintained by 
- Ramesh Yadav(TL) 
- Salman Khan
- Rohit
- Nitish Mandal
- Rushikesh
