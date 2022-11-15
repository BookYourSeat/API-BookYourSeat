package Book.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Book")
public class Book {
    @Id
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
