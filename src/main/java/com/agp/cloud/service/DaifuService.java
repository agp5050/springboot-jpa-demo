package com.agp.cloud.service;

import com.agp.cloud.entity.RepCsBankDaifu;
import com.agp.cloud.repository.DaifuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaifuService {
    @Autowired
    DaifuRepository daifuRepository;

    public List<RepCsBankDaifu>  queryList(List<String> lists) {
        List<RepCsBankDaifu> allById = daifuRepository.findAllById(lists);
        return allById;
    }
}
