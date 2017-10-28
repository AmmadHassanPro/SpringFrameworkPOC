package Recipe.JpaHibernateDemo.Commands;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import Recipe.JpaHibernateDemo.Entities.Recipe;
// A Command Object for Category Entity
public class CategoryCommand {
	    private Long id;
	    private String description;  
	    public Long getId() {

	        return id;

	    }
	    public void setId(Long id) {

	        this.id = id;

	    }

	    public String getDescription() {

	        return description;

	    }

	    public void setDescription(String description) {

	        this.description = description;

	    }


	
	
}
