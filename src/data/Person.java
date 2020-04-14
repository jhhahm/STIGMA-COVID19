package data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Person {	// 사람 객체 정보
/* 고정 정보 : 성별, 나이, 주거 지역, 주거 형태, 직업(다른 이와 접촉 경향), 교통편 및 이동시간, 기저질환(0~7) 및 사망률 영향(3), 신체적 접촉(0~7), 얼굴을 만지는 경향(0~7), 손을 닦는 경향(0~7), 마스크 착용 경향(0~7)
 * 변동 정보 : 참여한 모임, 이동경로 위치(x,y), 감염 상태(M-수동면역자 30%, S-감염가능자, I-감염자, E-보균자, R-회복자, D-사망자), 감염 시점, 전염 가능 시점, 병원에 격리된 시점, Mobility(0-자가격리~7)
 * 
 * 교통편 및 이동시간은 여러 사람이 모이므로 모임으로 가정
 * 
 * 1시간 기준
 * 감염률 : 일반인 2%, 기저질환자 10%
 * 사망률 : 기저질환자 5%
 * 전파율 : 일반인 2%, 슈퍼전파자 10% */
	
	private String P_name;	// 사람 이름
	private String P_sex;	// 생물학적 성별
	private int P_age;	// 나이

	private String P_residentialArea;	// 주거 지역
	private String P_residentialForm;	// 주거 형태
	
	private String P_job;	// 직업
	private int P_jobContactRate;	// 직업으로 인한 접촉율

	private String P_underlyingDisease;	// 기저질환
	private int P_tendencyToPhysicalContact;	// 신체적 접촉 경향(0~7). 낮을 수록 감염률 감소
	private int P_tendenctToTouchTheFace;	// 얼굴을 만지는 경향(0~7). 낮을 수록 감염률 감소
	private int P_tendencyToWashHands;	// 손을 씻는 경향(0~7). 높을 수록 감염률 감소
	private int P_tendencyToWearMask;	// 마스크 착용 경향(0~7). 높을 수록 감염률 감소
	
	private int P_mobility;	// Mobility(0은 자가격리~7)
	
	
	private int P_infectionRate;	// 감염률
	private int P_propagationRate;	// 전파율
	private int P_deathRate;	// 사망률
	
	private List<String> P_participatingMeeting = new ArrayList<String>();	// 참여한 모임
	
	private LinkedHashMap<Integer, String> P_infectionStatus = new LinkedHashMap<Integer, String>();	// 감염 상태(M-수동면역자 30%, S-감염가능자, I-감염자, E-보균자, R-회복자, D-사망자)
	private int P_infectionTime;	// 감염 시점
	private int P_infectiousTime;	// 전염 가능 시점
	private int P_isolationTime;	// 격리 시점
	private boolean P_superPropaganda;	// 슈퍼전파자 여부
	
	private boolean P_symptomatic;	// 증상 여부
	private boolean P_criticallyIll;	// 중환자 여부
	private boolean P_useICU;	// 중환자실 사용 여부
	private boolean P_useHA;	// 경환자실 사용 여부
	
	
	
	// Getter and Setter
	
	public String getP_name() {
		return P_name;
	}
	public void setP_name(String p_name) {
		P_name = p_name;
	}
	public String getP_sex() {
		return P_sex;
	}
	public void setP_sex(String p_sex) {
		P_sex = p_sex;
	}
	public int getP_age() {
		return P_age;
	}
	public void setP_age(int p_age) {
		P_age = p_age;
	}
	public String getP_residentialArea() {
		return P_residentialArea;
	}
	public void setP_residentialArea(String p_residentialArea) {
		P_residentialArea = p_residentialArea;
	}
	public String getP_residentialForm() {
		return P_residentialForm;
	}
	public void setP_residentialForm(String p_residentialForm) {
		P_residentialForm = p_residentialForm;
	}
	public String getP_job() {
		return P_job;
	}
	public void setP_job(String p_job) {
		P_job = p_job;
	}
	public int getP_jobContactRate() {
		return P_jobContactRate;
	}
	public void setP_jobContactRate(int p_jobContactRate) {
		P_jobContactRate = p_jobContactRate;
	}
	public String getP_underlyingDisease() {
		return P_underlyingDisease;
	}
	public void setP_underlyingDisease(String p_underlyingDisease) {
		P_underlyingDisease = p_underlyingDisease;
	}
	public int getP_tendencyToPhysicalContact() {
		return P_tendencyToPhysicalContact;
	}
	public void setP_tendencyToPhysicalContact(int p_tendencyToPhysicalContact) {
		P_tendencyToPhysicalContact = p_tendencyToPhysicalContact;
	}
	public int getP_tendenctToTouchTheFace() {
		return P_tendenctToTouchTheFace;
	}
	public void setP_tendenctToTouchTheFace(int p_tendenctToTouchTheFace) {
		P_tendenctToTouchTheFace = p_tendenctToTouchTheFace;
	}
	public int getP_tendencyToWashHands() {
		return P_tendencyToWashHands;
	}
	public void setP_tendencyToWashHands(int p_tendencyToWashHands) {
		P_tendencyToWashHands = p_tendencyToWashHands;
	}
	public int getP_tendencyToWearMask() {
		return P_tendencyToWearMask;
	}
	public void setP_tendencyToWearMask(int p_tendencyToWearMask) {
		P_tendencyToWearMask = p_tendencyToWearMask;
	}
	public int getP_mobility() {
		return P_mobility;
	}
	public void setP_mobility(int p_mobility) {
		P_mobility = p_mobility;
	}
	public int getP_infectionRate() {
		return P_infectionRate;
	}
	public void setP_infectionRate(int p_infectionRate) {
		P_infectionRate = p_infectionRate;
	}
	public int getP_propagationRate() {
		return P_propagationRate;
	}
	public void setP_propagationRate(int p_propagationRate) {
		P_propagationRate = p_propagationRate;
	}
	public int getP_deathRate() {
		return P_deathRate;
	}
	public void setP_deathRate(int p_deathRate) {
		P_deathRate = p_deathRate;
	}
	public LinkedHashMap<Integer, String> getP_infectionStatus() {
		return P_infectionStatus;
	}
	public void setP_infectionStatus(LinkedHashMap<Integer, String> linkedHashMap) {
		P_infectionStatus = linkedHashMap;
	}
	public int getP_infectionTime() {
		return P_infectionTime;
	}
	public void setP_infectionTime(int p_infectionTime) {
		P_infectionTime = p_infectionTime;
	}
	public int getP_infectiousTime() {
		return P_infectiousTime;
	}
	public void setP_infectiousTime(int p_infectiousTime) {
		P_infectiousTime = p_infectiousTime;
	}
	public int getP_isolationTime() {
		return P_isolationTime;
	}
	public void setP_isolationTime(int p_isolationTime) {
		P_isolationTime = p_isolationTime;
	}
	public boolean getP_superPropaganda() {
		return P_superPropaganda;
	}
	public void setP_superPropaganda(boolean p_superPropaganda) {
		P_superPropaganda = p_superPropaganda;
	}
	public List<String> getP_participatingMeeting() {
		return P_participatingMeeting;
	}
	public void setP_participatingMeeting(List<String> p_participatingMeeting) {
		P_participatingMeeting = p_participatingMeeting;
	}
	public boolean getP_useICU() {
		return P_useICU;
	}
	public void setP_useICU(boolean p_useICU) {
		P_useICU = p_useICU;
	}
	public boolean getP_criticallyIll() {
		return P_criticallyIll;
	}
	public void setP_criticallyIll(boolean p_criticallyIll) {
		P_criticallyIll = p_criticallyIll;
	}
	public boolean getP_useHA() {
		return P_useHA;
	}
	public void setP_useHA(boolean p_useHA) {
		P_useHA = p_useHA;
	}
	public boolean getP_symptomatic() {
		return P_symptomatic;
	}
	public void setP_symptomatic(boolean p_symptomatic) {
		P_symptomatic = p_symptomatic;
	}
}
