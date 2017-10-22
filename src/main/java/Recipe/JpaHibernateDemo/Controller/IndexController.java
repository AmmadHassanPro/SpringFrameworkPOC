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
    	
    	Optional<Category> cat_op = cat_repo.findByDescription("American");
    	Optional<UnitOfMeasure> uom_op = uom_repo.findByDescription("Pinch");
    	
    	System.out.println("Category ID : " +cat_op.get().getId());
    	System.out.println("Unite OF Measure ID : " +uom_op.get().getId());
    	

        return "index";

    }

}