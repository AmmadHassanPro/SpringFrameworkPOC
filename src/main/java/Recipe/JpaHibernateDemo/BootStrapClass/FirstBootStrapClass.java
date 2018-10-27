package Recipe.JpaHibernateDemo.BootStrapClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernatDemo.Utilities.ImageConverter;
import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Entities.Difficulty;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
import Recipe.JpaHibernateDemo.Entities.Notes;
import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
import Recipe.JpaHibernateDemo.Repository.RecipeRepository;
import Recipe.JpaHibernateDemo.Service.CategoryService;
import Recipe.JpaHibernateDemo.Service.UnitOfMeasureService;
@Component
public class FirstBootStrapClass implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private Recipe generalRecipe;
	@Autowired
	private Category generalCat;
	@Autowired
	private Ingredient generalIngredient;
	@Autowired
	private Notes generalNotes;
	@Autowired
	private UnitOfMeasure generalUnitofMeasure;

	private Difficulty generalDifficulty;
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private UnitOfMeasureService uomService;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	private ImageConverter byteArrayConverter = new ImageConverter();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		this.init();
		
		
	}
	
	public void initialization() {
		this.generalRecipe = new Recipe();
		this.generalCat = new Category();
		this.generalIngredient = new Ingredient ();
		this.generalNotes = new Notes();
		this.generalUnitofMeasure = new UnitOfMeasure();
	
		
	}
	public void init() {
		
		System.setProperty("http.agent", "Chrome");
		//Guacamole recipe
		generalRecipe.setName("Perfect Guacamole");
		generalRecipe.setCookTime(10);
		generalRecipe.setPrepTime(5);
		
		generalRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/print/");
		generalRecipe.setSource("http://www.simplyrecipes.com");
		generalRecipe.setServings(3);
		generalRecipe.setDescription("The BEST guacamole! So easy to make with ripe avocados, salt, serrano chiles, cilantro and lime. Garnish with red radishes or jicama. Serve with tortilla chips.");
		generalRecipe.setDirections("<b>1</b> Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.<br>" + 
				 
				"<b>2</b> Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)<br>" + 
				 
				"<b>3</b> Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.<br>" + 
				 
				"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.<br>" + 
				 
				"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.<br>" + 
				 
				"<b>4</b> Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.<br>" + 
				 
				"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.<br>" + 
				 
				"<h2>Variations</h2>" + 
				"<br>" + 
				"For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.<br>" + 
				 
				"Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.<br>" + 
				 
				"The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.<br>" + 
				 
				"To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
		
		generalNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
		generalNotes.setRecipe(generalRecipe);
		generalRecipe.setRecipeNotes(generalNotes);
		generalCat = catService.findByDescription("American");
		List<Category> catList = new ArrayList<>();
		catList.add(generalCat);	
		generalRecipe.setCategories(catList);
		Set<Recipe> recipeSet = new HashSet<>();		
		recipeSet.add(generalRecipe);
		generalRecipe.setDifficulty(generalDifficulty.EASY);
		
		//Adding Ingredients
		List<Ingredient> ingredientsList = new ArrayList<>();
		// Ingredient 1
		generalIngredient.setDescription("ripe avocados");
		generalIngredient.setAmount(new BigDecimal("2.00"));
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 2
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Kosher salt");
		generalIngredient.setAmount(new BigDecimal("0.5"));
		generalIngredient.setRecipes(generalRecipe);
		generalUnitofMeasure = uomService.findByDescription("Teaspoon");
		generalIngredient.setUom(generalUnitofMeasure);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 3
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("fresh lime juice or lemon juice");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 4
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("minced red onion or thinly sliced green onion");
		generalIngredient.setAmount(new BigDecimal("2.0"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 5
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("serrano chiles, stems and seeds removed, minced");
		generalIngredient.setAmount(new BigDecimal("2.0"));
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 6
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("cilantro (leaves and tender stems), finely chopped");
		generalIngredient.setAmount(new BigDecimal("2.0"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 7
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("freshly grated black pepper");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Dash");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 8
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("ripe tomato, seeds and pulp removed, chopped");
		generalIngredient.setAmount(new BigDecimal("0.5"));
		generalUnitofMeasure = uomService.findByDescription("Dash");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		generalRecipe.setIngredients(ingredientsList);
		
		generalRecipe.setImage(byteArrayConverter.ConvertToByteArray("http://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-horiz-a-1600.jpg"));
		recipeRepo.save(generalRecipe);
		
		
		
		//Spicy Grilled Chicken Tacos recipe
		
		initialization();//Initializing all the variables
		generalRecipe.setName("Spicy Grilled Chicken Tacos");
		generalRecipe.setCookTime(15);
		generalRecipe.setPrepTime(20);
		generalRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/print/");
		generalRecipe.setSource("http://www.simplyrecipes.com");
		generalRecipe.setServings(5);
		generalRecipe.setDescription("\r\n" + 
				"Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.\r\n" + 
				"");
		generalRecipe.setDirections("<b>1</b> Prepare a gas or charcoal grill for medium-high, direct heat.<br>" + 
				
				"<b>2</b> Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.<br>" + 
				
				"Set aside to marinate while the grill heats and you prepare the rest of the toppings.<br>" + 
				 
				"<b>3</b> Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.<br>" + 
				
				"<b>4</b> Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.<br>" + 
				
				"Wrap warmed tortillas in a tea towel to keep them warm until serving.<br>" + 
				 
				"<b>5</b> Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
		
		generalNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.");
		generalNotes.setRecipe(generalRecipe);
		generalRecipe.setRecipeNotes(generalNotes);
		generalCat = catService.findByDescription("Mexican");
		catList = new ArrayList<>();
		catList.add(generalCat);	
		generalRecipe.setCategories(catList);
		recipeSet = new HashSet<>();		
		recipeSet.add(generalRecipe);
		generalRecipe.setDifficulty(generalDifficulty.MODERATE);


		//Adding Ingredients
		ingredientsList = new ArrayList<>();
		// Ingredient 1
		generalIngredient.setDescription("ancho chili powder");
		generalIngredient.setAmount(new BigDecimal("2.00"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 2
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("dried oregano");
		generalIngredient.setAmount(new BigDecimal("1"));
		generalIngredient.setRecipes(generalRecipe);
		generalUnitofMeasure = uomService.findByDescription("Teaspoon");
		generalIngredient.setUom(generalUnitofMeasure);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 3
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("dried cumin");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 4
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("sugar");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Teaspoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 5
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("salt");
		generalIngredient.setAmount(new BigDecimal("0.5"));
		generalUnitofMeasure = uomService.findByDescription("Teaspoon");
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 6
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("garlic, finely chopped");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Clove");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 7
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("finely grated orange zest");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 8
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("fresh-squeezed orange juice");
		generalIngredient.setAmount(new BigDecimal("3"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);

		//Ingredient 9
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("olive oil");
		generalIngredient.setAmount(new BigDecimal("2"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 10
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("skinless, boneless chicken thighs (1 1/4 pounds)");
		generalIngredient.setAmount(new BigDecimal("5"));
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 11
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("corn tortillas");
		generalIngredient.setAmount(new BigDecimal("8"));
		generalUnitofMeasure = uomService.findByDescription("Small");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 12
		generalIngredient=new Ingredient();
		generalIngredient.setDescription(" packed baby arugula (3 ounces)");
		generalIngredient.setAmount(new BigDecimal("3"));
		generalUnitofMeasure = uomService.findByDescription("Cup");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 13
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("ripe avocados, sliced");
		generalIngredient.setAmount(new BigDecimal("2"));
		generalUnitofMeasure = uomService.findByDescription("Medium");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);

		//Ingredient 14
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("radishes, thinly sliced");
		generalIngredient.setAmount(new BigDecimal("4"));
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 13
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("cherry tomatoes, halved");
		generalIngredient.setAmount(new BigDecimal("0.5"));
		generalUnitofMeasure = uomService.findByDescription("Pint");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 14
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("red onion, thinly sliced");
		generalIngredient.setAmount(new BigDecimal("0.25"));
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 15
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Roughly chopped cilantro");
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 16
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("cup sour cream thinned with 1/4 cup milk");
		generalIngredient.setAmount(new BigDecimal("0.5"));
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 17
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("lime, cut into wedges");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		generalRecipe.setIngredients(ingredientsList);
		generalRecipe.setImage(byteArrayConverter.ConvertToByteArray("http://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-2.jpg"));
		recipeRepo.save(generalRecipe);		
		
		
		initialization();
		
		
		
		generalRecipe.setName("Healthy roast chicken");
		generalRecipe.setCookTime(15);
		generalRecipe.setPrepTime(20);
		generalRecipe.setUrl("https://www.kidspot.com.au/kitchen/recipes/healthy-roast-chicken-1661");
		generalRecipe.setSource("https://www.kidspot.com.au/");
		generalRecipe.setServings(5);
		generalRecipe.setDescription("\r\n" + 
				"This healthy roast chicken is stuffed with sage and lemon stuffing and cooked in an oven bag to keep it moist. Pop it in the oven with the vegies to roast for a healthy meal.\r\n" + 
			
				"");
		generalRecipe.setDirections("<b>1</b> Preheat oven to 180°C.<br>" + 
				
				"<b>2</b> Fill the chicken with the stuffing.<br>" + 
				 
				 
				"<b>3</b> Spray chicken with canola spray and sprinkle with all-purpose seasoning.<br>" + 
				
				"<b>4</b> Place inside an oven bag and add the flour to the bag.<br>" +  
				 
				"<b>5</b> Seal the bag and shake and rotate it to coat the chicken in the flour." +
				"<b>6</b> Place on a baking tray and pierce 2-3 small holes on top near the tie.\r\n" 
		+ "<b>7</b> Cook for 22 minutes per 500g of chicken, which is about 1 hour and 15 minutes for this chicken."
				);
		
		generalNotes.setRecipeNotes("A good way to test if a chicken is done is to pierce the thickest part of the thigh with a skewer to see if the juices are clear which means it is cooked.");
		generalNotes.setRecipe(generalRecipe);
		generalRecipe.setRecipeNotes(generalNotes);
		generalCat = catService.findByDescription("Fast Food");
		catList = new ArrayList<>();
		catList.add(generalCat);	
		generalRecipe.setCategories(catList);
		recipeSet = new HashSet<>();		
		recipeSet.add(generalRecipe);
		generalRecipe.setDifficulty(generalDifficulty.MODERATE);


		//Adding Ingredients
		ingredientsList = new ArrayList<>();
		// Ingredient 1
		generalIngredient.setDescription("Chicken Meat");
		generalIngredient.setAmount(new BigDecimal("1.00"));
		generalUnitofMeasure = uomService.findByDescription("Unit");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 2
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Sage Stuffing");
		generalIngredient.setAmount(new BigDecimal("1"));
		generalIngredient.setRecipes(generalRecipe);
		generalUnitofMeasure = uomService.findByDescription("Unit");
		generalIngredient.setUom(generalUnitofMeasure);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 3
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Flour");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 4
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Lemon Stuffing");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Unit");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 5
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Canola Spray");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Unit");
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		
		
		generalRecipe.setIngredients(ingredientsList);
		generalRecipe.setImage(byteArrayConverter.ConvertToByteArray("https://static.kidspot.com.au/recipe_asset/572/3239.jpg-20150309012046~q75,dx720y432u1r1gg,c--.jpg"));
		recipeRepo.save(generalRecipe);	
		
		
		
		initialization();
		
		
		generalRecipe.setName("One Pot Thai-Style Rice Noodles");
		generalRecipe.setCookTime(15);
		generalRecipe.setPrepTime(20);
		generalRecipe.setUrl("https://www.allrecipes.com/recipe/232279/one-pot-thai-style-rice-noodles/?internalSource=staff%20pick&referringId=1947&referringContentType=Recipe%20Hub");
		generalRecipe.setSource("www.allrecipes.com/");
		generalRecipe.setServings(5);
		generalRecipe.setDescription("\r\n" + 
				"Chicken, vegetables, and noodles prepared in a light tasting but full-flavored Asian-inspired sauce");
		generalRecipe.setDirections("<b>1</b> Stir cornstarch and water together in a small bowl until smooth. Pour chicken broth into a large pot and stir cornstarch mixture, soy sauce, fish sauce, rice vinegar, chile-garlic sauce, vegetable oil, ginger, garlic, and coriander into broth. Cover and bring to a boil.<br>" + 
				
				"<b>2</b> Place rice noodles in the boiling sauce, reduce heat to medium, and simmer until noodles are tender, 5 to 10 minutes. Stir zucchini, red bell pepper, and chicken into sauce. Bring back to a boil, cover, and simmer until vegetables are just become tender, about 5 more minutes.<br>" + 
				 
				 
				"<b>3</b> Remove from heat and let stand, covered, for 5 minutes to thicken. Serve garnished with crushed peanuts and cilantro.<br>" );
		
		generalNotes.setRecipeNotes("I often use frozen mixed vegetables in a pinch for an even quicker meal.");
		generalNotes.setRecipe(generalRecipe);
		generalRecipe.setRecipeNotes(generalNotes);
		generalCat = catService.findByDescription("Fast Food");
		catList = new ArrayList<>();
		catList.add(generalCat);	
		generalCat = catService.findByDescription("American");
		catList.add(generalCat);	
		generalRecipe.setCategories(catList);
		recipeSet = new HashSet<>();		
		recipeSet.add(generalRecipe);
		generalRecipe.setDifficulty(generalDifficulty.MODERATE);


		//Adding Ingredients
		ingredientsList = new ArrayList<>();
		// Ingredient 1
		generalIngredient.setDescription("Chicken Meat");
		generalIngredient.setAmount(new BigDecimal("1.00"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 2
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Sage Stuffing");
		generalIngredient.setAmount(new BigDecimal("1"));
		generalIngredient.setRecipes(generalRecipe);
		generalUnitofMeasure = uomService.findByDescription("Unit");
		generalIngredient.setUom(generalUnitofMeasure);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 3
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Flour");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Tablespoon");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 4
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Lemon Stuffing");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Unit");
		generalIngredient.setUom(generalUnitofMeasure);
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		//Ingredient 5
		generalIngredient=new Ingredient();
		generalIngredient.setDescription("Canola Spray");
		generalIngredient.setAmount(new BigDecimal("1.0"));
		generalUnitofMeasure = uomService.findByDescription("Unit");
		generalIngredient.setRecipes(generalRecipe);
		ingredientsList.add(generalIngredient);
		
		
		
		generalRecipe.setIngredients(ingredientsList);
		generalRecipe.setImage(byteArrayConverter.ConvertToByteArray("https://images.media-allrecipes.com/userphotos/560x315/2458255.jpg"));
		recipeRepo.save(generalRecipe);	
		
		
	}

	
	
	

}
