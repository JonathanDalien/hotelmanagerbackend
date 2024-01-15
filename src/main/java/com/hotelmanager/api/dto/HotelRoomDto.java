package com.hotelmanager.api.dto;

import lombok.Data;

//HotelRoom Data Transfer Object
@Data
public class HotelRoomDto {
    private Long id;
    private Integer roomNumber;
    private Long roomSize;
    private boolean miniBar;
}
