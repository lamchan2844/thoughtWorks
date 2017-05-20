import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        String[] arr = bowlingCode.split("\\|");
        String[] extraArr = bowlingCode.split("\\|\\|");

        Vector<grid> vectGrid = new Vector<grid>();
        for (int i = 0; i < 10; i++) {
            vectGrid.addElement(new grid(arr[i]));
        }

        Vector<Integer> SingleHitSocre = new Vector<Integer>();
        for (Iterator<grid> it = vectGrid.iterator(); it.hasNext(); ) {
            grid iterGrid = (grid) it.next();
            SingleHitSocre.addElement(iterGrid.getFirstHit());
            if (iterGrid.getSecondHit() != -1) {
                SingleHitSocre.addElement(iterGrid.getSecondHit());

            }
        }
        if (extraArr.length == 2) {
            String extra = extraArr[1];
            int tt = 0;
            for (int j = 0; j < extra.length(); j++) {

                String subStr = extra.substring(j, j + 1);
                if (subStr.equals("X")) {
                    tt = 10;
                } else if (subStr.equals("-")) {
                    tt = 0;
                } else {
                    tt = Integer.parseInt(subStr);
                }
                SingleHitSocre.addElement(tt);
            }
        }

        int[] Score = new int[10];
        int offset = 0;
        int currentPos = 0;
        int i = 0;
        for (i = 0; i < 10; i++) {
            grid thisGrid = vectGrid.elementAt(i);
            Score[i] = thisGrid.getBaseScore();
            if (thisGrid.getFirstHit() == 10) {
                currentPos++;
                int residue = 2;
                while (residue != 0) {
                    Score[i] += SingleHitSocre.elementAt(currentPos + offset);
                    offset++;
                    residue--;
                }
                offset = 0;
            } else if (thisGrid.getBaseScore() == 10) {
                currentPos += 2;
                int residue = 1;
                while (residue != 0) {
                    Score[i] += SingleHitSocre.elementAt(currentPos + offset);
                    offset++;
                    residue--;
                }
                offset = 0;
            } else {
                currentPos += 2;
            }
        }
        int ret = 0;
        for (i = 0; i < 10; i++) {
            ret += Score[i];
        }
        return ret;
    }

}
