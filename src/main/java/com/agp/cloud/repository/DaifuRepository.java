package com.agp.cloud.repository;

import com.agp.cloud.entity.RepCsBankDaifu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "rep_cs_bank_daifu")
@Qualifier("daifuRepository")
public interface DaifuRepository extends JpaRepository<RepCsBankDaifu,String> {
}
