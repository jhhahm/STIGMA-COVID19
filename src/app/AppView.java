package app;

import java.util.Scanner;

public class AppView {

	private static Scanner sc = new Scanner(System.in);	// scanner ��ü�� �����Ѵ�.

	private AppView() {	// AppView ������
		
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
			AppView.outputLine("'2020-01-01 ��'�� ���� �������� �ùķ��̼� ���� ��¥�� �Է��Ͻÿ�.");
			AppView.output("�ùķ��̼� ���� ��¥ : ");
			return "2020-01-01 ��";
			/*date = AppView.sc.nextLine();
			return date;*/
		}
	}

}
