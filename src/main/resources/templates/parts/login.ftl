<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group">
        <label for="username">Username: </label>
        <input type="text" class="form-control" id="username" name="username" aria-describedby="UsernameHelp" placeholder="Enter your Username">
        <small id="UsernameHelp" class="form-text text-muted">We'll never share your Username with anyone else.</small>
    </div>

    <div>
        <label for="password">Password: </label>
        <input type="password" class="form-control" id="password" name="password" aria-describedby="UsernameHelp" placeholder="Enter your password">
    </div>
    <#if isRegisterForm>
    <div>
        <label for="surname">Surname: </label>
        <input type="text" class="form-control" id="surname" name="surname" aria-describedby="UsernameHelp" placeholder="Enter your surname">
    </div>
    </#if>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <div class="container mt-2">

        <button type="submit" class="btn btn-primary"><#if isRegisterForm>Create<#else>Sign In</#if></button>

        <#if !isRegisterForm><a class="col-sm-6" href="/registration">Add new user</a></#if>
    </div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="col-sm-6">
    <button type="submit" class="btn btn-primary">Sign Out</button>
    </div>
</form>
</#macro>