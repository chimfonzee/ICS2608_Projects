<html>
    <!-- Defaulting to GET and POST methods because DELETE is not supported by HTML -->
    <h2>Testing Cookies:</h2>
    <form action="manage_cookies" method="GET">
        Name: <input type="text" name="name"><br>
        Value: <input type="text" name="value"><br>
        <input type="submit" value="Add Cookie">
    </form>
    <form action="manage_cookies" method="POST">
        <select name="chosenCookie">
        <%
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            String value = cookies[i].getValue();
        %>
            <option value="<%= name %>"><%= name + "=" + value %></option>
        <% } %>
        </select><br>
        <input type="submit" value="Delete Cookie">
    </form>
    <a href="/home.jsp">Return</a>
</html>