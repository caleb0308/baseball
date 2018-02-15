package CodeSquad;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class BaseballGame {

	public static void main(String[] args) {
		char[] com = computer();
//		System.out.println(com);   // 랜덤 숫자가 제대로 생성됐는지 확인
		
		while (true) {
			char[] user = user();   // 유저의 숫자를 저장할 변수
			int s  = strike(com, user);   // 스트라이크 와 볼의 갯수를 저장할 변수
			int b = ball(com, user);
			result(s, b);   // 스트라이크와 볼의 갯수를 인자로 받아서 결과를 리턴
			
			if (s == 3)   // 스트라이크가 3개일 경우, while문을 벗어남
				break;		
		}
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	// 컴퓨터 랜덤 숫자 메서드
	static char[] computer() {
		List<String> numList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
		Collections.shuffle(numList);   // 1~9 사이의 숫자를 섞음
		String com = "";
		for (int i = 0; i < 3; i++)
			com += numList.get(i);   // 그 중 인덱스값  0, 1, 2만  문자열 변수에 저장
		char[] chCom = com.toCharArray();   // 문자열을 char[]배열로 변환
		return chCom;   // 컴퓨터 랜덤숫자(char배열)를 리턴 
	}
	
	// 유저 숫자입력 메서드
	static char[] user() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("세 숫자를 입력해주세요. ex) 123 : ");
		String user = scanner.nextLine();
		char[] chUser = user.toCharArray();   // 문자열을 char[]배열로 변환
		return chUser;   // 유저 숫자(char배열)를 리턴
	}
	
	// 스트라이크 판별 메서드
	static int strike(char[] com, char[] user) {   // 컴퓨터 숫자와 유저 숫자로 이루어진 char배열을 매개변수로 받는다.
		int s = 0;
		for (int i = 0; i < com.length; i++) {
			if (com[i] == user[i])   // 숫자와 자릿수가 같으면 스트라이크  / com과 user의 인덱스를 i로 같게 해줘서 같은 자릿수의 두 숫자를 판별
				s++;
		}
		return s;   // 스트라이크 갯수를 리턴
	}
	
	// 볼 판별 메서드 (메서드 분리)
	static int ball(char[] computer, char[] user) {   // 컴퓨터 숫자와 유저 숫자로 이루어진 char배열을 매개변수로 받는다.
		int b = 0;
		for (int i = 0; i < computer.length; i ++)    
			b += ball_2(i, computer, user);   // 메서드 ball의 매개변수 computer, user를 메서드 ball_2가 매개변수로 받는다. / 같은 값을 참조
		return b;                             // 볼 판별을 해주는 ball_2 메서드를 호출해서 리턴값을 변수 b에 저장  / computer.length만큼 호출
	}
	
	static int ball_2(int i, char[] computer, char[] user) {
		int b = 0;
		for (int j = 0; j < user.length; j++)
			if (computer[i] == user[j] && i != j)   // 숫자는 같지만 자릿수는 달라야지만 볼
				b++;
		return b;   // 만약 볼이 없으면 0을 리턴
	}
	
	// 결과 메서드
	static void result(int s, int b) {   // 스트라이크 갯수와 볼의 갯수를 매개변수로 받는다.
		if (s > 0)
			System.out.print(s + "스트라이크 ");
		if (b > 0)
			System.out.print(b + "볼");
		if (s + b == 0)
			System.out.print("낫싱");
		System.out.println();
	}
	
	// 볼 판별 메서드 (이중 for문)
	/*static int ball(char[] com, char[] user) {   // 컴퓨터 숫자와 유저 숫자로 이루어진 char배열을 매개변수로 받는다.
	int b = 0;
	for (int i = 0; i < com.length; i++) {
		for (int j = 0; j < user.length; j++) {
			if (com[i] == user[j] && i != j)   // 숫자는 같지만 자릿수는 달라야지만 볼
				b++;
		}
	}
	return b;   // 볼 갯수를 리턴
}*/
}
