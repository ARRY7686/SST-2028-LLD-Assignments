public class GymPricing implements AddOnPricing {
    public boolean supports(AddOn addOn) {
        return addOn == AddOn.GYM;
    }
    public Money monthlyCharge() {
        return new Money(300.0);
    }
}