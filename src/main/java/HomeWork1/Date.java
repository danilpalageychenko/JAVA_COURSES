package HomeWork1;

/**
 * Created by gaara on 11.07.16.
 */

public class Date {
    private int day;
    private int month;
    private int year;

    private static class Year
    {

        public static boolean isLeap(int year)
        {
            if ((year%4 == 0 && year%100 != 0) || (year%400 == 0))
                return true;
            else
                return false;
        }

    }
    private static class Month
    {

        public static int getDaysCount(int month,int year)
        {
            final int days[] = {31,28,31,30,31,30,31,31,30,31,30,31 };
            if (month == 1)
            {
                if (Year.isLeap(year))
                    return days[month] + 1;
                else
                    return days[month];
            } else {
                return days[month];
            }

        }
    }

    private enum DayOfWeek{
        MONDAY(0),TUESDAY(1),WEDNESDAY(2),THURSDAY(3),FRIDAY(4),SATURDAY(5),SUNDAY(6);

        private final int num;
        DayOfWeek(int num)
        {
            this.num = num;
        }
        static public DayOfWeek valueOf(int num)
        {
            switch (num) {
                case 0:
                    return MONDAY;
                case 1:
                    return TUESDAY;
                case 2:
                    return WEDNESDAY;
                case 3:
                    return THURSDAY;
                case 4:
                    return FRIDAY;
                case 5:
                    return SATURDAY;
                case 6:
                    return SUNDAY;
                default: return MONDAY;
            }
        }
    }

    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDate(int day,int month,int year)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public DayOfWeek getDayOfWeek()
    {
        return DayOfWeek.valueOf((day+year+(year/4)-(year/100)+(year/400)+(31*month)/12) % 7);
    }

    public int getDayOfYear()
    {
        int dayofyear = 0;

        for (int i = 0;i < month-1;i++)
        {
            dayofyear += Month.getDaysCount(i,year);
        }

        return dayofyear + day;
    }
    public int daysBetween(Date date)
    {
        int betweenYears = Math.abs(getYear() - date.getYear());
        int betweenMonths = Math.abs(getMonth() - date.getMonth());
        int betweenDays = Math.abs(getDay() - date.getDay());

        return (betweenYears / 4) + betweenYears * 365 + betweenMonths * Month.getDaysCount(betweenMonths,betweenYears) + betweenDays;
    }
    public boolean isLeap()
    {
        return Year.isLeap(year);
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day)
    {
        if (day < 0)
            this.day = 0;
        else if(day > 31)
            this.day = 31;
        else
            this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month)
    {
        if(month <= 0)
            this.month = 1;
        else if(month > 12)
            this.month = 12;
        else
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year)
    {

        if(year < 0)
            this.year = 0;
        else
        this.year = year;
    }




}
