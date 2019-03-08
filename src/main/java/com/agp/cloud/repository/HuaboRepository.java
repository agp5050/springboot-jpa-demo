package com.agp.cloud.repository;

import com.agp.cloud.entity.RepCsBankZpHuabo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "rep_cs_bank_zp_huabo")
@Qualifier("huaboRepository")
public interface HuaboRepository extends JpaRepository<RepCsBankZpHuabo,String> {
}
