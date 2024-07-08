package data.data.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryJpaRepasitory extends JpaRepository <CategoryEntity, Long>{
    List<CategoryEntity> findAllByNameContains(String name);

    Optional<CategoryEntity> findByName(String name);

}
