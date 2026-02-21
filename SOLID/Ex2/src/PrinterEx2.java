public class PrinterEx2 {
    public static String printInvoice(Pair p){
        StringBuilder out = p.getSb();
        String printable = InvoiceFormatter.identityFormat(out.toString());
        System.out.print(printable);
        return printable;
    }

}
