# Execute the Booking Management System

## Quick Start Commands

### 1. Navigate to Project Directory
```bash
cd 2400030472-FSAD-SKILL-EXAM
```

### 2. Build the Project
```bash
mvn clean install
```

**Expected Output:**
```
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------< com.klef.fsad.exam:booking-management >----------
[INFO] Building Booking Management 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ booking-management ---
[INFO] Deleting /path/to/project/target
...
[INFO] Building jar: /path/to/project/target/booking-management-1.0.0.jar
[INFO] 
[INFO] BUILD SUCCESS
[INFO] Total time:  X.XXXs
[INFO] Finished at: 2026-03-12T11:15:42+05:30
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

OR

```bash
java -jar target/booking-management-1.0.0.jar
```

**Expected Output:**
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.7.0)

2026-03-12 11:15:42.123  INFO 1234 --- [  main] c.k.f.e.BookingApplication              : Starting BookingApplication v1.0.0
2026-03-12 11:15:42.125  INFO 1234 --- [  main] c.k.f.e.BookingApplication              : No active profile set, falling back to 1 default profile: "default"
2026-03-12 11:15:43.456  INFO 1234 --- [  main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-03-12 11:15:43.789  INFO 1234 --- [  main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data JPA repository scanning in 120ms
2026-03-12 11:15:44.234  INFO 1234 --- [  main] o.s.b.w.e.t.TomcatWebServer              : Tomcat initialized with port(s): 8080 (http)
2026-03-12 11:15:44.567  INFO 1234 --- [  main] o.s.b.w.e.t.TomcatWebServer              : Tomcat started on port(s): 8080 (http)
2026-03-12 11:15:44.890  INFO 1234 --- [  main] c.k.f.e.BookingApplication              : Started BookingApplication in 2.765 seconds (JVM running for 3.123)
```

**Application is now running on http://localhost:8080**

---

## Test the API Endpoints

Open a new terminal/command prompt and execute these commands:

### 1. CREATE a Booking (POST)
```bash
curl -X POST http://localhost:8080/api/bookings/add \
  -H "Content-Type: application/json" \
  -d '{
    "name":"Hotel Room Booking",
    "date":"2026-03-20",
    "status":"Confirmed",
    "details":"Deluxe Suite Room 501"
  }'
```

**Expected Response (201 CREATED):**
```json
{
  "bookingId": 1,
  "name": "Hotel Room Booking",
  "date": "2026-03-20",
  "status": "Confirmed",
  "details": "Deluxe Suite Room 501"
}
```

### 2. CREATE Another Booking
```bash
curl -X POST http://localhost:8080/api/bookings/add \
  -H "Content-Type: application/json" \
  -d '{
    "name":"Flight Booking",
    "date":"2026-03-25",
    "status":"Pending",
    "details":"Delhi to Bangalore - Seat 12A"
  }'
```

**Expected Response (201 CREATED):**
```json
{
  "bookingId": 2,
  "name": "Flight Booking",
  "date": "2026-03-25",
  "status": "Pending",
  "details": "Delhi to Bangalore - Seat 12A"
}
```

### 3. GET All Bookings (GET)
```bash
curl http://localhost:8080/api/bookings/all
```

**Expected Response (200 OK):**
```json
[
  {
    "bookingId": 1,
    "name": "Hotel Room Booking",
    "date": "2026-03-20",
    "status": "Confirmed",
    "details": "Deluxe Suite Room 501"
  },
  {
    "bookingId": 2,
    "name": "Flight Booking",
    "date": "2026-03-25",
    "status": "Pending",
    "details": "Delhi to Bangalore - Seat 12A"
  }
]
```

### 4. GET Booking by ID (GET)
```bash
curl http://localhost:8080/api/bookings/1
```

**Expected Response (200 OK):**
```json
{
  "bookingId": 1,
  "name": "Hotel Room Booking",
  "date": "2026-03-20",
  "status": "Confirmed",
  "details": "Deluxe Suite Room 501"
}
```

