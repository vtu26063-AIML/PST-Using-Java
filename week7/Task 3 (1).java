import java.util.*;

class UndergroundSystem {

    class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private Map<Integer, CheckInData> checkInMap;
    private Map<String, int[]> travelData;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelData = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkInMap.get(id);
        checkInMap.remove(id);

        String route = data.station + "->" + stationName;
        int travelTime = t - data.time;

        travelData.putIfAbsent(route, new int[2]);
        travelData.get(route)[0] += travelTime; // total time
        travelData.get(route)[1] += 1; // count
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        int[] stats = travelData.get(route);
        return (double) stats[0] / stats[1];
    }
}