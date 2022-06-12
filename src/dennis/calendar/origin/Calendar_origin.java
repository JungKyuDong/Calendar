package dennis.calendar.origin;

public class Calendar_origin {

		private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,30, 31};
		private static final int[] Leap_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,30, 31}; // 윤년
		
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
				return Leap_MAX_DAYS[month - 1];
			} else {
				return MAX_DAYS[month - 1];
			}
		}
		
		public void printCalendar(int year, int month, int weekday) {
			
			System.out.printf("    <<%4d년%3d월>>\n", year, month);
			System.out.println(" SU MO TU WE TH FR SA");
			System.out.println("--------------------");
			
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
		
	public void test_test1() {}
		
	public void test() {
		
	}
}
