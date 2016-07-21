/**
 * 
 */

 $(document).ready(function(){
	 $( "#accordion" ).accordion();
	
	 var rem = 450;
	 $("#text").html(rem + " characters remaining");	
	 $("#review").keyup(function() {
		 var rem = 450 - $("#post").val().length;
		 $("#text").html(rem + " characters remaining");
	 });
	/* $('#loginS').click(function (event) {
		 var idPost = $(this).attr('id');
		 var id = idPost.substring(4);
		 alert(id);
		 var dataString ='idRest='+ id;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "StudentHome",
             data: dataString,
             success: function(data){
                 window.location = 'http://localhost:8080/HUbanweb/studentHome.jsp';
               }                
			  });	 
	 
	 });*/
	 
}); 

