package com.xpanxion.booking.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.xpanxion.booking.domain.extra.SeatTypeEnum;
import com.xpanxion.booking.validator.StringEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingRequest {

    @NotBlank
    private String flightId;

    @NotBlank
    private String customerId;

    @NotNull
    @Min(1)
    private Integer seats;

    @NotBlank(message = "Seat type is required.")
    @StringEnum(enumClass = SeatTypeEnum.class, message = "Invalid seat type")
    private String seatType;

    @NotNull
    @Min(1)
    private Long fare;

}
