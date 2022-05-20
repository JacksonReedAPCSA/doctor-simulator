import java.util.ArrayList;

/**
 * FOR TESTING Grapher.java
 */

public class showGraph {
    public static void main(String[] args){
        ArrayList<Integer> data = new ArrayList<Integer>();
        data.add(38);
        data.add(42);
        data.add(34);
        data.add(40);
        data.add(38);
        data.add(36);
        data.add(34);
        data.add(36);
        data.add(34);
        data.add(42);
        data.add(44);
        data.add(37);
        data.add(34);
        data.add(44);
        data.add(36);
        data.add(40);
        data.add(38);
        data.add(34);
        data.add(39);
        data.add(41);
        data.add(34);
        data.add(37);
        data.add(48);
        Grapher graph = new Grapher(data, 0);
        graph.drawGraph();
    }
}
