<#import "parts/common.ftl" as c>

<@c.page>
List of Devices

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Project</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list device as device>
    <tr>
        <td>${device.nameDevice}</td>
        <td><#list device.projects as project>${project.title}<#sep>, </#list></td>
        <td><a href="/device/${device.id}">edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
