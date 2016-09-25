$(document).ready(function () {
	  $("#bay").click(function(){
	      alert($("#bay").val())
		$.ajax({
		    url: "BookApi",
		    data: 
		    	"<?xml version='1.0' encoding='UTF-8' standalone='yes'?>"
		        +"<book>" +
		        	 " <id>" +"</id>" +
		        	  "<name>"+$("#bay").val()+"</name>"
		            +"</book>"
		        
		    , 
		    type: 'PUT',
		    contentType: "text/xml",
		    dataType: "xml",
		    success : function(data){
		    	
		    },
		    error : function (data){  
		        alert(xhr.status);          
		        alert(thrownError);
		    } 
		}); 
	});
  $.ajax({
    type: "GET",
    url: "BookApi",
    dataType: "xml",
    success: function(xml) {
      $(xml).find("books").each(function () {
        $("#table").append("<tr>");
        $("#table").append("<td>" + "id=" + "</td>");
        $("#table").append("<td>" + $(this).find("id").text() + "</td>");
   
        $("#table").append("<br></tr>");    
        $("#table").append("<tr>");
        $("#table").append("<td>" + "name="+ "</td>");
        $("#table").append("<td>" + $(this).find("name").text() + "</td>");
        $("#table").append("<td>" + "<button id='bay' value="+$(this).find('name').text()+">bay</button>"+ "</td>");
      
        $("#table").append("</tr>");           
      });
    }
  });
  
  //post request add book
  $("#add").click(function(){
             alert($("#bookname").val())
  		$.ajax({
  		    url: "BookApi",
  		    data: 
  		    	"<?xml version='1.0' encoding='UTF-8' standalone='yes'?>"
  		        +"<book>" +
  		        	 " <id>" +"</id>" +
  		        	  "<name>"+$("#bookname").val()+"</name>"
  		            +"</book>"
  		        
  		    , 
  		    type: 'POST',
  		    contentType: "text/xml",
  		    dataType: "xml",
  		    success : function(data){
  		    	
  		    },
  		    error : function (data){  
  		        alert(xhr.status);          
  		        alert(thrownError);
  		    } 
  		}); 
  });

  
});