package rentcartest.rentcartest.Clear.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleTypeService {

    @Autowired
    private IVehicleJpaRepository vehicleJpaRepository;

    @Override
    public IVehicleType findById(Long id) {
        if ( id <= 0 || id == null ) {
            return null;
        }
        Optional<VehicleTypeEntity> entity = this.vehicleJpaRepository.findById(id);
        return entity.orElse(null);
    }

    @Override
    public IVehicleType findByName(String name) {
        if ( name == null || name.isEmpty() ) {
            return null;
        }
        Optional<VehicleTypeEntity> entity = this.vehicleJpaRepository.findByName(name);
        return entity.orElse(null);
    }

    private List<IVehicleType> getIVehicleTypeList(List<VehicleTypeEntity> list){
        if ( list == null || list.size() <=0 ){
            return null;
        }
        List<IVehicleType> result = list.stream()
                .map(entity -> (IVehicleType)entity)
                .toList();
        return result;
    }

    @Override
    public List<IVehicleType> getAllList() {
        List<IVehicleType> list = this.getIVehicleTypeList(
                this.vehicleJpaRepository.findAll()
        );
        return list;
    }

    private boolean isValidInsert(IVehicleType vehicleType){
        if ( vehicleType == null
                || vehicleType.getName() == null
                || vehicleType.getName().isEmpty() ) {
            return false;
        }
        return true;
    }

    @Override
    public IVehicleType insert(IVehicleType vehicleType) throws Exception {
        if ( !this.isValidInsert(vehicleType)){
            return null;
        }
        VehicleTypeEntity entity = VehicleTypeEntity.builder()
                .id(0L).name(vehicleType.getName()).build();
        VehicleTypeEntity result = this.vehicleJpaRepository.saveAndFlush(entity);
        return result;
    }

    @Override
    public boolean remove(Long id) throws Exception {
        IVehicleType find = this.findById(id);
        if ( find == null ){
            return false;
        }
        if ( find != null ){
            this.vehicleJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public IVehicleType update(Long id, IVehicleType vehicleType) throws Exception {
        IVehicleType find = this.findById(id);
        if ( find == null ){
            return null;
        }
        find.copyFields(vehicleType);
        IVehicleType result = this.vehicleJpaRepository.saveAndFlush((VehicleTypeEntity) find);
        return result;
    }

    @Override
    public List<IVehicleType> findAllByNameContains(String name) {
        if ( name == null || name.isEmpty() ){
            return null;
        }
        List<IVehicleType> list = this.getIVehicleTypeList(
                this.vehicleJpaRepository.findAllByNameContains(name)
        );
        return list;
    }
}
