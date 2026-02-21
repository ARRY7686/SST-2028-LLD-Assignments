public class OnboardingService {
    private final StudentRepository repository;
    private final Printer printer;

    public OnboardingService(StudentRepository repository,Printer printer) {
        this.repository = repository; this.printer = printer;
    }
    

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);
        StudentDto dt = InputParser.parse(raw); 
        if(!Validator.validate(dt)){
            return;
        }
        String id = IdUtil.nextStudentId(repository.count());
        StudentRecord rec = new StudentRecord(id, dt.getName(), dt.getEmail(), dt.getPhone(), dt.getProgram());

        repository.save(rec);
        printer.printSuccess(id, repository.count());
        printer.printConfirmation(rec);
    }
}
