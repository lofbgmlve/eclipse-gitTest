package com.insa.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insa.test.dao.InsaDao;
import com.insa.test.domain.Insa;
import com.insa.test.domain.InsaCom;

@Service
public  class InsaServiceImpl implements InsaService{

	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 5;
	
	@Autowired
	private InsaDao insaDao;
	
	
	public void setInsaDao(InsaDao insaDao) {
		this.insaDao = insaDao;
	}

	
	
	//1리스트 뽑기 - 2 페이징 하기 
	@Override
	public Map<String, Object> insaList(int pageNum) {
		
		int currentPage = pageNum;
		System.out.println("currentPage: "+currentPage);
		
		int startRow = (currentPage -1) * PAGE_SIZE;
		System.out.println("InsaServiceImpl startRow : " + startRow);
		
		int listCount = insaDao.getInsaCount();
		System.out.println("InsaServiceImpl -- listCount : " + listCount);
		
		List <Insa> insaList = insaDao.insaList(startRow, PAGE_SIZE);
		// ??? insaList.size ? ???  왜 이러는거야 ???
		System.out.println("InsaServiceImpl -- insaList.size: " +insaList.size());
		
		// pase size로 나눈 - 페이지 그룹 처리를 위해 - 전체 페이지 수 구하기
		int pageCount = 
				listCount /PAGE_SIZE +(listCount % PAGE_SIZE ==0 ? 0 : 1);
		System.out.println("InsaServiceImpl -- pageCount : " + pageCount);
		// 다음 click 시 시작되는 페이지번호 구하기  - 페이지 그룹 
		// currentPage = 11 이라면   OK
		//     = 1*(10+1)  - (0) = 11 
		int startPage = 
				(currentPage/PAGE_GROUP) * PAGE_GROUP +1
				-(currentPage % PAGE_GROUP == 0 ? PAGE_GROUP :0);
		System.out.println("InsaServiceImpl -- startPage  : "+startPage);
		
		// 11 + 10  - 1 = 20 
		// 페이지 그룹의 마지막 페이지가 몇 페이지인지 
		int endPage= startPage + PAGE_GROUP -1;
		System.out.println("InsaServiceImpl -- endPage  : " + endPage);
		
		if(endPage > pageCount) {
			endPage = pageCount;
			System.out.println("InsaServiceImpl -- endPage 2 : " + endPage);
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("insaList", insaList);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("listCount", listCount);
		modelMap.put("pageGroup", PAGE_GROUP);
		
		return modelMap;
		
		
	}

	
	@Override
	public void insertInsa(Insa insa) {
		System.out.println("InsaServiceImpl -- insertInsa");
		insaDao.insertInsa(insa);
	}

	 // 직급 불러오기 
	@Override
	public String getGbnName(int sabun) {
		System.out.println("InsaServiceImpl -- getGbnName" );
		return insaDao.getGbnName(sabun);
	}

	@Override
	public Insa detailInsa(int sabun) {	
		System.out.println("InsaServiceImpl -- detailInsa");
		
		return insaDao.detailInsa(sabun);
	}

	@Override
	public void updateInsa(Insa insa) {
		System.out.println("InsaServiceImpl -- updateInsa");
		insaDao.updateInsa(insa);
		System.out.println("sabun -- "+ insa.getSabun());
		System.out.println("name --" + insa.getName());
		
	}

	@Override
	public void deleteInsa(int sabun) {
		System.out.println("InsaServiceImpl -- updateInsa");
		insaDao.deleteInsa(sabun);
		
	}
	

	@Override
	public List<Insa> searchList(Insa insa) {
			System.out.println("InsaServiceImpl -- searchList ");
		return insaDao.searchList(insa);
	}
	
	// 공통코드 테이블 
	
	public List<InsaCom> mTypeList() {
		
		return insaDao.mTypeList();
	}

	
	public List < InsaCom> milLevelList(){
		
		return insaDao.milLevelList();
	}
	
	public List< InsaCom> posGbnCodeList(){
		return insaDao.posGbnCodeList();
	}
	
	public List< InsaCom> deptCodeList(){
		return insaDao.deptCodeList();
	}
	
	public List< InsaCom> joinGbnCodeList(){
		return insaDao.joinGbnCodeList();
	}
	
	public List<InsaCom> joinTypeList(){
		return insaDao.joinTypeList();
	}
	
	public List <InsaCom> gartLevelList(){
		return insaDao.gartLevelList();
	}
	
	public List < InsaCom> kosaClassCodeList(){
		return insaDao.kosaClassCodeList();
	}

	@Override
	public int maxSabunNumber() {
		return insaDao.maxSabunNumber();
	}
	
	@Override
	public int countSabun(int sabun) {
		System.out.println("Service -- countSabun" + sabun);
		return insaDao.countSabun(sabun);
	}



	@Override
	public String getGbnName() {
		// TODO Auto-generated method stub
		return null;
	}







	


	
	
	
}
