package guru.springframework.services;

import guru.springframework.models.Recipe;

import java.util.Set;

/**
 * Created by jleoirab on 2019-06-09
 */
public interface RecipeService {
    Set<Recipe> getAllRecipes();
}
