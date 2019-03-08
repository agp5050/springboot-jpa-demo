package com.agp.cloud.service;

import com.agp.cloud.entity.RepCsBankZpHuabo;
import com.agp.cloud.repository.HuaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuaboService {
    @Autowired
    HuaboRepository huaboRepository;

    public List<RepCsBankZpHuabo> queryList(List<String> list) {
        return huaboRepository.findAllById(list);
    }
}
