package data.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {

    @Autowired
    private PhoneBookJpaRepository phoneBookJpaRepository;

    private boolean isValidInsert(IPhoneBook dto){
        if( dto == null ){
            return false;
        }else if ( dto.getName() == null || dto.getName().isEmpty()){
            return false;
        }else if ( dto.getCategory() == null || dto.getCategory().isEmpty()){
            return false;
        }
        return true;
    }


    @Override
    public IPhoneBook findById(Long id) {
        Optional<PhoneBookEntity> find = this.phoneBookJpaRepository.findById(id);
        return find.orElse(null);
    }

    @Override
    public List<IPhoneBook> getAllList() {
        List<IPhoneBook> list = new ArrayList<>();
        for(PhoneBookEntity entity : this.phoneBookJpaRepository.findAll()){
            list.add((IPhoneBook)entity);
        }
        return list;
    }

    @Override
    public IPhoneBook insert(String name, String category, String phoneNumber, String email) throws Exception {
        PhoneBookEntity phoneBook = PhoneBookEntity.builder()
                .id(0L)
                .name(name).category(category)
                .phoneNumber(phoneNumber).email(email).build();
        return this.insert(phoneBook);
    }

    @Override
    public IPhoneBook insert(IPhoneBook phoneBook) throws Exception {
        if ( !this.isValidInsert(phoneBook)){
            return null;
        }
        PhoneBookEntity entity = new PhoneBookEntity();
        entity.copyFields(phoneBook);
        IPhoneBook result = this.phoneBookJpaRepository.saveAndFlush(entity);
        return result;
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if ( find != null ) {
            this.phoneBookJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public IPhoneBook update(Long id, IPhoneBook phoneBook) {
        IPhoneBook find = this.findById(id);
        return null;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        if(findName == null || findName.isEmpty()){
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }



    @Override
    public List<IPhoneBook> getListFromGroup(ECategory category) {
        if ( category == null ){
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }


    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        if(findPhone == null || findPhone.isEmpty()){
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }


    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        if (findEmail == null || findEmail.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
}