package com.ademozalp.ParkEt;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ademozalp.ParkEt.core.utilities.exceptions.BusinessException;
import com.ademozalp.ParkEt.core.utilities.exceptions.ProblemDetails;
import com.ademozalp.ParkEt.core.utilities.exceptions.ValidationProblemDetails;

import jakarta.validation.UnexpectedTypeException;

@SpringBootApplication
@RestControllerAdvice
public class ParkEtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkEtApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleMethodNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage("VALIDATIN.EXCEPTION");
		problemDetails.setErrors(new HashMap<String, String>());
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			problemDetails.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		
		return problemDetails;	
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		problemDetails.setErrors(new HashMap<String, String>());
				
		return problemDetails;	
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage(dataIntegrityViolationException.getMessage());
		
		return problemDetails;		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleUnexceptedTypeException(UnexpectedTypeException unexpectedTypeException) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage(unexpectedTypeException.getMessage());
		problemDetails.setErrors(new HashMap<String, String>());
				
		return problemDetails;	
	}
	
	//NullPointerException
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleNullPointerException(NullPointerException nullPointerException) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage(nullPointerException.getMessage());
		
		return problemDetails;	
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleStackOverFlowException(StackOverflowError stackOverflowError) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage(stackOverflowError.getLocalizedMessage());
		
		
		return problemDetails;	
	}
	
	//IncorrectResultSizeDataAccessException
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handlencorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException incorrectResultSizeDataAccessException) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage(incorrectResultSizeDataAccessException.getLocalizedMessage());
		
		
		return problemDetails;	
	}
	
	
	
	
	
}
