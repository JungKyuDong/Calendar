package dennis.calendar.comlete;

public class Calendar_complete {

	private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,30, 31};
	private static final int[] Leap_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,30, 31}; // 윤년
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return Leap_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}
	
	public void printCalendar(int year, int month) {
		
		System.out.printf("    <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		
		// get weekday automatically
		// 둠스데이 알고리즘, 젤러 알고리즘
		int weekday = getWeekday(year, month, 1);
		
		// print black space
		for(int i = 0; i < weekday; i++) { // weekday : 0 ~ 6
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfMonth(year, month);	
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		
		// print first line
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
			System.out.println();
		
		count++;	
		
		// print from second line to last
		for(int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == delim)
				System.out.println();
		}
		System.out.println();
		System.out.println();
}

	private int getWeekday(int year, int month, int day) {
		// 1970년  1월 1일 -> 컴퓨터 하드웨어 시간의 기준 날짜
		
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970/Jan/1st = Thursday
		
		int count = 0; // 총일수 합산
		
		for(int i = syear; i < year; i++) { // 1970년은 제외 1971년부터 해당
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		for(int i = 1; i < month; i++) { // 1월은 제외 2월부터 해당
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day - 1; // 1/1은 count 1이 된다
		
		int weekday = (count + STANDARD_WEEKDAY) % 7; // 날짜에 해당되는 요일을 계산해준다
		return weekday;
	}
	
	// simple test code here
	public static void main(String[] args)	{
		Calendar_complete cal = new Calendar_complete();
		System.out.println(cal.getWeekday(1970, 1, 1) == 4);
		System.out.println(cal.getWeekday(1971, 1, 1) == 5);


	}
}
