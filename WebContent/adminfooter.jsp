<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<hr/>
	<div>
		<footer>
			<p>&copy; 华南师范大学 计算机学院 软件工程09级 20092100128</p>
		</footer>
	</div>
	</div> <!-- /container -->
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/js.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		var ids = Array("#booklist","#userlist","#orderlist");
		var navbar = $("#navbar li");
		for (var i = 0,j = 0, len = navbar.length; i < len; i++) {	
			if(navbar[i].nodeType == 3){
				continue;
			}
			if($(ids[j]).length){
				navbar[i].className = "active";	
			} else {
				//navbar[i].className = "";
				navbar[i].removeAttribute("class"); 
			}
			++j;
		}
		if($("#info").length){
			$("#user")[0].className = "active";
		}
		
		$("#loginBtn").click(function(){
			$.getJSON("login",$("#loginForm").serialize(), function(result){
				switch(result.type){
				case 0:
					$("#login2 [class='icon-user']").after(result.username);
					$("#login1").css("display","none");
					$("#login2").css("display","block");
					break;
				case 1:
					window.location.href= "home";
					break;		
				default:
					$("#message span").text(result.tip);
					$("#message").css("display","block");
					break;
				}		
			});
		});
		$(".close").click(function(){
			$("#message").css("display","none");		
		});		
	});
	
	</script>
</body>
</html>