package com.xpanxion.booking.dto.response;

import com.xpanxion.booking.common.ErrorCode;
import com.xpanxion.booking.dto.ErrorDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse extends BaseResponse {

	private ErrorDto error;

	public ErrorResponse(final ErrorCode error) {
		super(Status.FAILURE, "Operation failed");
		this.error = ErrorDto.builder().code(error.getCode()).label(error.getMessage()).message(error.getLabel())
				.build();
	}
}
