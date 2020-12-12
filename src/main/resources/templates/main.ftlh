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
        <form method="post">

            <input type="text" class="form-control mt-1" name="nameDevice" placeholder="Ввведите название партии: ">
            <input type="text" class="form-control mt-1" name="titleProject1" placeholder="Ввведите операцию 1: ">
            <input type="text" class="form-control mt-1" name="titleProject2" placeholder="Ввведите операцию 2: ">
            <input type="text" class="form-control mt-1" name="titleProject3" placeholder="Ввведите операцию 3: ">

            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary mt-2">Добавить</button>

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
                                <#list dev.projects as project>
                                <li class="list-group-item" >${project.title}
                                    <input class="form-check-input ml-2" type="checkbox" value="isDone" id="defaultCheck1">
                                    <label class="form-check-label ml-4" for="defaultCheck1">Выполнено</label>
                                </li>

                                </#list>
                            </ul>

        </div>

    </#list>
</div>



</@c.page>