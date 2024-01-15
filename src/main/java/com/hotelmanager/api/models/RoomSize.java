package com.hotelmanager.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Room Size Entity
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomSize {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Size
    @NotNull
    @NotBlank
    private String size; //  Einzelzimmer, Doppelzimmer, Suite
}
