package Recipe.JpaHibernateDemo.Entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Ingredient {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long id;
private String description;
private BigDecimal amount;
@ManyToOne
private Recipe recipes;
@OneToOne (fetch = FetchType.EAGER)
private UnitOfMeasure uom;
public Long getId() {
	return id;
}
public UnitOfMeasure getUom() {
	return uom;
}
public void setUom(UnitOfMeasure uom) {
	this.uom = uom;
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
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public Recipe getRecipes() {
	return recipes;
}
public void setRecipes(Recipe recipes) {
	this.recipes = recipes;
}

}
