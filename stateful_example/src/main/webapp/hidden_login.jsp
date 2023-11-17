<html>
    <form action="hidden_login" method="GET">
        Username: <input type="text" name="uname"><br>
        Password: <input type="password" name="pword"><br>
        <input type="hidden" value="<%= request.getAttribute("uname1").toString() %>" name="uname1">
        <input type="hidden" value="<%= request.getAttribute("pword1").toString() %>" name="pword1">
        <input type="submit" value="Login">
    </form>
</html>
