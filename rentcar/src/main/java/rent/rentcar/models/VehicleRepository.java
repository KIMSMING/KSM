package rent.rentcar.models;

import java.util.List;

public interface VehicleRepository {
    String save(List<Vehicle> vehicles);
    String load(List<Vehicle> vehicles);
}
