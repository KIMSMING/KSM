package data.data;

import java.util.List;

public interface IPhoneBookService<T> {
    T findById(Long id);
    List<T> getAllList();
    IPhoneBook insert(String name, String category, String phoneNumber, String email) throws Exception;
    IPhoneBook insert(T phoneBook) throws Exception;
    boolean remove(Long id) throws Exception;
    IPhoneBook update(Long id, T phoneBook) throws Exception;
    List<T> getListFromName(String findName);
    List<T> getListFromGroup(ECategory phoneGroup);
    List<T> getListFromPhoneNumber(String findPhone);
    List<T> getListFromEmail(String findEmail);
}
