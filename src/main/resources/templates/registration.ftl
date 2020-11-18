<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<p>Add new user</p>
${message!}
<@l.login "/registration" />
</@c.page>
