class Maintenance implements MovementStrategy {
    @Override
    public int getNextStop(Lift lift) {
        return -1;
    }
}