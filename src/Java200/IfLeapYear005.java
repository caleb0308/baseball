package Java200;

public class IfLeapYear005 {

	public static void main(String[] args) {
		// 윤년의 조건
		// 연수가 4로 나누어 떨어지는 해는 윤년으로 한다.(1988년, 1992년, 1996년, 2004년, 2008년, 2012년 …)
		// 4로 나누어 떨어지는 해 중에서도 100으로 나누어떨어지는 해는 평년으로 한다.(1900년, 2100년, 2200년, 2300년, 2500년 …)
		// 그중에 400으로 나누어떨어지는 해는 윤년으로 둔다.(1600년, 2000년, 2400년 …)
		// 4로 나누어 떨어지고, 100으로 나누어 떨어지지 않는 수 or 4로 나누어 떨어지고, 400으로도 나누어 떨어지는 수.
		// 위 둘의 조건에서 한가지만 만족하면 윤년이다. 
		 
		// 1998년부터 2018년까지 각 연도를 윤년과 윤년이 아닌 해를 구분하는 코드
		for(int year = 1998; year<2019; year++) {
			boolean yearTF = false;
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {   // 400으로 나누어떨어지는 수는 4로도 무조건 나누어 떨어진다. 
				yearTF = true;
			}
			else {
				yearTF = false;
			}
			
			if(yearTF) {
				System.out.println(year + "는 윤년입니다.");
			}
			else {
				System.out.println(year + "는 윤년이 아닙니다.");
			}
		}
	}
}
