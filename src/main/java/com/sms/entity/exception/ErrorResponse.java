package com.sms.entity.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorResponse {
	Date date;
	String msg;
	String path;

}
