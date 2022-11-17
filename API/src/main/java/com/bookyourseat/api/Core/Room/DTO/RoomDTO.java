package com.bookyourseat.api.Core.Room.DTO;

import java.util.List;
import java.util.UUID;

import com.bookyourseat.api.Core.Room.Model.Room;
import com.bookyourseat.api.Core.Seat.DTO.SeatDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomDTO {
    private UUID Id;
    private UUID IdBuilding;
    private String Description;
    private String Map;

    private List<SeatDTO> seatDTOs;

    public RoomDTO(){}

    public RoomDTO(Room room, List<SeatDTO> seatDTOs){
        this.Id = room.getId();
        this.IdBuilding = room.getIdBuilding();
        this.Description = room.getDescription();
        this.Map = room.getMap();
        this.seatDTOs = seatDTOs;
    }

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("IdBuilding")
    public UUID getIdBuilding() {
        return IdBuilding;
    }

    public void setIdBuilding(UUID idBuilding) {
        IdBuilding = idBuilding;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @JsonProperty("Map")
    public String getMap() {
        return Map;
    }

    public void setMap(String map) {
        Map = map;
    }

    @JsonProperty("SeatDTO")
    public List<SeatDTO> getSeatDTO() {
        return seatDTOs;
    }

    public void setSeatDTO(List<SeatDTO> seatDTOs) {
        this.seatDTOs = seatDTOs;
    }
}
