function deletelist(n,n1,n2){
	let ok = confirm('정말 삭제 하시겠습니까?');
	
	if(ok){
		location.href='leaderdeleteC?a_id='+n+'&a_name='+n1+'&a_no='+n2;
	}
}

function agree(n,n1,n2){
	let ok = confirm('수락 하시겠습니까?');
	
	if(ok){
		location.href='leaderagreeC?a_id='+n+'&a_name='+n1+'&a_no='+n2;
	}
}