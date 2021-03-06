package Recipe.JpaHibernateDemo.Commands;

import java.math.BigDecimal;
//A Command Object for Ingredient Entity
public class IngredientCommand {
	private Long id;
	private String description;
	private BigDecimal amount;
	private UnitOfMeasureCommand uom;
	public Long getId() {
		return id;
	}
	public UnitOfMeasureCommand getUom() {
		return uom;
	}
	public void setUom(UnitOfMeasureCommand uom) {
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
	

}
