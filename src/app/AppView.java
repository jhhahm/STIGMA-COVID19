package app;

import java.util.Scanner;

public class AppView {

	private static Scanner sc = new Scanner(System.in);	// scanner 객체를 생성한다.

	private AppView() {	// AppView 생성자
		
	}
	
	public static void outputLine(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
	
	public static void output(String String) {
		System.out.print(String);
	}
	
	public static int scanInt() {
		return AppView.sc.nextInt();
	}
	
	public static String inputDate() {
		//String date;
		while(true) {
			AppView.outputLine("'2020-01-01 수'와 같은 형식으로 시뮬레이션 시작 날짜를 입력하시오.");
			AppView.output("시뮬레이션 시작 날짜 : ");
			return "2020-01-01 수";
			/*date = AppView.sc.nextLine();
			return date;*/
		}
	}

}
