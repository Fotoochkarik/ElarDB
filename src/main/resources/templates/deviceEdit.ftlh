<#import "parts/common.ftl" as c>

<@c.page>
Device editor

<form action="/device" method="post">

    <#list projects as projects_key, project>
    <div>
        ${project.title}
        <#if !project.status>
        <input type="text" name="comments" placeholder="Fdd"/>
        </#if>
    </div>
</#list>





<input type="hidden" value="${device.id}" name="deviceId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
<button type="submit">Save</button>


</form>
</@c.page>