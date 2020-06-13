package dennis.calendar.comlete;

import java.util.Scanner;

public class Prompt_complete {

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar_complete cal = new Calendar_complete();
		
		int month = 1;
		int year = 2020;
		
		while(true) {
			System.out.println("년도를 입력하세요(exit : -1).");
			System.out.print("YEAR> ");
			year = sc.nextInt();
			if(year == -1) {
				break;
			}
			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			month = sc.nextInt();
			
			if(month > 12 || month < 1) {
				System.err.println("잘못된 입력입니다.");
				continue;
			}
			
			cal.printCalendar(year, month);
			System.out.println();
		}
		
		System.out.println("Bye~");
		sc.close();
	}
	
	public static void main(String[] args) {
		
		// 셀 실행
		Prompt_complete p = new Prompt_complete();
		p.runPrompt();
			
	}
}
