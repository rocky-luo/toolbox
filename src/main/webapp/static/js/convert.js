
$(document).ready(function(){
    bind();
});

function bind() {
    //一键复制
    var clipboard = new Clipboard('#one-click-copy');

    $("#parse-bn").click(function () {
        var strFrom = $("#from-text").val();
        var strTo =$("#to-text").val();
        var typeFrom = $('input:radio[name="from-select-type"]:checked').val();
        var typeTo = $('input:radio[name="to-select-type"]:checked').val();
        $.ajax({
            url:"/toolbox/convert/parse",
            async:false,
            data:{
                text:strFrom,
                type:typeFrom
            },
            success:function (data) {
                var fields = JSON.parse(data).data;
                genFieldsBn($("#from-field-container"), fields);
            }
        });

        $.ajax({
            url:"/toolbox/convert/parse",
            async:false,
            data:{
                text:strTo,
                type:typeTo
            },
            success:function (data) {
                var fields = JSON.parse(data).data;
                genFieldsBn($("#to-field-container"), fields);
            }
        });

        autoPair();

    });
    $("#add-pair").click(function () {
        addPair();

    });
    $('input:radio[name="code-type"]').change( function(){
        genCode();
    });

}

function genFieldsBn($container, fields) {
    $container.empty();
    for(n in fields) {
        var field = fields[n];
        addFieldBn($container, field);
    }
}

function addFieldBn($container, field) {
    var name = $container.attr("data-group");
    $radio = $('<input type="radio">')
        .val(field.name)
        .attr("data-type", field.type)
        .attr("name", name);
    $wapper = $('<label class="radio"></label>').append($radio).append(field.name);
    $container.append($wapper);
}

function addPair() {
    $fromRadio = $('input:radio[name="from-fields"]:checked');
    $toRadio = $('input:radio[name="to-fields"]:checked');
    radios2Pair($fromRadio, $toRadio);
    genCode();
}

function genCode() {
   var $pair=$("#pair-container tbody tr");
    var pairs = new Array(0);
    for (n=0; n < $pair.length; n++) {
        var $tds=$pair.eq(n).find("td");
        var source = $tds.eq(1).attr("data-name");
        var target = $tds.eq(2).attr("data-name");
        pairs.push({source:source,target:target});
    }
    $.ajax({
        url:"/toolbox/convert/gen",
        data:{
            pairs:JSON.stringify(pairs),
            type:$('input:radio[name="code-type"]:checked').val()
        },
        success:function (data) {
            var text = JSON.parse(data).data;
            $("#code-block").text(text);
        }
    });
}

function autoPair() {
    $("#pair-container tbody").empty();
    $fromRadios = $('input:radio[name="from-fields"]');
    $toRadios = $('input:radio[name="to-fields"]');
    var toMap = [];
    for (i=0; i < $toRadios.length; i++) {
        var toName = $toRadios.eq(i).val();
        toMap[toName] = $toRadios.eq(i);
    }
    for (i = 0; i < $fromRadios.length; i++) {
        var fromName = $fromRadios.eq(i).val();
        var fromType = $fromRadios.eq(i).attr("data-type");
        $to = toMap[fromName];
        if ($to != undefined) {
            var toType = $to.attr("data-type");
            if (fromType == toType) {
                radios2Pair($fromRadios.eq(i), $to);
            }
        }
    }
    genCode();
}

function radios2Pair($fromRadio, $toRadio) {
    if ($fromRadio == undefined || $toRadio == undefined) {
        return;
    }
    var fromField = {name:$fromRadio.val(),type:$fromRadio.attr("data-type")};
    var toField = {name:$toRadio.val(),type:$toRadio.attr("data-type")};
    var no=$("table tbody tr").length + 1;
    $tdNo=$("<td>"+no+"</td>");
    $tdFrom=$('<td></td>')
        .attr("data-type", fromField.type)
        .attr("data-name", fromField.name)
        .text(fromField.name);
    $tdTo=$('<td></td>')
        .attr("data-type", toField.type)
        .attr("data-name", toField.name)
        .text(toField.name);
    var colors=["info","success","danger","warning","active"];
    var color=(no-1)%colors.length;
    $tr=$('<tr></tr>')
        .addClass(colors[color])
        .append($tdNo)
        .append($tdFrom)
        .append($tdTo);
    $tr.dblclick(function () {
        addFieldBn($("#from-field-container"), fromField);
        addFieldBn($("#to-field-container"), toField);
        $(this).remove();
        refreshTable();
        genCode();
        
    });
    $("#pair-container tbody").append($tr);
    $fromRadio.parent().remove();
    $toRadio.parent().remove();
}

function refreshTable() {
    $trs=$("#pair-container tbody tr");
    for (i=0; i<$trs.length; i++) {
        $tr=$trs.eq(i);
        $tr.find("td").eq(0).text(i+1);
    }

}
