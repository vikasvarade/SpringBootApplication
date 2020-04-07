package com.xpanxion.booking.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorCode {

	SEATS_NOT_AVAILABLE(1000, "SEATS_NOT_AVAILABLE", "Seats are not available"),
	INVALID_FLIGHT_ID(1001, "INVALID_FLIGHT_ID", "Invalid flight id");

	private int code;
	private String label;
	private String message;

}
