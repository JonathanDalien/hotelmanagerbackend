package com.hotelmanager.api.controllers;

import com.hotelmanager.api.HotelRoomDto;
import com.hotelmanager.api.models.HotelRoom;
import com.hotelmanager.api.service.HotelRoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class HotelRoomController {

    //Inject HotelRoomService
    private HotelRoomService hotelRoomService;

    //Constructor
    @Autowired
    public HotelRoomController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    //Get All HotelRooms
    @GetMapping("hotelrooms")
    public ResponseEntity<List<HotelRoom>> getHotelRooms(@RequestParam(required = false) Optional<Boolean[]> withMinibar, @RequestParam(required = false) Optional<Long[]> roomSizeIds){
        List<HotelRoom> hotelRooms = hotelRoomService.getAllHotelRooms(withMinibar, roomSizeIds);
        return ResponseEntity.ok(hotelRooms);
    }

    //Get HotelRoom
    @GetMapping("hotelroom/{id}")
    public ResponseEntity<HotelRoom> getHotelRoom(@PathVariable Long id){
        HotelRoom hotelRoom = hotelRoomService.getHotelRoom(id);
        return ResponseEntity.ok(hotelRoom);
    }

    //Get HotelRoom by RoomNumber
    @GetMapping("hotelroom/roomnumber/{roomNumber}")
    public ResponseEntity<HotelRoom> getHotelRoomByRoomNumber(@PathVariable Integer roomNumber){
        HotelRoom hotelRoom = hotelRoomService.getHotelRoomByRoomNumber(roomNumber);
        return ResponseEntity.ok(hotelRoom);
    }

   //Get HotelRoom by RoomNumber
    @PostMapping("hotelroom")
    public ResponseEntity<HotelRoom> createHotelRoom(@Valid @RequestBody HotelRoomDto hotelRoom){
        HotelRoom newHotelRoom = hotelRoomService.createHotelRoom(hotelRoom);
        return ResponseEntity.ok(newHotelRoom);
    }

    //Update HotelRoom
    @PutMapping("hotelroom/{id}")
    public ResponseEntity<HotelRoom> updateHotelRoom(@PathVariable Long id, @Valid @RequestBody HotelRoomDto hotelRoom){
        HotelRoom updatedHotelRoom = hotelRoomService.updateHotelRoom(id, hotelRoom);
        return ResponseEntity.ok(updatedHotelRoom);
    }

    //Update HotelRoom by RoomNumber
    @PutMapping("hotelroom/roomnumber/{roomNumber}")
    public ResponseEntity<HotelRoom> updateHotelRoomByRoomNumber(@PathVariable Integer roomNumber, @Valid @RequestBody HotelRoomDto hotelRoom){
        HotelRoom updatedHotelRoom = hotelRoomService.updateHotelRoomByRoomNumber(roomNumber, hotelRoom);
        return ResponseEntity.ok(updatedHotelRoom);
    }

    //Delete HotelRoom
    @DeleteMapping("hotelroom/{id}")
    public ResponseEntity<Void> deleteHotelRoom(@PathVariable Long id){
        hotelRoomService.deleteHotelRoom(id);
        return ResponseEntity.noContent().build();
    }


}
