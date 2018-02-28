package Recipe.JpaHibernateDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddNewRecipeController {
	

	@RequestMapping("/addNewRecipe")
	public String getRecipeList(Model model) {
    
		return "NewRecipe";
	}
	
	
	
	
	

}
