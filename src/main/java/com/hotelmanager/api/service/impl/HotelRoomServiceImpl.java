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

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//HotelRoom Service Implementation
@Service
public class HotelRoomServiceImpl implements HotelRoomService {

    //Inject HotelRoomRepository and RoomSizeRepository
    private HotelRoomRepository hotelRoomRepository;
    private RoomSizeRepository roomSizeRepository;

    //Constructor
    @Autowired
    public HotelRoomServiceImpl(HotelRoomRepository hotelRoomRepository, RoomSizeRepository roomSizeRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.roomSizeRepository = roomSizeRepository;
    }

    //Create HotelRoom
    @Override
    public HotelRoom createHotelRoom(HotelRoomDto hotelRoom) {
        //Create new HotelRoom
        HotelRoom newHotelRoom = new HotelRoom();
        newHotelRoom.setRoomNumber(hotelRoom.getRoomNumber());
        //Find RoomSize by ID
        RoomSize roomSize = roomSizeRepository.findById(hotelRoom.getRoomSize())
                .orElseThrow(() -> new EntityNotFoundException("RoomSize not found"));
        newHotelRoom.setRoomSize(roomSize);
        newHotelRoom.setMiniBar(hotelRoom.isMiniBar());

        //Save HotelRoom
        HotelRoom savedHotelRoom = hotelRoomRepository.save(newHotelRoom);

        return savedHotelRoom;
    }

    //Get HotelRoom
    public HotelRoom getHotelRoom(Long id) {
        //Find HotelRoom by ID
        HotelRoom foundHotelRoom = hotelRoomRepository.findById(id).orElse(null);

        //If HotelRoom not found, throw exception
        if (foundHotelRoom == null) {
            throw new RuntimeException("HotelRoom with id " + id + " not found");
        }
        return foundHotelRoom;
    }

    //Get HotelRoom by RoomNumber
    @Override
    public HotelRoom getHotelRoomByRoomNumber(Integer roomNumber) {
        //Find HotelRoom by RoomNumber
        HotelRoom foundHotelRoom = hotelRoomRepository.findByRoomNumber(roomNumber);

        //If HotelRoom not found, throw exception
        if (foundHotelRoom == null) {
            throw new RuntimeException("HotelRoom with roomNumber " + roomNumber + " not found");
        }
        return foundHotelRoom;
    }

    //Get All HotelRooms
    @Override
    public List<HotelRoom> getAllHotelRooms(Optional<Boolean[]> minibarStatuses, Optional<Long[]> roomSizeIds, Optional<Integer> roomNumber ) {
        //Get all HotelRooms and create stream
        Stream<HotelRoom> hotelRoomStream = hotelRoomRepository.findAll().stream();

        // Filter based on minibar status if present
        if (minibarStatuses.isPresent()) {
            // Convert the array to a list
            List<Boolean> statusList = Arrays.asList(minibarStatuses.get());
            // Filter the stream based on the list
            hotelRoomStream = hotelRoomStream.filter(hotelRoom -> statusList.isEmpty() || statusList.contains(hotelRoom.isMiniBar()));
        }

        // Filter based on room size IDs if present
        if (roomSizeIds.isPresent()) {
            // Convert the array to a list
            List<Long> sizeIds = Arrays.asList(roomSizeIds.get());
            // Filter the stream based on the list
            hotelRoomStream = hotelRoomStream.filter(hotelRoom -> hotelRoom.getRoomSize() != null && sizeIds.contains(hotelRoom.getRoomSize().getId()));
        }

        // Filter based on a single room number if present
        if (roomNumber.isPresent()) {
            int number = roomNumber.get();
            hotelRoomStream = hotelRoomStream.filter(hotelRoom -> hotelRoom.getRoomNumber().toString().contains(String.valueOf(number)));
        }

        // Return the sorted list
        return hotelRoomStream.sorted(Comparator.comparing(HotelRoom::getId)).toList();
    }

    //Delete HotelRoom
    @Override
    public void deleteHotelRoom(Long id) {
        hotelRoomRepository.deleteById(id);
    }

    //Update HotelRoom
    @Override
    public HotelRoom updateHotelRoom(Long id, HotelRoomDto hotelRoom) {
        //Find HotelRoom by ID
        HotelRoom existingHotelRoom = hotelRoomRepository.findById(id).orElse(null);

        //If HotelRoom not found, throw exception
        if (existingHotelRoom == null) {
            throw new RuntimeException("HotelRoom with id " + id + " not found");
        }

        existingHotelRoom.setRoomNumber(hotelRoom.getRoomNumber());
        RoomSize roomSize = roomSizeRepository.findById(hotelRoom.getRoomSize())
                .orElseThrow(() -> new EntityNotFoundException("RoomSize not found"));
        existingHotelRoom.setRoomSize(roomSize);
        existingHotelRoom.setMiniBar(hotelRoom.isMiniBar());

        //Save HotelRoom
        HotelRoom savedHotelRoom = hotelRoomRepository.save(existingHotelRoom);

        return savedHotelRoom;
    }

    //Update HotelRoom by RoomNumber
    @Override
    public HotelRoom updateHotelRoomByRoomNumber(Integer roomNumber, HotelRoomDto hotelRoom) {
        HotelRoom existingHotelRoom = hotelRoomRepository.findByRoomNumber(roomNumber);

        //If HotelRoom not found, throw exception
        if (existingHotelRoom == null) {
            throw new RuntimeException("HotelRoom with roomNumber " + roomNumber + " not found");
        }

        existingHotelRoom.setRoomNumber(hotelRoom.getRoomNumber());

        RoomSize roomSize = roomSizeRepository.findById(hotelRoom.getRoomSize())
                .orElseThrow(() -> new EntityNotFoundException("RoomSize not found"));
        existingHotelRoom.setRoomSize(roomSize);

        existingHotelRoom.setMiniBar(hotelRoom.isMiniBar());

        //Save HotelRoom
        HotelRoom savedHotelRoom = hotelRoomRepository.save(existingHotelRoom);

        return savedHotelRoom;
    }
}
