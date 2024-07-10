package rentcartest.rentcartest.Clear.Vehicle;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rentcar_tb1")
public class VehicleTypeEntity implements IVehicleType{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20, unique = true)
    private String name;
}
