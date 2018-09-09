function validateForm(){
	var catCheckBoxChilds = document.getElementById("cat").children;
	var count = catCheckBoxChilds.length;
	var ischecked=false;
	for(i=0;i<count;i++){
		if(catCheckBoxChilds[i].checked==true){
			ischecked=true;
		}
		
		
	}
	
	if(ischecked==false){
		catLabel = document.getElementById("cat_label");
		catLabel.focus();
		catLabel.scrollIntoView();
		alert("Please select at least one categry");
		
		
		return false;
	}
	else{
		return true;
	}
	
}