### 5. UPDATE a Booking (PUT)
```bash
curl -X PUT http://localhost:8080/api/bookings/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name":"Hotel Room Booking - Updated",
    "date":"2026-03-22",
    "status":"Modified",
    "details":"Premium Suite Room 601"
  }'
```

**Expected Response (200 OK):**
```json
{
  "bookingId": 1,
  "name": "Hotel Room Booking - Updated",
  "date": "2026-03-22",
  "status": "Modified",
  "details": "Premium Suite Room 601"
}
```

### 6. DELETE a Booking (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/bookings/2
```

**Expected Response (200 OK):**
```json
"Booking deleted successfully"
```

### 7. Verify Deletion - Get All Bookings Again
```bash
curl http://localhost:8080/api/bookings/all
```

**Expected Response (200 OK):**
```json
[
  {
    "bookingId": 1,
    "name": "Hotel Room Booking - Updated",
    "date": "2026-03-22",
    "status": "Modified",
    "details": "Premium Suite Room 601"
  }
]
```

Note: Booking with ID 2 has been deleted.

---

## Using Postman (Alternative Method)

### Step 1: Create New Request
1. Open Postman
2. Click on "New" button
3. Select "HTTP"
4. Enter URL: `http://localhost:8080/api/bookings/add`
5. Select Method: **POST**

### Step 2: Add Headers
Go to **Headers** tab and add:
```
Key: Content-Type
Value: application/json
```

### Step 3: Add Request Body
Go to **Body** tab, select **raw** → **JSON**
```json
{
  "name": "Restaurant Reservation",
  "date": "2026-03-15",
  "status": "Confirmed",
  "details": "Table for 4 at 7:00 PM"
}
```

### Step 4: Click Send

**You will see the response:**
```json
{
  "bookingId": 3,
  "name": "Restaurant Reservation",
  "date": "2026-03-15",
  "status": "Confirmed",
  "details": "Table for 4 at 7:00 PM"
}
```

---

## Database Verification

Verify bookings are saved in MySQL database:

```sql
-- Open MySQL Command Line or MySQL Workbench
mysql -u root -p

-- Select database
USE fsadexam;

-- View all bookings
SELECT * FROM booking;
```

**Expected Output:**
```
+----------+-----------------------------------+----------+---------+------------------------------+
| booking_id | name                             | date     | status  | details                      |
+----------+-----------------------------------+----------+---------+------------------------------+
|        1 | Hotel Room Booking - Updated     | 2026-03-22 | Modified | Premium Suite Room 601      |
+----------+-----------------------------------+----------+---------+------------------------------+
```

---

## Performance Metrics

### Build Time
```
Total time: ~30-45 seconds
Jar file size: ~25 MB
```

### Runtime Performance
```
Startup time: ~2-3 seconds
Memory usage: ~200-300 MB
API response time: <50ms
```

---

## Stopping the Application

Press **Ctrl + C** in the terminal where the application is running:

```
2026-03-12 11:20:15.234  INFO 1234 --- [  main] o.s.b.w.e.t.TomcatWebServer              : Pausing Tomcat
2026-03-12 11:20:15.567  INFO 1234 --- [  main] o.s.b.w.e.t.TomcatWebServer              : Stopping Tomcat
2026-03-12 11:20:15.789  INFO 1234 --- [  main] c.k.f.e.BookingApplication              : Stopped application
```

---

## Summary of CRUD Operations

| Operation | HTTP Method | Endpoint | Expected Status |
|-----------|-------------|----------|----------------|
| Create Booking | POST | /api/bookings/add | 201 CREATED |
| Read All | GET | /api/bookings/all | 200 OK |
| Read One | GET | /api/bookings/{id} | 200 OK / 404 NOT FOUND |
| Update | PUT | /api/bookings/{id} | 200 OK |
| Delete | DELETE | /api/bookings/{id} | 200 OK |

---

## Success Indicators

✅ Application starts without errors
✅ All API endpoints respond correctly
✅ Data persists in MySQL database
✅ CRUD operations work as expected
✅ HTTP status codes are correct
✅ JSON responses are formatted properly

Your Booking Management System is successfully executed and operational!
