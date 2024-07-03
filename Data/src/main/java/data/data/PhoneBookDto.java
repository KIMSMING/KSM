package data.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PhoneBookDto implements IPhoneBook{
    private Long id;
    private String name;
    private String category;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return String.format("ID: %6d, 이름:%s, 그룹:%s, 번호:%s, 이메일:%s}"
                , this.id, this.name, this.category, this.phoneNumber, this.email);
    }
}