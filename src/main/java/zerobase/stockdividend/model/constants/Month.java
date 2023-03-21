package zerobase.stockdividend.model.constants;

public enum Month {

    JAN("Jan",1),
    Feb("Feb",2),
    Mar("Mar",3),
    Apr("Apr",4),
    May("May",5),
    Jun("Jun",6),
    Jul("Jul",7),
    Aug("Aug",8),
    Sep("Sep",9),
    Oct("Oct",10),
    Nov("Nov",11),
    Dec("Dec",12);


    private String s;
    private int number;

    Month(String s, int number) {
        this.s = s;
        this.number = number;
    }

    public static int strToNumber(String s){
        for (var m : Month.values()){
            if (m.s.equals(s)){
                return m.number;
            }
        }
        return -1;
    }
}
