enum GateType {
    ENTRY,
    EXIT
}

abstract class Gate {
    int gateNumber;
    GateType type;

    public Gate(int num, GateType type) {
        this.gateNumber = num;
        this.type = type;
    }
}

class EntryGate extends Gate {
    public EntryGate(int num) {
        super(num, GateType.ENTRY);
    }
}

class ExitGate extends Gate {
    public ExitGate(int num) {
        super(num, GateType.EXIT);
    }
}