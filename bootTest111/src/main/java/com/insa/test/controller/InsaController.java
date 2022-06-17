package com.insa.test.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insa.test.domain.Insa;
import com.insa.test.domain.InsaCom;
import com.insa.test.service.InsaService;

@Controller
public class InsaController {
	
	
	@Autowired
	private InsaService insaService;
	
	
	
	public void setInsaService(InsaService insaService) {
		this.insaService = insaService;
	}
	
	
	
	@RequestMapping("/test")
	public String test() {
		return "index";
	}
	
	
	
	
	//main
	@RequestMapping(value="/" , method= RequestMethod.GET)
	public String main(Model model) {
		System.out.println("InsaController -- main");
		
		return "main";
	}
	
	
	// 전화면 click
	@RequestMapping(value="/back" , method=RequestMethod.GET)
	public String back() {
		System.out.println("InsaCotroller --- back ");
		return "main";
	}
	

	
	
	 //입력 click 
	 @RequestMapping(value="/insaWriteForm")
	 public String insaWriteForm(Model model, InsaCom insacom,
			   			String code, String gubun, String name, String note, 
			   			@RequestParam (value="sabun", required=false, defaultValue="1" )int sabun) {
		 System.out.println("InsaController -- insaWriteForm");
		 
		 
		 	  //List < Insa> insaList = insaService.insaList();
		 	  
		 	  int  maxSabun = insaService.maxSabunNumber();
		 	  
		 	  
			  List <InsaCom> mTList = insaService.mTypeList(); 
			  List <InsaCom> mLList = insaService.milLevelList();
			  List <InsaCom> pCodeList =insaService.posGbnCodeList();
			  List <InsaCom> dCodeList = insaService.deptCodeList(); 
			  List <InsaCom> jCodeList =insaService.joinGbnCodeList(); 
			  List <InsaCom> jList =insaService.joinTypeList(); 
			  List <InsaCom> gLList =insaService.gartLevelList(); 
			  List <InsaCom> kCodeList = insaService.kosaClassCodeList();
			  
			  
			  //Insa insa = insaService.detailInsa(sabun);
			  // model.addAttribute("sabun", insa.getSabun());
			  //System.out.println("sabun" + sabun);
			  
			//  model.addAttribute("insaList", insaList);
			  model.addAttribute("maxSabun", maxSabun );   // max(sabun) +1
			  System.out.println("InsaController --maxSabun--" + maxSabun);
			  model.addAttribute("mTList" , mTList);
			  model.addAttribute("mLList", mLList);
			  model.addAttribute("pCodeList" , pCodeList); 
			  model.addAttribute("dCodeList",dCodeList); 
			  model.addAttribute("jCodeList" , jCodeList);
			  model.addAttribute("jList" , jList); 
			  model.addAttribute("gLList", gLList);
			  model.addAttribute("kCodeList" , kCodeList);
		
		 
	      return "insaWriteForm";
	   }
	 
	   
	
