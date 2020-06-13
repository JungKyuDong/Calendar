package dennis.calendar.comlete;

import java.util.Scanner;

public class Prompt_complete {

	public int parseDay(String week)	{
		if(week.equals("SU")) {
			return 0;
		}
		
		else if(week.equals("MO")) {
			return 1;
		}
		else if(week.equals("TU")) {
			return 2;
		}
		else if(week.equals("WE")) {
			return 3;
		}
		else if(week.equals("TH")) {
			return 4;
		}
		else if(week.equals("FR")) {
			return 5;
		}
		else if(week.equals("SA")) {
			return 6;
		}
		else
			return 0;
	}
	
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
