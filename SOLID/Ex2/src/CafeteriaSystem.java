import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceRepository repository;
    private final PrinterEx2 printer;
    public CafeteriaSystem(InvoiceRepository repository,PrinterEx2 printer) {
        this.repository = repository; this.printer = printer;
    }


    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        Pair p = PriceCalculation.calculateTotal(customerType, lines);
        String invId = p.getInvId();
        String printable = PrinterEx2.printInvoice(p);
        repository.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + repository.countLines(invId) + ")");
    }
}
