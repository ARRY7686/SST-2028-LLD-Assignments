import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PriceCalculation {
    private static final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private static int invoiceSeq = 1000;
    public static void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public static Pair calculateTotal(String customerType ,List<OrderLine> lines){
        String invId = "INV-" + (++invoiceSeq);
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");
        Pair p = new Pair();

        p.setInvId(invId);
        p.setSb(out);
        p = calculateSubTotal(lines, p);
        p = calculateTax(customerType, p);
        p = calculateDiscount(customerType, lines, p);
        double total = p.getSubTotal() + p.getTax() - p.getDiscount();
        p.setTotal(total);
        out = p.getSb();
        out.append(String.format("TOTAL: %.2f\n", total));
        p.setSb(out);
        return p;
    }

    public static Pair calculateSubTotal(List<OrderLine> lines,Pair p){
        StringBuilder out = p.getSb();
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        out.append(String.format("Subtotal: %.2f\n", subtotal));
        p.setSb(out);
        p.setSubTotal(subtotal);
        return p;
    }

    public static Pair calculateTax(String customerType,Pair p){
        StringBuilder out = p.getSb();
        double subtotal = p.getSubTotal();
        double taxPct = TaxRules.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        p.setTax(tax);
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        p.setSb(out);
        return p;
    }

    public static Pair calculateDiscount(String customerType,List<OrderLine> lines,Pair p ){
        double subtotal = p.getSubTotal();
        StringBuilder out = p.getSb();
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        p.setDiscount(discount);
        out.append(String.format("Discount: -%.2f\n", discount));
        p.setSb(out);
        return p;
    }
}

