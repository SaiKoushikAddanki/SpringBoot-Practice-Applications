package com.koushik.batch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalesRecords {

	@Id
	private long orderID;
	private String region;
	private String country;
	private String itemType;
	private String salesChannel;
	private String orderPriority;
	private Date orderDate;
	private Date shipDate;
	private int unitsSold;
	private double unitPrice;
	private double unitCost;
	private double totalRevenue;
	private double totalCost;
	private double totalProfit; 
}
