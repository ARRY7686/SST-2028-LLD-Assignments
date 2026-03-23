class FareCalculator {
    FareStrategy strategy;

    public FareCalculator(FareStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFare(Ticket ticket) {
        return strategy.calculateFare(ticket, ticket.spot.getHourlyRate());
    }
}