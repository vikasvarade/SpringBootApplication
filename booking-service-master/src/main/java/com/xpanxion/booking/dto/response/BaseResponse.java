package com.xpanxion.booking.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BaseResponse {

	protected Status status;
	protected String message;

	public BaseResponse(final Status status) {
		this.status = status;
		this.message = "Operation is successfull.";
	}
	
	public BaseResponse(final Status status, final String message) {
		this.status = status;
		this.message = message;
	}

	enum Status {
		SUCCESS, FAILURE;
	}
}
