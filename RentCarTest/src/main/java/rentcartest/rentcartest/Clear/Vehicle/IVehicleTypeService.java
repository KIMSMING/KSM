package rentcartest.rentcartest.Clear.Vehicle;

import java.util.List;

public interface IVehicleTypeService {
    IVehicleType findById(Long id);
    IVehicleType findByName(String name);
    List<IVehicleType> getAllList();
    IVehicleType insert(IVehicleType vehicleType) throws Exception;
    boolean remove(Long id) throws Exception;
    IVehicleType update(Long id, IVehicleType vehicleType) throws Exception;
    List<IVehicleType> findAllByNameContains(String name);
}
