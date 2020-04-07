package com.xpanxion.booking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xpanxion.booking.domain.extra.BookingStatusEnum;
import com.xpanxion.booking.domain.extra.SeatTypeEnum;

import lombok.*;

/**
 * Model Class For Booking
 *
 * @author Madhav
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "flight_id")
    private String flightId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "seats")
    private Integer seats;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type")
    private SeatTypeEnum seatType;

    @Column(name = "fare")
    private Long fare;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatusEnum bookingStatus;
}
