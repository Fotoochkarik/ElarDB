<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User List</a> </span>
</div>

<div>
    <form method="post">

        <input type="text" name="nameDevice" placeholder="Ввведите название партии: ">
        <input type="text" name="titleProject1" placeholder="Ввведите операцию 1: ">
        <input type="text" name="titleProject2" placeholder="Ввведите операцию 2: ">
        <input type="text" name="titleProject3" placeholder="Ввведите операцию 3: ">

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>

    </form>
</div>

<div> Список партий </div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter?ifExists}" placeholder="Введите партию для поиска" >
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Найти</button>
</form>


    <ul>

        <#list device as dev>
        <li>
            <b>${dev.id}</b>
            <span>${dev.nameDevice}</span>
            <strong>${dev.nameAuthor}</strong>
            <td><#list dev.projects as project>${project.title}<#sep>, </#list></td>
        </li>
    </#list>

</ul>



</@c.page>