function check(){
	
	let name = document.apply.name;
	let age = document.apply.age;
	let gender = document.apply.gender;
	let start = document.apply.start;
	let end = document.apply.end;
	let tname = document.apply.tname;
	let img = document.apply.img;
	
	if(isEmpty(name)){
		alert('강아지 이름을 입력해주세요');
		name.value="";
		name.focus();
		
		return false;
	}
	
	if(isEmpty(age)){
		alert('나이를 입력해주세요');
		age.value="";
		age.focus();
		
		return false;
	}
	
	if(isNotNumber(age)){
		alert('숫자만 입력해주세요');
		age.value="";
		age.focus();
		
		return false;
	}
	
	if(isEmpty(start)){
		alert('시작 날짜를 선택해주세요');
		start.value="";
		start.focus();
		
		return false;
	}
	
	if(isEmpty(end)){
		alert('종료 날짜를 선택해주세요');
		end.value="";
		end.focus();
		
		return false;
	}
	
	if(isEmpty(img) || isNotType(img, "jpg") && isNotType(img, "png")){
		alert('강아지 사진(jpg, png형식)을 저장해주세요');
		img.value="";
		img.focus();
		
		return false;
	}
		
}