<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>
  <div id="w">
  
  
  </div>
	<form>
		<table id="r">
			<tr>
				<td>username</td>
				<td><input id="username" type="text"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" id="password"></td>
			</tr>
			<tr>
				<td><select id="town">
						<option value="Smolian">Smolian</option>
						<option value="Sofia">Sofia</option>
						<option value="Varna">Varna</option>
						<option value="Plovdiv">Plovdiv</option>
				</select></td>
			</tr>
			<tr>
				<td><input id="gender" type="radio" name="gender" value="male">
					Male<br> <input type="radio" name="gender" id="gender" value="female" >
					Female<br></td>
			</tr>
        
		</table>
       <button value="submit"  id="submit">submit</button>
       <button value="change" id="b">change </button>
	</form>
</body>
</html>