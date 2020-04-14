package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import data.Meeting;
import data.Person;

public class AppController {
	int a = 100; // 1시간 감염률 1000을 기준으로 함. 1000이 100%
	int b = 96; // 보균자가 감염자가 되기까지의 시간
	int c = 48; // 보균자가 유증상이 나타나기까지의 시간
	int d = 800; // 감염자 중 유증상 감염자가 될 확률
	int e = 24; // 유증상자가 병원을 찾거나 찾지 않을 때까지 걸리는 시간
	int f = 300; // 유증상자가 병원을 가지 않을 확률
	int g = 4; // 유증상자가 병원에서 확진이 날때까지 걸리는 시간
	int h = 2; // 확진자가 병원에 입원하기까지 걸리는 시간
	int i = 100; // 유증상자가 중환자가 될 확률
	int j = 0; // 중환자실 여유 병실수
	int k = 50; // 중환자가 중환자실을 사용했을 경우의 사망 확률
	int l = 500; // 중환자가 중환자실을 사용하지 못했을 경우의 사망 확률
	int m = 995; // 무증상 감염자가 회복될 확률
	int n = 240; // 무증상 감염자가 회복 혹은 사망까지 걸리는 시간
	int o = 200; // 무증상 감염자가 병원을 찾을 확률
	int p = 72; // 무증상 감염자가 자가 점검까지 걸리는 시간
	int q = 24; // 자가 점검 후 병원을 찾기까지의 시간
	int r = 240; // 유증상자가 병원을 가고 회복 혹은 사망까지 걸리는 시간
	int s = 144; // 유증상자가 병원을 가지 않고 회복 혹은 사망까지 걸리는 시간
	int t = 10; // 확진자가 일반환자일 때 사망할 확률
	int u = 20; // 유증상자가 병원을 가지 않고 일반환자가 되었을 때 사망할 확률
	int v = 100; // 유증상자가 병원을 가지 않고 중환자가 되었을 때 사망할 확률
	int w = 1000; // 경환자실 여유 병실수

	Random random = new Random();

	private int time;
	private String Date;
	private String[] header;
	private LinkedHashMap<String, Meeting> meetingLinkedHashMap = new LinkedHashMap<String, Meeting>();
	private LinkedHashMap<String, Person> personLinkedHashMap = new LinkedHashMap<String, Person>();

	public LinkedHashMap<String, Meeting> getMeetingLinkedHashMap() {
		return meetingLinkedHashMap;
	}

	public void setMeetingLinkedHashMap(LinkedHashMap<String, Meeting> meetingLinkedHashMap) {
		this.meetingLinkedHashMap = meetingLinkedHashMap;
	}

	public LinkedHashMap<String, Person> getPersonLinkedHashMap() {
		return personLinkedHashMap;
	}

	public void setPersonLinkedHashMap(LinkedHashMap<String, Person> personLinkedHashMap) {
		this.personLinkedHashMap = personLinkedHashMap;
	}

	public void run() {
		// TODO Auto-generated method stub

		AppView.outputLine("<<< Corona19 Simulation Start >>>");
		AppView.outputLine("");

		this.sumulationSetting(); // 시뮬레이션 세팅
		this.simulationStart(); // 시뮬레이션 시작

		AppView.outputLine("");
		AppView.outputLine("<<< Corona19 Simulation Finish >>>");
	}

	private void simulationFinish() {
		// TODO Auto-generated method stub
		Iterator<Person> i = personLinkedHashMap.values().iterator();
		List<String[]> result = new ArrayList<String[]>();
		List<String> values = new ArrayList<String>();
		Collection<String> value;

		while (i.hasNext()) {
			value = i.next().getP_infectionStatus().values();
			Object[] s = value.toArray();
			String[] sa = Arrays.copyOf(s, s.length, String[].class);
			values.add(sa[sa.length - 1]);
		}
		String[] arrays = values.toArray(new String[values.size()]);
		result.add(arrays);

		// writeToCsvFile(result, "result");
		graphWriteToCsvFile(header, arrays);
	}

	private String[] graphHeaderWriteToCsvFile() { // (총대상인원, 초기감염자, 중증병상수, 감염률, 그룹수, 하루 횟수, 모임당인원)
		// TODO Auto-generated method stub
		List<String[]> header = new ArrayList<String[]>();
		String[] h = new String[12];
		h[0] = "D";
		h[1] = "I1";
		h[2] = "I2";
		h[3] = "I3";
		h[4] = "I4";
		h[5] = "I5";
		h[6] = "I6";
		h[7] = "I7";
		h[8] = "E";
		h[9] = "R";
		h[10] = "S1";
		h[11] = "M";
		header.add(h);
		writeToCsvFile(header, "graph");

		String[] sortHeader = {"D", "E", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "M", "R", "S1"};
		return sortHeader;
	}

