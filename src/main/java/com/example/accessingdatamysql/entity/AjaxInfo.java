package com.example.accessingdatamysql.entity;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class AjaxInfo {
    public AjaxInfo(){

    }
    public AjaxInfo(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    private Integer code=0;

    private String msg="操作成功";

    private Object data;







}