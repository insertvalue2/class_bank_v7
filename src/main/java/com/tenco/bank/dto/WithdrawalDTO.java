package com.tenco.bank.dto;

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
public class WithdrawalDTO {
	
	private Long amount;
	private String wAccountNumber; 
	private String wAccountPassword; 
}








