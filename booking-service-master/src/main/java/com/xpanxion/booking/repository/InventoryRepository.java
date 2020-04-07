package com.xpanxion.booking.repository;

import com.xpanxion.booking.domain.BookingInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for {@link BookingInventory} class.
 *
 * @author Madhav
 */
@Repository
public interface InventoryRepository extends JpaRepository<BookingInventory, Integer> {

    /**
     * Method to find {@link BookingInventory} by flight id.
     *
     * @param flightId the flight id.
     * @return the {@link BookingInventory} object.
     */
    BookingInventory findByFlightId(String flightId);
}
