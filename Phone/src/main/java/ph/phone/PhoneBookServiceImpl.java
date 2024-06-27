package ph.phone;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Long maxId = Long.MIN_VALUE; // 가장 작은 값으로 초기화합니다.

        for (IPhoneBook obj : this.list) {
            maxId = Math.max(maxId, obj.getId());
        }

        return maxId + 1; // 최대값보다 1 큰 값을 반환합니다.
    }

    @Override
    public IPhoneBook findById(Long id) {
        int low = 0;
        int high = this.list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            IPhoneBook midObj = this.list.get(mid);

            if (id.equals(midObj.getId())) {
                return midObj;
            } else if (id < midObj.getId()) {
                high = mid - 1;
            } else {
                low = mid + 1;
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
        if (isNameDuplicate(name)) {
            System.out.println("이미 존재하는 이름입니다");
            return false;
        }

        IPhoneBook phoneBook = PhoneBook.builder()
                .id(this.getMaxId())
                .name(name).group(group)
                .phoneNumber(phoneNumber).email(email).build();
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean insert(IPhoneBook phoneBook) throws Exception {
        if (isNameDuplicate(phoneBook.getName())) {
            System.out.println("이미 존재하는 이름입니다");
            return false;
        }

        this.list.add(phoneBook);
        return true;
    }

    private boolean isNameDuplicate(String name) {
        for (IPhoneBook contact : list) {
            if (contact.getName().equals(name)) {
                return true;
            }
        }
        return false;
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
        int low = 0;
        int high = this.list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            IPhoneBook midObj = this.list.get(mid);

            if (id.equals(midObj.getId())) {
                return mid;
            } else if (id < midObj.getId()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        return this.list.stream()
                .filter(phoneBook -> phoneBook.getName().contains(findName)) // 이름에 찾고자 하는 문자열이 포함된 객체를 필터링
                .collect(Collectors.toList()); // 필터링된 객체들을 리스트로 수집
    }


    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup) {
        return this.list.stream()
                .filter(phoneBook -> phoneGroup.equals(phoneBook.getGroup()))
                .collect(Collectors.toList()); // 필터링된 객체들을 리스트로 수집
    }


    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        return this.list.stream()
                .filter(phoneBook -> phoneBook.getPhoneNumber().contains(findPhone))
                .collect(Collectors.toList());
    }


    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        return this.list.stream()
                .filter(phoneBook -> phoneBook.getEmail() .contains(findEmail))
                .collect(Collectors.toList());
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