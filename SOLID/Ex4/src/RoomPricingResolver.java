import java.util.List;

public class RoomPricingResolver {

    private final List<RoomPricing> roomPricings;

    public RoomPricingResolver() {
        this.roomPricings = List.of(
            new SingleRoomPricing(),
            new DoubleRoomPricing(),
            new TripleRoomPricing()
        );
    }

    public Money resolve(int roomType) {
        for (RoomPricing rp : roomPricings) {
            if (rp.supports(roomType)) {
                return rp.monthlyBase();
            }
        }
        return new Money(16000.0);
    }
}