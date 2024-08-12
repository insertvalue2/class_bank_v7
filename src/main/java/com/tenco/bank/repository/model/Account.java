package com.tenco.bank.repository.model;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

import com.tenco.bank.handler.exception.DataDeliveryException;
import com.tenco.bank.utils.Define;
import com.tenco.bank.utils.ValueFormatter;

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
public class Account extends ValueFormatter {
	
	private Integer id;
	private String number;
	private String password; 
	private Long balance; 
	private Integer userId; 
	private Timestamp createdAt;
	
	// 출금 기능
	public void withdraw(Long amount) {
		// 방어적 코드 
		this.balance -= amount;
	}
	// 입금 기능 
	public void deposit(Long amount) {
		this.balance += amount;
	}
	
	// 패스워드 체크 
	public void checkPassword(String password) {
		//     f                          ==  f 일때 ---> true 
		if(this.password.equals(password) == false) {
			throw new DataDeliveryException(Define.FAIL_ACCOUNT_PASSWROD, HttpStatus.BAD_REQUEST);
		}
	}
	// 잔액 여부 확인 - checkBalance
	public void checkBalance(Long amount) {
		if(this.balance < amount) {
			throw new DataDeliveryException(Define.LACK_Of_BALANCE, HttpStatus.BAD_REQUEST);
		}
	}
	
	// 계좌 소유자 확인 기능 - checkOwner 
	public void checkOwner(Integer principalId) {
		if(this.userId != principalId) {
			throw new DataDeliveryException(Define.NOT_ACCOUNT_OWNER, HttpStatus.BAD_REQUEST);
		}
	}
	
}


