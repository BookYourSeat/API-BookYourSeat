package com.bookyourseat.api.Core.Book.Model;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private UUID Id;
    private UUID IdUser;
    private UUID IdSeat;
    private Date BookedAt;
    private Date BookedUntil;

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("IdUser")
    public UUID getIdUser() {
        return IdUser;
    }

    public void setIdUser(UUID idUser) {
        IdUser = idUser;
    }

    @JsonProperty("IdSeat")
    public UUID getIdSeat() {
        return IdSeat;
    }

    public void setIdSeat(UUID idSeat) {
        IdSeat = idSeat;
    }

    @JsonProperty("BookedAt")
    public Date getBookedAt() {
        return BookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        BookedAt = bookedAt;
    }

    @JsonProperty("BookedUntil")
    public Date getBookedUntil() {
        return BookedUntil;
    }

    public void setBookedUntil(Date bookedUntil) {
        BookedUntil = bookedUntil;
    }
}
