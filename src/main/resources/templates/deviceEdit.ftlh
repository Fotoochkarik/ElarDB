<#import "parts/common.ftl" as c>

<@c.page>
Device editor

<form action="/device" method="post">

    <input type="text" name="comments0" projects.get(0L) placeholder="1" />
    <input type="hidden" value="${device.id}" name="deviceId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>

    <input type="text" name="comments1" projects.get(1L) placeholder="2"/>
    <input type="hidden" value="${device.id}" name="deviceId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>

    <input type="text" name="comments2" projects.get(2L) placeholder="3"/>


<input type="hidden" value="${device.id}" name="deviceId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
<button type="submit">Save</button>


</form>
</@c.page>