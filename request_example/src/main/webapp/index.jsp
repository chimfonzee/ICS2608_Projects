<html>
<body>
<h2>Hello World!</h2>
<form action="/request_example/handle" method="GET">
    <input name="exampleString" type="text" />
    <input type="submit" value="Submit" />
</form>

<form action="/request_example/app/handle_parameters" method="GET">
    <input name="checkbox1" type="checkbox" value="checkbox1" />
    <input name="checkbox2" type="checkbox" value="checkbox2" />
    <input name="checkbox3" type="checkbox" value="checkbox3" />
    <input type="submit" value="Submit" />
</form>

<form action="/request_example/cookie_example" method="GET">
    <input type="text" name="anotherString0"/>
    <input type="text" name="anotherString1"/>
    <input type="text" name="anotherString2"/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
