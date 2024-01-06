package com.hotelmanager.api;

import lombok.Data;

@Data
public class HotelRoomDto {
    private Long id;
    private Integer roomNumber;
    private Long roomSize;
    private boolean miniBar;
}
