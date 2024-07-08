package data.data.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryJpaRepasitory categoryJpaRepasitory;

    @Override
    public ICategory findById(Long id) {
        if ( id == null || id <= 0 ){
            return null;
        }
        Optional<CategoryEntity> entity = this.categoryJpaRepasitory.findById(id);
        return entity.orElse(null);
    }

    @Override
    public ICategory findByName(String name) {
        if ( name == null || name.isEmpty() ){
            return null;
        }
        Optional<CategoryEntity> entity = this.categoryJpaRepasitory.findByName(name);
        return entity.orElse(null);
    }

    @Override
    public List<ICategory> getAllList() {
        List<ICategory> list = this.getICategoryList(
                this.categoryJpaRepasitory.findAll()
        );
//        List<ICategory> list = new ArrayList<>();
//        for(ICategory entity : this.categoryJpaRepasitory.findAll()){
//            list.add((ICategory) entity);
//        }
        return list;
    }

    private List<ICategory> getICategoryList(List<CategoryEntity> list) {
        if( list == null || list.size() <= 0 ) {
            return new ArrayList<>();
        }
        List<ICategory> result = list.stream()
                .map(entity -> (ICategory)entity)
                .toList();
        return result;
    }

    private boolean isValidInsert(ICategory category) {
        if ( category == null ){
            return false;
        }else if ( category.getName() == null || category.getName().isEmpty()){
            return false;
//       else return category.getName() != null && !category.getName().isEmpty();
        }
        return true;
    }

    @Override
    public ICategory insert(ICategory category) throws Exception{
        if ( !this.isValidInsert(category)){
            return null;
        }
        CategoryEntity entity = CategoryEntity.builder()
                        .id(0L).name(category.getName()).build();
        CategoryEntity result = this.categoryJpaRepasitory.saveAndFlush(entity);
        return result;
    }

    @Override
    public boolean remove(Long id) throws Exception {
        ICategory find = this.findById(id);
        if ( find == null ){
            return false;
        }
        if (find != null) {
            this.categoryJpaRepasitory.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ICategory update(Long id, ICategory category) throws Exception {
        ICategory find = this.findById(id);
        if ( find == null ){
            return null;
        }
        find.copyFields(category);
        CategoryEntity result = this.categoryJpaRepasitory.saveAndFlush((CategoryEntity) find);
        return result;
    }

    @Override
    public List<ICategory> findAllByNameContains(String name) {
        if ( name == null || name.isEmpty() ){
            return null;
        }
        List<ICategory> list = this.getICategoryList(
                this.categoryJpaRepasitory.findAllByNameContains(name)
        );
        return list;
    }
}
