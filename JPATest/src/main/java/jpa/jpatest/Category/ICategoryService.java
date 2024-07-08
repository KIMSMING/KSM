package jpa.jpatest.Category;

import jpa.jpatest.ECategory;
import jpa.jpatest.IPhoneBook;

import java.util.List;

public interface ICategoryService {
    ICategory FindById(Long id);
    ICategory FindByName(String name);
    List<ICategory> getAllList();
    Exception insert(ICategory category) throws Exception;
    boolean remove(Long id) throws Exception;
    ICategory update(Long id, ICategory category) throws Exception;
    List<ICategory>
}
