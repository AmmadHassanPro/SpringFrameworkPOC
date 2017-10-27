package Recipe.JpaHibernateDemo.Service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Repository.RecipeRepository;

@Service
public class RecipeService {

@Autowired	
private RecipeRepository recipe_repo;
@Autowired
private List<Recipe> recipeVar;

public List<Recipe> findAll() {
	byte[] img;
	recipeVar = (List<Recipe>) recipe_repo.findAll();
	return recipeVar;
		
}

public void save(Recipe recipe) {
	
	recipe_repo.save(recipe);
	
}

public Recipe findById(String string) throws Exception{
	Long id = Long.valueOf(string);
	Optional<Recipe> optRecipe = recipe_repo.findById(id);
	Recipe recipe = optRecipe.get();
	return recipe;
	
}



	
}
