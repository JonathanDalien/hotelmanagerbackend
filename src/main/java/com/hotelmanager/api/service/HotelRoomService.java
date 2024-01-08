package com.hotelmanager.api.service;

import com.hotelmanager.api.HotelRoomDto;
import com.hotelmanager.api.models.HotelRoom;
import com.hotelmanager.api.repository.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface HotelRoomService {

    HotelRoom createHotelRoom(HotelRoomDto hotelRoom);

    HotelRoom getHotelRoom(Long id);

    HotelRoom getHotelRoomByRoomNumber(Integer roomNumber);

    List<HotelRoom> getAllHotelRooms(Optional<Boolean[]> minibarStatuses, Optional<Long[]> roomSizeIds);

    void deleteHotelRoom(Long id);

    HotelRoom updateHotelRoom(Long id, HotelRoomDto hotelRoom);

    HotelRoom updateHotelRoomByRoomNumber(Integer roomNumber, HotelRoomDto hotelRoom);





}
