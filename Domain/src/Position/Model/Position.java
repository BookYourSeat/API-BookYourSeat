package Position.Model;

import java.util.UUID;

public class Position {

    private UUID PositionId;

    private double TopLongitude;

    private double TopLatitude;

    private double BottomLongitude;

    private double BottomLatitude;

    public UUID getPositionId() {
        return PositionId;
    }

    public void setPositionId(UUID positionId) {
        PositionId = positionId;
    }

    public double getTopLongitude() {
        return TopLongitude;
    }

    public void setTopLongitude(double topLongitude) {
        TopLongitude = topLongitude;
    }

    public double getTopLatitude() {
        return TopLatitude;
    }

    public void setTopLatitude(double topLatitude) {
        TopLatitude = topLatitude;
    }

    public double getBottomLongitude() {
        return BottomLongitude;
    }

    public void setBottomLongitude(double bottomLongitude) {
        BottomLongitude = bottomLongitude;
    }

    public double getBottomLatitude() {
        return BottomLatitude;
    }

    public void setBottomLatitude(double bottomLatitude) {
        BottomLatitude = bottomLatitude;
    }
}
