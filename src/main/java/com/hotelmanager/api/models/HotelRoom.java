package com.hotelmanager.api.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Room number is mandatory")
    @Column(unique = true)
    private Integer roomNumber;

    //@NotNull
    //@NotBlank(message = "Room size is mandatory")
    //@Pattern(regexp = "Einzelzimmer|Doppelzimmer|Suite", message = "Room size must be Einzelzimmer, Doppelzimmer or Suite")
    //private String roomSize; //Einzelzimmer, Doppelzimmer, Suite

    @ManyToOne
    @JoinColumn(name = "room_size_id")
    private RoomSize roomSize;

    @NotNull
    private boolean miniBar;

}
