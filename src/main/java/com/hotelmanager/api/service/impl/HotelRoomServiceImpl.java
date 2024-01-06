package com.hotelmanager.api.service.impl;

import com.hotelmanager.api.HotelRoomDto;
import com.hotelmanager.api.models.HotelRoom;
import com.hotelmanager.api.models.RoomSize;
import com.hotelmanager.api.repository.HotelRoomRepository;
import com.hotelmanager.api.repository.RoomSizeRepository;
import com.hotelmanager.api.service.HotelRoomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelRoomServiceImpl implements HotelRoomService {

    private HotelRoomRepository hotelRoomRepository;
    private RoomSizeRepository roomSizeRepository;

    @Autowired
    public HotelRoomServiceImpl(HotelRoomRepository hotelRoomRepository, RoomSizeRepository roomSizeRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.roomSizeRepository = roomSizeRepository;
    }

    @Override
    public HotelRoom createHotelRoom(HotelRoomDto hotelRoom) {
        HotelRoom newHotelRoom = new HotelRoom();
        newHotelRoom.setRoomNumber(hotelRoom.getRoomNumber());
        RoomSize roomSize = roomSizeRepository.findById(hotelRoom.getRoomSize())
                .orElseThrow(() -> new EntityNotFoundException("RoomSize not found"));
        newHotelRoom.setRoomSize(roomSize);
        newHotelRoom.setMiniBar(hotelRoom.isMiniBar());

        HotelRoom savedHotelRoom = hotelRoomRepository.save(newHotelRoom);

        return savedHotelRoom;
    }

    public HotelRoom getHotelRoom(Long id) {
        HotelRoom foundHotelRoom = hotelRoomRepository.findById(id).orElse(null);
        if (foundHotelRoom == null) {
            throw new RuntimeException("HotelRoom with id " + id + " not found");
        }
        return foundHotelRoom;
    }

    @Override
    public HotelRoom getHotelRoomByRoomNumber(Integer roomNumber) {
        HotelRoom foundHotelRoom = hotelRoomRepository.findByRoomNumber(roomNumber);
        if (foundHotelRoom == null) {
            throw new RuntimeException("HotelRoom with roomNumber " + roomNumber + " not found");
        }
        return foundHotelRoom;
    }

    @Override
    public List<HotelRoom> getAllHotelRooms() {
        return hotelRoomRepository.findAll();
    }

    @Override
    public void deleteHotelRoom(Long id) {
        hotelRoomRepository.deleteById(id);
    }

    @Override
    public HotelRoom updateHotelRoom(Long id, HotelRoomDto hotelRoom) {
        HotelRoom existingHotelRoom = hotelRoomRepository.findById(id).orElse(null);

        if (existingHotelRoom == null) {
            throw new RuntimeException("HotelRoom with id " + id + " not found");
        }

        existingHotelRoom.setRoomNumber(hotelRoom.getRoomNumber());
        RoomSize roomSize = roomSizeRepository.findById(hotelRoom.getRoomSize())
                .orElseThrow(() -> new EntityNotFoundException("RoomSize not found"));
        existingHotelRoom.setRoomSize(roomSize);
        existingHotelRoom.setMiniBar(hotelRoom.isMiniBar());

        HotelRoom savedHotelRoom = hotelRoomRepository.save(existingHotelRoom);

        return savedHotelRoom;
    }

    @Override
    public HotelRoom updateHotelRoomByRoomNumber(Integer roomNumber, HotelRoomDto hotelRoom) {
        HotelRoom existingHotelRoom = hotelRoomRepository.findByRoomNumber(roomNumber);

        if (existingHotelRoom == null) {
            throw new RuntimeException("HotelRoom with roomNumber " + roomNumber + " not found");
        }

        existingHotelRoom.setRoomNumber(hotelRoom.getRoomNumber());

        RoomSize roomSize = roomSizeRepository.findById(hotelRoom.getRoomSize())
                .orElseThrow(() -> new EntityNotFoundException("RoomSize not found"));
        existingHotelRoom.setRoomSize(roomSize);

        existingHotelRoom.setMiniBar(hotelRoom.isMiniBar());

        HotelRoom savedHotelRoom = hotelRoomRepository.save(existingHotelRoom);

        return savedHotelRoom;
    }
}
