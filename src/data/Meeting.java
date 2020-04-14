package data;

import java.util.LinkedHashMap;

public class Meeting {	// ���� ����
/* ������ �ݵ�� 2�� �̻��� �ʿ��ϸ�, ���������̶�� ����
 * �̸�, ������ ����, ���� �ð�, ���� �ð�, ������ ���, ������ �Ӽ� */
	
	private String M_name;	// ���� �̸�
	private String M_form;	// ���� ����. �б�, ���͵� ����, Ŭ�� ��
	
	private int M_startTime;	// ���� �ð�
	private int M_endTime;	// ���� �ð�
	private int M_totalTime;	// �� ���� �ð�
	
	private int M_personnel;	// ���� �ο�
	private int M_property;	// ���� �Ӽ�. �ڷγ�19 ���� ����

	private int M_mapX;	// ���� ��ġ x��
	private int M_mapY;	// ���� ��ġ y��
	
	private LinkedHashMap<String, Person> M_participants;	// ���� ������ ���

	
	
	// Getter and Setter
	
	public String getM_name() {
		return M_name;
	}

	public void setM_name(String m_name) {
		M_name = m_name;
	}

	public String getM_form() {
		return M_form;
	}

	public void setM_form(String m_form) {
		M_form = m_form;
	}

	public int getM_startTime() {
		return M_startTime;
	}

	public void setM_startTime(int m_startTime) {
		M_startTime = m_startTime;
	}

	public int getM_endTime() {
		return M_endTime;
	}

	public void setM_endTime(int m_endTime) {
		M_endTime = m_endTime;
	}

	public int getM_totalTime() {
		return M_totalTime;
	}

	public void setM_totalTime(int m_totalTime) {
		M_totalTime = m_totalTime;
	}

	public int getM_personnel() {
		return M_personnel;
	}

	public void setM_personnel(int m_personnel) {
		M_personnel = m_personnel;
	}

	public int getM_property() {
		return M_property;
	}

	public void setM_property(int m_property) {
		M_property = m_property;
	}

	public int getM_mapX() {
		return M_mapX;
	}

	public void setM_mapX(int m_mapX) {
		M_mapX = m_mapX;
	}

	public int getM_mapY() {
		return M_mapY;
	}

	public void setM_mapY(int m_mapY) {
		M_mapY = m_mapY;
	}

	public LinkedHashMap<String, Person> getM_participants() {
		return M_participants;
	}

	public void setM_participants(LinkedHashMap<String, Person> m_participants) {
		M_participants = m_participants;
	}
	
}
