package guru.springframework.repositories;

import guru.springframework.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jleoirab on 2019-06-08
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
