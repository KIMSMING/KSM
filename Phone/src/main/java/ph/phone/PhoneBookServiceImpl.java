package ph.phone;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {
    private List<IPhoneBook> list = new ArrayList<>();
    private final IPhoneBookRepository<IPhoneBook> phoneBookRepository;

    public PhoneBookServiceImpl(String arg1, String fileName) throws Exception {
        if ( "-j".equals(arg1) ) {
            this.phoneBookRepository = new PhoneBookJSONRepository(fileName);
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
        for ( IPhoneBook obj : this.list ) {
            if ( nMax < obj.getId() ) {
                nMax = obj.getId();
            }
        }
        return ++nMax;
    }

    @Override
    public IPhoneBook findById(Long id) {
        for ( IPhoneBook obj : this.list ) {
            if ( id.equals(obj.getId()) ) {
                return obj;
            }
        }
        return null;
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

    @Override
    public boolean update(Long id, IPhoneBook phoneBook) {
        int findIndex = this.findIndexById(id);
        if ( findIndex >= 0 ) {
            phoneBook.setId(id);
            this.list.set(findIndex, phoneBook);
            return true;
        }
        return false;
    }

    private int findIndexById(Long id) {
        for ( int i = 0; i < this.list.size(); i++ ) {
            if ( id.equals(this.list.get(i).getId()) ) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getName().contains(findName)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneGroup.equals(phoneBook.getGroup())) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getPhoneNumber().contains(findPhone)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getEmail().contains(findEmail)) {
                findArr.add(phoneBook);
            }
        }
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