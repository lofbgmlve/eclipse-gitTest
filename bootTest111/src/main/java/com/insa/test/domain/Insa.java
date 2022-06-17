package com.insa.test.domain;

import org.apache.ibatis.type.Alias;

@Alias("Insa")  // 매퍼에서 TypeAlias 지정하지 않으면 쓸 수 있는 것 . 
public class Insa {
	private int sabun; 	// 사번
	private String joinDay; 	// 입사일
	private String retireDay; 	// 퇴사일
	private String putYn; 	// 투입여부
	private String name; 	// 이름 
	private String regNo; 	// 주민번호
	private String engName;		//영어이름
	private String phone;	// 전화번호
	private String hp;		// 핸드폰
	private String carrier;	// 이력서
	private String posGbnCode;	// 직위구분코드
	private String cmpRegNo;	// 사업자등록번호
	private String cmpRegImage;			// 사업자등록증
	private String sex;	// 성별
	private int years;		// 나이
	private String email;		// 이메일
	private int zip;		// 우편번호
	private String addr1;		//주소1
	private String addr2;		//주소2
	private String deptCode;		// 부서코드
	private String joinGbnCode;		// 직종
	private String id;		//아이디
	private String pwd;		//비밀번호
	private int salary;			//연봉
	private String kosaRegYn;		//KOSA 등록
	private String kosaClassCode;		//KOSA 등급
	private String milYn;	//입대여부
	private String milType;		//군별
	private String milLevel;	//계급
	private String milStartdate;		//입영일자
	private String milEnddate;	//전역일자
	private String joinType;	//입사구분
	private String gartLevel;	// 등급
	private String selfIntro;	//자기소개
	private String crmName;		//업체
	private String profileImage; 		// 프로필사진
	private String carrierImage;		// 이력서이미지
	

    public Insa() {}
    
    // public Insa(int startRow, int endRow) {}
    
    public Insa(int sabun, String joinDay, String retireDay, String putYn, String name, String regNo, String engName, String phone,
          String hp, String carrier, String posGbnCode, String cmpRegNo, String cmpRegImage, String sex, int years, String email,
           int zip, String addr1, String addr2, String deptCode, String joinGbnCode, String id, String pwd, int salary, String kosaRegYn,
           String kosaClassCode, String milYn, String milType, String milLevel, String milStartdate, String milEnddate,String joinType, String gartLevel,
           String selfIntro, String crmName, String profileImage, String carrierImage) {
       this.sabun = sabun;
       this.joinDay = joinDay;
       this.retireDay = retireDay;
       this.putYn = putYn;
       this.name = name;
       this.regNo = regNo;
       this.engName = engName;
       this.phone = phone;
       this.hp = hp;
       this.carrier = carrier;
       this.posGbnCode = posGbnCode;
       this.cmpRegNo = cmpRegNo;
       this.cmpRegImage = cmpRegImage;
       this.sex = sex;
       this.years = years;
       this.email = email;
       this.zip = zip;
       this.addr1 = addr1;
       this.addr2 = addr2;
       this.deptCode = deptCode;
       this.joinGbnCode = joinGbnCode;
       this.id = id;
       this.pwd = pwd;
       this.salary = salary;
       this.kosaRegYn = kosaRegYn;
       this.kosaClassCode = kosaClassCode;
       this.milYn = milYn;
       this.milType = milType;
       this.milLevel =milLevel;
       this.milStartdate = milStartdate;
       this.milEnddate = milEnddate;
       this.joinType = joinType;
       this.gartLevel = gartLevel;
       this.selfIntro = selfIntro;
       this.crmName = crmName;
       this.profileImage  = profileImage;
       this.carrierImage = carrierImage;
    }
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getJoinDay() {
		return joinDay;
	}
	public void setJoinDay(String joinDay) {
		this.joinDay = joinDay;
	}
	public String getRetireDay() {
		return retireDay;
	}
	public void setRetireDay(String retireDay) {
		this.retireDay = retireDay;
	}
	public String getPutYn() {
		return putYn;
	}
	public void setPutYn(String putYn) {
		this.putYn = putYn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getPosGbnCode() {
		return posGbnCode;
	}
	public void setPosGbnCode(String posGbnCode) {
		this.posGbnCode = posGbnCode;
	}
	public String getCmpRegNo() {
		return cmpRegNo;
	}
	public void setCmpRegNo(String cmpRegNo) {
		this.cmpRegNo = cmpRegNo;
	}
	public String getCmpRegImage() {
		return cmpRegImage;
	}
	public void setCmpRegImage(String cmpRegImage) {
		this.cmpRegImage = cmpRegImage;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getJoinGbnCode() {
		return joinGbnCode;
	}
	public void setJoinGbnCode(String joinGbnCode) {
		this.joinGbnCode = joinGbnCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getKosaRegYn() {
		return kosaRegYn;
	}
	public void setKosaRegYn(String kosaRegYn) {
		this.kosaRegYn = kosaRegYn;
	}
	public String getKosaClassCode() {
		return kosaClassCode;
	}
	public void setKosaClassCode(String kosaClassCode) {
		this.kosaClassCode = kosaClassCode;
	}
	public String getMilYn() {
		return milYn;
	}
	public void setMilYn(String milYn) {
		this.milYn = milYn;
	}
	public String getMilType() {
		return milType;
	}
	public void setMilType(String milType) {
		this.milType = milType;
	}
	public String getMilLevel() {
		return milLevel;
	}
	public void setMilLevel(String milLevel) {
		this.milLevel = milLevel;
	}
	public String getMilStartdate() {
		return milStartdate;
	}
	public void setMilStartdate(String milStartdate) {
		this.milStartdate = milStartdate;
	}
	public String getMilEnddate() {
		return milEnddate;
	}
	public void setMilEnddate(String milEnddate) {
		this.milEnddate = milEnddate;
	}
	public String getJoinType() {
		return joinType;
	}
	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}
	public String getGartLevel() {
		return gartLevel;
	}
	public void setGartLevel(String gartLevel) {
		this.gartLevel = gartLevel;
	}
	public String getSelfIntro() {
		return selfIntro;
	}
	public void setSelfIntro(String selfIntro) {
		this.selfIntro = selfIntro;
	}
	public String getCrmName() {
		return crmName;
	}
	public void setCrmName(String crmName) {
		this.crmName = crmName;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getCarrierImage() {
		return carrierImage;
	}
	public void setCarrierImage(String carrierImage) {
		this.carrierImage = carrierImage;
	}
    
    
}
