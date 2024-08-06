<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="${pageContext.request.contextPath}/calculate" method="post">
    <label>Number 1:</label>
    <input type="number" name="num1" step="any" required/>
    <label>Operation:</label>
    <select name="operation">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <label>Number 2:</label>
    <input type="number" name="num2" step="any" required/>
    <button type="submit">Calculate</button>
</form>

<c:if test="${not empty result}">
    <div>
        <p>Result: ${result}</p>
    </div>
</c:if>
</body>
</html>