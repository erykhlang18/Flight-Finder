import java.util.List;


public class PathClass implements PathInterface {

    private final List<String> route;
    private final List<Double> milesSegment;
    private final double totalMiles;

    /**
     * @param route
     * @param milesSegment
     * @param totalMiles
     */
    public PathClass(List<String> route, List<Double> milesSegment, double totalMiles){
        this.route = route;
        this.milesSegment = milesSegment;
        this.totalMiles = totalMiles;
    }

    @Override
    public List<String> getRoute() {
        // TODO Auto-generated method stub
        return route;
    }

    @Override
    public List<Double> getMilesSegment() {
        // TODO Auto-generated method stub
        return milesSegment;    
    }

    @Override
    public Double getTotalMiles() {
        // TODO Auto-generated method stub
        return totalMiles;
    }
    
}
