<#import "parts/common.ftl" as c>

<@c.page>
<h5>Device editor</h5>


<div>
<form action="/device" method="post">
${projects[0].title}
    <input type="text" name="comments" placeholder="Fdd"/>

    <input type="hidden" value="${device.id}" name="deviceId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
    </form>
</div>
</@c.page>