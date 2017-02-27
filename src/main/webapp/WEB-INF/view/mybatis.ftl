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
    <div class="row" style="margin: 10px">
        <div class="col-md-1">数据库:</div>
        <div class="col-md-6">
            <select id="databases">
            </select>
        </div>
    </div>
    <div class="row" style="margin: 10px">
        <div class="col-md-1">表:</div>
        <div class="col-md-6">
            <select id="tables">
            </select>
        </div>
    </div>

    <div class="row" style="margin: 10px">
        <div class="col-md-3">
            <button id="javabean-bn" class="btn btn-default">JavaBean</button>
            <button id="mapper-bn" class="btn btn-default">Mapper</button>
            <button id="dao-bn" class="btn btn-default">Dao</button>
        </div>
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
<script src="/static/js/mybatis.js"></script>
</body>
</html>