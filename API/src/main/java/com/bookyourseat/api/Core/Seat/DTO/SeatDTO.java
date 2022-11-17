package com.bookyourseat.api.Core.Seat.DTO;

import java.util.List;
import java.util.UUID;

import com.bookyourseat.api.Core.Book.Model.Book;
import com.bookyourseat.api.Core.Position.Model.Position;
import com.bookyourseat.api.Core.Seat.Model.Seat;
import com.bookyourseat.api.Core.SeatType.Model.SeatType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatDTO {
    //Seat
    private UUID Id;
    private UUID IdType;
    private UUID IdRoom;
    private UUID IdPosition;

    //Position
    private Float Longitude;
    private Float Latitude;
    private Float Radius;

    //Type
    private String Description;

    //Books
    private List<Book> books;

    public SeatDTO(){
    }

    public SeatDTO(Seat seat, Position position){
        this.Id = seat.getId();
        this.IdType = seat.getIdType();
        this.IdRoom = seat.getIdRoom();
        this.IdPosition = seat.getIdPosition();

        this.Longitude = position.getLongitude();
        this.Latitude = position.getLatitude();
        this.Radius = position.getRadius();
    }

    public SeatDTO(Seat seat, Position position, SeatType seatType){
        this.Id = seat.getId();
        this.IdType = seat.getIdType();
        this.IdRoom = seat.getIdRoom();
        this.IdPosition = seat.getIdPosition();

        this.Longitude = position.getLongitude();
        this.Latitude = position.getLatitude();
        this.Radius = position.getRadius();

        this.Description = seatType.getDescription();
    }

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID seatId) {
        Id = seatId;
    }

    @JsonProperty("IdType")
    public UUID getIdType() {
        return IdType;
    }

    public void setIdType(UUID idType) {
        IdType = idType;
    }

    @JsonProperty("IdRoom")
    public UUID getIdRoom() {
        return IdRoom;
    }

    public void setIdRoom(UUID idRoom) {
        IdRoom = idRoom;
    }

    @JsonProperty("IdPosition")
    public UUID getIdPosition() {
        return IdPosition;
    }

    public void setIdPosition(UUID idPosition) {
        IdPosition = idPosition;
    }

    @JsonProperty("Longitude")
    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }

    @JsonProperty("Latitude")
    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    @JsonProperty("Radius")
    public Float getRadius() {
        return Radius;
    }

    public void setRadius(Float radius) {
        Radius = radius;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @JsonProperty("Books")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks( List<Book> books) {
        this.books = books;
    }
}
