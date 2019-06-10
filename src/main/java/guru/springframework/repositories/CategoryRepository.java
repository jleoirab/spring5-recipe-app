package guru.springframework.repositories;

import guru.springframework.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by jleoirab on 2019-06-08
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);
}
