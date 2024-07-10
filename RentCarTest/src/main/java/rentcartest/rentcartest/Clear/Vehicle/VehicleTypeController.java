package rentcartest.rentcartest.Clear.Vehicle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/vt")
public class VehicleTypeController {

    @Autowired
    private IVehicleTypeService vehicleTypeService;

    @PostMapping
    public ResponseEntity<IVehicleType> insert(@RequestBody VehicleTypeEntity entity){
        try{
            if ( entity == null ){
                return ResponseEntity.badRequest().build();
            }
            IVehicleType result = this.vehicleTypeService.insert(entity);
            if ( result == null ){
                return ResponseEntity.badRequest().build();
            }
            return  ResponseEntity.ok(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
