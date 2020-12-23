<#import "parts/common.ftl" as c>


<@c.page>

<div class="container mt-2">
    <div class="form-group col-md-6">
        <form method="post" class="form-inline">

            <input type="text" class="form-control mt-1" name="nameD" placeholder="Название партии: ">

            <div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mt-2"  >Добавить</button>
            </div>

        </form>


    </div>
</div>


</@c.page>