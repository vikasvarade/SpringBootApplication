package com.xpanxion.booking.service;

import com.xpanxion.booking.domain.Booking;
import com.xpanxion.booking.domain.BookingInventory;
import com.xpanxion.booking.domain.extra.BookingStatusEnum;
import com.xpanxion.booking.domain.extra.SeatTypeEnum;
import com.xpanxion.booking.dto.request.BookingRequest;
import com.xpanxion.booking.dto.response.BookingResponse;
import com.xpanxion.booking.handler.exception.ApplicationException;
import com.xpanxion.booking.handler.exception.BadRequestException;
import com.xpanxion.booking.repository.BookingRepository;
import com.xpanxion.booking.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.xpanxion.booking.common.ErrorCode.INVALID_FLIGHT_ID;
import static com.xpanxion.booking.common.ErrorCode.SEATS_NOT_AVAILABLE;

/**
 * Service Implementation for {@link Booking}.
 *
 * @author Madhav
 */
@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    private final static Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    /**
     * Method to book flight.
     *
     * @param bookingRequest the {@link Booking} object.
     * @return the saved {@link Booking} object.
     */
    @Override
    @Transactional
    public BookingResponse bookFlight(final BookingRequest bookingRequest) {
        final BookingInventory inventory = inventoryRepository.findByFlightId(bookingRequest.getFlightId());
        if (null != inventory) {
            allocateFlightSeats(inventory, SeatTypeEnum.valueOf(bookingRequest.getSeatType()), bookingRequest.getSeats());
            Booking bookingEntity = Booking.builder().bookingStatus(BookingStatusEnum.BOOKED)
                    .customerId(bookingRequest.getCustomerId())
                    .fare(bookingRequest.getFare())
                    .flightId(bookingRequest.getFlightId())
                    .seats(bookingRequest.getSeats())
                    .seatType(SeatTypeEnum.valueOf(bookingRequest.getSeatType())).build();

            bookingEntity = bookingRepository.save(bookingEntity);
            logger.info("Booking {} saved successfully", bookingEntity.getId());
            inventoryRepository.save(inventory);
            logger.info("Inventory update for flight id {} successfully", bookingEntity.getId());
            return new BookingResponse(bookingEntity.getId().toString());
        } else {
            throw new BadRequestException(INVALID_FLIGHT_ID, "Invalid flight Id: " + bookingRequest.getFlightId());
        }


    }

    private void allocateFlightSeats(final BookingInventory bookingInventory, final SeatTypeEnum type, int requiredSeats) {
        switch (type) {
            case ECONOMY:
                if (areSeatsAvailable(bookingInventory.getEconomySeats(), requiredSeats)) {
                    bookingInventory.setEconomySeats(bookingInventory.getEconomySeats() - requiredSeats);
                }
                break;
            case PREMIUM_ECONOMY:
                if (areSeatsAvailable(bookingInventory.getPremiumEconomySeats(), requiredSeats)) {
                    bookingInventory.setPremiumEconomySeats(bookingInventory.getPremiumEconomySeats() - requiredSeats);
                }
                break;
            case BUSINESS:
                if (areSeatsAvailable(bookingInventory.getBusinessSeats(), requiredSeats)) {
                    bookingInventory.setBusinessSeats(bookingInventory.getBusinessSeats() - requiredSeats);
                }
                break;
            case FIRST_CLASS:
                if (areSeatsAvailable(bookingInventory.getFirstClassSeats(), requiredSeats)) {
                    bookingInventory.setFirstClassSeats(bookingInventory.getFirstClassSeats() - requiredSeats);
                }
                break;
        }
    }

    private Boolean areSeatsAvailable(int availableSeats, int requiredSeats) throws ApplicationException {
        if (availableSeats >= requiredSeats) {
            return Boolean.TRUE;
        } else {
            throw new BadRequestException(SEATS_NOT_AVAILABLE, "Error while allocating seats.");
        }
    }
}
