package jpa.jpatest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {
    @Autowired
    private PhoneBookJpaRepository phoneBookJpaRepository;

    @Override
    public IPhoneBook findById(Long id) {
        Optional<PhoneBookEntity> find = this.phoneBookJpaRepository.findById(id);
        return find.orElse(null);
    }

    @Override
    public List<IPhoneBook> getAllList() {
        List<IPhoneBook> list = new ArrayList<>();
        for ( PhoneBookEntity entity : this.phoneBookJpaRepository.findAll() ) {
            list.add( (IPhoneBook)entity );
        }
        return list;
    }

    @Override
    public IPhoneBook insert(String name, ECategory category, String phoneNumber, String email) throws Exception {
        PhoneBookDto phoneBook = PhoneBookDto.builder()
                .id(0L)
                .name(name).category(category)
                .phoneNumber(phoneNumber).email(email).build();
        return this.insert(phoneBook);
    }

    @Override
    public IPhoneBook insert(IPhoneBook phoneBook) throws Exception {
        if ( !this.isValidInsert(phoneBook) ) {
            return null;
        }
        PhoneBookEntity entity = new PhoneBookEntity();
        entity.copyFields(phoneBook);
        IPhoneBook result = this.phoneBookJpaRepository.saveAndFlush(entity);
        return result;
    }

    private boolean isValidInsert(IPhoneBook dto) {
        if (dto == null) {
            return false;
        } else if ( dto.getName() == null || dto.getName().isEmpty() ) {
            return false;
        } else if ( dto.getCategory() == null ) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if ( find == null ) {
            return false;
        }
        this.phoneBookJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public IPhoneBook update(Long id, IPhoneBook phoneBook) {
//        IPhoneBook find = this.findById(id);
        IPhoneBook find = this.findById(id);
        if ( find == null ) {
            return null;
        }
//        PhoneBookEntity entity = PhoneBookEntity.builder()
//                .id(id).name(find.getName()).category(find.getCategory())
//                .phoneNumber(find.getPhoneNumber()).build();
//        entity.copyFields(phoneBook);
//        PhoneBookEntity result = this.phoneBookJpaRepository.saveAndFlush(entity);
        find.copyFields(phoneBook);
        PhoneBookEntity result = this.phoneBookJpaRepository.saveAndFlush((PhoneBookEntity)find);
        return result;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        if (findName == null || findName.isEmpty()) {
            return new ArrayList<>();
        }
        List<PhoneBookEntity> list = this.phoneBookJpaRepository.findAllByNameContains(findName);
        //PhoneBookEntity|PhoneBookEntity|PhoneBookEntity|PhoneBookEntity|PhoneBookEntity
        List<IPhoneBook> result = new ArrayList<>();
        for ( PhoneBookEntity item : list ) {
            result.add((IPhoneBook) item);
        }
        //IPhoneBook|IPhoneBook|IPhoneBook|IPhoneBook|IPhoneBook
        return result;
    }

    @Override
    public List<IPhoneBook> getListFromCategory(ECategory category) {
        if (category == null) {
            return new ArrayList<>();
        }
        List<PhoneBookEntity> list = this.phoneBookJpaRepository.findAllByCategory(category);
        List<IPhoneBook> result = list.stream()
                .map(x -> (IPhoneBook)x)
                .toList();
        return result;
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        if (findPhone == null || findPhone.isEmpty()) {
            return new ArrayList<>();
        }
        List<PhoneBookEntity> list = this.phoneBookJpaRepository.findAllByPhoneNumberContains(findPhone);
        List<IPhoneBook> result = list.stream()
                .map(item -> (IPhoneBook)item)
                .toList();
        return result;
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        if (findEmail == null || findEmail.isEmpty()) {
            return new ArrayList<>();
        }
        List<PhoneBookEntity> list = this.phoneBookJpaRepository.findAllByEmailContains(findEmail);
        //PhoneBookEntity|PhoneBookEntity|PhoneBookEntity|PhoneBookEntity|PhoneBookEntity
        List<IPhoneBook> result = list.stream()
                .map(node -> (IPhoneBook)node)
                .collect(Collectors.toUnmodifiableList());
        //IPhoneBook|IPhoneBook|IPhoneBook|IPhoneBook|IPhoneBook
        return result;
    }
}
