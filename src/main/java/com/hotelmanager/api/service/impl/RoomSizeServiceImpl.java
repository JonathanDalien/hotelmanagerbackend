package com.hotelmanager.api.service.impl;

import com.hotelmanager.api.models.RoomSize;
import com.hotelmanager.api.repository.RoomSizeRepository;
import com.hotelmanager.api.service.RoomSizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomSizeServiceImpl implements RoomSizeService {

    private RoomSizeRepository roomSizeRepository;

    public RoomSizeServiceImpl(RoomSizeRepository roomSizeRepository) {
        this.roomSizeRepository = roomSizeRepository;
    }
    @Override
    public List<RoomSize> getAllRoomSizes() {
        return roomSizeRepository.findAll();
    }
}
