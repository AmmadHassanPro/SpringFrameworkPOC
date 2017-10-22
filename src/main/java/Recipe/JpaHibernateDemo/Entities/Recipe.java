package Recipe.JpaHibernateDemo.Entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
@Entity
@Component
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;	
		 @Enumerated(value = EnumType.STRING)
		 private Difficulty difficulty;
		 private String name;
		private String description;
		private Integer prepTime;
	 	private Integer cookTime;
		private Integer servings;
		private String source;
		private String url;
		@Lob
	    private String directions;
	    @OneToOne(cascade = CascadeType.ALL)
	    private Notes recipeNotes;
	    @Lob
	    private byte[] Image;
	    // private Byte[] Image;
		@OneToMany(cascade = CascadeType.ALL)
		@JoinTable(name="recipe_ingredients")
	    private Set<Ingredient> ingredients;
	    @ManyToMany
		@JoinTable(name = "recipe_category",joinColumns = @JoinColumn(name = "recipe_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
	    private Set<Category> categories;
	   public Set<Category> getCategories() {
			return categories;
		}
		 public Integer getCookTime() {
			return cookTime;
		}	
	    public String getDescription() {
			return description;
		}
	    public Difficulty getDifficulty() {
			return difficulty;
		}
	    
		public String getDirections() {
			return directions;
		}
		public Long getId() {
			return id;
		}
	    
	    public byte[] getImage() {
			return Image;
		}
		public Set<Ingredient> getIngredients() {
			return ingredients;
		}
	    public String getName() {
			return name;
		}
		public Integer getPrepTime() {
			return prepTime;
		}
		public Notes getRecipeNotes() {
			return recipeNotes;
		}
		public Integer getServings() {
			return servings;
		}
		public String getSource() {
			return source;
		}
		public String getUrl() {
			return url;
		}
		public void setCategories(Set<Category> categories) {
			this.categories = categories;
		}
		public void setCookTime(Integer cookTime) {
			this.cookTime = cookTime;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setDifficulty(Difficulty difficulty) {
			this.difficulty = difficulty;
		}
		public void setDirections(String directions) {
			this.directions = directions;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setImage(byte[] image) {
			Image = image;
		}
		public void setIngredients(Set<Ingredient> ingredients) {
			this.ingredients = ingredients;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setPrepTime(Integer prepTime) {
			this.prepTime = prepTime;
		}
		public void setRecipeNotes(Notes recipeNotes) {
			this.recipeNotes = recipeNotes;
		}
		public void setServings(Integer servings) {
			this.servings = servings;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public void setUrl(String url) {
			this.url = url;
		}

	    
	    
	    
	
	
}
