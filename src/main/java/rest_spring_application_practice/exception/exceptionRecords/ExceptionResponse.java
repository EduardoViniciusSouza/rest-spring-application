package rest_spring_application_practice.exception.exceptionRecords;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
