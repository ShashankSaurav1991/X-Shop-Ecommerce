<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<style>
*{
    box-sizing: border-box;
}

form.example input[type=text] {
    padding: 8px;
    font-size: 8px;
    border: 1px solid grey;
    width: 60%;
    background: #f1f1f1;
}

form.example button {
    float: left;
    width: 10%;
    padding: 8px;
    background: #2196F3;
    color: white;
    font-size: 8px;
    border: 1px solid grey;
    border-left: none;
    cursor: pointer;
}

form.example button:hover {
    background: #0b7dda;
}

form.example::after {
    content: "";
    clear: both;
    display: table;
}
</style>
<div class="menu-container">

  <form action="${pageContext.request.contextPath}/searchProduct"><input type="text" name="searchTxt" placeholder="Search Product...."><button type="submit">Search</button></input></form>
   <a href="${pageContext.request.contextPath}/">Home</a>
   |
   <a href="${pageContext.request.contextPath}/electronics">Electronics</a>
   |
   <a href="${pageContext.request.contextPath}/clothing">Clothing</a>
   |
   <a href="${pageContext.request.contextPath}/home">Home and Furniture</a>
   |
   <a href="${pageContext.request.contextPath}/books">Sports , Books & More...</a>
   |
   <a href="${pageContext.request.contextPath}/productList">
      Product List
   </a>
   |
   <a href="${pageContext.request.contextPath}/shoppingCart">
      My Cart
   </a>
   |
   <security:authorize  access="hasAnyRole('ROLE_MANAGER','ROLE_EMPLOYEE','ROLE_USER')">
     <a href="${pageContext.request.contextPath}/orderList">
         Order List
     </a>
     |
   </security:authorize>
   
   <security:authorize  access="hasRole('ROLE_MANAGER')">
         <a href="${pageContext.request.contextPath}/product">
                        Create Product
         </a>
         |
   </security:authorize>
  
</div>