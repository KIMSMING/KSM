package data.data.PhoneBook;

import data.data.Category.ICategory;
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
        }else if ( dto.getCategory() == null ){
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
        if ( find == null){
            return null;
        }
        find.copyFields(phoneBook);
        PhoneBookEntity result = this.phoneBookJpaRepository.saveAndFlush((PhoneBookEntity) find);
        return result;
    }

    private List<IPhoneBook> getIPhoneBookList(List<PhoneBookEntity> list){
        if( list == null || list.size() <=0){
            return new ArrayList();
        }
//        List<IPhoneBook> result = list.stream()
//                .map(item -> (IPhoneBook)item)
//                .toList();
        List<IPhoneBook> result = new ArrayList<>();
        for ( PhoneBookEntity entity : list ){
            result.add( (IPhoneBook) entity );
        }
        return result;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        if(findName == null || findName.isEmpty()){
            return new ArrayList<>();
        }
        List<IPhoneBook> result = this.getIPhoneBookList(
                this.phoneBookJpaRepository.findAllByNameContains(findName)
        );
        return result;
    }



    @Override
    public List<IPhoneBook> getListFromCategory(ICategory category) {
        if ( category == null ){
            return new ArrayList<>();
        }
        List<IPhoneBook> result = this.getIPhoneBookList(
                this.phoneBookJpaRepository.findAllByCategory(category)
        );
        return result;
    }


    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        if(findPhone == null || findPhone.isEmpty()){
            return new ArrayList<>();
        }
        List<IPhoneBook> result = this.getIPhoneBookList(
                this.phoneBookJpaRepository.findAllByPhoneNumberContains(findPhone)
        );
        return result;
    }


    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        if (findEmail == null || findEmail.isEmpty()) {
            return new ArrayList<>();
        }
        List<IPhoneBook> result = this.getIPhoneBookList(
                this.phoneBookJpaRepository.findAllByEmailContains(findEmail)
        );
        return result;
    }
}