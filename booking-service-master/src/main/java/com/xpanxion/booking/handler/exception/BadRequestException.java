package com.xpanxion.booking.handler.exception;

import com.xpanxion.booking.common.ErrorCode;

public class BadRequestException extends ApplicationException {

	public BadRequestException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7990566631935920315L;

}
