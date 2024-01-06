package com.hotelmanager.api.repository;

import com.hotelmanager.api.models.RoomSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomSizeRepository extends JpaRepository<RoomSize, Long> {
}
