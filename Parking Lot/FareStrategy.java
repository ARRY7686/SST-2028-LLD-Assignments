interface FareStrategy {
    double calculateFare(Ticket ticket, double hourlyRate);
}

class DefaultFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Ticket ticket, double hourlyRate) {
        long hours = Math.max(1, ticket.calculateParkingDuration());
        return hours * hourlyRate;
    }
}

class PeakHoursStrategy implements FareStrategy {
    @Override
    public double calculateFare(Ticket ticket, double hourlyRate) {
        long hours = Math.max(1, ticket.calculateParkingDuration());
        return hours * hourlyRate * 1.5; // surge pricing
    }
}