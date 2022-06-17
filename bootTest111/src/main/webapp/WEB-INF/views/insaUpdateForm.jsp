<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="resources/js/formCheck.js"></script>
<link type="text/css" href="resources/css/insa.css" rel="stylesheet" />
    
<article>
<form name="insaWriteForm" action="writeProcess" id="insaWriteForm"
	method="post" enctype="multipart/form-data">
	
	<table class="Insa_table">
		<tr>
			<td colspan="9">직원 등록</td>
			<td colspan="3"><input type="submit" value="저장" ></td>
			<td><input type="reset" value="신규" ></td>
			<td><input type="button" id="back" value="전화면" onclick='javascript:window.location.href="back"'></td>
		</tr>
		<tr>
			<td colspan="2" rowspan="6" ><input type="image" name="profileImage"><input type="button"  id="btnImage" value="사진올리기"></td>
			
			<td>*사번</td>
			<td>
					<input type="text" name="sabun" id="sabun" value="${maxSabun}" readonly/>	
			</td>
			<td>*한글성명</td>
			<td><input type="text"  name="name" id="name" maxlength="10"></td>
			<td>영문성명</td>
			<td><input type="text"  name="engName" id="engName" maxlength="10"></td>
		</tr>
		<tr>
			<td>*아이디</td>
			<td><input type="text" name="id" id="id"></td>
			<td>*패스워드</td>
			<td><input type="password"  name="pwd" id="pwd1"></td>
			<td>*패스워드확인</td>
			<td><input type="password"   id="pwd2"></td>
		</tr>
		<tr>
			<td>전화번호</td> 
			<td><input type="text"  id="phone" name="phone"></td>
			<td>*핸드폰번호</td>
			<td><input type="text"  name="hp" id="hp"></td>
			<td>주민번호</td>
			<td><input type="text"  name="regNo" id="regNo"></td>
		</tr>
		<tr>
			<td>연령</td>
			<td><input type="text"  name="years" id="years"></td>
			<td>*이메일</td>
			<td><input type="text" name="email" id="email" maxlength="15" width="10px;">
			<input type="text" name="emailDomain" id="emailDomain">
		
			<select name="selectDomain" id="selectDomain">
				<option>직접입력</option>
				<option>네이버</option>
				<option>다음</option>
				<option>지메일</option>
			</select></td>
			<td>직종체크</td>
			<td>
			<select id="joinGbnCode" name="joinGbnCode"> 
					<option value="">선택해주세요</option>
				<c:forEach var="jbn" items="${jCodeList }">
					<option value="${jbn.code}">${jbn.name }</option>
				</c:forEach>
			</select>
			성별
			<select  name="sex">
				<option value="">선택해주세요</option>
				<option>여자</option>
				<option>남자</option>
			</select></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="zip" id="zip">
			<input type="button" id="btnZipFind" value="주소검색"></td>
			<td ><input type="text"  name="addr1" id="addr1"></td>
			<td ><input type="text"  name="addr2" id="addr2"></td>
		</tr>	
		<tr>
			<td>직위</td>
			<td>
				<select name="posGbnCode">
						<option value="">선택해주세요</option>
					<c:forEach var="p" items="${pCodeList }">
						<option value="${p.code}">${p.name }</option>
					</c:forEach>
				</select>
			</td>
			<td>부서</td>
			<td>
				<select name="deptCode">
						<option value="">선택해주세요</option>
					<c:forEach var ="d" items="${dCodeList}">
						<option value="${d.code }">${ d.name}</option>
					</c:forEach>
				</select>
			</td>
			<td>연봉(만원)</td>
			<td><input type="text"  name="salary" id="salary" dir="rtl"></td>
		</tr>
		<tr>
			<td>입사구분</td>
			<td>
				<select name="joinType">
						<option value="">선택해주세요</option>
					<c:forEach var="j" items="${jList }">
						<option value="${ j.code}">${j.name }</option>
					</c:forEach>
				</select>
			</td>
			<td>등급</td>
			<td >
				<select  name="gartLevel">
						<option value="">선택해주세요</option>
					<c:forEach var="g" items="${gLList }">
						<option value="${g.code }">${g.name }</option>
					</c:forEach>
				</select>
			</td>
			<td>투입여부</td>
			<td >
				<select  name="putYn">
				<option value="">선택해주세요</option>
				<option>투입</option>
				<option>미투입</option>
				</select>
			</td>
			<td>군필여부</td>
			<td >
				<select name="milYn">
				<option value="">선택해주세요</option>
				<option>군필</option>
				<option>미필</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>군별</td>
			<td>
				<select  name="milType">
						<option value="">선택해주세요</option>
					<c:forEach var="milT" items="${mTList }">
						<option value="${milT.code }">${milT.name }</option>
					</c:forEach>
				</select>
			</td>
			<td>계급</td>
			<td>
				<select  name="milLevel"> 
						<option value="">선택해주세요</option>
					<c:forEach var="milL" items="${mLList }">
						<option value="${milL.code }">${milL.name }</option>
					</c:forEach>
				</select>
			</td>
			<td>입영일자</td>
			<td><input type="text" name="milStartdate" id="milStartdate"></td>
			<td>전역일자</td>
			<td><input type="text" name="milEnddate" id="milEnddate"></td>
		</tr>
		<tr>
			<td>KOSA등록</td>
			<td>
				<select  name="kosaRegYn" >
					
					<option>미등록</option>
					<option>등록</option>
				</select>	
			</td>
			<td>KOSA계급</td>
			<td>
				<select  name="kosaClassCode">
						<option value="">선택해주세요</option>
					<c:forEach var="k" items="${kCodeList }">
						<option value="${k.code }">${k.name }</option>
					</c:forEach>
				</select>
			</td>
			<td>*입사일자</td>
			<td><input type="text" name="joinDay" id="joinDay"></td>
			<td>전역일자</td>
			<td><input type="text" name="retireDay" id="retireDay"></td>
		</tr>
		<tr>
			<td>사업자번호</td>
			<td><input type="text" name="cmpRegNo"></td>
			<td>업체명</td>
			<td><input type="text" name="crmName"></td>
			<td>사업자등록증</td>
			<td><input type="text" name="cmpRegImage"></td>
			<td><input type="button" value="미리보기">&nbsp;&nbsp;&nbsp;<input type="button" value="등록"></td>
		</tr>
		<tr>
			<td >자기소개</td>
			<td colspan="2"><textarea  name="selfIntro"></textarea></td>
			<td>이력서</td>
			<td><input type="text" name="carrier"></td>
			<td><input type="button" value="미리보기">&nbsp;&nbsp;&nbsp;<input type="button" value="등록"></td>
		</tr>
	</table>
</form>
</article>