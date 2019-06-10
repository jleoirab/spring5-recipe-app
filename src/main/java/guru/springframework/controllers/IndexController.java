package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
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

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = checkNotNull(recipeService);
    }


    @RequestMapping({"", "/"})
    public String getIndexPage() {
        return "index";
    }
}
