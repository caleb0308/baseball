package CodeSquad;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class BaseballGame {

	public static void main(String[] args) {
		char[] com = computer();
//		System.out.println(com);   // ���� ���ڰ� ����� �����ƴ��� Ȯ��
		
		while (true) {
			char[] user = user();   // ������ ���ڸ� ������ ����
			int s  = strike(com, user);   // ��Ʈ����ũ �� ���� ������ ������ ����
			int b = ball(com, user);
			result(s, b);   // ��Ʈ����ũ�� ���� ������ ���ڷ� �޾Ƽ� ����� ����
			
			if (s == 3)   // ��Ʈ����ũ�� 3���� ���, while���� ���
				break;		
		}
		
		System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
	}
	
	// ��ǻ�� ���� ���� �޼���
	static char[] computer() {
		List<String> numList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
		Collections.shuffle(numList);   // 1~9 ������ ���ڸ� ����
		String com = "";
		for (int i = 0; i < 3; i++)
			com += numList.get(i);   // �� �� �ε�����  0, 1, 2��  ���ڿ� ������ ����
		char[] chCom = com.toCharArray();   // ���ڿ��� char[]�迭�� ��ȯ
		return chCom;   // ��ǻ�� ��������(char�迭)�� ���� 
	}
	
	// ���� �����Է� �޼���
	static char[] user() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� ���ڸ� �Է����ּ���. ex) 123 : ");
		String user = scanner.nextLine();
		char[] chUser = user.toCharArray();   // ���ڿ��� char[]�迭�� ��ȯ
		return chUser;   // ���� ����(char�迭)�� ����
	}
	
	// ��Ʈ����ũ �Ǻ� �޼���
	static int strike(char[] com, char[] user) {   // ��ǻ�� ���ڿ� ���� ���ڷ� �̷���� char�迭�� �Ű������� �޴´�.
		int s = 0;
		for (int i = 0; i < com.length; i++) {
			if (com[i] == user[i])   // ���ڿ� �ڸ����� ������ ��Ʈ����ũ  / com�� user�� �ε����� i�� ���� ���༭ ���� �ڸ����� �� ���ڸ� �Ǻ�
				s++;
		}
		return s;   // ��Ʈ����ũ ������ ����
	}
	
	// �� �Ǻ� �޼��� (�޼��� �и�)
	static int ball(char[] computer, char[] user) {   // ��ǻ�� ���ڿ� ���� ���ڷ� �̷���� char�迭�� �Ű������� �޴´�.
		int b = 0;
		for (int i = 0; i < computer.length; i ++)    
			b += ball_2(i, computer, user);   // �޼��� ball�� �Ű����� computer, user�� �޼��� ball_2�� �Ű������� �޴´�. / ���� ���� ����
		return b;                             // �� �Ǻ��� ���ִ� ball_2 �޼��带 ȣ���ؼ� ���ϰ��� ���� b�� ����  / computer.length��ŭ ȣ��
	}
	
	static int ball_2(int i, char[] computer, char[] user) {
		int b = 0;
		for (int j = 0; j < user.length; j++)
			if (computer[i] == user[j] && i != j)   // ���ڴ� ������ �ڸ����� �޶������ ��
				b++;
		return b;   // ���� ���� ������ 0�� ����
	}
	
	// ��� �޼���
	static void result(int s, int b) {   // ��Ʈ����ũ ������ ���� ������ �Ű������� �޴´�.
		if (s > 0)
			System.out.print(s + "��Ʈ����ũ ");
		if (b > 0)
			System.out.print(b + "��");
		if (s + b == 0)
			System.out.print("����");
		System.out.println();
	}
	
	// �� �Ǻ� �޼��� (���� for��)
	/*static int ball(char[] com, char[] user) {   // ��ǻ�� ���ڿ� ���� ���ڷ� �̷���� char�迭�� �Ű������� �޴´�.
	int b = 0;
	for (int i = 0; i < com.length; i++) {
		for (int j = 0; j < user.length; j++) {
			if (com[i] == user[j] && i != j)   // ���ڴ� ������ �ڸ����� �޶������ ��
				b++;
		}
	}
	return b;   // �� ������ ����
}*/
}
