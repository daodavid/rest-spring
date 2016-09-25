$(document).ready(function() {
       
      
    
        
        $("#submit").click(function(){
      	  $("#w").append("motherfactory is best group");
      		$.ajax({
      		    url: "AutorisationApi",
      		  data: 
    		    	"<?xml version='1.0' encoding='UTF-8' standalone='yes'?>"
    		        +"<user>" +
    		        		
    		             +" <id>0</id>"
    		         +" <password>"+$("#password").val()+"</password>"
    		 
    		   +" <username>"+$("#username").val()+"</username>"
    		+"</user>"
      		    , 
      		    type: 'POST',
      		    contentType: "text/xml",
      		    dataType: "xml",
      		    success : function(data){
      		    	alert("data:"+data);
      		    },
      		    error : function (data){  
      		        alert(xhr.status);          
      		        alert(thrownError);
      		    } 
      		}); 
      });
        $.ajax({
        	  type: "GET",
        	  url: "AutorisationApi",
        	  data:{
        	      format: 'text/html'
        	   },
        	
        	  success: function(data){
        		  var m;
        		  $("#textt").val(data);
        	
        		 if("ok"==$("#textt").val()){
        			 window.location.href = "http://localhost:8088/Library/index.jsp";
        			 $("#p").text("hello"+$("#textt").val());
        			 
        		 }
        		
        	    
        		  
        	  }
        	});
});