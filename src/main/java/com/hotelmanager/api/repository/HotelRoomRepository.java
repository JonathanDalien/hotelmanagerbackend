package com.hotelmanager.api.repository;

import com.hotelmanager.api.models.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {

    //Find HotelRoom by RoomNumber
    HotelRoom findByRoomNumber(Integer roomNumber);




}
