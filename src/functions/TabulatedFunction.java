package functions;

public class TabulatedFunction {
    private FunctionPoint[] points;
    private int countPoints;

    public TabulatedFunction(double leftX, double rightX, int pointsCount){
        points = new FunctionPoint[pointsCount];
        double interval = (rightX - leftX)/(pointsCount - 1);
        for (int i = 0; i < pointsCount; ++i) {
            points[i].x = leftX + i * interval;
            points[i].y = 0;
        }
    }

    public TabulatedFunction(double leftX, double rightX, double[] values){
        points = new FunctionPoint[values.length];
        double interval = (rightX - leftX)/(values.length - 1);
        for (int i = 0; i < values.length; ++i) {
            points[i].x = leftX + i * interval;
            points[i].y = values[i];
        }
    }

    public double getLeftDomainBorder(){ return this.points[0].x;}
    public double getRightDomainBorder(){ return this.points[points.length - 1].x;}
    public double getFunctionValue(double x){
        if ((x < points[0].x) || (x > points[points.length - 1].x)){ return Double.NaN;}
        double interval = points[1].x - points[0].x;
        int index = (int) ((x - points[0].x) / interval); // Индекс левой точки, нашего интервала
        return (points[index + 1].y - points[index].y)*x/interval;
    }

    public int getPointsCount(){ return points.length;}
    public FunctionPoint getPoint(int index){return points[index]; }
    public void setPoint(int index, FunctionPoint point){
        if ( !((index == 0) || (index == points.length - 1)) ){
            if ( (point.x > points[index - 1].x) && (point.x < points[index + 1].x) ){
                points[index] = point;
            }
        }
    }

    public double getPointX(int index){ return points[index].x;}
    public void setPointX(int index, double x){
        if ( !((index == 0) || (index == points.length - 1)) ){
            if ( (x > points[index - 1].x) && (x < points[index + 1].x) ){
                points[index].x = x;
            }
        }
    }

    public double getPointY(int index){ return points[index].y;}
    public void setPointY(int index, double y){ points[index].y = y; }

    public void deletePoint(int index){

    }

    public void addPoint(FunctionPoint point){


    }

}