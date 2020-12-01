<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
</div>

<div>
    <form method="post">
        <input type="text" name="nameDevice" placeholder="Ввведите название партии: ">
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




        </li>
    </#list>

</ul>



</@c.page>