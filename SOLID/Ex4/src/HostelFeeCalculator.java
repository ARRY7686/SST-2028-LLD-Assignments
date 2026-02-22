import java.util.*;

public class HostelFeeCalculator {

    private final FakeBookingRepo repo;
    private final RoomPricingResolver roomResolver;
    private final AddOnPricingResolver addOnResolver;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
        this.roomResolver = new RoomPricingResolver();
        this.addOnResolver = new AddOnPricingResolver();
    }

    public void process(BookingRequest req) {

        Money base = roomResolver.resolve(req.roomType);
        Money addOns = addOnResolver.resolve(req.addOns);

        Money monthly = new Money(base.amount + addOns.amount);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}