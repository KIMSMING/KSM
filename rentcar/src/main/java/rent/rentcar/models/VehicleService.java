package rent.rentcar.models;

public interface VehicleService {
    Vehicle addVehicle();
    Long removeVehicle();
    Vehicle updateVehicle();
    Long findVehicleById();
    void getAllVehicle();
    VehicleStatus findVehicleForStatus();

}
