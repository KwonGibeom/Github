function productView(articleId){
	$.ajax({
		url : "product.do?action=productView",
		dataType : "html",
		type : "post" ,
		data : {"articleId":articleId},
		dataType : "json",
		success : function(result){
			$("#productView").hide();
			$("#productView").fadeIn();
			$("#name").val(result.name);
			$("#company").val(result.company);
			$("#articleId").val(result.id);
			$("#price").val(result.price);
		},
		error : function(request, status, error){
			alert("error");
		},
		complete:function(){
		}
	});
}

function retrieve1(){
	alert("조회");
}
function insert1(){
	//location.href="product.do?action=productInsertPage";
	$("#productView").hide();
	$("#productView").fadeIn();
	$("#productView input").val("");
}

function del1(){
	if($("#articleId").val() == ""){
		alert("삭제하실 제품을 선택해주세요.");
		return;
	}
	if(confirm("삭제 하시겠습니까?")){
		$.ajax({
			url : "product.do?action=productDelete",
			dataType : "html",
			type : "post" ,
			data : {"articleId":$("#articleId").val()},
			success : function(){
				location.reload(true);
			},
			error : function(request, status, error){
				alert("error");
			},
			complete:function(){
			}
		});
	}
}

function save1(){
	if($("#name").val().trim() == ""){
		alert("제품명을 입력해주세요.");
		return;
	}else if($("#company").val().trim() == ""){
		alert("회사명을 입력해주세요.");
		return;
	}
	
	if($("#articleId").val() == ""){
		if(confirm("등록 하시겠습니까?")){
			$.ajax({
				url : "product.do?action=productInsert",
				dataType : "html",
				type : "post" ,
				data : {
					"name":$("#name").val(),
					"company":$("#company").val(),
					"price":$("#price").val()
				},
				success : function(){
					location.reload(true);
				},
				error : function(request, status, error){
					alert("error");
				},
				complete:function(){
				}
			});
		}
	}else{
		if(confirm("저장 하시겠습니까?")){
			var articleId = $("#articleId").val();
			$.ajax({
				url : "product.do?action=productUpdate",
				dataType : "html",
				type : "post" ,
				data : {
					"articleId":$("#articleId").val(),
					"name":$("#name").val(),
					"company":$("#company").val(),
					"price":$("#price").val()
				},
				success : function(){
					document.location.hash=articleId;
					location.reload(true);
				},
				error : function(request, status, error){
					alert("error");
				},
				complete:function(){
				}
			});
		}
	}
}

function checkForHash() {
	if(document.location.hash){
		var HashLocationName = document.location.hash;
		HashLocationName = HashLocationName.replace("#","");
		productView(HashLocationName);
	}
}