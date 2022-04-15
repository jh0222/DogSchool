function board(){
	let title = document.myForm.title;
	let txt = document.myForm.txt;
	
	if (isEmpty(title)) {
        alert('제목을 입력해주세요.');
        title.value = "";
        title.focus();

        return false;
    }

	if (isEmpty(txt)) {
        alert('내용을 입력해주세요.');
        txt.value = "";
        txt.focus();

        return false;
    }
}

function boardupdate(n,ti,tx){
	
	let ok = confirm('정말 수정하시겠습니까?');
	
	
	if(ok){
			let form = document.createElement("form");
			form.setAttribute("charset", "UTF-8");
			form.setAttribute("method", "Post"); // Get 또는 Post 입력
			form.setAttribute("action", "Noticeboard_updateC");
			document.body.appendChild(form);
			 
			
			let in_title = document.createElement("input");
			let in_txt = document.createElement("input");
			let in_no = document.createElement("input");	
			
			in_title.setAttribute("type", "hidden");
			in_title.setAttribute("name", "title");
			in_title.setAttribute("value", ti);
			
			in_txt.setAttribute("type", "hidden");
			in_txt.setAttribute("name", "txt");
			in_txt.setAttribute("value", tx);
			
			
			in_no.setAttribute("type", "hidden");
			in_no.setAttribute("name", "no");
			in_no.setAttribute("value", n);
			
			
			form.appendChild(in_title);
			form.appendChild(in_txt);
			form.appendChild(in_no);

			form.submit();
	}
}

function nboarddelete(no){
	let ok = confirm('정말 삭제하시겠습니까?');
	
	if(ok){
		location.href='Noticeboard_deleteC?no='+no;
	}
}

function tboarddelete(no){
	let ok = confirm('정말 삭제하시겠습니까?');
	
	if(ok){
		location.href='Teacherpostscript_deleteC?no='+no;
	}
}