package Recipe.JpaHibernateDemo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Repository.RecipeRepository;

//This class is responsible for acting as a Service Layer , which connects with the database to get the Recipe Records

@Service
public class RecipeService{

@Autowired	
private RecipeRepository recipe_repo;
@Autowired
private List<Recipe> recipeList=new ArrayList<Recipe>(); // Cache, which will hold all the Recipes
private boolean functionCalledBefore = false;

private void updateCache() {
	
	this.recipeList = (List<Recipe>) recipe_repo.findAll();
}


public List<Recipe> findAll() { // Returning the cached data
	
	this.recipeList = (List<Recipe>) recipe_repo.findAll();
	return this.recipeList;
		
}

public void save(Recipe recipe) {
	
	this.recipe_repo.save(recipe);
	
}

public Recipe findById(String string) throws Exception{
	Long id = Long.valueOf(string);
	Optional<Recipe> optRecipe = recipe_repo.findById(id);
	Recipe recipe = optRecipe.get();
	return recipe;
	
}

public List<Recipe> findByCategory(String category){
	
	this.recipeList = recipe_repo.findbyCategory(category);
	return this.recipeList;
}

public List<Recipe> findByNameOrDesc(String searchTerm){
	this.recipeList = recipe_repo.findByNameOrDesc(searchTerm);
	return this.recipeList;
	
}






	
}
