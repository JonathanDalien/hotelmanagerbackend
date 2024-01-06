package com.hotelmanager.api.controllers;


import com.hotelmanager.api.models.RoomSize;
import com.hotelmanager.api.service.RoomSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RoomSizeController {

    private RoomSizeService roomSizeService;

    @Autowired
    public RoomSizeController(RoomSizeService roomSizeService) {
        this.roomSizeService = roomSizeService;
    }

    @GetMapping("roomsizes")
    public ResponseEntity<List<RoomSize>> getRoomSizes(){
        List<RoomSize> roomSizes = roomSizeService.getAllRoomSizes();
        return ResponseEntity.ok(roomSizes);
    }

}
