package ph.phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PhoneBook implements IPhoneBook{
    private Long id;
    private String name;
    private EPhoneGroup group;
    private String phoneNumber;
    private String email;

    public PhoneBook() {

    }

    @Override
    public String toString() {
        return String.format("ID: %6d, 이름:%s, 그룹:%s, 번호:%s, 이메일:%s}"
                , this.id, this.name, this.group, this.phoneNumber, this.email);
    }
}
