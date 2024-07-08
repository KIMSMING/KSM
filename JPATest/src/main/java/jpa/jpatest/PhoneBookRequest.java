package jpa.jpatest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneBookRequest implements IPhoneBook {
    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(min = 2, max = 12)
    private String name;

    @NotBlank
    private ECategory category;

    @NotBlank
    @Size(min = 10, max = 20)
    private String phoneNumber;

    @Size(min = 0, max = 200)
    private String email;
}
