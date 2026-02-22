public class DisciplinaryRule implements EligibilityRule {

    @Override
    public boolean isSatisfied(StudentProfile s) {
        return s.disciplinaryFlag == LegacyFlags.NONE;
    }

    @Override
    public String reason() {
        return "disciplinary flag present";
    }
}