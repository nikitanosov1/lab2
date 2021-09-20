import functions.TabulatedFunction;

public class Main {
    public static void main(String[] args){
        final int countPoints = 5;
        final double left = 0.0;
        final double right = 10.0;

        TabulatedFunction graph;
        graph = new TabulatedFunction(left, right, countPoints);

        for (int i = 0; i < countPoints; ++i){
            graph.setPointY(i, - (graph.getPointX(i) - 4)*(graph.getPointX(i) - 4) + 5);
        }


        for (int i = 0; i < countPoints; ++i){
            System.out.print("x value: ");
            System.out.print(graph.getPointX(i));
            System.out.print("            y value: ");
            System.out.println(graph.getPointY(i));
        }

        final int countPointsForTest = 10;
        final double interval = (right - left)/(countPointsForTest - 1);
        for (int i = 0; i < countPointsForTest; ++i){
            System.out.print("x value: ");
            System.out.print(left + i * interval);
            System.out.print("           y value: ");
            System.out.println(graph.getFunctionValue(left + i * interval));
        }

    }
}