	private void graphWriteToCsvFile(String[] h, String[] arrays) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		List<String[]> result = new ArrayList<String[]>();
		Arrays.sort(arrays);
		String[] number = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
		String current = arrays[0];
		int cnt = 0;
		for (int i = 0; i < arrays.length; i++) {
			if (arrays[i] != current) {
				map.put(current, cnt);
				current = arrays[i];
				cnt = 1;
			} else {
				cnt += 1;
			}
		}
		map.put(current, cnt);
		current = arrays[i];
		Set<String> k = map.keySet();
		Object[] o = k.toArray();
		for (int j = 0; j < o.length; j++) {
			for (int i = 0; i < h.length; i++) {
				if (o[j].toString().equals(h[i])) {
					number[i] = Integer.toString(map.get(h[i]));
				}
			}
		}
		
		number = sortGraph(number);
		
		result.add(number);
		writeToCsvFile(result, "graph");
	}

	private String[] sortGraph(String[] number) {
		// TODO Auto-generated method stub
		//String D = number[0];
		String E = number[1];
		String I1 = number[2];
		String I2 = number[3];
		String I3 = number[4];
		String I4 = number[5];
		String I5 = number[6];
		String I6 = number[7];
		String I7 = number[8];
		String M = number[9];
		String R = number[10];
		String S1 = number[11];

		number[1] = I1;
		number[2] = I2;
		number[3] = I3;
		number[4] = I4;
		number[5] = I5;
		number[6] = I6;
		number[7] = I7;
		number[8] = E;
		number[9] = R;
		number[10] = S1;
		number[11] = M;
		
		return number;
	}

	private void simulationStart() {
		// TODO Auto-generated method stub
		setHeader(graphHeaderWriteToCsvFile());
		this.simulationFinish();
		LinkedHashMap<String, Meeting> meeting = new LinkedHashMap<String, Meeting>(meetingLinkedHashMap);
		Set<String> m = meeting.keySet();
		int day = 1;

		while (time < 8760) { // 91일 이전까지 반복.
			calculationOfInfectionTime();
			
			Iterator<String> m_it = m.iterator();
			while (m_it.hasNext()) {
				String ms = m_it.next();
				if (meetingLinkedHashMap.get(ms).getM_endTime() < time) { // 이미 끝난 모임이면
					m_it.remove();
					meetingLinkedHashMap.remove(ms);
				} else if (meetingLinkedHashMap.get(ms).getM_startTime() <= time
						&& meetingLinkedHashMap.get(ms).getM_endTime() >= time) { // 지금 이루어지고 있는 모임이면
					if (meetingLinkedHashMap.get(ms).getM_participants() != null) {
						LinkedHashMap<String, Person> lm = new LinkedHashMap<String, Person>(
								meetingLinkedHashMap.get(ms).getM_participants()); // 모임 참석자 명단
						Set<String> p = lm.keySet();
						Iterator<String> p_it = p.iterator();
						while (p_it.hasNext()) {
							String ps = p_it.next();
							LinkedHashMap<Integer, String> p_status = lm.get(ps).getP_infectionStatus();
							if (p_status.containsValue("I2") || p_status.containsValue("I1")) { // 전염자이고
								if (!(p_status.containsValue("R") && p_status.containsValue("D"))) { // 아직 전염시킬 수 있는
																										// 상태이면
									Iterator<String> p_it2 = p.iterator();
									while (p_it2.hasNext()) {
										String ps2 = p_it2.next();
										LinkedHashMap<Integer, String> p_status2 = lm.get(ps2).getP_infectionStatus();
										if (p_status2.containsValue("S1")) {
											if (!(p_status2.containsValue("E") && p_status2.containsValue("I1") && p_status2.containsValue("I2") && p_status2.containsValue("I3") && p_status2.containsValue("I4") && p_status2.containsValue("I5") && p_status2.containsValue("I6") && p_status2.containsValue("I7") && p_status2.containsValue("R") && p_status2.containsValue("D"))) {
												if (random.nextInt(1000) <= a) { // 1시간 기준 감염
													lm.get(ps2).setP_infectionTime(time);
													p_status2.remove(time);
													p_status2.put(time, "E");
													personLinkedHashMap.get(ps2).setP_infectionStatus(p_status2);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			time += 1;
			this.simulationFinish();
			
			// !! 임시 코드 변경할 것
			if (time % 24 == 9 || time % 24 == 11 || time % 24 == 13 || time % 24 == 15) {
				if (time != 9) {
					setParticipantsRandomize();
				}
			}
			
			if (time % 24 == 0) {
				System.out.println(day);
				day += 1;
			}
		}
	}

	private void calculationOfInfectionTime() {
		// TODO Auto-generated method stub
		Iterator<Person> iter = personLinkedHashMap.values().iterator();
		while (iter.hasNext()) {
			Person person = iter.next();
			LinkedHashMap<Integer, String> status = person.getP_infectionStatus();
			if (!status.containsValue("M")) { // 자가면역자가 아닐 경우에
				Collection<String> value = status.values();
				Object[] values = value.toArray();
				String key = (String) values[values.length - 1];
				if (key == "E") { // 보균자일 경우
					if (time - person.getP_infectionTime() < b) { // 보균자가 감염자가 되기까지의 시간까지
						status.remove(time - 1);
						status.put(time, "E");
					} else { // 보균자가 감염자가 되기까지의 시간을 넘으면
						int sym = random.nextInt(1000);
						if (sym <= d) { // 유증상자 확률
							person.setP_infectiousTime(time);
							status.remove(time - 1);
							status.put(time, "I2");
							person.setP_symptomatic(true);
							if (random.nextInt(1000) <= i) { // 유증상 감염자가 중환자가 될 확률
								person.setP_criticallyIll(true);
							}
						} else { // 무증상자 확률
							person.setP_infectiousTime(time);
							status.remove(time - 1);
							status.put(time, "I1");
							person.setP_symptomatic(false);
						}
					}
				} else if (key == "I1") { // 무증상 감염자일 경우
					if (time - person.getP_infectiousTime() < p) { // 무증상 감염자가 자가 점검까지 걸리는 시간까지
						status.remove(time - 1);
						status.put(time, "I1");
					} else { // 무증상 감염자가 자가 점검까지 걸리는 시간을 넘었을 때
						if (time - person.getP_infectiousTime() == p + q) { // 자가 점검 후 병원을 찾기까지의 시간
							if (random.nextInt(1000) <= o) { // 무증상 감염자가 병원을 찾을 확률
								person.setP_isolationTime(time);
								status.remove(time - 1);
								status.put(time, "I3"); // 병원 확진자로 상태 변경
							} else {
								status.remove(time - 1);
								status.put(time, "I1");
							}
						} else if (time - person.getP_infectiousTime() == p + n) { // 무증상 감염자가 회복 혹은 사망까지 걸리는 시간
							if (random.nextInt(1000) <= m) { // 무증상 감염자가 회복될 확률
								status.remove(time - 1);
								status.put(time, "R");
							} else { // 무증상 감염자가 사망할 확률
								status.remove(time - 1);
								status.put(time, "D");
							}
						} else {
							status.remove(time - 1);
							status.put(time, "I1");
						}
					}
				} else if (key == "I2") { // 유증상 감염자일 경우
					if (time - person.getP_infectiousTime() < c) { // 보균자가 유증상이 나타나기까지의 시간까지
						status.remove(time - 1);
						status.put(time, "I2");
					} else { // 보균자가 유증상이 나타나기까지의 시간을 넘었을 때
						if (time - person.getP_infectiousTime() == c + e) { // 중증환자가 병원을 찾거나 찾지 않을 때, 병원을 찾았을 경우엔
																			// 확진까지 걸리는 시간
							if (random.nextInt(1000) <= f) { // 중증환자가 병원을 가지 않을 확률
								status.remove(time - 1);
								status.put(time, "I2");
							} else { // 유증상자가 병원을 가면 100% 확진
								person.setP_isolationTime(time);
								status.remove(time - 1);
								status.put(time, "I3");
							}
						} else if (time - person.getP_infectiousTime() == c + s) { // 중증환자가 병원을 가지 않고 회복 혹은 사망까지 걸리는
																					// 시간
							if (person.getP_criticallyIll() == true) {
								if (random.nextInt(1000) <= v) { // 중증환자가 병원을 가지 않았을 때 사망할 확률
									status.remove(time - 1);
									status.put(time, "D");
								} else { // 중증환자가 병원을 가지 않았을 때 회복할 확률
									status.remove(time - 1);
									status.put(time, "R");
								}
							} else {
								if (random.nextInt(1000) <= u) { // 경증환자가 병원을 가지 않았을 때 사망할 확률
									status.remove(time - 1);
									status.put(time, "D");
								} else { // 중증환자가 병원을 가지 않았을 때 회복할 확률
									status.remove(time - 1);
									status.put(time, "R");
								}
							}
						} else {
							status.remove(time - 1);
							status.put(time, "I2");
						}
					}
				} else if (key == "I3") { // 확진 대기중일 경우
					if (time - person.getP_isolationTime() == g) { // 감염자가 병원에서 확진을 받기까지 걸리는 시간
						if (person.getP_criticallyIll() == true) { // 중환자일 경우
							status.remove(time - 1);
							status.put(time, "I6");
						} else {
							status.remove(time - 1);
							status.put(time, "I4");
						}
					} else {
						status.remove(time - 1);
						status.put(time, "I3");
					}
				} else if (key == "I4") { // 경증 병실대기 환진자일 경우
					if (time - person.getP_isolationTime() >= g + h) { // 병실에 입원하기까지 걸리는 시간 이후
						if (w > 0) { // 경환자실 여유 병실수가 양수이면
							w -= 1;
							person.setP_useHA(true);
							status.remove(time - 1);
							status.put(time, "I5");
						} else { // 경환자실 여유 병실수가 없으면
							if (time - person.getP_isolationTime() == s) { // 유증상자가 병원을 가서 회복 혹은 사망까지 걸리는 시간
								if (random.nextInt(1000) <= u) { // 경증환자가 입원하지 못했을 때 사망할 확률
									status.remove(time - 1);
									status.put(time, "D");
								} else {
									status.remove(time - 1);
									status.put(time, "R");
								}
							} else {
								status.remove(time - 1);
								status.put(time, "I4");
							}
						}
					} else { // 병실에 입원하기까지 걸리는 시간
						status.remove(time - 1);
						status.put(time, "I4");
					}
				} else if (key == "I5") { // 경증 입원 확진자일 경우
					if (time - person.getP_isolationTime() == g + h + r) { // 경증환자가 입원하고 회복 혹은 사망까지 걸리는 시간
						if (random.nextInt(1000) <= t) { // 경증 입원 환자가 사망할 확률
							status.remove(time - 1);
							status.put(time, "D");
							person.setP_useHA(false);
						} else {
							status.remove(time - 1);
							status.put(time, "R");
							person.setP_useHA(false);
						}
					} else {
						status.remove(time - 1);
						status.put(time, "I5");
					}
				} else if (key == "I6") { // 중증 병실대기 확진자일 경우
					if (time - person.getP_isolationTime() >= g + h) { // 병실에 입원하기까지 걸리는 시간 이후
						if (j > 0) { // 중환자실 여유 병실수가 양수이면
							j -= 1;
							person.setP_useICU(true);
							status.remove(time - 1);
							status.put(time, "I7");
						} else { // 중환자실 여유 병실수가 없으면
							if (time - person.getP_isolationTime() == s) { // 유증상자가 병원을 가서 회복 혹은 사망까지 걸리는 시간
								if (random.nextInt(1000) <= l) { // 중증환자가 입원하지 못했을 때 사망할 확률
									status.remove(time - 1);
									status.put(time, "D");
								} else {
									status.remove(time - 1);
									status.put(time, "R");
								}
							} else {
								status.remove(time - 1);
								status.put(time, "I6");
							}
						}
					} else { // 병실에 입원하기까지 걸리는 시간
						status.remove(time - 1);
						status.put(time, "I6");
					}
				} else if (key == "I7") { // 중증 입원 확진자일 경우
					if (time - person.getP_isolationTime() == g + h + r) { // 경증환자가 입원하고 회복 혹은 사망까지 걸리는 시간
						if (random.nextInt(1000) <= k) { // 중증 입원 환자가 사망할 확률
							status.remove(time - 1);
							status.put(time, "D");
							person.setP_useICU(false);
						} else {
							status.remove(time - 1);
							status.put(time, "R");
							person.setP_useICU(false);
						}
					} else {
						status.remove(time - 1);
						status.put(time, "I7");
					}
				} else { // 감염가능자, 회복자, 사망자일 경우
					status.remove(time - 1);
					status.put(time, key);
				}
			} else { // 수동 면역자일 때
				status.remove(time - 1);
				status.put(time, "M");
			}
		}
	}

	private void sumulationSetting() {
		// TODO Auto-generated method stub
		setTime(0); // 시간 시작
		AppView.outputLine("Please input the information.");
		// setInputData();

		AppView.outputLine("Please set the meeting information.");
		setMeetingLinkedHashMap(this.inputMeetingData()); // 모임 정보 입력

		AppView.outputLine("Please set person information.");
		setPersonLinkedHashMap(this.inputPersonData()); // 사람 정보 입력

		AppView.outputLine("Please set the rest of the information.");
		setParticipantsRandomize(); // 첫 모임 참여자 생성
		setCreateRandomInfected(); // 감염자 생성
	}
	
	int preStartTime = 9;
	int currentStartTime = 9;
	LinkedHashMap<String, Person> firstMeetingPerson = new LinkedHashMap<String, Person>();
	private void setParticipantsRandomize() {
		// TODO Auto-generated method stub
		Iterator<String> iter = meetingLinkedHashMap.keySet().iterator();
		LinkedHashMap<String, Person> newPersonMap = new LinkedHashMap<String, Person>(personLinkedHashMap);
		
		while (iter.hasNext()) {
			String key = iter.next();
			if (currentStartTime < meetingLinkedHashMap.get(key).getM_startTime()) {
				currentStartTime = meetingLinkedHashMap.get(key).getM_startTime();
				break;
			}
			LinkedHashMap<String, Person> inputPersonMap = new LinkedHashMap<String, Person>();
			int participantsNumber = 5; // 모임당 인원은 총 10명씩

			/*if (preStartTime != currentStartTime) { // 이전 모임과 현재 모임의 시간이 같지 않아야 동시간대가 아님
				break;
				//newPersonMap = new LinkedHashMap<String, Person>(personLinkedHashMap);
			}*/

			while (participantsNumber > 0) {
				int temp = random.nextInt(newPersonMap.size());
				Set<String> keySet = newPersonMap.keySet();
				Object[] array = keySet.toArray();
				String sTemp = (String) array[temp];
				if (personLinkedHashMap.get(sTemp).getP_infectionStatus().containsValue("D") || personLinkedHashMap.get(sTemp).getP_infectionStatus().containsValue("I5") || personLinkedHashMap.get(sTemp).getP_infectionStatus().containsValue("I7")) {
					continue;
				}
				inputPersonMap.put(sTemp, personLinkedHashMap.get(sTemp));
				if (currentStartTime == 9) {
					firstMeetingPerson.put(sTemp, personLinkedHashMap.get(sTemp));
				}
				newPersonMap.remove(sTemp);
				participantsNumber -= 1;
			}

			preStartTime = currentStartTime;
			meetingLinkedHashMap.get(key).setM_participants(inputPersonMap);
		}
		//System.out.println();
	}

	private void setCreateRandomInfected() {
		// TODO Auto-generated method stub
		AppView.output("생성할 감염자 수를 입력하시오 : ");
		// int n = AppView.scanInt();
		int n = 10;
		List<String> m = new ArrayList<String>(this.personLinkedHashMap.keySet());

		while (n != 0) {
			int t = random.nextInt(m.size());
			String s = "Person" + (t + 1);
			if (firstMeetingPerson.containsKey(s)) {
				personLinkedHashMap.get(s).setP_infectionStatus(infectionStatusRandomize(personLinkedHashMap.get(s),
						personLinkedHashMap.get(s).getP_infectionStatus()));
				m.remove(s);
				firstMeetingPerson.remove(s);
				n -= 1;
			}
		}
		firstMeetingPerson.clear();
		System.out.println("감염자 생성 완료");
	}

	private LinkedHashMap<String, Person> inputPersonData() {
		// TODO Auto-generated method stub
		// !!나중에 파일 이름 입력받는 형식으로 변경하기
		List<String[]> pList = readFromCsvFile("person.csv"); // 인물 정보가 저장되어 있는 csv 파일을 불러옴

		LinkedHashMap<String, Person> t_personLinkedHashMap = new LinkedHashMap<String, Person>();

		for (int i = 1; i < pList.size(); i++) {
			String k = "Person" + Integer.toString(i);
			t_personLinkedHashMap.put(k, transformPersonClass(pList.get(i), k));
		}

		return t_personLinkedHashMap;
	}

	private Person transformPersonClass(String[] strings, String k) {
		// TODO Auto-generated method stub
		Person p = new Person();
		p.setP_name(strings[0]);
		p.setP_sex(strings[1]);
		p.setP_age(Integer.parseInt(strings[2]));
		p.setP_residentialArea(strings[3]);
		p.setP_residentialForm(strings[4]);
		p.setP_job(strings[5]);
		p.setP_jobContactRate(Integer.parseInt(strings[6]));
		p.setP_underlyingDisease(strings[7]);
		p.setP_tendencyToPhysicalContact(Integer.parseInt(strings[8]));
		p.setP_tendenctToTouchTheFace(Integer.parseInt(strings[9]));
		p.setP_tendencyToWashHands(Integer.parseInt(strings[10]));
		p.setP_tendencyToWearMask(Integer.parseInt(strings[11]));
		p.setP_mobility(Integer.parseInt(strings[12]));

		p.setP_participatingMeeting(null);
		// p.setP_participatingMeeting(participatingMeetingRandomize(p, k));

		p.setP_criticallyIll(false);
		p.setP_useICU(false);
		p.setP_useHA(false);

		CalculateFirstStatus(p);

		return p;
	}

	private void CalculateFirstStatus(Person p) {
		// TODO Auto-generated method stub
		LinkedHashMap<Integer, String> l = new LinkedHashMap<Integer, String>();

		p.setP_infectionStatus(infectionStatusRandomize(p, l));
		p.setP_infectionTime(0);
		p.setP_infectiousTime(0);
		p.setP_isolationTime(0);
	}

	private LinkedHashMap<Integer, String> infectionStatusRandomize(Person p, LinkedHashMap<Integer, String> l) {
		// TODO Auto-generated method stub
		int i = random.nextInt(10);

		if (l.isEmpty() == true) { // 처음 값 생성
			if (i < 3) { // 처음엔 초기 면역자 빼고는 감염가능자로 가정
				l.put(time, "M");
			} else {
				l.put(time, "S1");
			}
		} else { // person 생성 시에 감염자로 집어넣을 때에는 무언가 값을 집어넣어주었기 때문에
			l.clear(); // 미리 해쉬 값을 지운다
			if (random.nextBoolean() == true) {
				l.put(time, "I2");
				p.setP_symptomatic(true);
				if (random.nextInt(1000) <= i) { // 유증상 감염자가 중환자가 될 확률
					p.setP_criticallyIll(true);
				}
				p.setP_infectiousTime(time);
			} else {
				p.setP_symptomatic(false);
				l.put(time, "I1");
				p.setP_infectiousTime(time);
			}
		}
		return l;
	}

	private LinkedHashMap<String, Meeting> inputMeetingData() {
		// TODO Auto-generated method stub
		// !!나중에 파일 이름 입력받는 형식으로 변경하기
		List<String[]> mList = readFromCsvFile("meeting.csv"); // 모임 정보가 저장되어 있는 csv 파일을 불러옴
		LinkedHashMap<String, Meeting> t_meetingLinkedHashMap = new LinkedHashMap<String, Meeting>();

		for (int i = 1; i < mList.size(); i++) {
			String k = "Meeting" + Integer.toString(i);
			t_meetingLinkedHashMap.put(k, transformMeetingClass(mList.get(i)));
		}

		return t_meetingLinkedHashMap;
	}

	private Meeting transformMeetingClass(String[] strings) {
		// TODO Auto-generated method stub
		Meeting m = new Meeting();
		m.setM_name(strings[0]);
		m.setM_form(strings[1]);
		m.setM_startTime(Integer.parseInt(strings[2]));
		m.setM_endTime(Integer.parseInt(strings[3]));
		m.setM_totalTime(Integer.parseInt(strings[4]));
		m.setM_personnel(Integer.parseInt(strings[5]));
		m.setM_property(Integer.parseInt(strings[6]));
		m.setM_mapX(Integer.parseInt(strings[7]));
		m.setM_mapY(Integer.parseInt(strings[8]));

		m.setM_participants(null);

		return m;
	}

	private List<String[]> readFromCsvFile(String fileName) { // csv 파일을 읽어옴
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			List<String[]> list = new ArrayList<>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] array = line.split(",");
				list.add(array);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void writeToCsvFile(List<String[]> thingsToWrite, String fileName) { // csv 파일로 저장
		try (FileWriter writer = new FileWriter(fileName + ".csv", true)) {
			for (String[] strings : thingsToWrite) {
				for (int i = 0; i < strings.length; i++) {
					writer.append(strings[i]);
					if (i < (strings.length - 1))
						writer.append(",");
				}
				writer.append(System.lineSeparator());
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}
}
