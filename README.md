# Dealer & Vehicle Management API

A Spring Boot RESTful API for managing car dealers, their vehicles, and simulating payment gateway transactions.

- **Dealer CRUD** – Create, Read, Update, Delete dealers
- **Vehicle CRUD** – Manage vehicles linked to dealers
- **Filter Vehicles by PREMIUM Dealers**
- **Payment Gateway Simulation** – Initiate payment, auto-update status after 5 seconds
- **Error Handling** – Appropriate HTTP status codes and error messages
- **Swagger API Docs**

---

## Tech Stack

- **Backend:** Spring Boot, Spring Data JPA
- **Database:** PostgreSQL (can switch to MySQL)
- **Testing:** Postman, Swagger UI

---

## ⚙️ Installation & Setup

### 1. Clone the repo

```bash
git clone https://github.com/Pankaj1752/dealer-vehicle-api.git
cd dealer-vehicle-api
```

### 2. Database Setup (PostgreSQL)

Create database & user:
```sql
CREATE DATABASE dealerdb;
CREATE USER youruser WITH PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE dealerdb TO youruser;
```

### 3. Configure `application.properties`


### 4. Run the project

```bash
mvn spring-boot:run
```

---

## 📝 API Endpoints

### Dealer

- `GET /api/dealers` – List all dealers
- `GET /api/dealers/{id}` – Get dealer by ID
- `POST /api/dealers` – Create dealer
- `PUT /api/dealers/{id}` – Update dealer
- `DELETE /api/dealers/{id}` – Delete dealer

### Vehicle

- `GET /api/vehicles` – List all vehicles
- `GET /api/vehicles/{id}` – Get vehicle by ID
- `POST /api/vehicles/dealer/{dealerId}` – Create vehicle for dealer
- `PUT /api/vehicles/{id}` – Update vehicle
- `DELETE /api/vehicles/{id}` – Delete vehicle
- `GET /api/vehicles/premium` – List vehicles of PREMIUM dealers

### Payment

- `POST /api/payment/initiate?dealerId={id}&amount={amt}&method={method}` – Initiate payment


## 🖼️ Screenshots

| Home | Dealer List | Vehicle List | Payment Simulation |
|------|-------------|--------------|-------------------|
| ![](screenshots/home.png) | ![](screenshots/dealers.png) | ![](screenshots/vehicles.png) | ![](screenshots/payment.png) |

## 🧑‍💻 Author

**Pankaj Kumar**
