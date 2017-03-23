<#list pairs as pair>
if (input.${pair.source} != null) output.${pair.target} = input.${pair.source};
</#list>