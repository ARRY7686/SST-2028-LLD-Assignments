public class MessPricing implements AddOnPricing {
    public boolean supports(AddOn addOn) {
        return addOn == AddOn.MESS;
    }
    public Money monthlyCharge() {
        return new Money(1000.0);
    }
}