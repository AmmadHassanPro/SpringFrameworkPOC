package Recipe.JpaHibernateDemo.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
import Recipe.JpaHibernateDemo.Repository.CategoryRepository;
import Recipe.JpaHibernateDemo.Repository.UnitOfMeasureRepository;

@Controller

public class IndexController {

private CategoryRepository cat_repo;
private UnitOfMeasureRepository uom_repo;


public IndexController(CategoryRepository cat_repo,UnitOfMeasureRepository uom_repo){
	this.cat_repo = cat_repo;
	this.uom_repo = uom_repo;
	
}

    @RequestMapping({"", "/", "/index"})

    public String getIndexPage(){

    	return "redirect:/getRecipe";

    }

}