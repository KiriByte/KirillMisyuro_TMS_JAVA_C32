<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<div>
    <form action="register" method="post">

        <div>
            Name: <input type="text" name="name">${loginError}
        </div>

        <div>
            Email: <input type="email" name="email">${emailError}
        </div>

        <div>
            Age: <input type="number" name="age">${ageError}
        </div>

        <div>
            Password: <input type="password" name="password">${passwordError}
        </div>


        <input type="submit" value="Register">

    </form>
</div>
</body>
</html>
