<body>
<div class="container-fluid">
    <div class="form-horizontal">
        <div class="form-group">
            <label class="col-md-2 control-label">数据库</label>
            <div class="col-md-6">
                <select id="databases" class="form-control">
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">表</label>
            <div class="col-md-6">
                <select id="tables" class="form-control">
                </select>
            </div>
        </div>
        <ul class="nav nav-tabs" id="code-type-tab">
            <li ><a id="javabean-bn" href="#" data-toggle="tab" aria-expanded="true">JavaBean</a></li>
            <li ><a id="mapper-bn" href="#" data-toggle="tab" >Mapper</a></li>
            <li ><a id="dao-bn" href="#" data-toggle="tab">Dao</a></li>
        </ul>
        <div class="col-md-12 tab-content" style="margin-top: 10px">
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
</div>
</body>
<head>
    <script src="/toolbox/static/js/mybatis.js?4"></script>
    <script type='text/javascript' src="https://cdn.staticfile.org/clipboard.js/1.5.15/clipboard.min.js"></script>
</head>
