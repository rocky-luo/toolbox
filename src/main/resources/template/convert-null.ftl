<#list pairs as pair>
if (input.get${pair.source} != null) output.set${pair.target}(input.get${pair.source}());
</#list>