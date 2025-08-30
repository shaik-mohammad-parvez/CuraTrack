# CuraTrack AI Coding Agent Instructions

## Project Overview
- **CuraTrack** is a hospital management system with a React frontend (`frontend/`) and a Spring Boot backend (`backend/`).
- The backend exposes REST APIs for managing patients, doctors, appointments, and related entities.
- The frontend is a single-page React app using Bootstrap 4 and custom CSS, communicating with the backend via HTTP.

## Architecture & Key Patterns
- **Backend:**
  - Java Spring Boot (see `backend/src/main/java/com/example/demo/FirstAppApplication.java`).
  - REST controllers in `controller/`, DTOs in `dto/`, entities in `entity/`, and business logic in `service/`.
  - Uses ModelMapper for DTO/entity conversion, JPA/Hibernate for persistence.
  - Main entry: `FirstAppApplication.main()` or `mvn spring-boot:run`.
  - API endpoints are versioned and grouped by resource (see `ApiPaths`).
- **Frontend:**
  - Bootstrapped with Create React App.
  - Main entry: `src/index.js`, routes in `src/App.js` and `src/Routes/`.
  - Components are grouped by feature (e.g., `PatientComponents/`, `ProblemComponent/`, `ReceipeComponent/`).
  - Uses service classes (e.g., `PatientService.js`, `ApiService.js`) for API calls.
  - Custom modals and forms are implemented in `Routes/BasicComponent/` and `Routes/modal.jsx`.

## Developer Workflows
- **Backend:**
  - Build/run: `cd backend && mvn spring-boot:run` (requires JDK 1.8+, Maven 3+).
  - Test: `mvn test` (tests in `src/test/java/`).
  - Configuration: `src/main/resources/application.properties`.
- **Frontend:**
  - Install: `cd frontend && npm install` (Node.js required).
  - Run: `npm start` (dev server at http://localhost:3000).
  - Test: `npm test` (Jest, see `setupTests.js`).
  - Build: `npm run build` (output in `build/`).

## Conventions & Integration
- **API URLs** are typically relative and may require proxy setup for local dev.
- **DTOs** are used for all API payloads; avoid exposing entities directly.
- **Alerting** uses a custom `AlertifyService` wrapping `alertifyjs`.
- **Modals** use `react-modal` or Bootstrap modal markup.
- **Validation** is handled in React forms (see `IndexPage2.jsx` for examples).
- **Styling**: Custom CSS in `src/Assets/css/`, Bootstrap 4 for layout.

## External Dependencies
- **Backend:** Spring Boot, ModelMapper, JPA/Hibernate, Oracle DB (see `README.md` for versions).
- **Frontend:** React, Bootstrap, alertifyjs, react-modal, @material/react-checkbox, moment, formik.

## Examples
- See `frontend/src/Routes/BasicComponent/ReceipeDetailModal.jsx` for modal pattern.
- See `backend/src/main/java/com/example/demo/controller/ReceipeController.java` for REST controller structure.
- See `frontend/src/services/ApiService.js` for API integration pattern.

## Additional Notes
- For local development, run backend and frontend separately.
- Update this file if project structure or conventions change.
