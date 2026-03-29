class Priority implements MovementStrategy {
    @Override
    public int getNextStop(Lift lift) {
        return lift.requests.peek() != null ? lift.requests.peek() : lift.currFloor;
    }
}