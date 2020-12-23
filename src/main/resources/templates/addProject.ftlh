<#import "parts/common.ftl" as c>

<@c.page>

<form method="post" class="form-inline" action="/add">




    <div>
        <input type="text" class="form-control mt-1" name="titleProject" placeholder="Наименование операции: ">
        <input type="text" class="form-control mt-1" name="modeProject" placeholder="Режим: ">


        <input type="hidden" value="${device.id}" name="deviceId">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary mt-2">Добавить</button>
    </div>


</form>

</@c.page>