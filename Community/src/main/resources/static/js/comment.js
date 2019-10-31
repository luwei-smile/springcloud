//一级回复
function comment() {
	var commentcontent = $("#comment").val();
	var articleid = $("#articleid").val();
	if (commentcontent == null) {
		alert("回复不能为空,请输入回复内容。");
		return;
	}

	$.ajax({
		method : 'post',
		url : '/send_comment',
		data : {
			"commentcontent" : commentcontent,
			"articleid" : articleid
		},
		success : function(data) {
			if (data == "success") {
				window.location.reload();
				$("#comment");
				$("#sendbutton").hide();
			} else {
				window.open("/loginpage");
				window.localStorage.setItem("code", true);
			}
		}
	})
}

// 二级回复
function secondary(e) {
	var comment_parent = e.getAttribute("data-id");
	var commentcontent = $("#secondary" + comment_parent).val();
	var articleid = $("#articleid").val();
	$.ajax({
		method : 'post',
		url : '/send_secondary_comment',
		data : {
			"commentcontent" : commentcontent,
			"comment_parent" : comment_parent,
			"articleid" : articleid
		},
		success : function(data) {
			if (data == "success") {
				window.location.reload();
			} else {
				window.open("/loginpage");
				window.localStorage.setItem("code", true);
			}
		}
	})
}

// 加载二级回复列表
function show(e) {
	var comment_parent = e.getAttribute("data-id");
	var classval = document.getElementById(comment_parent);
	var articleid = $("#articleid").val();
	$.ajax({
		method : 'post',
		url : '/secondary_comment',
		data : {
			"comment_parent" : comment_parent,
			"articleid" : articleid
		},
		success : function(data) {
			var html = "";
			$.each(data, function(key, value) {
				html += "<h4 class='secondary-body'><a href='/usercenter?user="
						+ value.commentid + "'>" + value.reader.name + ":</a>"
						+ value.commentcontent
						+ "<span class=pull-right commenticon' aria-hidden='true'>" 
						+ value.commentdata
						+ "</span><h4/>";
			})
			$("#reply" + comment_parent).html(html);
		}
	})

	if (classval.classList.contains("glyphicon-menu-right")) {
		classval.classList.remove("glyphicon-menu-right");
		classval.classList.add("glyphicon-menu-down");
	} else {
		classval.classList.remove("glyphicon-menu-down");
		classval.classList.add("glyphicon-menu-right");
	}

}

// 添加标签
function selecttags(value) {
	var pervious = $("#tag").val();
	if (pervious.indexOf(value) == -1) {
		// 点击标签进行添加
		if (!pervious) {
			pervious += value;
		} else {
			pervious += "," + value;
		}
	} else {
		// 点击已有的标签，进行删除
		pervious += ",";
		pervious = pervious.replace(value + ",", "");
	}
	// 去除标签结尾的","
	if (pervious.lastIndexOf(",") == (pervious.length - 1)) {
		pervious = pervious.substr(0, pervious.length - 1);
	}
	$("#tag").val(pervious);
}

//显示标签
function showtags(tagstype,id){
	$.ajax({
		method : 'get',
		url : '/showtags',
		data : {
			"tagstype" : tagstype
		},
		success : function(data) {
			var html = "";
			$.each(data, function(key, value) {
				var test = value.tagname
				html += "<span class='label label-info glyphicon glyphicon-tags label-tags' onclick=" + "\"selecttags('" 
					+ value.tagname + "')\"> " + value.tagname + "</span>";
			})
			document.getElementById(id).innerHTML=html;
		}
	})
}
//点赞弹窗
function popwindow(value){
	alert(value);
}