public interface InvoiceRepository {
    void save(String invId,String printable);
    int countLines(String name);
    
}
