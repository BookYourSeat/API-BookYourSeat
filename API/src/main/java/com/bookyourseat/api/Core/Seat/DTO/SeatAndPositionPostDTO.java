package com.bookyourseat.api.Core.Seat.DTO;

import com.bookyourseat.api.Core.Position.Model.Position;
import com.bookyourseat.api.Core.Seat.Model.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatAndPositionPostDTO {
    private Seat seat;
    private Position position;

    public SeatAndPositionPostDTO(){
    }

    public SeatAndPositionPostDTO(Seat seat, Position position){
        this.seat = seat;
        this.position = position;
    }

    @JsonProperty("Seat")
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @JsonProperty("Position")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
