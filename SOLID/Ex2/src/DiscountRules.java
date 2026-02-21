public class DiscountRules {
    public static DiscountPolicy forCustomer(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            return new StudentDiscountPolicy();
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return new StaffDiscountPolicy();
        }
        return new NoDiscountPolicy();
    }
    public static double discountAmount(String customerType,double subtotal,int distinctLines) {

        DiscountPolicy policy =forCustomer(customerType);

        return policy.discountAmount(subtotal, distinctLines);
    }
}
