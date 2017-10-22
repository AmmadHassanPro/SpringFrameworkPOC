package Recipe.JpaHibernateDemo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;
@Entity
@Component
public class Notes {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public String getRecipeNotes() {
		return recipeNotes;
	}
	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToOne
    private Recipe recipe;
	@Lob
    private String recipeNotes;

}
