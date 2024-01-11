package com.hotelmanager.api.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Hotelroom Entity
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRoom {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Room Number
    @Positive(message = "Room number must be positive")
    @NotNull(message = "Room number is mandatory")
    @Column(unique = true)
    private Integer roomNumber;

    //Room Size
    @ManyToOne
    @JoinColumn(name = "room_size_id")
    private RoomSize roomSize;

    //Minibar
    @NotNull
    private boolean miniBar;

}
