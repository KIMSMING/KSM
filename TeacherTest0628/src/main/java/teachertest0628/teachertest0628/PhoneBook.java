package teachertest0628.teachertest0628;

import com.softagape.sbtest0628.EPhoneGroup;
import com.softagape.sbtest0628.IPhoneBook;
import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBook implements IPhoneBook {
    private Long id;
    private String name;
    private EPhoneGroup group;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return String.format("ID:%6d, 이름:%s, 그룹:%s, 번호:%s, 이메일:%s}"
                , this.id, this.name, this.group, this.phoneNumber, this.email);
    }

    public void copyFields(IPhoneBook from) {
        if ( from == null ) {
            return;
        }
        if ( from.getName() != null && !from.getName().isEmpty() ) {
            this.name = from.getName();
        }
        if ( from.getGroup() != null ) {
            this.group = from.getGroup();
        }
        if ( from.getPhoneNumber() != null && !from.getPhoneNumber().isEmpty() ) {
            this.phoneNumber = from.getPhoneNumber();
        }
        if ( from.getEmail() != null && !from.getEmail().isEmpty() ) {
            this.email = from.getEmail();
        }
    }

    public static final Comparator<IPhoneBook> ORDER_GREAT =
            new OrderGreatComparator();

    private static class OrderGreatComparator implements Comparator<IPhoneBook> {
        @Override
        public int compare(IPhoneBook d1, IPhoneBook d2) {
            return d1.getId().compareTo(d2.getId());
        }
    }
}
