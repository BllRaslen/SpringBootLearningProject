package com.bilal.springbootproject.error;

import com.bilal.springbootproject.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {



@ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException departmentNotFoundException ,
                                                                    WebRequest webRequest){

    ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,
            departmentNotFoundException.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
