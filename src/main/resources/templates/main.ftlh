<#import "parts/common.ftl" as c>


<@c.page>
<div> Список партий </div>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Введите партию для поиска" >
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <button type="submit" class="btn btn-primary ml-2">Найти</button>
        </form>
    </div>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Device
</a>

<div class="collapse  mt-3" id="collapseExample">
    <div class="form-group col-md-6">
        <form method="post" class="form-inline">

                <input type="text" class="form-control mt-1" name="nameDevice" placeholder="Название партии: ">
                <div class="mt-3">
                <input type="text" class="form-control mt-1" name="titleProject1" placeholder="Наименование операции: ">
                <input type="text" class="form-control mt-1" name="modeProject1" placeholder="Режим: ">
                </div>
                <div>
                <input type="text" class="form-control mt-1" name="titleProject2" placeholder="Наименование операции: ">
                <input type="text" class="form-control mt-1" name="modeProject2" placeholder="Режим: ">
                </div>
                <div>
                <input type="text" class="form-control mt-1" name="titleProject3" placeholder="Наименование операции: ">
                <input type="text" class="form-control mt-1" name="modeProject3" placeholder="Режим: ">

                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary mt-2">Добавить</button>
                </div>


        </form>

    </div>
</div>


<div class="card-columns">
    <#list device as dev>

        <div class="card my-3">

                    <div class="card-header">
                        <span>${dev.nameDevice}  ${dev.nameAuthor}</span>
                        <a href="/device/${dev.id}">edit</a>
                    </div>
                            <ul class="list-group list-group-flush">
                                <#list dev.projects as projects_key, project>
                                <li class="list-group-item" >${projects_key}: ${project.title}: ${project.comments?ifExists}

                                </li>

                                </#list>
                            </ul>

        </div>

    </#list>
</div>



</@c.page>