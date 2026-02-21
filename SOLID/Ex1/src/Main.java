public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        StudentRepository repository = new FakeDb();
        Printer printer = new Printer();
        OnboardingService svc = new OnboardingService(repository,printer);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        printer.printDbDump(repository);;
    }
}
