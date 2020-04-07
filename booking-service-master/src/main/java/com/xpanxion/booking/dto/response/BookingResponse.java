package com.xpanxion.booking.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Booking Response class
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookingResponse extends BaseResponse {

	private String bookingID;

	public BookingResponse(final String bookingID) {
		super(Status.SUCCESS);
		this.bookingID = bookingID;
	}

}
