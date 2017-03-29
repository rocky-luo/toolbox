<body xmlns="http://www.w3.org/1999/html">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <div class="well">
                <form class="form-horizontal">
                    <fieldset>
                        <legend>From</legend>
                        <div class="form-group">
                            <label class="col-md-3 control-label">类型</label>
                            <div class="col-md-9">
                                <label class="radio"><input name="from-select-type" type="radio" value="1" checked>java</label>
                                <label class="radio"><input name="from-select-type" type="radio"
                                                            value="2">thrift</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="from-text" class="col-md-3 control-label">代码</label>
                            <div class="col-md-9">
                                <textarea class="form-control" rows="3" id="from-text"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

        <div class="col-md-6">
            <div class="well">
                <form class="form-horizontal">
                    <fieldset>
                        <legend>To</legend>
                        <div class="form-group">
                            <label class="col-md-3 control-label">类型</label>
                            <div class="col-md-9">
                                <label class="radio"><input name="to-select-type" type="radio" value="1"
                                                            checked>java</label>
                                <label class="radio"><input name="to-select-type" type="radio" value="2">thrift</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="to-text" class="col-md-3 control-label">代码</label>
                            <div class="col-md-9">
                                <textarea class="form-control" rows="3" id="to-text"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <a id="parse-bn" class="btn btn-default" role="button" style="margin-bottom: 20px">解析</a>
        </div>
    </div>
    <div class="well">
        <div class="row">
            <div class="col-md-4">
                <a class="btn btn-default" id="add-pair">添加</a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div data-group="from-fields" id="from-field-container"></div>
            </div>
            <div class="col-md-4">
                <div data-group="to-fields" id="to-field-container" ></div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-10" id="pair-container">
        </div>
    </div>

    <div class="row">
        <label class="radio"><input name="code-type" type="radio" value="1" checked>direct</label>
        <label class="radio"><input name="code-type" type="radio" value="2">if not null</label>
    </div>

    <div class="row">
                <pre id="code-block">
                </pre>
    </div>


</div>
</body>

<head>
    <script src="/toolbox/static/js/convert.js?7"></script>
</head>
