package Book.Model;

import java.util.Date;
import java.util.UUID;

public class Book {

    private UUID BookId;

    private UUID idUser;

    private UUID idSeat;

    private Date BookedAt;

    private Date BookedUntil;

    public UUID getBookId() {
        return BookId;
    }

    public void setBookId(UUID bookId) {
        BookId = bookId;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public UUID getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(UUID idSeat) {
        this.idSeat = idSeat;
    }

    public Date getBookedAt() {
        return BookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        BookedAt = bookedAt;
    }

    public Date getBookedUntil() {
        return BookedUntil;
    }

    public void setBookedUntil(Date bookedUntil) {
        BookedUntil = bookedUntil;
    }
}
