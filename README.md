# BLOGAPI

## Project Overview
This is a RESTful Blog Application API. Users can register, login, create/read/update/delete blog posts, and manage comments. JWT is used for authentication and authorization.

## Technologies Used
- Java 23
- Spring Boot 3.1.4
- PostgreSQL Database
- Postman (for API testing)
- JWT Authentication
- DBeaver (to check database tables)

## Database Setup
Database name: `blog_app`

Tables created:
- `users` – stores registered users.
- `posts` – stores blog posts.
- `comments` – stores comments for posts.

When testing in Postman, data is saved to these tables automatically.

## How to Run the Project
1. Open IntelliJ IDEA.
2. Open the project folder `BLOGAPI`.
3. Make sure PostgreSQL is running.
4. Configure database connection in `application.properties` (database name, username, password, port 5432).
5. Run the main class: `BlogapiApplication.java`.
6. Server will start at `http://localhost:8080`.

## API Endpoints

### User
- **Register**: `POST http://localhost:8080/api/auth/register`  
  Body: `{ "username": "", "email": "", "password": "" }`

- **Login**: `POST http://localhost:8080/api/auth/login`  
  Body: `{ "username": "", "password": "" }`  
  Response: JWT token (used for authentication in next requests)

### Posts
- **Create Post**: `POST http://localhost:8080/api/posts`
- **Get All Posts**: `GET http://localhost:8080/api/posts`
- **Get Single Post**: `GET http://localhost:8080/api/posts/{id}`
- **Update Post**: `PUT http://localhost:8080/api/posts/{id}`
- **Delete Post**: `DELETE http://localhost:8080/api/posts/{id}`

### Comments
- **Create Comment**: `POST http://localhost:8080/api/comments`
- **Get Comments for Post**: `GET http://localhost:8080/api/comments?postId={postId}`
- **Get Single Comment**: `GET http://localhost:8080/api/comments/{id}`
- **Update Comment**: `PUT http://localhost:8080/api/comments/{id}`
- **Delete Comment**: `DELETE http://localhost:8080/api/comments/{id}`

**Note:** For all protected routes (create/update/delete), pass JWT token in **Authorization → Bearer Token** in Postman.

## Testing
- All endpoints were tested in Postman.
- Saved collection includes requests and example responses.
- Data is saved automatically in the PostgreSQL database tables (`users`, `posts`, `comments`).
