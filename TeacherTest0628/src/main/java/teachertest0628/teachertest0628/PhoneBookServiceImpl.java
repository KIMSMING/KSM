package teachertest0628.teachertest0628;

import com.softagape.sbtest0628.EPhoneGroup;
import com.softagape.sbtest0628.IPhoneBook;
import com.softagape.sbtest0628.IPhoneBookRepository;
import com.softagape.sbtest0628.IPhoneBookService;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {
    private List<IPhoneBook> list = new ArrayList<>();
    private final IPhoneBookRepository<IPhoneBook> phoneBookRepository;

    public PhoneBookServiceImpl(String arg1, String fileName) throws Exception {
        if ( "-j".equals(arg1) ) {
            this.phoneBookRepository = new PhoneBookJsonRepository(fileName);
        } else if ( "-t".equals(arg1) ) {
            this.phoneBookRepository = new PhoneBookTextRepository(fileName);
        } else {
            throw new Exception( "Error : You need program arguments (-j/-t) (filename) !");
        }
    }

    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * List<IPhoneBook> list 배열객체에서 id 가 가장 큰 숫자를 찾아서 리턴한다.
     * @return get Maximum id number value
     */
    @Override
    public Long getMaxId() {
        Long nMax = 0L;
//        for ( IPhoneBook obj : this.list ) {
//            if ( nMax < obj.getId() ) {
//                nMax = obj.getId();
//            }
//        }
//        return ++nMax;
        IPhoneBook last = this.list.stream()
                .reduce((first, second) -> second)
                .orElse(PhoneBook.builder().id(0L).build());
        nMax = last.getId() + 1L;
        return nMax;
    }

    @Override
    public IPhoneBook findById(Long id) {
//        for ( IPhoneBook obj : this.list ) {
//            if ( id.equals(obj.getId()) ) {
//                return obj;
//            }
//        }
//        return null;
        Optional<IPhoneBook> find = this.list.stream().parallel()
                .filter(item -> id.equals(item.getId())).findAny();
        return find.orElse(null);
    }

    private int findIndexById(Long id) {
//        for ( int i = 0; i < this.list.size(); i++ ) {
//            if ( id.equals(this.list.get(i).getId()) ) {
//                return i;
//            }
//        }
//        return -1;
        IPhoneBook find = PhoneBook.builder().id(id).build();
        int findIndex = Arrays.binarySearch(this.list.toArray(IPhoneBook[]::new)
                , find
                , PhoneBook.ORDER_GREAT);
        return findIndex;
    }

    @Override
    public List<IPhoneBook> getAllList() {
        return this.list;
    }

    @Override
    public boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception {
        IPhoneBook phoneBook = PhoneBook.builder()
                .id(this.getMaxId())
                .name(name).group(group)
                .phoneNumber(phoneNumber).email(email).build();
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean insert(IPhoneBook phoneBook) throws Exception {
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if ( find != null ) {
            this.list.remove(find);
            return true;
        }
        return false;
    }

    private boolean setIphoneBookIsNotNull(IPhoneBook to, IPhoneBook from) {
        if ( to == null || from == null ) {
            return false;
        }
        if ( from.getName() != null && !from.getName().isEmpty() ) {
            to.setName(from.getName());
        }
        if ( from.getGroup() != null ) {
            to.setGroup(from.getGroup());
        }
        if ( from.getPhoneNumber() != null && !from.getPhoneNumber().isEmpty() ) {
            to.setPhoneNumber(from.getPhoneNumber());
        }
        if ( from.getEmail() != null && !from.getEmail().isEmpty() ) {
            to.setEmail(from.getEmail());
        }
        return true;
    }

    @Override
    public boolean update(Long id, IPhoneBook phoneBook) {
        IPhoneBook find = this.findById(id);
        int findIndex = this.findIndexById(id);
        if ( findIndex >= 0 ) {
//            ((PhoneBook)find).copyFields(phoneBook);
//            this.list.set(findIndex, find);
//            return true;
            if (this.setIphoneBookIsNotNull(find, phoneBook)) {
                this.list.set(findIndex, find);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneBook.getName().contains(findName)) {
//                findArr.add(phoneBook);
//            }
//        }
        if (findName == null || findName.isEmpty()) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()
                .filter(item -> item.getName().contains(findName))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneGroup.equals(phoneBook.getGroup())) {
//                findArr.add(phoneBook);
//            }
//        }
//        return findArr;
        if (phoneGroup == null) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()//.parallel()
                .filter(item -> item.getGroup().equals(phoneGroup))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneBook.getPhoneNumber().contains(findPhone)) {
//                findArr.add(phoneBook);
//            }
//        }
        if (findPhone == null || findPhone.isEmpty()) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()
                .filter(item -> item.getPhoneNumber().contains(findPhone))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneBook.getEmail().contains(findEmail)) {
//                findArr.add(phoneBook);
//            }
//        }
        if (findEmail == null || findEmail.isEmpty()) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()
                .filter(item -> item.getEmail().contains(findEmail))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

    @Override
    public boolean loadData() throws Exception {
        return this.phoneBookRepository.loadData(this.list);
    }

    @Override
    public boolean saveData() throws Exception {
        return this.phoneBookRepository.saveData(this.list);
    }
}
