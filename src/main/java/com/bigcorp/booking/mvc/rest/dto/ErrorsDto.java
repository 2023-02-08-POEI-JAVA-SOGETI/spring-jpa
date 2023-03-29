package com.bigcorp.booking.mvc.rest.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorsDto {

	private String title;

	private Integer httpCode;

	private List<ErrorDto> errorDtos = new ArrayList<>();

}