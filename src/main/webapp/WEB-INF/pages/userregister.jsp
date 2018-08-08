<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
   <div class="page-title">Register New User </div>
   <div class="login-container">
       <h3>Enter new user details</h3>
       <br>
       <!-- /login?error=true -->
       <c:if test="${param.error == 'true'}">
           <div style="color: red; margin: 10px 0px;">
               Registration  Failed!!!<br />
           </div>
       </c:if>
      <c:if test="${not empty message }">
     <div class="error-message">
         ${message}
     </div>
     </c:if>
      <c:if test="${not empty successmessage }">
     <div class="error-message">
         ${successmessage}
     </div>
     </c:if>
       <form method="POST"
           action="${pageContext.request.contextPath}/registerNewUser">
           <table>
               <tr>
                   <td>User Name *</td>
                   <td><input name="username" type="text"/></td>
               </tr>
 
               <tr>
                   <td>Password *</td>
                   <td><input type="password" name="password" /></td>
               </tr>
               
               <tr>
		           <td> Confirm Password:</td>
		    		   <td><input type="password" name="cpassword"  required="required"/></td>
			   </tr>
			   		<tr>
				<td colspan="2">
				<label for="captchaCode" class="prompt">Retype the characters from the picture:</label> 
				<%
					// Adding BotDetect Captcha to the page
					  Captcha captcha = Captcha.load(request, "exampleCaptcha");

					  String captchaHtml = captcha.getHtml();
					  out.write(captchaHtml);
					
				%> 
				<input id="captchaCode" type="text" name="captchaCode" required="required"/>
				</td>
			</tr>
 
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Register" /> <input type="reset"
                       value="Reset" /></td>
               </tr>
           </table>
       </form>
       <span class="error-message">${error }</span>
       	<a href="${pageContext.request.contextPath}/forgotpassword">Forgot password?</a>
	   <a href="${pageContext.request.contextPath}/register">Register User</a>
   </div>
   <jsp:include page="_footer.jsp" />
</body>
</html>