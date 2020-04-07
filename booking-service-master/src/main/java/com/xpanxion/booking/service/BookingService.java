package com.xpanxion.booking.service;

import com.xpanxion.booking.domain.Booking;
import com.xpanxion.booking.dto.request.BookingRequest;
import com.xpanxion.booking.dto.response.BookingResponse;

/**
 * Service Interface for {@link Booking}.
 *
 * @author Madhav
 */
public interface BookingService {

	/**
	 * Method to book flight.
	 *
	 * @param booking the {@link Booking} object.
	 * @return the saved {@link Booking} object.
	 */
	BookingResponse bookFlight(BookingRequest bookingRequest) throws Exception;
}
