<#import "parts/common.ftl" as c>

<@c.page>
Device editor

<form action="/device" method="post">

    <#list projects as project>
    <div>
        ${project.title}
        <input type="text" name="comments" >

    </div>
</#list>
<input type="hidden" value="${device.id}" name="deviceId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
<button type="submit">Save</button>
</form>
</@c.page>