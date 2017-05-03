<#list pairs as pair>
output.set${pair.target}(input.get${pair.source}());
</#list>