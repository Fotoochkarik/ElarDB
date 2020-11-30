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

{#list device as device}
<div>
    <b>${device.id}</b>
    <span>${device.nameDevice}</span>
    <strong>${device.nameAuthor}</strong>
    <ul>
        {#list projects as project}
        <li>${project.title}
            ${project.status}
        </li>
        {/#list}
    </ul>
</div>
<#else>
No Device
{/#list>
</@c.page>