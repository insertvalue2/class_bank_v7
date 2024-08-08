<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- start of content.jsp(xxx.jsp)   -->
<div class="col-sm-8">
	<h2>이체 요청(인증)</h2>
	<h5>Bank App에 오신걸 환영합니다</h5>
	<form action="/account/transfer" method="post">
		<div class="form-group">
			<label for="amount">이체 금액:</label> <input type="text" name="amount" class="form-control" placeholder="Enter amount" id="amount" value="1000">
		</div>
		<div class="form-group">
			<label for="wAccountNumber">출금 계좌 번호:</label> <input type="text" name="wAccountNumber" class="form-control" placeholder="출금 계좌번호 입력" id="wAccountNumber" value="1111">
		</div>
		<div class="form-group">
			<label for="password">출금 계좌 비밀 번호:</label> <input type="password" name="password" class="form-control" placeholder="출금 계좌 비밀번호 입력" id="password" value="1234">
		</div>
		<div class="form-group">
			<label for="dAccountNumber">입금(이체) 계좌번호:</label> <input type="text" name="dAccountNumber" class="form-control" placeholder="입금 계좌번호 입력" id="dAccountNumber" value="1111">
		</div>

		<div class="text-right">
			<button type="submit" class="btn btn-primary">이체하기</button>
		</div>
	</form>
</div>
<!-- end of col-sm-8  -->
</div>
</div>
<!-- end of content.jsp(xxx.jsp)   -->

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>



