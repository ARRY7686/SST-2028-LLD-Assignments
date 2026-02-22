public class AttendanceRule implements EligibilityRule {

    private final int minAttendance;

    public AttendanceRule(int minAttendance) {
        this.minAttendance = minAttendance;
    }

    @Override
    public boolean isSatisfied(StudentProfile s) {
        return s.attendancePct >= minAttendance;
    }

    @Override
    public String reason() {
        return "attendance below " + minAttendance;
    }
}