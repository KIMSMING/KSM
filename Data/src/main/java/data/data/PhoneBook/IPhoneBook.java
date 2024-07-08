package data.data.PhoneBook;

import java.io.Serializable;

public interface IPhoneBook extends Serializable {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);


    ECategory getCategory();
    void setCategory(ECategory category);

    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);

    String getEmail();
    void setEmail(String email);

    default void copyFields(IPhoneBook from) {
        if ( from == null ) {
            return;
        }
        if ( from.getId() != null ) {
            this.setId(from.getId());
        }
        if ( from.getName() != null && !from.getName().isEmpty() ) {
            this.setName(from.getName());
        }
        if ( from.getCategory() != null ) {
            this.setCategory(from.getCategory());
        }
        if ( from.getPhoneNumber() != null && !from.getPhoneNumber().isEmpty() ) {
            this.setPhoneNumber(from.getPhoneNumber());
        }
        if ( from.getEmail() != null && !from.getEmail().isEmpty() ) {
            this.setEmail(from.getEmail());
        }
    }
}
