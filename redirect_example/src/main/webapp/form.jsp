<html>
    <body>
        <h1>Form Page</h1>
        <form action="/redirect_example/form/result" method="GET">
            Input String: <input name="example" type="text" size="30" /><br>
            <input type="submit" value="Submit" />
        </form>
        <%@ page import = "java.util.*" %>
        <%
            String example = request.getParameter("example");
            if (example != null) {
                out.println("Example: " + example);
            }
        %>
    </body>
</html>