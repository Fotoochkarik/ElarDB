<#import "parts/common.ftl" as c>

<@c.page>
<table class="table" border="2" width="100">
    <thead class="thead-light">
    <tr>
        <th>№</th>
        <th>Title</th>
        <th>Mode</th>
        <th>Comments</th>
        <th>Quantity</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <#list device.projects as project>
    <tr>
        <td>${project.counter?ifExists}</td>
        <td >${project.title?ifExists} </td>
        <td>${project.mode?ifExists} </td>
        <td>${project.comments?ifExists}</td>
        <td>${project.quantity?ifExists}</td>
        <td>${project.data?ifExists}</td>

    </tr>
    </#list>
    </tbody>
</table>

<form method="post" class="form-inline" action="/device/add">
    <div>
        Введите наименование операции:
        <input type="text" class="form-control mt-1" name="titleProject" placeholder="Наименование операции: ">
        Введите режим операции:
        <input type="text" class="form-control mt-1" name="modeProject" placeholder="Режим: ">

        <input type="hidden" value="${device.id}" name="deviceId">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary mt-2">Добавить</button>
    </div>


</form>

<body>
<button onclick="window.location.href = '/main/';">Click Here</button>
</body>

</@c.page>