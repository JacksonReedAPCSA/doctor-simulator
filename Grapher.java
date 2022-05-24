import java.util.ArrayList;

/** 
 * DRAWS AN ARRAYLIST INTO A LINE GRAPH USING window.java
 * @author Andrei
*/
public class Grapher {

    public static final int TEMP = 0;
    public static final int BPM = 1;
    private final double xLBOUND;
    private final double xUBOUND;
    private final double yLBOUND;
    private final double yUBOUND;
    private double deathLBOUND;
    private double deathUBOUND;
    private ArrayList<Integer> data = new ArrayList<Integer>();
    private Draw window;

    public Grapher(ArrayList<Integer> vals, int type) {
        window = new Draw();
        for (int i = 0; i < vals.size(); i++) {
            data.add(vals.get(i));
        }
        if (type == TEMP) {
            yLBOUND = 34.0 - 20;
            yUBOUND = 44.0 + 20;
            deathLBOUND = 34.0;
            deathUBOUND = 44.0;
        } else {
            yLBOUND = 40.0 - 20;
            yUBOUND = 160.0 + 20;
            deathLBOUND = 40.0;
            deathUBOUND = 160.0;
        }
        xLBOUND = -0.1 * data.size();
        xUBOUND = 1.1 * data.size();
    }

    public void drawGraph() {
        window.setXscale(xLBOUND, xUBOUND);
        window.setYscale(yLBOUND, yUBOUND);
        window.setPenColor(Draw.BLACK);
        window.setPenRadius(0.01);
        window.line(0, deathLBOUND - 10, 0, deathUBOUND + 10);
        window.line(0, deathLBOUND - 10, data.size(), deathLBOUND - 10);
        window.setPenColor(Draw.RED);
        window.line(0, deathLBOUND, data.size(), deathLBOUND);
        window.line(0, deathUBOUND, data.size(), deathUBOUND);
        window.setPenColor(Draw.GREEN);
        for (int i = 0; i < data.size() - 2; i++) {
            window.line(i, data.get(i), i + 1, data.get(i + 1));
        }
        for (int i = 0; i < data.size(); i++) {
            window.setPenColor(Draw.RED);
            window.filledCircle(i, data.get(i), xUBOUND/50);
        }
        window.setPenColor(Draw.RED);
        window.line(data.size() - 2, data.get(data.size() - 2), data.size() - 1, data.get(data.size() - 1));
        if (deathLBOUND == 34.0) {
            window.text(0.5, yUBOUND - 5, "TEMP");
        } else {
            window.text(0.5, yUBOUND - 5, "BPM");
        }
        window.text(-0.9, deathUBOUND, "" + deathUBOUND);
        window.text(-0.9, deathLBOUND, "" + deathLBOUND);
        for (int i = 0; i < data.size(); i++) {
            window.text(i, (yLBOUND + deathLBOUND - 10) / 2, "" + i);
        }
    }
}
