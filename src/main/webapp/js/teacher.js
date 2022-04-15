function deletett(n,n1,n2){
	let ok = confirm('정말 삭제 하시겠습니까?');
	
	if(ok){
		location.href='TeacherDelC?u_id='+n+'&u_name='+n1+'&t_id='+n2;
	}
}