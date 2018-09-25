function addIngredient(){
	var child= document.getElementById("IngredientsDiv").children;
	var length = document.getElementById("IngredientsDiv").children.length;
	var lastNode= child[length-1];

	var newNode = lastNode.cloneNode(true);
	var ingLabel= newNode.getElementsByClassName("description");

	ingLabel[0].innerHTML="Ingredient#"+(length+1); // label for the Ingredient

	var desc = newNode.getElementsByClassName("ing_desc");
	desc[0].setAttribute("name", "ingredients["+(length)+"].description"); 

	var amount = newNode.getElementsByClassName("ing_amount");
	amount[0].setAttribute("name", "ingredients["+(length)+"].amount"); 

	var uom = newNode.getElementsByClassName("ing_uom");
	uom[0].setAttribute("name", "ingredients["+(length)+"].uom.id"); 

	document.getElementById("IngredientsDiv").appendChild(newNode);
}

function removeIngredient(){
	var child= document.getElementById("IngredientsDiv").children;
	var length = document.getElementById("IngredientsDiv").children.length;
	var lastNode= child[length-1];
	lastNode.remove();
}