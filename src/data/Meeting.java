package data;

import java.util.LinkedHashMap;

public class Meeting {	// 모임 정보
/* 모임은 반드시 2명 이상이 필요하며, 오프라인이라고 가정
 * 이름, 모임의 형태, 시작 시간, 종료 시간, 참석자 명단, 모임의 속성 */
	
	private String M_name;	// 모임 이름
	private String M_form;	// 모임 형태. 학교, 스터디 모임, 클럽 등
	
	private int M_startTime;	// 시작 시간
	private int M_endTime;	// 종료 시간
	private int M_totalTime;	// 총 모임 시간
	
	private int M_personnel;	// 모임 인원
	private int M_property;	// 모임 속성. 코로나19 전파 수준

	private int M_mapX;	// 모임 위치 x축
	private int M_mapY;	// 모임 위치 y축
	
	private LinkedHashMap<String, Person> M_participants;	// 모임 참석자 명단

	
	
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
