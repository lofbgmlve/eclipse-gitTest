package com.insa.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.insa.test.domain.Insa;
import com.insa.test.domain.InsaCom;

@Mapper
public interface InsaDao {

	//인사리스트
	public abstract List<Insa> insaList(int startRow, int endRow);
	
	// 페이징하기 위한 count 
	public abstract int getInsaCount();
	//정보입력
	public void insertInsa (Insa insa);
	//상세보기
	public Insa detailInsa (int sabun);
	//수정하기
	public void updateInsa(Insa insa);
	//삭제하기
	public void deleteInsa(int sabun);
	
	public abstract String getGbnName(int sabun);
	
	public abstract List <Insa> searchList (Insa insa) ;
	// 공통코드 테이블 
	public abstract List <InsaCom> mTypeList();
	
	public abstract List <InsaCom> milLevelList();
	
	public abstract List <InsaCom> posGbnCodeList();
	
	public abstract List <InsaCom> deptCodeList();
	
	public abstract List <InsaCom> joinGbnCodeList();
	
	public abstract List <InsaCom> joinTypeList();
	
	public abstract List <InsaCom> gartLevelList();
	
	public abstract List <InsaCom> kosaClassCodeList();

	// max+1 사번
	public abstract int maxSabunNumber();
	
	// 사번이 있는지 확인하기 위한 count 
	public abstract int countSabun(int sabun);
	
	
	
}
