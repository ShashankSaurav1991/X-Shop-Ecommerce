<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Online</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
    $("#flip").click(function(){
        $("#panel").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#flip1").click(function(){
        $("#panel1").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#flip2").click(function(){
        $("#panel2").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#flip3").click(function(){
        $("#panel3").slideToggle("slow");
    });
});
</script>
<style> 
#panel,#panel1,#panel2,#panel3, #flip,#flip1,#flip2,#flip3 {
    padding: 5px;
    border: solid 1px #c3c3c3;
}

#panel,#panel1,#panel2,#panel3 {
    padding: 50px;
    display: none;
}
</style>
</head>
<body>
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
   <div class="page-title">Shopping Cart</div>
   <div class="demo-container">
   <h3>Latest Stuffs</h3>
   </div><div>
   <div id="flip">Featured Products...</div>
   <div id="panel"></div>
   </div>
   <div>
   <div id="flip1">Most Discounts..</div>
   <div id="panel1">No Products on Discount yet , check back soon for latest offers )) </div>
   </div>
   <div>
   <div id="flip2">Books to Read</div>
   <div id="panel2"></div>
   </div>
   <div>
   <div id="flip3">What others are looking for...</div>
   <div id="panel3"></div>
   </div>
   
   <jsp:include page="_footer.jsp" />
</body>
</html>