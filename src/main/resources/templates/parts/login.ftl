<#macro login path>
    <form action="${path}" method="post">
        <div><label> UserName: <input type="text" name="username"/> </label></div>
        <br>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="Sign In"/></div>
        <br>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>
