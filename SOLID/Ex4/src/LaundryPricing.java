public class LaundryPricing implements AddOnPricing {
    public boolean supports(AddOn addOn) {
        return addOn == AddOn.LAUNDRY;
    }
    public Money monthlyCharge() {
        return new Money(500.0);
    }
}