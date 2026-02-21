public class NoDiscountPolicy implements DiscountPolicy {

    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        return 0.0;
    }
}