function resetActive(rmelem, addelem){
	rmelem.attr("class", "");
	addelem.parent().attr("class", "active");
}