<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .highlight {
            padding: 9px 14px;
            margin-bottom: 14px;
            background-color: #f7f7f9;
            border: 1px solid #e1e1e8;
            border-radius: 4px;
        }
    </style>
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <h2>From</h2>
            </div>
            <div class="col-md-6">
                <h2>To</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <input name="from-select-type" type="radio" value="1" checked>java</input>
                <input name="from-select-type" type="radio" value="2">thrift</input>
            </div>
            <div class="col-md-6">
                <input name="to-select-type" type="radio" value="1" checked>java</input>
                <input name="to-select-type" type="radio" value="2">thrift</input>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <textarea id="from-text"></textarea>
            </div>
            <div class="col-md-6">
                <textarea id="to-text"></textarea>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <a id="parse-bn" class="btn btn-default" role="button" style="outline:none">解析</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="row">
                    <a class="btn btn-default" id="add-pair">添加</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div data-group="from-fields" id="from-field-container" style="border:1px rgba(0, 0, 0)">

                </div>
            </div>
            <div class="col-md-4">
               <div data-group="to-fields" id="to-field-container" style="border:1px solid rgba(255, 0, 0, 0)"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10" id="pair-container">
            </div>
        </div>

        <div class="row">
            <input name="code-type" type="radio" value="1" checked>direct
            <input name="code-type" type="radio" value="2">if not null
        </div>

        <div class="row">
            <div class="col-md-12">
                <figure class="highlight">
                <pre>
                    <code id="code-block">

                    </code>
                </pre>
                </figure>
            </div>
        </div>


    </div>
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/toolbox/static/js/convert.js?5"></script>
</body>
</html>