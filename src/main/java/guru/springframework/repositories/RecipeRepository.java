package guru.springframework.repositories;

import guru.springframework.models.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jleoirab on 2019-06-08
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
