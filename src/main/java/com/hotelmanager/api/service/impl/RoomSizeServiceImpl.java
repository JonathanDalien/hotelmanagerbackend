package com.hotelmanager.api.service.impl;

import com.hotelmanager.api.models.RoomSize;
import com.hotelmanager.api.repository.RoomSizeRepository;
import com.hotelmanager.api.service.RoomSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomSizeServiceImpl implements RoomSizeService {

    //Inject RoomSizeRepository
    private RoomSizeRepository roomSizeRepository;

    //Constructor
    @Autowired
    public RoomSizeServiceImpl(RoomSizeRepository roomSizeRepository) {
        this.roomSizeRepository = roomSizeRepository;
    }

    //Get All RoomSizes
    @Override
    public List<RoomSize> getAllRoomSizes() {
        return roomSizeRepository.findAll();
    }
}
