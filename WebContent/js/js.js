$(document).ready(function(){
		var ids = Array("#home","#list","#order");
		var navbar = $("#navbar li");
		for (var i = 0,j = 0, len = navbar.length; i < len; i++) {	
			if(navbar[i].nodeType == 3){
				continue;
			}
			if($(ids[j]).length){
				navbar[i].className = "active";	
			} else {
				navbar[i].removeAttribute("class"); 
			}
			++j;
		}
		if($("#info").length){
			$("#user")[0].className = "active";
		}
		
		$(".alert button").click(function(){
			this.parentNode.style.display = "none";		
		});
		
		$("#loginBtn").click(function(){
			$.post("login",$("#loginForm").serialize(), function(result){
				switch(result.type){
				case 0:
					window.location.href= "booklist";
					break;	
				case 1:		
					$("#login2 [class='icon-user']").after(result.username);
					$("#login1").css("display","none");
					$("#login2").css("display","block");
					break;
				default:
					$("#message span").text(result.tip);
					$("#message").css("display","block");
					break;
				}		
			},"json");
		});
		
		$("#regBtn").click(function(){
			$.post("regist",$("#regForm").serialize(), function(result){
				switch(result.type){
				case 0:
					$("#regmess span").text(result.tip);
					$("#regmess").css("display","block");
					break;
				case 1:
					$("#login2 [class='icon-user']").after(result.username);
					$("#login1").css("display","none");
					$("#login2").css("display","block");
					$('#reg').modal('hide');
					break;
				}		
			},"json");
		});	
		
		//更新个人信息
		$("#updateInfoBtn").click(function(){
			$.post("updateuser",$("#updateInfoForm").serialize(), function(result){
				$("#message span").text(result.tip);
				$("#message").css("display","block");
			},"json");
		});
		
		//更新密码
		$("#updatePasswordBtn").click(function(){
			$.post("updatepassword",$("#updatePasswordForm").serialize(), function(result){
				$("#message span").text(result.tip);
				$("#message").css("display","block");
			},"json");
		});
		
		//更新清单书的数量
		$("a[name='update']").click(function(){	
			var id = $(this).data("id");
			var count=$(this).prev().val();
			$.post("updatelistdetail",{"id": id,"count": count}, function(result){
				$("#message span").text(result.tip);
				$("#message").css("display","block");
			},"json");
		});
		//删除清单中的书
		$("a[name='delete']").click(function(){
			var listId = $(this).data("listid");
			var detailId =$(this).data("detailid");
			var div = $(this).parent().parent();
			var hr = div.prev();
			
			$.post("deletelistdetail",{"listId": listId,"detailId": detailId}, function(result){
				$("#message span").text(result.tip);
				$("#message").css("display","block");
				div.fadeOut();
				div.remove();
				hr.remove();
			},"json");
		});
		//添加书到清单
		$("a[name='add']").click(function(){	
			var id = $(this).data("id");
			var count=$(this).prev().val();
			$.post("createlistdetail",{"id": id,"count": count}, function(result){
				$("#message span").text(result.tip);
				$("#message").css("display","block");
			},"json");
		});
		
		$("a[name='book']").click(function(){
			var id = $(this).data("id");
			$.post("bookdetail",{"id": id}, function(result){
				$("input[name='id']").val(result.book.id);
				$("input[name='name']").val(result.book.name);
				$("input[name='author']").val(result.book.author);
				$("input[name='publish']").val(result.book.publish);
				$("input[name='publishDate']").val(result.book.publishDate);
				$("input[name='isbn']").val(result.book.isbn);
				$("textarea[name='description']").val(result.book.description);
				$("input[name='cover']").val(result.book.cover);
				$("img[name='img']")[0].src="img/"+result.book.cover;
				$("input[name='price']").val(result.book.price);
				$("#bookinfo").modal('show');
			},"json");
		});
		$('#bookinfo').on('hidden', function () {
			$("input").removeAttr("value");
			$("img[name='img']").removeAttr("src");
			$("textarea[name='description']").removeAttr("value");
		});
		
		$("a[name='user']").click(function(){
			var tds =  $(this).parent().parent().children();
			$("input[name='id']").val($(this).data("id"));
			$("input[name='username']").val(tds[1].innerHTML);
			$("input[name='email']").val(tds[2].innerHTML);
			$("select[name='role']").val($(tds[3]).data("role"));
			$("#userinfo").modal('show');	
		});
		$('#userinfo').on('hidden', function () {
			$("input").removeAttr("value");
			$("select").val(1);
		});
		
		$("a[name='addbook']").click(function(){
			$("input[name='orderId']").val($(this).data("id"));
			$("#book").modal('show');	
		});
		$('#book').on('hidden', function () {
			$("input").removeAttr("value");
		});
	});