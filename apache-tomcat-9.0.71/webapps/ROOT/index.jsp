<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Calculator Product</h2>
<form action="/calculator" method="GET">
    <h2>Currency Converter</h2>
    <label>Product Description: </label><br/>
    <textarea name="info" placeholder="Information"></textarea><br>
    <label>List Price: </label><br/>
    <input type="number" class="width" name="price" placeholder="List price" min="0"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="number" class="width" name="discountPercent" placeholder="xx%" min="0" max="100"/><br/>
    <input type = "submit" id = "submit" value = "Submit"/>
</form>
</body>
</html>