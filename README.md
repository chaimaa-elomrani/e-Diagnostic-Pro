# e-Diagnostic

Java 17 Maven web application for the medical tele-expertise workflow. The application targets Jakarta Servlet 6 (Tomcat 10.1+) and uses JSP/JSTL for server-rendered pages.

## Project layout

- `com.hospital.config` — application and persistence configuration
- `com.hospital.model` — patient, staff, consultation, expertise, appointment and medical-act models
- `com.hospital.enums` — roles, specialties, workflow statuses and priority values
- `com.hospital.dao` — persistence access
- `com.hospital.service` — intake, queue, consultation, scheduling, expertise and cost rules
- `com.hospital.web.servlet` — HTTP endpoints, grouped by user workflow
- `com.hospital.web.filter` — authentication, authorization and CSRF filters
- `com.hospital.security` — session identity and password hashing helpers
- `src/main/webapp/WEB-INF/views` — JSP pages, grouped by role
- `src/main/resources/META-INF` — JPA configuration

The WAR is named `e-diagnostic.war`. Database connection details and the concrete persistence provider should be configured for the target environment before implementing persistence.
