package ph.phone;

import java.util.List;

public interface IPhoneBookService<T> {
    int size();
    Long getMaxId();
    T findById(Long id);
    List<T> getAllList();
    boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception;
    boolean insert(T phoneBook) throws Exception;
    boolean remove(Long id) throws Exception;
    boolean update(Long id, T phoneBook) throws Exception;
    List<T> getListFromName(String findName);
    List<T> getListFromGroup(EPhoneGroup phoneGroup);
    List<T> getListFromPhoneNumber(String findPhone);
    List<T> getListFromEmail(String findEmail);
    void loadData() throws Exception;
    void saveData() throws Exception;
}