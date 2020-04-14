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
	int a = 100; // 1�ð� ������ 1000�� �������� ��. 1000�� 100%
	int b = 96; // �����ڰ� �����ڰ� �Ǳ������ �ð�
	int c = 48; // �����ڰ� �������� ��Ÿ��������� �ð�
	int d = 800; // ������ �� ������ �����ڰ� �� Ȯ��
	int e = 24; // �������ڰ� ������ ã�ų� ã�� ���� ������ �ɸ��� �ð�
	int f = 300; // �������ڰ� ������ ���� ���� Ȯ��
	int g = 4; // �������ڰ� �������� Ȯ���� �������� �ɸ��� �ð�
	int h = 2; // Ȯ���ڰ� ������ �Կ��ϱ���� �ɸ��� �ð�
	int i = 100; // �������ڰ� ��ȯ�ڰ� �� Ȯ��
	int j = 0; // ��ȯ�ڽ� ���� ���Ǽ�
	int k = 50; // ��ȯ�ڰ� ��ȯ�ڽ��� ������� ����� ��� Ȯ��
	int l = 500; // ��ȯ�ڰ� ��ȯ�ڽ��� ������� ������ ����� ��� Ȯ��
	int m = 995; // ������ �����ڰ� ȸ���� Ȯ��
	int n = 240; // ������ �����ڰ� ȸ�� Ȥ�� ������� �ɸ��� �ð�
	int o = 200; // ������ �����ڰ� ������ ã�� Ȯ��
	int p = 72; // ������ �����ڰ� �ڰ� ���˱��� �ɸ��� �ð�
	int q = 24; // �ڰ� ���� �� ������ ã������� �ð�
	int r = 240; // �������ڰ� ������ ���� ȸ�� Ȥ�� ������� �ɸ��� �ð�
	int s = 144; // �������ڰ� ������ ���� �ʰ� ȸ�� Ȥ�� ������� �ɸ��� �ð�
	int t = 10; // Ȯ���ڰ� �Ϲ�ȯ���� �� ����� Ȯ��
	int u = 20; // �������ڰ� ������ ���� �ʰ� �Ϲ�ȯ�ڰ� �Ǿ��� �� ����� Ȯ��
	int v = 100; // �������ڰ� ������ ���� �ʰ� ��ȯ�ڰ� �Ǿ��� �� ����� Ȯ��
	int w = 1000; // ��ȯ�ڽ� ���� ���Ǽ�

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

		this.sumulationSetting(); // �ùķ��̼� ����
		this.simulationStart(); // �ùķ��̼� ����

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

	private String[] graphHeaderWriteToCsvFile() { // (�Ѵ���ο�, �ʱⰨ����, ���������, ������, �׷��, �Ϸ� Ƚ��, ���Ӵ��ο�)
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

		while (time < 8760) { // 91�� �������� �ݺ�.
			calculationOfInfectionTime();
			
			Iterator<String> m_it = m.iterator();
			while (m_it.hasNext()) {
				String ms = m_it.next();
				if (meetingLinkedHashMap.get(ms).getM_endTime() < time) { // �̹� ���� �����̸�
					m_it.remove();
					meetingLinkedHashMap.remove(ms);
				} else if (meetingLinkedHashMap.get(ms).getM_startTime() <= time
						&& meetingLinkedHashMap.get(ms).getM_endTime() >= time) { // ���� �̷������ �ִ� �����̸�
					if (meetingLinkedHashMap.get(ms).getM_participants() != null) {
						LinkedHashMap<String, Person> lm = new LinkedHashMap<String, Person>(
								meetingLinkedHashMap.get(ms).getM_participants()); // ���� ������ ���
						Set<String> p = lm.keySet();
						Iterator<String> p_it = p.iterator();
						while (p_it.hasNext()) {
							String ps = p_it.next();
							LinkedHashMap<Integer, String> p_status = lm.get(ps).getP_infectionStatus();
							if (p_status.containsValue("I2") || p_status.containsValue("I1")) { // �������̰�
								if (!(p_status.containsValue("R") && p_status.containsValue("D"))) { // ���� ������ų �� �ִ�
																										// �����̸�
									Iterator<String> p_it2 = p.iterator();
									while (p_it2.hasNext()) {
										String ps2 = p_it2.next();
										LinkedHashMap<Integer, String> p_status2 = lm.get(ps2).getP_infectionStatus();
										if (p_status2.containsValue("S1")) {
											if (!(p_status2.containsValue("E") && p_status2.containsValue("I1") && p_status2.containsValue("I2") && p_status2.containsValue("I3") && p_status2.containsValue("I4") && p_status2.containsValue("I5") && p_status2.containsValue("I6") && p_status2.containsValue("I7") && p_status2.containsValue("R") && p_status2.containsValue("D"))) {
												if (random.nextInt(1000) <= a) { // 1�ð� ���� ����
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
			
			// !! �ӽ� �ڵ� ������ ��
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
			if (!status.containsValue("M")) { // �ڰ��鿪�ڰ� �ƴ� ��쿡
				Collection<String> value = status.values();
				Object[] values = value.toArray();
				String key = (String) values[values.length - 1];
				if (key == "E") { // �������� ���
					if (time - person.getP_infectionTime() < b) { // �����ڰ� �����ڰ� �Ǳ������ �ð�����
						status.remove(time - 1);
						status.put(time, "E");
					} else { // �����ڰ� �����ڰ� �Ǳ������ �ð��� ������
						int sym = random.nextInt(1000);
						if (sym <= d) { // �������� Ȯ��
							person.setP_infectiousTime(time);
							status.remove(time - 1);
							status.put(time, "I2");
							person.setP_symptomatic(true);
							if (random.nextInt(1000) <= i) { // ������ �����ڰ� ��ȯ�ڰ� �� Ȯ��
								person.setP_criticallyIll(true);
							}
						} else { // �������� Ȯ��
							person.setP_infectiousTime(time);
							status.remove(time - 1);
							status.put(time, "I1");
							person.setP_symptomatic(false);
						}
					}
				} else if (key == "I1") { // ������ �������� ���
					if (time - person.getP_infectiousTime() < p) { // ������ �����ڰ� �ڰ� ���˱��� �ɸ��� �ð�����
						status.remove(time - 1);
						status.put(time, "I1");
					} else { // ������ �����ڰ� �ڰ� ���˱��� �ɸ��� �ð��� �Ѿ��� ��
						if (time - person.getP_infectiousTime() == p + q) { // �ڰ� ���� �� ������ ã������� �ð�
							if (random.nextInt(1000) <= o) { // ������ �����ڰ� ������ ã�� Ȯ��
								person.setP_isolationTime(time);
								status.remove(time - 1);
								status.put(time, "I3"); // ���� Ȯ���ڷ� ���� ����
							} else {
								status.remove(time - 1);
								status.put(time, "I1");
							}
						} else if (time - person.getP_infectiousTime() == p + n) { // ������ �����ڰ� ȸ�� Ȥ�� ������� �ɸ��� �ð�
							if (random.nextInt(1000) <= m) { // ������ �����ڰ� ȸ���� Ȯ��
								status.remove(time - 1);
								status.put(time, "R");
							} else { // ������ �����ڰ� ����� Ȯ��
								status.remove(time - 1);
								status.put(time, "D");
							}
						} else {
							status.remove(time - 1);
							status.put(time, "I1");
						}
					}
				} else if (key == "I2") { // ������ �������� ���
					if (time - person.getP_infectiousTime() < c) { // �����ڰ� �������� ��Ÿ��������� �ð�����
						status.remove(time - 1);
						status.put(time, "I2");
					} else { // �����ڰ� �������� ��Ÿ��������� �ð��� �Ѿ��� ��
						if (time - person.getP_infectiousTime() == c + e) { // ����ȯ�ڰ� ������ ã�ų� ã�� ���� ��, ������ ã���� ��쿣
																			// Ȯ������ �ɸ��� �ð�
							if (random.nextInt(1000) <= f) { // ����ȯ�ڰ� ������ ���� ���� Ȯ��
								status.remove(time - 1);
								status.put(time, "I2");
							} else { // �������ڰ� ������ ���� 100% Ȯ��
								person.setP_isolationTime(time);
								status.remove(time - 1);
								status.put(time, "I3");
							}
						} else if (time - person.getP_infectiousTime() == c + s) { // ����ȯ�ڰ� ������ ���� �ʰ� ȸ�� Ȥ�� ������� �ɸ���
																					// �ð�
							if (person.getP_criticallyIll() == true) {
								if (random.nextInt(1000) <= v) { // ����ȯ�ڰ� ������ ���� �ʾ��� �� ����� Ȯ��
									status.remove(time - 1);
									status.put(time, "D");
								} else { // ����ȯ�ڰ� ������ ���� �ʾ��� �� ȸ���� Ȯ��
									status.remove(time - 1);
									status.put(time, "R");
								}
							} else {
								if (random.nextInt(1000) <= u) { // ����ȯ�ڰ� ������ ���� �ʾ��� �� ����� Ȯ��
									status.remove(time - 1);
									status.put(time, "D");
								} else { // ����ȯ�ڰ� ������ ���� �ʾ��� �� ȸ���� Ȯ��
									status.remove(time - 1);
									status.put(time, "R");
								}
							}
						} else {
							status.remove(time - 1);
							status.put(time, "I2");
						}
					}
				} else if (key == "I3") { // Ȯ�� ������� ���
					if (time - person.getP_isolationTime() == g) { // �����ڰ� �������� Ȯ���� �ޱ���� �ɸ��� �ð�
						if (person.getP_criticallyIll() == true) { // ��ȯ���� ���
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
				} else if (key == "I4") { // ���� ���Ǵ�� ȯ������ ���
					if (time - person.getP_isolationTime() >= g + h) { // ���ǿ� �Կ��ϱ���� �ɸ��� �ð� ����
						if (w > 0) { // ��ȯ�ڽ� ���� ���Ǽ��� ����̸�
							w -= 1;
							person.setP_useHA(true);
							status.remove(time - 1);
							status.put(time, "I5");
						} else { // ��ȯ�ڽ� ���� ���Ǽ��� ������
							if (time - person.getP_isolationTime() == s) { // �������ڰ� ������ ���� ȸ�� Ȥ�� ������� �ɸ��� �ð�
								if (random.nextInt(1000) <= u) { // ����ȯ�ڰ� �Կ����� ������ �� ����� Ȯ��
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
					} else { // ���ǿ� �Կ��ϱ���� �ɸ��� �ð�
						status.remove(time - 1);
						status.put(time, "I4");
					}
				} else if (key == "I5") { // ���� �Կ� Ȯ������ ���
					if (time - person.getP_isolationTime() == g + h + r) { // ����ȯ�ڰ� �Կ��ϰ� ȸ�� Ȥ�� ������� �ɸ��� �ð�
						if (random.nextInt(1000) <= t) { // ���� �Կ� ȯ�ڰ� ����� Ȯ��
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
				} else if (key == "I6") { // ���� ���Ǵ�� Ȯ������ ���
					if (time - person.getP_isolationTime() >= g + h) { // ���ǿ� �Կ��ϱ���� �ɸ��� �ð� ����
						if (j > 0) { // ��ȯ�ڽ� ���� ���Ǽ��� ����̸�
							j -= 1;
							person.setP_useICU(true);
							status.remove(time - 1);
							status.put(time, "I7");
						} else { // ��ȯ�ڽ� ���� ���Ǽ��� ������
							if (time - person.getP_isolationTime() == s) { // �������ڰ� ������ ���� ȸ�� Ȥ�� ������� �ɸ��� �ð�
								if (random.nextInt(1000) <= l) { // ����ȯ�ڰ� �Կ����� ������ �� ����� Ȯ��
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
					} else { // ���ǿ� �Կ��ϱ���� �ɸ��� �ð�
						status.remove(time - 1);
						status.put(time, "I6");
					}
				} else if (key == "I7") { // ���� �Կ� Ȯ������ ���
					if (time - person.getP_isolationTime() == g + h + r) { // ����ȯ�ڰ� �Կ��ϰ� ȸ�� Ȥ�� ������� �ɸ��� �ð�
						if (random.nextInt(1000) <= k) { // ���� �Կ� ȯ�ڰ� ����� Ȯ��
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
				} else { // ����������, ȸ����, ������� ���
					status.remove(time - 1);
					status.put(time, key);
				}
			} else { // ���� �鿪���� ��
				status.remove(time - 1);
				status.put(time, "M");
			}
		}
	}

	private void sumulationSetting() {
		// TODO Auto-generated method stub
		setTime(0); // �ð� ����
		AppView.outputLine("Please input the information.");
		// setInputData();

		AppView.outputLine("Please set the meeting information.");
		setMeetingLinkedHashMap(this.inputMeetingData()); // ���� ���� �Է�

		AppView.outputLine("Please set person information.");
		setPersonLinkedHashMap(this.inputPersonData()); // ��� ���� �Է�

		AppView.outputLine("Please set the rest of the information.");
		setParticipantsRandomize(); // ù ���� ������ ����
		setCreateRandomInfected(); // ������ ����
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
			int participantsNumber = 5; // ���Ӵ� �ο��� �� 10��

			/*if (preStartTime != currentStartTime) { // ���� ���Ӱ� ���� ������ �ð��� ���� �ʾƾ� ���ð��밡 �ƴ�
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
		AppView.output("������ ������ ���� �Է��Ͻÿ� : ");
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
		System.out.println("������ ���� �Ϸ�");
	}

	private LinkedHashMap<String, Person> inputPersonData() {
		// TODO Auto-generated method stub
		// !!���߿� ���� �̸� �Է¹޴� �������� �����ϱ�
		List<String[]> pList = readFromCsvFile("person.csv"); // �ι� ������ ����Ǿ� �ִ� csv ������ �ҷ���

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

		if (l.isEmpty() == true) { // ó�� �� ����
			if (i < 3) { // ó���� �ʱ� �鿪�� ����� ���������ڷ� ����
				l.put(time, "M");
			} else {
				l.put(time, "S1");
			}
		} else { // person ���� �ÿ� �����ڷ� ������� ������ ���� ���� ����־��־��� ������
			l.clear(); // �̸� �ؽ� ���� �����
			if (random.nextBoolean() == true) {
				l.put(time, "I2");
				p.setP_symptomatic(true);
				if (random.nextInt(1000) <= i) { // ������ �����ڰ� ��ȯ�ڰ� �� Ȯ��
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
		// !!���߿� ���� �̸� �Է¹޴� �������� �����ϱ�
		List<String[]> mList = readFromCsvFile("meeting.csv"); // ���� ������ ����Ǿ� �ִ� csv ������ �ҷ���
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

	private List<String[]> readFromCsvFile(String fileName) { // csv ������ �о��
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

	private void writeToCsvFile(List<String[]> thingsToWrite, String fileName) { // csv ���Ϸ� ����
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
