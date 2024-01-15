package com.hotelmanager.api.service;

import com.hotelmanager.api.dto.HotelRoomDto;
import com.hotelmanager.api.models.HotelRoom;

import java.util.List;
import java.util.Optional;

//HotelRoom Service Interface
public interface HotelRoomService {


    //Create HotelRoom
    HotelRoom createHotelRoom(HotelRoomDto hotelRoom);

    //Get HotelRoom
    HotelRoom getHotelRoom(Long id);

    //Get HotelRoom by RoomNumber
    HotelRoom getHotelRoomByRoomNumber(Integer roomNumber);

    //Get All HotelRooms
    List<HotelRoom> getAllHotelRooms(Optional<Boolean[]> minibarStatuses, Optional<Long[]> roomSizeIds, Optional<Integer> roomNumber);

    //Delete HotelRoom
    void deleteHotelRoom(Long id);

    //Update HotelRoom
    HotelRoom updateHotelRoom(Long id, HotelRoomDto hotelRoom);

    //Update HotelRoom by RoomNumber
    HotelRoom updateHotelRoomByRoomNumber(Integer roomNumber, HotelRoomDto hotelRoom);





}
