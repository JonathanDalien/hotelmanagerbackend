package com.hotelmanager.api;

import lombok.Data;

//HotelRoom Data Transfer Object
@Data
public class HotelRoomDto {
    private Long id;
    private Integer roomNumber;
    private Long roomSize;
    private boolean miniBar;
}
