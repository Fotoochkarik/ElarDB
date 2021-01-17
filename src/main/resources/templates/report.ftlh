<#import "parts/common.ftl" as c>

<@c.page>
<div class="container mt-2">
    <h6>Партия: ${device.nameDevice}</h6>
</div>
<div class="container mt-1">
    <h6>Ответственный: ${device.author.username} ${device.author.surname}</h6>
</div>

            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th>№ </th>
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
                    <td>${project.counter}</td>
                    <td>${project.title} </td>
                    <td>${project.mode?ifExists} </td>
                    <td>${project.comments?ifExists}</td>
                    <td>${project.quantity?ifExists}</td>
                    <td>${project.data?ifExists}</td>

                </tr>
                </#list>
                </tbody>
            </table>

</@c.page>