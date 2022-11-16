package com.bookyourseat.api.Core.SeatType.Model;

import java.util.UUID;

public class SeatType {
    private UUID Id;
    private String Description;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
