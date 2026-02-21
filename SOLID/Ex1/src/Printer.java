public class Printer {
    public void printSuccess(String id, int total) {
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + total);
    }

    public void printConfirmation(StudentRecord record) {
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }
    public void printDbDump(StudentRepository repository) {
        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(repository));
    }
}
