now = new Date()
hour = now.getHours()
if(hour<6){
	gesture ="凌晨好!"
}else if(hour<9){
	gesture = "早上好!"
}else if(hour<12){
	gesture="上午好！"
}else if(hour<14){
	gesture="中午好！"
}else if(hour<17){
	gesture="下午好！"
}else if(hour<19){
	gesture="傍晚好！"
}else{
	gesture="晚上好！"
}