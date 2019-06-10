package guru.springframework.services;

import guru.springframework.models.Recipe;
import guru.springframework.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by jleoirab on 2019-06-09
 */
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = checkNotNull(recipeRepository);
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        HashSet<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }
}
