package net.javaguides.ems_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class reosurcenotfound extends RuntimeException{
  public  reosurcenotfound(String message){

      super(message);
  }

}
