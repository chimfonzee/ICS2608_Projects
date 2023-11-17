<%@ page import="java.util.Enumeration" %>
<html>
    <!-- Defaulting to GET and POST because of HTML limitation -->
    <h2>Hello, <%= session.getAttribute("uname").toString() %>!</h2>
    <form action="manage_session" method="GET">
        Name: <input type="text" name="name"><br>
        Value: <input type="text" name="value"><br>
        <input type="submit" value="Add Attribute">
    </form>
    <form action="manage_session" method="POST">
        <select name="chosenAttribute">
        <%
        String name;
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            name = names.nextElement();
            if (!name.equals("uname")) {
        %>
            <option value="<%= name %>"><%= name + "=" + session.getAttribute(name).toString() %></option>
        <%
            }
        }
        %>
        </select><br>
        <input type="submit" value="Delete Attribute">
    </form>
    <form action="session_logout" method="POST">
        <input type="submit" value="Logout">
    </form>
</html>