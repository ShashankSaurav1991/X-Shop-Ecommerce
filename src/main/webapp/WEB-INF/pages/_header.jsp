<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div class="header-container">
    <div class="site-name">X-Shopping</div>
    <div class="site-header-search"><form action="${pageContext.request.contextPath}/searchProduct"><input  class="search-product-header" type="text" name="searchTxt" placeholder="Search Product...."><button style=" height: 30px;" type="submit">Search</button></input></form>
  </div>
    <div class="header-bar">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        Welcome 
           <a href="${pageContext.request.contextPath}/accountInfo">
                ${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Logout</a>
 
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
    </div>
</div>