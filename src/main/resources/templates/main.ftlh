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
                <div>
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
                        <ul>Партия: ${dev.nameDevice}</ul>
                           <ul> Ответственный: ${dev.nameAuthor}
                        </ul>
                        <ul><a href="/device/${dev.id}">Добавить примечание о праделанной операции</a></ul>
                        <a href="/report/${dev.id}">Сопроводительный лист комплекта</a>
                    </div>
                            <ul class="list-group list-group-flush">
                                <#list dev.projects as project>
                                <li class="list-group-item" >${project.counter}: ${project.title}: ${project.comments?ifExists}</li>
                                </#list>
                            </ul>

        </div>

    </#list>
</div>



</@c.page>