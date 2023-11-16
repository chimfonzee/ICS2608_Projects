<html>
    <form action="" method="POST">
        Input 1st Number: <input type="string" name="firstVal"><br>
        Input 2nd Number: <input type="string" name="secondVal">
        Operator: <input type="radio" name="op" value="add"> Add
        <input type="radio" name="op" value="sub"> Subtract
        <input type="radio" name="op" value="mul"> Multiply
        <input type="radio" name="op" value="div"> Divide <br>
        History: <select name="history">
            <option selected="selected" disabled="true">History</option>
            <%
            Cookie cookies[] = request.getCookies();
            int j = 0;
            for(int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("history" + j)) { %>
                    <option value=<%= cookies[i].getValue() %>><%= cookies[i].getValue() %></option>
            <%      j++;
                }
            } %>
        </select>
        <input type="submit" />
    </form>
    <%
        Object result = request.getParameter("result");
        if (result != null)
            out.println(result.toString());
    %>
</html>
