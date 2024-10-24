
# Blood Donation Management System (BDMS)



The **Blood Donation Management System (BDMS)** is a web-based application designed to facilitate and streamline blood donation processes. The system allows donors to register and manage their donation history, while hospitals and blood banks can manage blood requests and inventory seamlessly. This project aims to modernize blood banks by providing an online platform accessible to both donors and administrators.

## Purpose

The purpose of the BDMS is to enhance the efficiency of blood banks by developing a comprehensive blood bank information system. This online system is accessible to both donors and administrators, enabling:
- Donors to view donation history and update personal information without contacting the blood bank registry.
- Administrators to handle hospital blood requests and manage blood inventory.

## Scenario

<img width="473" alt="Screenshot 2024-10-24 at 12 02 16" src="https://github.com/user-attachments/assets/40b129ca-a971-4dec-b6ea-d56a5c1c15d2">


## Features

### Functional Requirements
 **Access Website**:
   - The web application is accessible through web browsers on both mobile phones and computers without any limitations.

 **User Registration**:
   - Donors can register by providing first name, gender, blood group, location, contact, username, and password.

 **User Login**:
   - Registered users can log in to access their dashboard. Login credentials are stored in a database for future use.

 **Search Results in List View**:
   - Users can search for donors. The results are displayed in a list format with details such as first name, gender, blood group, location, and contact.

 **Request Blood**:
   - Hospitals can request blood during emergencies by specifying blood group, location, required date, and contact information. The request is checked against the blood bank's inventory.

 **View Requests**:
   - Blood banks can view and respond to blood requests. They can search requests by blood group and provision.

 **Search Blood Bank Stock**:
   - Blood inventory is checked to match requests received from hospitals, and available units are sent accordingly.

### Non-Functional Requirements
 **Availability**:
   - The system is accessible 24/7, ensuring both online and offline availability.

 **Reliability**:
   - Database backup and recovery mechanisms ensure that data is secure and can be restored in the event of a failure.

 **Security**:
   - The system is designed with strong security protocols to protect donor and hospital data.

 **Correctness**:
   - Blood units sent by the blood bank match the requested units, ensuring they reach the correct destination.

 **Maintainability**:
   - The blood inventory manager maintains accurate records of blood stock.


