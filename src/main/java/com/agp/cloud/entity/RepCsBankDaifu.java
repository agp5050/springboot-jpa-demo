package com.agp.cloud.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "rep_cs_bank_daifu")
public class RepCsBankDaifu  implements Serializable {
	@Id  // id should be added manually because script don't know which is the primary key.
	@Column(name = "app_id")
	private String appId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "trans_no")
	private String transNo;

	@Column(name = "approve_amt")
	private Double approveAmt;

	@Column(name = "contract_amt")
	private Double contractAmt;

	@Column(name = "drawn_amt")
	private Double drawnAmt;

	@Column(name = "trans_date")
	private String transDate;

	@Column(name = "business_type")
	private String businessType;

	@Column(name = "source_type")
	private String sourceType;

}