	 @RequestMapping(value="/writeProcess" , method=RequestMethod.POST)
	 @ResponseBody
	 public String insertInsa(HttpServletRequest request, 
			 HttpServletResponse response,Insa insa, String email, String emailDomain,
			@RequestParam(value="sabun", required =false, 
			 								defaultValue="0") int  sabun,
			 @RequestParam(value="years1" , required =false, 
					 						defaultValue="0") int years,
			 @RequestParam(value="zip", required=false, 
					 						defaultValue="0") int zip,
			 @RequestParam(value="salary", required=false, 
					 						defaultValue="0") int salary)
						throws IOException {
		
			
		 	System.out.println("InsaController -- writeProcess");
		 	System.out.println("name :"  + insa.getName());
		 	System.out.println("MaxSabun : " + insaService.maxSabunNumber());
		 	System.out.println("regNo : " + insa.getRegNo());
		 	System.out.println("year : " + insa.getYears());  
		 	System.out.println("pwd : " + insa.getPwd());
		 	System.out.println("engName :" + insa.getEngName());
				
		 	insa.setYears(years);
		 //	insa.setEmail(email + "@" + emailDomain);
		 //	System.out.println("emailDomain" + emailDomain);
		 	System.out.println("years ----" + insa.getYears());
		 	
			
			 String test1 = "";
			
		System.out.println("countSabun----before : sabun " + insa.getSabun());	 
		int testCnt = insaService.countSabun(sabun);
		System.out.println("countSabun : " + testCnt );
		
		int cnt = 0; 
		cnt =testCnt ;
		
		if(cnt <1) {
			System.out.println("insert -- sabun : " + insa.getSabun());
			
			insaService.insertInsa(insa); //insert
			
			System.out.println("cnt : insert  : " + cnt);
			test1 = "insert";
			
			System.out.println("---------------test Insert 완료");
			
		
		}else if(cnt >=1){
			
			
			System.out.println("writeProcess cnt :update  : " + cnt);
			System.out.println("update -- sabun : " + insa.getSabun());
			System.out.println("---------------test Update");
			
			insaService.updateInsa(insa); // update
			
			System.out.println("cnt :update  : " + cnt);
			System.out.println("---------------test Update 완료");
			test1="update";
		}  // writeProcess
		
		System.out.println("return : " +test1);
		 return test1;
	 	}
	
	 	
	
		
		//조회
		@RequestMapping(value="/insaList", method=RequestMethod.GET)
		//@ResponseBody
		public String insaList(Model model, 
				@RequestParam (value="pageNum", required=false, 
						defaultValue="1")int pageNum) {
			System.out.println("test - InsaController -- insaList");
			
			// service 클래스를 이용해서 게시글 리스트를 가져온다. 
			Map<String, Object> modelMap = insaService.insaList(pageNum);
			// 파라미터로 받은 모델 객체에 뷰로 보낼 모델을 저장. 
			// 모델에는 도메인객체나 비즈니스 로직을 처리한 결과를 저장.
			model.addAllAttributes(modelMap);
			
			System.out.println("modelMap :  " + modelMap);
			
			// 직급 불러오기  
			  String getGbnName = insaService.getGbnName();
			// 공통코드 불러오기
			  List <InsaCom> pCodeList =insaService.posGbnCodeList();
			  List <InsaCom> jCodeList =insaService.joinGbnCodeList(); 
			  List <InsaCom> jList =insaService.joinTypeList(); 
			 
			  // model 에 담아서 뿌리기 
			  model.addAttribute("getGbnName" , getGbnName);
			  model.addAttribute("pCodeList" , pCodeList); 
			  model.addAttribute("jCodeList" , jCodeList);
			  model.addAttribute("jList" , jList); 
			  
			
			  
			  System.out.println("InsaController -- insaList End");
			  
			//List<Insa> iList = insaService.insaList();
			
			//model.addAttribute("iList", iList);
			// System.out.println(iList);
			
			// **  직위를 번호가 아닌 대표 차장 부장 과장 대리 사원으로 뽑아 오기.
			
			return "insaList";
		} // insaList
		
		
		
		// 검색 조회하기 
		@RequestMapping(value = "/searchList" , method=RequestMethod.POST)
		public String searchList (Insa insa) {
			 
			 return "insaList";
		 }
		
		
		 // 상세보기
		 @RequestMapping(value="/insaDetail", method=RequestMethod.GET)
		public String detailInsa(Model model, int sabun,
				@RequestParam(value="pageNum" , required =false, 
										defaultValue="1")int pageNum) {
			 System.out.println("InsaController -- insaDetail");
			 
			 
			  List <InsaCom> mTList = insaService.mTypeList(); 
			  List <InsaCom> mLList = insaService.milLevelList();
			  List <InsaCom> pCodeList =insaService.posGbnCodeList();
			  List <InsaCom> dCodeList = insaService.deptCodeList(); 
			  List <InsaCom> jCodeList =insaService.joinGbnCodeList(); 
			  List <InsaCom> jList =insaService.joinTypeList(); 
			  List <InsaCom> gLList =insaService.gartLevelList(); 
			  List <InsaCom> kCodeList = insaService.kosaClassCodeList();
			  
			  
			 
			  model.addAttribute("mTList" , mTList);
			  model.addAttribute("mLList", mLList);
			  model.addAttribute("pCodeList" , pCodeList); 
			  model.addAttribute("dCodeList",dCodeList); 
			  model.addAttribute("jCodeList" , jCodeList);
			  model.addAttribute("jList" , jList); 
			  model.addAttribute("gLList", gLList);
			  model.addAttribute("kCodeList" , kCodeList);
			 
			// insa.setEmail(insa.getEmail().substring());
			// ** 
			
			Insa insa =  insaService.detailInsa(sabun);
			// 이메일 id 뽑아내기 . 
			String email0 = insa.getEmail();
			String email = email0.substring(0,email0.indexOf("@"));
			System.out.println("email : "  + email);
			model.addAttribute("insa", insa);
			model.addAttribute("pageNum", pageNum);
		
			return "insaDetail";
			
		} // insaDetail

		
		 
		 
		 
		
	
	
	
	
	
}
