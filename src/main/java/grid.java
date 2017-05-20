/**
 * Created by Administrator on 2017/5/19.
 */
public class grid {
    private int firstHit;
    private int secondHit;
    public int baseScore;
    private String result;
    public grid(String s){
            result = s;
            if(s.length()==1 && s.charAt(0) == 'X'){
                firstHit = 10;
                secondHit = -1;
                baseScore = 10;
            }else if(s.length() == 2 && s.charAt(1) == '/'){
                firstHit = (s.charAt(0)=='-')?0:Integer.parseInt(s.substring(0,1));
                secondHit = 10 - firstHit;
                baseScore = 10;
            }else{
                firstHit = (s.charAt(0)=='-')?0:Integer.parseInt(s.substring(0,1));
                secondHit = (s.charAt(1)=='-')?0:Integer.parseInt(s.substring(1,2));
                baseScore = firstHit+secondHit;
            }
    }

    public int getFirstHit(){
        return firstHit;
    }

    public int getSecondHit() {
        return secondHit;
    }

    public int getBaseScore() {
        return baseScore;
    }
}
