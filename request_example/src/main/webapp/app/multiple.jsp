<html><h1> <%@ page import = "java.util.*" %>
    <%
        Object result = request.getAttribute("result");
        if (result != null) {
            out.println("Result: " + result.toString());
        }
    %></h1>
    <%= request.getContextPath() %>
<form action="/request_example/sample_hidden" method="GET">
    <input type="hidden" name="uname" value=<%= result.toString() %>>
    <input type="hidden" name="user_access" value="administrator">
    <input type="submit">Submit</input>
</form>
</html>