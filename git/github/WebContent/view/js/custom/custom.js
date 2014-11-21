function customView(articleId) {
	$.ajax({
		url : "custom.do?action=customView",
		dataType : "html",
		type : "post",
		data : {
			"articleId" : articleId
		},
		dataType : "json",
		success : function(result) {
			$("#customView").hide();
			$("#customView").fadeIn();
			$("#custNum").val(result.custNum);
			$("#custName").val(result.custName);
			$("#articleId").val(result.custNo);
			$("#ownerName").val(result.ownerName);
			$("#custMail").val(result.custMail);
			$("#custTel").val(result.custTel);
			$("#custFax").val(result.custFax);
			$("#custEmp1").val(result.custEmp1);
			$("#custEmp2").val(result.custEmp2);
			$("#custEmp3").val(result.custEmp3);
			$("#empTel1").val(result.empTel1);
			$("#empTel2").val(result.empTel2);
			$("#empTel3").val(result.empTel3);
			$("#addDate").val(result.addDate);
		},
		error : function(request, status, error) {
			alert("error");
		},
		complete : function() {
		}
	});
}

function retrieve1() {
	alert("조회");
}
function insert1() {
	// location.href="custom.do?action=customInsertPage";
	$("#customView").hide();
	$("#customView").fadeIn();
	$("#customView input").val("");
}

function del1() {
	if ($("#articleId").val() == "") {
		alert("삭제하실 제품을 선택해주세요.");
		return;
	}
	if (confirm("삭제 하시겠습니까?")) {
		$.ajax({
			url : "custom.do?action=customDelete",
			dataType : "html",
			type : "post",
			data : {
				"articleId" : $("#articleId").val()
			},
			success : function() {
				location.reload(true);
			},
			error : function(request, status, error) {
				alert("error");
			},
			complete : function() {
			}
		});
	}
}

function save1() {

	if ($("#articleId").val() == "") {
		if (confirm("등록 하시겠습니까?")) {
			$.ajax({
				url : "custom.do?action=customInsert",
				dataType : "html",
				type : "post",
				data : $("form[name=customViewForm]").serialize(),
				success : function() {
					location.reload(true);
				},
				error : function(request, status, error) {
					alert("error");
				},
				complete : function() {
				}
			});
		}
	} else {
		if (confirm("저장 하시겠습니까?")) {
			var articleId = $("#articleId").val();
			$.ajax({
				url : "custom.do?action=customUpdate",
				dataType : "html",
				type : "post",
				data : $("form[name=customViewForm]").serialize(),
				success : function() {
					document.location.hash = articleId;
					location.reload(true);
				},
				error : function(request, status, error) {
					alert("error"+request+", "+status+", "+error);
				},
				complete : function() {
				}
			});
		}
	}
}

function checkForHash() {
	if (document.location.hash) {
		var HashLocationName = document.location.hash;
		HashLocationName = HashLocationName.replace("#", "");
		customView(HashLocationName);
	}
}