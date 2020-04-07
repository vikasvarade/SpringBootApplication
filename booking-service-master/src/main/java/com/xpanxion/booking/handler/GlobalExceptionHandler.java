package com.xpanxion.booking.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xpanxion.booking.dto.response.ErrorResponse;
import com.xpanxion.booking.handler.exception.ApplicationException;
import com.xpanxion.booking.handler.exception.BadRequestException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public @ResponseBody ErrorResponse handleBadRequestException(final HttpServletRequest request,
			final BadRequestException ex) {
		logger.error("BadRequestException", ex);
		return new ErrorResponse(ex.getErrorCode());
	}

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ApplicationException.class)
	public @ResponseBody ErrorResponse handleApplciatiopnException(final HttpServletRequest request,
			final ApplicationException ex) {
		logger.error("ApplicationException", ex);
		return new ErrorResponse(ex.getErrorCode());
	}

}
