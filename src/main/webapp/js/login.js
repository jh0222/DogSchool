function call(){
	let id1 = document.myForm.id1;
	let password = document.myForm.password;
	let password1 = document.myForm.password1;
	let name = document.myForm.name;
	let phonesecond = document.myForm.phonesecond;
	let phonethird = document.myForm.phonethird;
	
	if (isEmpty(id1)) {
        alert('아이디를 입력해주세요.');
        id1.value = "";
        id1.focus();

        return false;
	}

	if (isEmpty(password) || lessThan(password, 3)) {
		alert('비밀번호를 입력해주세요.');
		password.value = "";
		password.focus();

		return false;
	}
	if (notEquals(password, password1)) {
		alert('비밀번호가 다릅니다.');
		password.value = "";
		password.focus();
		password1.value = "";
		password1.focus();
		return false;
	}

	if (isEmpty(name)) {
        alert('이름을 입력해주세요.');
        name.value = "";
        name.focus();

        return false;
	}
	
	if (isEmpty(phonesecond)) {
        alert('전화번호를 입력해주세요.');
        phonesecond.value = "";
        phonesecond.focus();

        return false;
	}
	
	if (isEmpty(phonethird)) {
        alert('전화번호를 입력해주세요.');
        phonethird.value = "";
        phonethird.focus();

        return false;
	}

	
	if(isNotNumber(phonesecond)){
		alert('전화번호에 숫자만 입력해주세요.');
        phonesecond.value = "";
        phonesecond.focus();

        return false;
	}
	
	if(isNotNumber(phonethird)){
		alert('전화번호에 숫자만 입력해주세요.');
        phonethird.value = "";
        phonethird.focus();

        return false;
	}
	
	if(lessThan(phonesecond,4)){
		alert('전화번호에 4자리를 입력해주세요.');
        phonesecond.value = "";
        phonesecond.focus();

        return false;
	}
	
	if(lessThan(phonethird,4)){
		alert('전화번호에 4자리를 입력해주세요.');
        phonethird.value = "";
        phonethird.focus();

        return false;
	}

	
}


function t_idcheck(){
	let id = prompt("중복 확인할 아이디");
	let regExp = /[A-Za-z0-9]/;
	
	if(id === ""){
		alert("아이디를 입력하지 않았습니다.")
	}else{
		 if (regExp.test(id) ) {
             location.href='t_idcheck?id='+id;
           } else {
             alert("한글 또는 특수문자가 있습니다.")
           }
	}
	
}

function u_idcheck(){
	let id = prompt("중복 확인할 아이디");
	let regExp = /[A-Za-z0-9]/;
		
	if(id === ""){
		alert("아이디를 입력하지 않았습니다.")
	}else{
		 if (regExp.test(id) ) {
             location.href='u_idcheck?id='+id;
           } else {
             alert("한글 또는 특수문자가 있습니다.")
           }
	}
	
}

function delete_t_mypage(id){
	let ok = confirm('정말 삭제 합니까?');
	
	if(ok){
		location.href='T_mypageDeleteC?id='+id;
	}
}

function root_deleteT(name){
	let ok = confirm('선생님 정보가 삭제 됩니다. 정말 삭제 하시겠습니다.');
	
	if(ok){
		
		location.href='T_Menu2deleteC?name='+name;
	}
}

function delete_u_mypage(id){
	let ok = confirm('정말 삭제 합니까?');
	
	if(ok){
		location.href='U_mypageDeleteC?id='+id;
	}
}


function logincall(){
	let id = document.myForm.id;
	let pw = document.myForm.pw;
	
		if (isEmpty(id)) {
        alert('아이디를 입력해주세요.');
        id.value = "";
        id.focus();

        return false;
    }

	if (isEmpty(pw)) {
        alert('비밀번호를 입력해주세요.');
        pw.value = "";
        pw.focus();

        return false;
    }
}