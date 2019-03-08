package com.agp.cloud.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "rep_cs_bank_zp_huabo")
public class RepCsBankZpHuabo  implements Serializable {
	@Id // id should be added manually because script don't know which is the primary key.
	@Column(name = "app_id")
	private String appId;

	@Column(name = "serial_no")
	private String serialNo;

	@Column(name = "approve_amt")
	private Double approveAmt;

	@Column(name = "contract_amt")
	private Double contractAmt;

	@Column(name = "drawn_amt")
	private Double drawnAmt;

	@Column(name = "trans_time")
	private String transTime;

	@Column(name = "transin_account_name")
	private String transinAccountName;

	@Column(name = "transout_account_name")
	private String transoutAccountName;

	@Column(name = "trade_type")
	private String tradeType;

	@Column(name = "source_type")
	private String sourceType;

}
