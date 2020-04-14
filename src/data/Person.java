package data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Person {	// ��� ��ü ����
/* ���� ���� : ����, ����, �ְ� ����, �ְ� ����, ����(�ٸ� �̿� ���� ����), ������ �� �̵��ð�, ������ȯ(0~7) �� ����� ����(3), ��ü�� ����(0~7), ���� ������ ����(0~7), ���� �۴� ����(0~7), ����ũ ���� ����(0~7)
 * ���� ���� : ������ ����, �̵���� ��ġ(x,y), ���� ����(M-�����鿪�� 30%, S-����������, I-������, E-������, R-ȸ����, D-�����), ���� ����, ���� ���� ����, ������ �ݸ��� ����, Mobility(0-�ڰ��ݸ�~7)
 * 
 * ������ �� �̵��ð��� ���� ����� ���̹Ƿ� �������� ����
 * 
 * 1�ð� ����
 * ������ : �Ϲ��� 2%, ������ȯ�� 10%
 * ����� : ������ȯ�� 5%
 * ������ : �Ϲ��� 2%, ���������� 10% */
	
	private String P_name;	// ��� �̸�
	private String P_sex;	// �������� ����
	private int P_age;	// ����

	private String P_residentialArea;	// �ְ� ����
	private String P_residentialForm;	// �ְ� ����
	
	private String P_job;	// ����
	private int P_jobContactRate;	// �������� ���� ������

	private String P_underlyingDisease;	// ������ȯ
	private int P_tendencyToPhysicalContact;	// ��ü�� ���� ����(0~7). ���� ���� ������ ����
	private int P_tendenctToTouchTheFace;	// ���� ������ ����(0~7). ���� ���� ������ ����
	private int P_tendencyToWashHands;	// ���� �Ĵ� ����(0~7). ���� ���� ������ ����
	private int P_tendencyToWearMask;	// ����ũ ���� ����(0~7). ���� ���� ������ ����
	
	private int P_mobility;	// Mobility(0�� �ڰ��ݸ�~7)
	
	
	private int P_infectionRate;	// ������
	private int P_propagationRate;	// ������
	private int P_deathRate;	// �����
	
	private List<String> P_participatingMeeting = new ArrayList<String>();	// ������ ����
	
	private LinkedHashMap<Integer, String> P_infectionStatus = new LinkedHashMap<Integer, String>();	// ���� ����(M-�����鿪�� 30%, S-����������, I-������, E-������, R-ȸ����, D-�����)
	private int P_infectionTime;	// ���� ����
	private int P_infectiousTime;	// ���� ���� ����
	private int P_isolationTime;	// �ݸ� ����
	private boolean P_superPropaganda;	// ���������� ����
	
	private boolean P_symptomatic;	// ���� ����
	private boolean P_criticallyIll;	// ��ȯ�� ����
	private boolean P_useICU;	// ��ȯ�ڽ� ��� ����
	private boolean P_useHA;	// ��ȯ�ڽ� ��� ����
	
	
	
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
