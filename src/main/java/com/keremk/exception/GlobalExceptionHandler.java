package com.keremk.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	// Spring Validation dan fırlatılan hataları response olarak dönmek

	private List<String> addMapValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;

	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		Map<String, List<String>> errorMapsMap = new HashMap<>();

		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {

			String fieldNameString = ((FieldError) objectError).getField();
			if (errorMapsMap.containsKey(fieldNameString)) {
				errorMapsMap.put(fieldNameString,
						addMapValue(errorMapsMap.get(fieldNameString), objectError.getDefaultMessage()));
			} else {
				errorMapsMap.put(fieldNameString, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}

		}
		return ResponseEntity.badRequest().body(createApiError(errorMapsMap));

	}

	private <T> ApiError<T> createApiError(T errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errors);
		return apiError;

	}

}
