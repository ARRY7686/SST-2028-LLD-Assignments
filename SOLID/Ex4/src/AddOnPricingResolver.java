import java.util.List;

public class AddOnPricingResolver {

    private final List<AddOnPricing> addOnPricings;

    public AddOnPricingResolver() {
        this.addOnPricings = List.of(
            new MessPricing(),
            new LaundryPricing(),
            new GymPricing()
        );
    }

    public Money resolve(List<AddOn> addOns) {
        double total = 0.0;

        for (AddOn addOn : addOns) {
            for (AddOnPricing ap : addOnPricings) {
                if (ap.supports(addOn)) {
                    total += ap.monthlyCharge().amount;
                }
            }
        }

        return new Money(total);
    }
}