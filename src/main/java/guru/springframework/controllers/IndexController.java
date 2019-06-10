package guru.springframework.controllers;

import guru.springframework.models.Category;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by jleoirab on 2019-06-09
 */
@RestController
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;

    public IndexController(
            CategoryRepository categoryRepository,
            UnitOfMeasureRepository unitOfMeasureRepository,
            IngredientRepository ingredientRepository,
            RecipeRepository recipeRepository
    ) {
        this.categoryRepository = checkNotNull(categoryRepository);
        this.unitOfMeasureRepository = checkNotNull(unitOfMeasureRepository);
        this.ingredientRepository = checkNotNull(ingredientRepository);
        this.recipeRepository = checkNotNull(recipeRepository);
    }


    @RequestMapping({"", "/"})
    public String getIndexPage() {
        categoryRepository.findByCategoryName("American")
                .ifPresent(category -> LOG.info("Category = {}", category.getId()));

        return "index";
    }
}
