import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Helper class to store check-in details for a customer
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Helper class to store aggregated trip metrics between two stations
    private static class RouteInfo {
        double totalTime;
        int tripCount;

        RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    // Map: customer id -> check-in details
    private Map<Integer, CheckInInfo> checkInMap;
    // Map: "startStation->endStation" -> accumulated trip stats
    private Map<String, RouteInfo> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove check-in record for this customer
        CheckInInfo checkIn = checkInMap.remove(id);
        
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.time;

        // Update total time and count for this route
        RouteInfo route = routeMap.getOrDefault(routeKey, new RouteInfo(0, 0));
        route.totalTime += travelTime;
        route.tripCount += 1;
        
        routeMap.put(routeKey, route);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeMap.get(routeKey);
        return route.totalTime / route.tripCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
