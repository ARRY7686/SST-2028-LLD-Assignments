import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");
        InvoiceRepository repository = new FileStore();
        PrinterEx2 printer = new PrinterEx2();
        CafeteriaSystem sys = new CafeteriaSystem(repository,printer);
        PriceCalculation.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        PriceCalculation.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        PriceCalculation.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        sys.checkout("student", order);
    }
}
