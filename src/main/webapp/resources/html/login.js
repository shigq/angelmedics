//$(document).ready(function(){
//	
//	
//	  $("#login").click(function(){
//		  var url = "/j_spring_security_check";  
//		    var username= $("input[name='j_username']").val();  
//		    var password= $("input[name='j_password']").val();  
//		    $.ajax({  
//		        url:url,  
//		        type:"POST",  
//		        data:"j_username="+username+"&j_password="+password,  
//		        success: function(data){  
//		            $("#results").text(data);  
//		             window.location.href="/resources/html/userHome.html"; 
//		        }  
//		    }); 
//	  });
//	  
//	  
//	});

$(document).ready(function(){

	  $('#captchaImage').click(function () {//生成验证码  
		  getCaptchaImage();
	    });  
	
/*	  $("#login").click(function(){
		  var url = "/j_spring_security_check";  
		    var username= $("input[name='j_username']").val();  
		    var password= $("input[name='j_password']").val();  
		    var captchaCode=$("#captcha").val();
		    $.ajax({  
		        url:url,  
		        type:"POST",  
		        data:"j_username="+username+"&j_password="+password+"&captchaCode="+captchaCode,  
		        success: function(response)  {

		            if(response != null && response.success == true) {
		            	 window.location.href="/resources/html/userHome.html"; 
		            } else {
		                // response is JSON version of the Spring's Authentication
		               // alert("authentication success");
		            	$("#results").text(response.message);
		            	getCaptchaImage();
		            }
		        },
		        error: function(response)  { 
		        	$("#results").text(response.message);
		        	getCaptchaImage();
		        }
		    });
		    
		    }); */
	  });
function login(){
	  var url = "../../j_spring_security_check";  
	    var username= $("input[name='j_username']").val();  
	    var password= $("input[name='j_password']").val();  
	    var captchaCode=$("#captcha").val();
	    $.ajax({  
	        url:url,  
	        type:"POST",  
	        data:"j_username="+username+"&j_password="+password+"&captchaCode="+captchaCode,  
	        success: function(response)  {

	            if(response != null && response.success == true) {
	            	 window.location.href="../../resources/html/1.html"; 
	            } else {
	                // response is JSON version of the Spring's Authentication
	               // alert("authentication success");
	            	$("#results").text(response.message);
	            	getCaptchaImage();
	            }
	        },
	        error: function(response)  { 
	        	$("#results").text(response.message);
	        	getCaptchaImage();
	        }
	    });
}
function getCaptchaImage()
{
	 $('#captchaImage').hide().attr('src', '../../captcha/image.do?' + Math.floor(Math.random()*100) ).fadeIn();  
     event.cancelBubble=true;  
}
	  