package Recipe.JpaHibernateDemo.Service;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Entities.Difficulty;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
import Recipe.JpaHibernateDemo.Entities.Notes;
import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
import Recipe.JpaHibernateDemo.Repository.RecipeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional // To roll back what we save in this suite
public class RecipeServiceTestSuite {
	@Autowired
	private RecipeService recipeService;
	
	@Autowired	
	private RecipeRepository recipe_repo;
	@Autowired
	private List<Recipe> recipeVar;
	@Autowired
	private Recipe recipe;
	@Autowired
	private Category catEntity;
	@Autowired
	private Notes notes;
	@Autowired
	private UnitOfMeasure uomEntity;
	private Difficulty diff;
	@Autowired
	private Ingredient ing;
	@Autowired
	private List<Ingredient> ingSet;
	@Autowired
	private Set<Category> catSet;
	@Autowired
	private UnitOfMeasureService uomService;
	@Autowired
	private CategoryService catService;
	
	@Before
	public void setUp() {
	
		catEntity.setDescription("Sample Category");		
		notes.setRecipeNotes("Sample Notes");
		uomEntity.setDescription("Test Description");		
		ing.setDescription("Sample example");
		ing.setAmount(new BigDecimal(4));
		ing.setUom(this.uomEntity);
		ingSet = new ArrayList<Ingredient>();
		catSet = new HashSet<Category>();
		ingSet.add(this.ing);
		catSet.add(this.catEntity);
		
		
	}

	
	@Test
	public void testRecipe() {
	
		recipe.setCookTime(20);
		recipe.setDescription("Demo Description");
		recipe.setDirections("Example Direction");
		recipe.setName("Sample Recipe");
		recipe.setPrepTime(40);
		recipe.setServings(2);
		recipe.setSource("Example Source");
		recipe.setUrl("wwww.example.com");
		recipe.setRecipeNotes(this.notes);
		recipe.setCategories(this.catSet);
		recipe.setIngredients(this.ingSet);
		recipe.setDifficulty(diff.EASY);
		recipeService.save(this.recipe);
	
		
		
		List<Recipe> returnedRecipeList = new ArrayList<Recipe>();
		returnedRecipeList = recipeService.findAll();
		Recipe returnedRecipe = new Recipe();
		for(Recipe rec : returnedRecipeList) {
			
			if(rec.getDescription().equals(recipe.getDescription()))
			{
				
				returnedRecipe = rec;
				
			}
		}
		
		List<Ingredient> listIngredient = new ArrayList<Ingredient>(recipe.getIngredients());
		listIngredient = this.SortIngredientList(listIngredient);
		
		List<Category> listCategory = new ArrayList<Category>(recipe.getCategories());
		listCategory = this.SortListCategory(listCategory);		
		
		List<Ingredient> returnedlistIngredient = new ArrayList<Ingredient>(returnedRecipe.getIngredients());
		returnedlistIngredient = this.SortIngredientList(returnedlistIngredient);
		
		List<Category> returnedlistCategory = new ArrayList<Category>(returnedRecipe.getCategories());
		returnedlistCategory = this.SortListCategory(returnedlistCategory);
		
		assertEquals(returnedRecipe.getId(), recipe.getId());		
		assertTrue(this.compareCategoryList(listCategory, returnedlistCategory));
		assertTrue(this.compareIngredientsList(listIngredient, returnedlistIngredient));
		assertEquals(returnedRecipe.getCookTime(), recipe.getCookTime());
		assertEquals(returnedRecipe.getDescription(), recipe.getDescription());
		assertEquals(returnedRecipe.getDifficulty(), recipe.getDifficulty());
		assertEquals(returnedRecipe.getDirections(), recipe.getDirections());
		assertEquals(returnedRecipe.getName(), recipe.getName());
		assertEquals(returnedRecipe.getPrepTime(), recipe.getPrepTime());
		assertEquals(returnedRecipe.getRecipeNotes().getRecipeNotes(), recipe.getRecipeNotes().getRecipeNotes());
		assertEquals(returnedRecipe.getServings(), recipe.getServings());
		assertEquals(returnedRecipe.getSource(), recipe.getSource());
		assertEquals(returnedRecipe.getUrl(), recipe.getUrl());
		
		
		
	}
	
	// Function to apply Bubble sort for sorting elements of List
		public List<Category> SortListCategory(List<Category> catList2bsorted) {
			List<Category> resultList1 = catList2bsorted;
				Category temp1 = new Category() ;
				Category temp2 = new Category() ;
				for(int i=0;i<catList2bsorted.size()-1;i++) {
					
					for(int m=catList2bsorted.size()-1;m<catList2bsorted.size()-i;m--) {
						if (resultList1.get(i).getId() > resultList1.get(i+1).getId()) {
							temp1= resultList1.get(i);
							temp2= resultList1.get(i+1);
							resultList1.remove(i);
							resultList1.add(i, temp2);
							resultList1.remove(i+1);
							resultList1.add(i+1, temp1);
						}
						
					}
		
			}		
			return resultList1;
			
		}
	
		
		public List<Ingredient> SortIngredientList(List<Ingredient> list2bSorted){
			Ingredient temp1 = new Ingredient();
			Ingredient temp2 = new Ingredient();		
			for(int i=0;i<list2bSorted.size()-1;i++) {
				for(int m=list2bSorted.size()-1;m<list2bSorted.size()-i;m--) {
					if(list2bSorted.get(i).getId() < list2bSorted.get(i+1).getId()) {
						temp1 = list2bSorted.get(i);
						temp2 = list2bSorted.get(i+1);
						list2bSorted.remove(i);
						list2bSorted.add(i, temp2);
						list2bSorted.remove(i+1);
						list2bSorted.add(i+1, temp1);
					}
				}	
			}		
			return list2bSorted;
		}
		
		
		//compare Ingredient List
		public boolean compareIngredientsList(List<Ingredient> l1, List<Ingredient> l2 ) {
			// Recipe needs to have Ingredients
			if(l1 == null && l2!=null || l1!=null && l2==null){
				
				return false;
			}
			
			
			for (int i =0; i<l1.size(); i++) {
				
				if(l1.get(i).getDescription()!= l2.get(i).getDescription()) {
					
					return false;
				}
				
	
			}
			

			return true;
			
			
		}
		
		//compare Category List
		public boolean compareCategoryList (List<Category> l1, List<Category>l2) {
			// Recipe can be without category
			if(l1 == null && l2 == null) {
				return true;
				
			}
			if(l1 == null && l2!=null || l1!=null && l2==null){
				
				return false;
			}
	for (int i =0; i<l1.size(); i++) {
				
				if(l1.get(i).getDescription()!= l2.get(i).getDescription()) {
					
					return false;
				}
				
	
			}
			

			return true;
			
			
			
		}
		
		
		
		
		
		
	

}
