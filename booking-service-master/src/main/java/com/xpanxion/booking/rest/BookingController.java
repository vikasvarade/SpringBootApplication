package com.xpanxion.booking.rest;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.booking.dto.request.BookingRequest;
import com.xpanxion.booking.dto.response.BaseResponse;
import com.xpanxion.booking.dto.response.BookingResponse;
import com.xpanxion.booking.service.BookingService;

/**
 * REST Controller for Booking Service.
 *
 * @author Madhav
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class BookingController {

	private final static Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private BookingService bookingService;

	/**
	 * REST API to book the flight.
	 *
	 * @param bookingRequest the booking dto request body.
	 * @return the response.
	 * @throws Exception
	 */
	@PostMapping("/bookings")
	public ResponseEntity<BaseResponse> bookFlight(@RequestBody @Valid final BookingRequest bookingRequest) throws Exception {
		logger.info("REST API to book flight called.");
		final BookingResponse response = bookingService.bookFlight(bookingRequest);
		return ResponseEntity.created(new URI("/v1/bookings")).body(response);
	}
}
