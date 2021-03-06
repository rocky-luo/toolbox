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
            <div class="col-md-6">
                <fieldset class="radio-container">
                    <legend style="width: auto">From</legend>
                    <div data-group="from-fields" id="from-field-container"></div>
                </fieldset>

            </div>
            <div class="col-md-6">
                <fieldset class="radio-container">
                    <legend style="width: auto">To</legend>
                    <div data-group="to-fields" id="to-field-container"></div>
                </fieldset>
            </div>
        </div>
    </div>

    <table id="pair-container" class="table table-striped table-hover ">
        <thead>
        <tr>
            <th>No.</th>
            <th>From Field</th>
            <th>To Field</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

    <div class="row">
        <div class="col-md-10" id="pair-container">
        </div>
    </div>

    <div class="row form-group">
        <label class="col-md-2 control-label">展示类型</label>
        <div class="col-md-10">
            <label class="radio"><input name="code-type" type="radio" value="1" checked>direct</label>
            <label class="radio"><input name="code-type" type="radio" value="2">if not null</label>
        </div>
    </div>

    <div class="row">
        <div class="row">
            <span id="one-click-copy" class="label label-success" style="float: right" data-clipboard-target="#code-block">
            一键复制
            </span>
        </div>
        <div class="row">
            <pre id="code-block" style="margin-top: 1px"></pre>
        </div>

    </div>


</div>
</body>

<head>
    <script src="/toolbox/static/js/convert.js?19"></script>
    <script type='text/javascript' src="https://cdn.staticfile.org/clipboard.js/1.5.15/clipboard.min.js"></script>
</head>

<title>
    <link rel="stylesheet" href="/toolbox/static/css/convert.css">
</title>
