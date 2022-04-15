function deletenn(n1){
	let ok = confirm('알림장을 삭제 합니까?');
	
	if(ok){
		location.href='nnoteDeleteC?mp_no='+n1;
	}
}

function deletecm(n1,n2){
	let ok = confirm('댓글을 삭제 합니까?');
	
	if(ok){
		location.href='commentDeleteC?mp_no='+n1+'&c_no='+n2;
	}
}

function updatecm_u(n1,n2,t){
	let no= n1;
	let cno = n2;
	let ctxt = prompt("수정 할 댓글", t);
	

	location.href='commentUpdateC_u?mp_no='+no+'&c_no='+cno+'&c_txt='+ctxt;

}

function deletecm_u(n1,n2){
	let ok = confirm('댓글을 삭제 합니까?');
	
	if(ok){
		location.href='commentDeleteC_u?mp_no='+n1+'&c_no='+n2;
	}
}

function updatecm(n1,n2,t){
	let no= n1;
	let cno = n2;
	let ctxt = prompt("수정 할 댓글", t);
	

	location.href='commentUpdateC?mp_no='+no+'&c_no='+cno+'&c_txt='+ctxt;

}

function call() {
	let ic_txt = document.myForm.c_txt;	
	
	if (isEmpty(ic_txt)) {
		alert('댓글을 입력하세요');
		ic_txt.value = "";
		ic_txt.focus();

		return false;
	}
	
}

function call2(){
	let imp_title = document.myForm.mp_title;	
	let imp_meal = document.myForm.mp_meal;	
	let imp_defecate = document.myForm.mp_defecate;	
	
	if (isEmpty(imp_title)) {
		alert('제목을 입력하세요');
		imp_title.value = "";
		imp_title.focus();

		return false;
	}
	
	if (isEmpty(imp_meal)) {
		alert('식사횟수을 입력하세요');
		imp_meal.value = "";
		imp_meal.focus();

		return false;
	}
	
	if (isNotNumber(imp_meal)) {
		alert('숫자를 입력하세요');
		imp_meal.value = "";
		imp_meal.focus();

		return false;
	}
	
	if (isEmpty(imp_defecate)) {
		alert('배변횟수을 입력하세요');
		imp_defecate.value = "";
		imp_defecate.focus();

		return false;
	}
	
	if (isNotNumber(imp_defecate)) {
		alert('숫자를 입력하세요');
		imp_defecate.value = "";
		imp_defecate.focus();

		return false;
	}


}

function galler_updatecall(){
	let ig_title = document.myForm.g_title;
	let ig_img = document.myForm.g_img;
	
	if (isEmpty(ig_title)) {
		alert('제목을 입력하세요');
		ig_title.value = "";
		ig_title.focus();

		return false;
	}
	


	if (isEmpty(ig_img)) {
		alert('파일을 넣어주세요');
		ig_img.value = "";
		ig_img.focus();

		return false;
	}
	

}

function deletegy(n){
	let ok = confirm('이미지를 삭제 합니까?');
	
	if(ok){
		location.href='galleryDeleteC?g_no='+n;
	}
}

