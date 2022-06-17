package com.insa.test.service;

import java.util.List;
import java.util.Map;

import com.insa.test.domain.Insa;
import com.insa.test.domain.InsaCom;

public interface InsaService {

	// public List <Insa> insaList();
	public  Map <String, Object> insaList (int pageNum);
	
	public void insertInsa (Insa insa);
	
	public Insa detailInsa (int sabun);
	
	public void updateInsa(Insa insa);
	
	public void deleteInsa(int sabun);
	// 직급 불러오기 
	public String getGbnName(int sabun);
	
	public abstract List <Insa> searchList (Insa insa) ;
	// 공통코드 테이블  
	public List< InsaCom> mTypeList();
	
	public List< InsaCom> milLevelList();
	
	public List< InsaCom> posGbnCodeList();
	
	public List <InsaCom> deptCodeList();
	
	public List <InsaCom> joinGbnCodeList();
	
	public List <InsaCom> joinTypeList();
	
	public List <InsaCom> gartLevelList();
	
	public List <InsaCom> kosaClassCodeList();
	
	public abstract int  maxSabunNumber();
	
	public abstract int countSabun(int sabun);

	public abstract String getGbnName();
	
}
