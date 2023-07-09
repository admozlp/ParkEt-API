package com.ademozalp.ParkEt.core.utilities.exceptions;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
	private HashMap<String, String> errors;
}