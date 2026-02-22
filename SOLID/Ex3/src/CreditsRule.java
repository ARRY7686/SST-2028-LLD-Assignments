public class CreditsRule implements EligibilityRule {

    private final int minCredits;

    public CreditsRule(int minCredits) {
        this.minCredits = minCredits;
    }

    @Override
    public boolean isSatisfied(StudentProfile s) {
        return s.earnedCredits >= minCredits;
    }

    @Override
    public String reason() {
        return "credits below " + minCredits;
    }
}