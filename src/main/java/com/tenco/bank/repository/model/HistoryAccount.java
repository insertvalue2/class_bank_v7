package com.tenco.bank.repository.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HistoryAccount {
	
	private Integer id; 
	private Long amount;
	private Long balance; 
	private String sender; 
	private String receiver; 
	private Timestamp createdAt;
}



