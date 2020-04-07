package com.xpanxion.booking.handler.exception;

import com.xpanxion.booking.common.ErrorCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends RuntimeException {

	/***/
	private static final long serialVersionUID = -5100900965072633516L;

	private ErrorCode errorCode;

	public ApplicationException() {
		super();
	}

	public ApplicationException(final ErrorCode errorCode, final String message, final Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public ApplicationException(final ErrorCode errorCode, final String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationException(final ErrorCode errorCode, final Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

}
