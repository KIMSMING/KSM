package ph.phone;

import java.util.List;

public interface IPhoneBookRepository<T> {
    boolean saveData(List<T> listData) throws Exception ;
    boolean loadData(List<T> listData) throws Exception ;
}