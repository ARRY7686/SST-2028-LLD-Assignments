public class CGRRule implements EligibilityRule {

    private final double minCgr;

    CGRRule(double minCgr) {
        this.minCgr = minCgr;
    }

    @Override
    public boolean isSatisfied(StudentProfile s) {
        return s.cgr >= minCgr;
    }

    @Override
    public String reason() {
        return "CGR below " + minCgr;
    }
}