package com.bored.model.dto.response;

import com.bored.model.dto.BoredDTO;
import com.bored.util.BoredException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<BoredDTO> handleBadRequest(Exception ex) {
        BoredDTO boredDTO = new BoredDTO();
        boredDTO.setMessage("Invalid Request Parameter");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(boredDTO);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<BoredDTO> handleNoResourceException(Exception ex) {
        BoredDTO boredDTO = new BoredDTO();
        boredDTO.setMessage("API Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(boredDTO);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<BoredDTO> handleInternalServerError(Exception ex) {
        BoredDTO boredDTO = new BoredDTO();
        boredDTO.setMessage("Internal Server Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(boredDTO);
    }

    @ExceptionHandler(BoredException.class)
    public ResponseEntity<BoredDTO> handleBoredException(BoredException ex){
        ex.printStackTrace();
        BoredDTO boredDTO = new BoredDTO();
        boredDTO.setMessage("Internal Server Error");
        if(HttpStatus.BAD_REQUEST == ex.getStatus()){
            boredDTO.setMessage("Invalid Request Parameter");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(boredDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(boredDTO);
    }
}
