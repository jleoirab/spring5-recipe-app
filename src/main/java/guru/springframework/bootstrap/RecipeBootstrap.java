package guru.springframework.bootstrap;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import guru.springframework.models.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by jleoirab on 2019-06-09
 */
@Component
public final class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(
            CategoryRepository categoryRepository,
            RecipeRepository recipeRepository,
            UnitOfMeasureRepository unitOfMeasureRepository
    ) {
        this.categoryRepository = checkNotNull(categoryRepository);
        this.recipeRepository = checkNotNull(recipeRepository);
        this.unitOfMeasureRepository = checkNotNull(unitOfMeasureRepository);
    }

    public List<Recipe> getRecipes() {
        Optional<UnitOfMeasure> eachUOMOptional = unitOfMeasureRepository.findByValue("Each");

        if (!eachUOMOptional.isPresent()) {
            throw new RuntimeException("Expected 'Each' UOM but not found");
        }

        Optional<UnitOfMeasure> tableSpoonUOMOptional = unitOfMeasureRepository.findByValue("Tablespoon");

        if (!tableSpoonUOMOptional.isPresent()) {
            throw new RuntimeException("Expected 'TableSpoon' UOM but not found");
        }

        Optional<UnitOfMeasure> teaSpoonUOMOptional = unitOfMeasureRepository.findByValue("Teaspoon");

        if (!teaSpoonUOMOptional.isPresent()) {
            throw new RuntimeException("Expected 'TeaSpoon' UOM but not found");
        }

        Optional<UnitOfMeasure> dashUOMOptional = unitOfMeasureRepository.findByValue("Dash");

        if (!dashUOMOptional.isPresent()) {
            throw new RuntimeException("Expected 'Dash' UOM but not found");
        }

        Optional<UnitOfMeasure> pintUOMOptional = unitOfMeasureRepository.findByValue("Pint");

        if (!pintUOMOptional.isPresent()) {
            throw new RuntimeException("Expected 'Pint' UOM but not found");
        }

        Optional<Category> americanCategoryOptional = categoryRepository.findByCategoryName("American");

        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected 'American' Category but not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByCategoryName("Mexican");

        if (!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected 'Mexican' Category but not found");
        }

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setCookTime(0);
        guacRecipe.setPrepTime(10);

        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n"
                );
        Notes guacRecipeNote = new Notes();
        guacRecipeNote.setRecipeNotes(
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
        guacRecipe.setNotes(guacRecipeNote);

        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("Ripe Avocados", eachUOMOptional.get()), 0.5f));
        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("Kosher salt", teaSpoonUOMOptional.get()), 0.5f));
        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("fresh lime juice or lemon juice", tableSpoonUOMOptional.get()), 1.0f));
        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("minced red onion or thinly sliced green onion", tableSpoonUOMOptional.get()), 2.0f));
        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", eachUOMOptional.get()), 1.0f));
        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", tableSpoonUOMOptional.get()), 2.0f));
        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("freshly grated black pepper", dashUOMOptional.get()), 1.0f));
        guacRecipe.getMeasuredIngredients().add(new MeasuredIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", eachUOMOptional.get()), 0.5f));

        guacRecipe.getCategories().add(americanCategoryOptional.get());
        guacRecipe.getCategories().add(mexicanCategoryOptional.get());

        return ImmutableList.of(
                guacRecipe
        );
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }
}
