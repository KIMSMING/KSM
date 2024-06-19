package rent.rentcar.models;

import lombok.Getter;

@Getter

public class MotorCycle implements Vehicle{
    private Long id;
    private String company;
    private String model;
    private int makeYear;
    private VehicleType type;
    private String color;
    private int totalKm;
    private String factoryNumber;
    private String registNumber;
    private VehicleStatus status;

}
