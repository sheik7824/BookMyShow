package dev.anil.bookmyshow.dtos;

import dev.anil.bookmyshow.Models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
    private Booking booking;
    public String TestField;
    private String unUsedMethod(){return null;}
    ResponseStatus status;
}
