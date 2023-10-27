<html>
    <% Cookie[] cookies = request.getCookies();%>
    <%= cookies[0].getValue() %>
    <%= cookies[1].getValue() %>
    <%= cookies[2].getValue() %>
</html>