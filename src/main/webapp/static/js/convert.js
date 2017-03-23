
$(document).ready(function(){
    bind();
});

function bind() {
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
        var name = $container.attr("data-group");
        $radio = $('<input type="radio">')
            .val(field.name)
            .attr("data-type", field.type)
            .attr("name", name);
        $wapper = $('<div class="row"></div>').append($radio).append(field.name);
        $container.append($wapper);
    }
}

function addPair() {
    $fromRadio = $('input:radio[name="from-fields"]:checked');
    $toRadio = $('input:radio[name="to-fields"]:checked');
    radios2Pair($fromRadio, $toRadio);
    genCode();
}

function genCode() {
    var $fromFields = $("#pair-container").find(".from-field");
    var $toFields = $("#pair-container").find(".to-field");
    var pairs = new Array(0);
    for (n=0; n < $fromFields.length; n++) {
        var source = $fromFields.eq(n).attr("data-name");
        var target = $toFields.eq(n).attr("data-name");
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
    var toField = {name:$fromRadio.val(),type:$fromRadio.attr("data-type")};
    $fromA = $('<a class="btn btn-default disabled from-field"></a>')
        .attr("data-type", fromField.type)
        .attr("data-name", fromField.name)
        .text(fromField.name);
    $toA = $('<a class="btn btn-default disabled to-field"></a>')
        .attr("data-type", toField.type)
        .attr("data-name", toField.name)
        .text(toField.name);

    $fromWapper = $("<div class='col-md-3'></div>").append($fromA);
    $toWapper = $("<div class='col-md-3'></div>").append($toA);
    $wapper = $("<div class='row'></div>").append($fromWapper).append($('<div class="col-md-3">----></div>')).append($toWapper);
    $("#pair-container").append($wapper);
    $fromRadio.parent().remove();
    $toRadio.parent().remove();
}