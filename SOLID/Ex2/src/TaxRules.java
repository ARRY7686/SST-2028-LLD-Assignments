public class TaxRules {
    public static TaxPolicy forCustomer(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            return new StudentTaxPolicy();
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return new StaffTaxPolicy();
        }
        return new DefaultTaxPolicy();
    }
    public static double taxPercent(String customerType) {
        TaxPolicy policy = forCustomer(customerType);
        return policy.taxPercent();
    }
}
