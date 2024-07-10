package rentcartest.rentcartest.Clear.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IVehicleJpaRepository extends JpaRepository <VehicleTypeEntity, Long> {
    Optional<VehicleTypeEntity> findById(Long id);

    Optional<VehicleTypeEntity> findByName(String name);

    List<VehicleTypeEntity> findAllByNameContains(String name);
}
