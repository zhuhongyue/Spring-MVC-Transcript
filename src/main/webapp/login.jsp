<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
    <h3>登陆界面</h3>
    <form name='f'
        action='${pageContext.request.contextPath}/j_spring_security_check'
        method='POST'>
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type='text' name='j_username'
                    value='demo'>(账户：demo)</td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type='password' name='j_password'
                    value="demo" />(密码：demo)</td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                    value="登录" /></td>
            </tr>
        </table>
    </form>
</body>
</html>