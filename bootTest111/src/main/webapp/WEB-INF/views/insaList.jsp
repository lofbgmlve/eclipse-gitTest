<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/formCheck.js"></script>
<link type="text/css" href="resources/css/insa.css" rel="stylesheet" />

<article class="insaListForm">
<h2>직원 상세 정보</h2>
<form name="searchForm" id="searchForm"  >
	<table>
		<tr>
			<td>사번</td>
			<td><input type="text" id="sabun"></td>
			<td>성명</td>
			<td><input type="text" id="name"></td>
			<td>입사구분</td>
			<td>
				<select name="joinType" id="joinType">
						<option value="">선택해주세요</option>
					<c:forEach var="join" items="${jList }">
						<option value="${ join.code}">${join.name }</option>
					</c:forEach>
				</select>	
			</td>
			<td>투입여부</td>
			<td>
				<select  name="putYn" id="putYn">
					<option value="">선택해주세요</option>
					<option>투입</option>
					<option>미투입</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>직위</td>
			<td>
				<select  name="posGbnCode" id="posGbnCode">
						<option value="">선택해주세요</option>
					<c:forEach var="g" items="${getGbnName }">
						<option value="${g.pos_gbn_name }">${g.pos_gbn_name }</option>
					</c:forEach>
				</select>
			</td>
			<td>입사일자</td>
			<td><input type="text" id="joinDay"></td>
			<td>퇴사일자</td>
			<td><input type="text"  id="retireDay"></td>
			<td>직종분류</td>
			<td>
				<select id="joinGbnCode" name="joinGbnCode"> 
					<option value="">선택해주세요</option>
				<c:forEach var="jbn" items="${jCodeList }">
					<option value="${jbn.code}">${jbn.name }</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td><input type="button" id="search" value="검색"></td>
			<td><input type="reset" value="초기화"></td>
			<td><input type="button" value="이전" onclick="location.href='main';"></td>	
		</tr>
		<tr>
			<td>사번</td>
			<td>성명</td>
			<td>주민번호</td>
			<td>핸드폰 번호</td>
			<td>직위</td>
			<td>입사일자</td>
			<td>퇴사일자</td>
			<td>투입여부</td>
			<td>연봉(만원)</td>
		</tr>
		<c:if test="${not empty insaList }">
		<c:forEach var = "i" items="${insaList }" varStatus="status">
			<tr>
				<td>${i.sabun}</td>
				<td> <a href="insaDetail?sabun=${i.sabun}">${i.name} </a> </td>
				<td>${i.regNo}</td>
				<td>${i.hp}</td>
				<td>${i.posGbnCode}</td> <!-- 직위 -->
				<td>${i.joinDay}</td>
				<td>${i.retireDay}</td>
				<td>${i.putYn}</td>
				<td>${i.salary}</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="9" class="listPage">
					<c:if test="${startPage > pageGroup}">
						<a href="insaList?pageNum=${startPage-pageGroup }">이전</a>
					</c:if>
					<c:forEach var= "i" begin = "${startPage }" end="${endPage }">
						<c:if test="${i==currentPage }">
							${i }
						</c:if>
						<c:if test="${i != currentPage }">
							<a href="insaList?pageNum=${i}">${i}</a>
						</c:if>
					</c:forEach>
						<c:if test="${endPage <pageCount }">
							<a href="insaList?pageNum=${startPage + pageGroup }">다음</a>
						</c:if>
					</td>
				</tr>
		</c:if>
			<c:if test="${empty insaList }">
				<tr>
					<td colspan="12" >사원이 존재하지 않습니다.</td>
				</tr>
			</c:if>
	</table>
</form>
</article>