package com.agp.cloud.controller;

import com.agp.cloud.constant.Constants;
import com.agp.cloud.entity.RepCsBankDaifu;
import com.agp.cloud.entity.Result;
import com.agp.cloud.service.DaifuService;
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
@RequestMapping("/com/jffox/ai/queryDaifu")
public class DaifuController {
    @Autowired
    DaifuService daifuService;
    @GetMapping
    public Result batchGetQuery(@RequestParam String appIds){
        if (StringUtils.isNotEmpty(appIds)){
            try{
                String[] split = appIds.split(Constants.COMMA);
                List<String> list = Arrays.asList(split);
                List<RepCsBankDaifu> repCsBankDaifus = daifuService.queryList(list);
                Result successInstance = Result.getSuccessInstance();
                successInstance.setData(repCsBankDaifus);
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
              List<RepCsBankDaifu> repCsBankDaifus = daifuService.queryList(list);
              Result successInstance = Result.getSuccessInstance();
              successInstance.setData(repCsBankDaifus);
              return successInstance;
          }catch (Exception e){
              log.info(e.getMessage());
              e.printStackTrace();
              return Result.INTERNAL_EXCEPTION;
          }
        }
        return Result.PARAMETER_ISNULL;
    }

}
