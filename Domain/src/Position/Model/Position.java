package Position.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="Position")
public class Position {
    @Id
    private UUID PositionId;
    private float TopLongitude;
    private float TopLatitude;
    private float BottomLongitude;
    private float BottomLatitude;

    public UUID getPositionId() {
        return PositionId;
    }

    public void setPositionId(UUID positionId) {
        PositionId = positionId;
    }

    public float getTopLongitude() {
        return TopLongitude;
    }

    public void setTopLongitude(float topLongitude) {
        TopLongitude = topLongitude;
    }

    public float getTopLatitude() {
        return TopLatitude;
    }

    public void setTopLatitude(float topLatitude) {
        TopLatitude = topLatitude;
    }

    public float getBottomLongitude() {
        return BottomLongitude;
    }

    public void setBottomLongitude(float bottomLongitude) {
        BottomLongitude = bottomLongitude;
    }

    public float getBottomLatitude() {
        return BottomLatitude;
    }

    public void setBottomLatitude(float bottomLatitude) {
        BottomLatitude = bottomLatitude;
    }
}
