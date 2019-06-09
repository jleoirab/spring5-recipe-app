package guru.springframework.repositories;

import guru.springframework.models.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jleoirab on 2019-06-08
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
