package com.agp.cloud.controller;

import com.agp.cloud.constant.Constants;
import com.agp.cloud.entity.RepCsBankZpHuabo;
import com.agp.cloud.entity.Result;
import com.agp.cloud.service.HuaboService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/com/jffox/ai/queryHuabo")
public class HuaboController {
    @Autowired
    HuaboService huaboService;

    @GetMapping
    public Result batchGetQuery(String appIds){
        if (StringUtils.isNotEmpty(appIds)){
            try{
                String[] split = appIds.split(Constants.COMMA);
                List<String> list = Arrays.asList(split);
                List<RepCsBankZpHuabo> repCsBankZpHuabos = huaboService.queryList(list);
                Result successInstance = Result.getSuccessInstance();
                successInstance.setData(repCsBankZpHuabos);
                return successInstance;
            }catch (Exception e){
                log.warn(e.getMessage());
                e.printStackTrace();
                return Result.INTERNAL_EXCEPTION;
            }
        }
        return Result.PARAMETER_ISNULL;
    }
    @PostMapping
    public Result batchPostQuery(@RequestBody String appIds){
        if (StringUtils.isNotEmpty(appIds)){
            try{
                JSONObject jsonObject = JSON.parseObject(appIds);
                JSONArray jsonArray = jsonObject.getJSONArray(Constants.jsonAppIds);
                List<String> list = jsonArray.toJavaList(String.class);
                List<RepCsBankZpHuabo> repCsBankZpHuabos = huaboService.queryList(list);
                Result successInstance = Result.getSuccessInstance();
                successInstance.setData(repCsBankZpHuabos);
                return successInstance;
            }catch (Exception e){
                log.warn(e.getMessage());
                e.printStackTrace();
                return Result.INTERNAL_EXCEPTION;
            }
        }
        return Result.PARAMETER_ISNULL;
    }
}
