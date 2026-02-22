import java.util.*;

public class EligibilityEngine {

    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store) {
        this.store = store;

        // Order preserved exactly like original chain
        this.rules = List.of(
            new DisciplinaryRule(),
            new CGRRule(8.0),
            new AttendanceRule(75),
            new CreditsRule(20)
        );
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {

        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for (EligibilityRule rule : rules) {
            if (!rule.isSatisfied(s)) {
                status = "NOT_ELIGIBLE";
                reasons.add(rule.reason());
                break;  
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}