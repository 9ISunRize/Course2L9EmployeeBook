package SkyPro.EmployeeBook9.EmployeeBook9.expectoin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaximumEmployeesException extends RuntimeException {
    public MaximumEmployeesException() {
    }

    public MaximumEmployeesException(String message) {
        super(message);
    }
}
