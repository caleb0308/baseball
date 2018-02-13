package CodeSquad;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class BaseballGame {

	public static void main(String[] args) {
		String com = computer();
		char[] chCom = com.toCharArray();
//		System.out.println(com);   // 랜덤 숫자가 제대로 생성됐는지 확인
		Scanner scanner = new Scanner(System.in);
				
		while (true) {
			System.out.print("세 숫자를 입력해주세요. ex) 123 : ");
			String user = scanner.nextLine();
			char[] chUser = user.toCharArray();
			
			int s  = strike(chCom, chUser);   // 스트라이크 와 볼의 갯수를 저장할 변수
			int b = ball(chCom, chUser);
			result(s, b);
			
			if (s == 3)
				break;		
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	// 컴퓨터 랜덤 숫자 메서드
	static String computer() {
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(numList);   // 1~9 사이의 숫자를 섞음
		String com = "";
		com += numList.get(0);   // 그 중 인덱스값  0, 1, 2만  문자열 변수에 저장
		com += numList.get(1);
		com += numList.get(2);
		return com;
	}
	
	// 스트라이크 판별 메서드
	static int strike(char[] com, char[] user) {
		int s = 0;
		for (int i = 0; i < com.length; i++) {
			if (com[i] == user[i])   // 숫자와 자릿수가 같으면 스트라이크   // com과 user의 인덱스를 i로 같게 해줘서 같은 자릿수의 두 숫자를 판별
				s++;
		}
		return s;
	}
	
	// 볼 판별 메서드
	static int ball(char[] com, char[] user) {
		int b = 0;
		for (int i = 0; i < com.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if (com[i] == user[j] && i != j)   // 숫자를 같지만 자릿수는 달라야지만 볼
					b++;
			}
		}
		return b;
	}
	
	// 결과 메서드
	static void result(int s, int b) {
		if (s > 0)
			System.out.print(s + "스트라이크 ");
		if (b > 0)
			System.out.print(b + "볼");
		if (s + b == 0)
			System.out.print("낫싱");
		System.out.println();
	}
}
