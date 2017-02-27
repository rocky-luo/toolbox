package com.rocky.toolbox.web;

/**
 * Created by rocky on 17/2/23.
 */
public class SuccessResult extends DataResult{

    private SuccessResult() {
    }

    SuccessResult(Object data) {
        super(200, data, "操作成功");
    }

}
