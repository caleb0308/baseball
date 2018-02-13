package CodeSquad;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class BaseballGame {

	public static void main(String[] args) {
		String com = computer();
		char[] chCom = com.toCharArray();
//		System.out.println(com);   // ���� ���ڰ� ����� �����ƴ��� Ȯ��
		Scanner scanner = new Scanner(System.in);
				
		while (true) {
			System.out.print("�� ���ڸ� �Է����ּ���. ex) 123 : ");
			String user = scanner.nextLine();
			char[] chUser = user.toCharArray();
			
			int s  = strike(chCom, chUser);   // ��Ʈ����ũ �� ���� ������ ������ ����
			int b = ball(chCom, chUser);
			result(s, b);
			
			if (s == 3)
				break;		
		}
		System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
	}
	
	// ��ǻ�� ���� ���� �޼���
	static String computer() {
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(numList);   // 1~9 ������ ���ڸ� ����
		String com = "";
		com += numList.get(0);   // �� �� �ε�����  0, 1, 2��  ���ڿ� ������ ����
		com += numList.get(1);
		com += numList.get(2);
		return com;
	}
	
	// ��Ʈ����ũ �Ǻ� �޼���
	static int strike(char[] com, char[] user) {
		int s = 0;
		for (int i = 0; i < com.length; i++) {
			if (com[i] == user[i])   // ���ڿ� �ڸ����� ������ ��Ʈ����ũ   // com�� user�� �ε����� i�� ���� ���༭ ���� �ڸ����� �� ���ڸ� �Ǻ�
				s++;
		}
		return s;
	}
	
	// �� �Ǻ� �޼���
	static int ball(char[] com, char[] user) {
		int b = 0;
		for (int i = 0; i < com.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if (com[i] == user[j] && i != j)   // ���ڸ� ������ �ڸ����� �޶������ ��
					b++;
			}
		}
		return b;
	}
	
	// ��� �޼���
	static void result(int s, int b) {
		if (s > 0)
			System.out.print(s + "��Ʈ����ũ ");
		if (b > 0)
			System.out.print(b + "��");
		if (s + b == 0)
			System.out.print("����");
		System.out.println();
	}
}
