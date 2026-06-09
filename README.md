# 📦 ASSET-MANAGER

**Empowering Smarter Asset Management for Future Success**

![last commit](https://img.shields.io/github/last-commit/JulianRn/asset-manager)
![language](https://img.shields.io/badge/language-Java-blue)
![build](https://img.shields.io/badge/build-Gradle-green)
![database](https://img.shields.io/badge/database-MongoDB-lightgrey)

---

## 📚 Table of Contents

- [Overview](#overview)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Usage](#usage)
    - [Testing](#testing)

---

## 📖 Overview

**Asset-Manager** is a  backend tailored for managing assets, users, and investments for financial purposes.
Built with **Spring Boot** and **MongoDB**. The application provides an API to execute CRUD operations, for example 
creating, reading, updating and deleting assets, users or investments. The project includes a swagger api documentation,
which provides a GUI to use the API. An alternative is to use postman to access the API.

<!--### 🚀 Why asset-manager?

This project simplifies the development of asset-centric systems by providing ready-to-use RESTful APIs, security configurations, and documentation.

**Key Features:**

- 🔗 **API Endpoints**: RESTful interfaces for assets, users, and investments
- 🌐 **MongoDB Integration**: NoSQL database for flexible and efficient data storage
- 🔒 **Security**: Stateless authentication via Spring Security (JWT-ready), password encryption, and role-based access control
- 📘 **OpenAPI Documentation**: Auto-generation of Swagger UI for testing and exploration
- ⚙️ **Build Automation**: Simple Gradle setup and consistent environment management

--->

## Getting Started

### Prerequisites

Make sure the following are installed on your system:

- 📌 **Java** (JDK 17 or higher recommended)
- 📦 **Gradle** (or use `./gradlew` wrapper)
- 🧩 Optional: MongoDB locally running or hosted remotely

---

### 📥 Installation

Clone the project and build it:

```bash
# 1. Clone the repository
git clone https://github.com/JulianRn/asset-manager

# 2. Navigate to project folder
cd asset-manager

# 3. Build the project
gradle build
```
The application runs locally with MongoDB. That is why a MongoDB should be put on to make use of the Java Backend.
After the MongoDB is configured and ready to use, the port of the database needs to be added in the application.yml.