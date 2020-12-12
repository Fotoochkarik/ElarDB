<#import "parts/common.ftl" as c>

<@c.page>
<div class="container mt-2">
    <h5>List of Devices</h5>
</div>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">Device</th>
        <th scope="col">Project</th>

    </tr>
    </thead>
    <tbody>
    <#list device as  device>
    <tr>
            <td>${device.nameDevice}  <a href="/device/${device.id}">edit</a></td>

                    <td>
                        <table class="table">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Title</th>
                                    <th>Comments</th>
                                </tr>
                                </thead>
                            <tbody>
                                <#list device.projects as projects_key, project>
                                    <tr>
                                        <td>${projects_key}</td>
                                        <td>${project.title} </td>
                                        <td>${project.comments?ifExists}</td>
                                    </tr>
                               </#list>
                            </tbody>
                        </table>
                    </td>

    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
