enum VehicleEnum {
    TWO_WHEELER,
    CAR,
    BUS
}

abstract class Vehicle {
    String vehicleNo;
    VehicleEnum vehicleType;

    public Vehicle(String vehicleNo, VehicleEnum type) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = type;
    }

    public VehicleEnum getVehicleType() {
        return vehicleType;
    }
}

class Car extends Vehicle {
    public Car(String vehicleNo) {
        super(vehicleNo, VehicleEnum.CAR);
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNo) {
        super(vehicleNo, VehicleEnum.TWO_WHEELER);
    }
}

class Bus extends Vehicle {
    public Bus(String vehicleNo) {
        super(vehicleNo, VehicleEnum.BUS);
    }
}