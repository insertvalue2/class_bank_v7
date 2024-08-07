package com.tenco.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.bank.dto.SaveDTO;
import com.tenco.bank.handler.exception.DataDeliveryException;
import com.tenco.bank.handler.exception.RedirectException;
import com.tenco.bank.repository.interfaces.AccountRepository;

@Service 
public class AccountService {

	private final AccountRepository accountRepository;
	
	@Autowired // 생략 가능  - DI 처리 
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	/**
	 * 계좌 생성 기능 
	 * @param dto
	 * @param id
	 */
	// 트랜 잭션 처리 
	@Transactional
	public void createAccount(SaveDTO dto, Integer principalId) {
		int result = 0; 
		
		try {
			result = accountRepository.insert(dto.toAccount(principalId));
		} catch (DataAccessException e) {
			throw new DataDeliveryException("잘못된 요청입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			throw new RedirectException("알 수 없는 오류 입니다", HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		if(result == 0) {
			throw new DataDeliveryException("정상 처리 되지 않았습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}






