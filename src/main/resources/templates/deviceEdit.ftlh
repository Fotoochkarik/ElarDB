<#import "parts/common.ftl" as c>

<@c.page>
<h5>Партия: ${device.nameDevice}</h5>
<h5>Ответственный: ${device.author.username}</h5>



<form action="/device/comment" method="post">
    <table border="2">
        <thead>
        <tr>
            <th>№ </th>
            <th>The name of the operation</th>
            <th>Mode</th>
            <th>Control parameters</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${projects[0].counter}</td>
            <td>${projects[0].title}</td>
            <td>${projects[0].mode}</td>
            <td><input type="text" name="comments" placeholder="Добавь примечание о проделанной операции"/></td>
        </tr>

        </tbody>
    </table>
    <input type="hidden" value="${device.id}" name="deviceId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit" class="mt-2">Save</button>
    </form>

</@c.page>