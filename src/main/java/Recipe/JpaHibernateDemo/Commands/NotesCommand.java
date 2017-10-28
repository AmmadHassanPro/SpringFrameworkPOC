package Recipe.JpaHibernateDemo.Commands;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import Recipe.JpaHibernateDemo.Entities.Recipe;
//A Command Object for Notes Entity
public class NotesCommand {
    private Long id;
    private String recipeNotes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecipeNotes() {
		return recipeNotes;
	}
	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}

}
