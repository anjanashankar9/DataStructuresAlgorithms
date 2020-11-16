import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-28
 */

enum Granularity {
    MINUTE,
    HOUR,
    DAY
}

/**
 * Assumptions:
 * 1. Data is small enough to fit into memory.
 */

public class EventCounter {

    Map<String, Map<LocalDateTime, Integer>> minuteCountMap = new HashMap<>();
    Map<String, Map<LocalDateTime, Integer>> hourCountMap = new HashMap<>();
    Map<String, Map<LocalDateTime, Integer>> dayCountMap = new HashMap<>();

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        EventCounter ec = new EventCounter();
        // Click - 28 August 2020 17:18:08
        ec.insertEvent("click", 1598635088L);
        // Click - 28 August 2020 17:18:15
        ec.insertEvent("click", 1598635095L);
        // Click - 28 August 2020 17:19:15
        ec.insertEvent("click", 1598635155L);
        // Click - 28 August 2020 18:19:15
        ec.insertEvent("click", 1598638755L);
        // Click - 28 August 2020 20:19:20
        ec.insertEvent("click", 1598645960L);
        // Click - 29 August 2020 20:19:20
        ec.insertEvent("click", 1598732360L);

        String str = "2020-08-28 17:18";
        LocalDateTime st = LocalDateTime.parse(str, formatter);
        str = "2020-08-28 17:23";
        LocalDateTime et = LocalDateTime.parse(str, formatter);
        ArrayList<String> res = ec.queryCount("click", st, et, Granularity.MINUTE);
        printResult(res);

    }

    private static void printResult(ArrayList<String>res) {
        for (String s: res) {
            System.out.println(s);
        }
    }

    /**
     * Processes an incoming event. Increments the respective count.
     * @param eventName
     * @param epochTimeStamp
     */
    public void insertEvent(String eventName, long epochTimeStamp ) {
        LocalDateTime dateTime = Instant.ofEpochSecond(epochTimeStamp)
                .atOffset(ZoneOffset.UTC)
                .toLocalDateTime();
        System.out.println(dateTime);

        LocalDateTime minute = dateTime.withSecond(0);
        LocalDateTime hour = dateTime.withMinute(0).withSecond(0);
        LocalDateTime day = dateTime.withHour(0).withMinute(0).withSecond(0);

        updateMap(minuteCountMap, eventName, minute);
        updateMap(hourCountMap, eventName, hour);
        updateMap(dayCountMap, eventName, day);

    }

    /**
     * Helper function to update counts in the map
     * @param mapToUpdate
     * @param eventName
     * @param dateTime
     */
    private void updateMap(Map<String, Map<LocalDateTime, Integer>> mapToUpdate,
                           String eventName, LocalDateTime dateTime) {

        if(!mapToUpdate.containsKey(eventName)) {
            Map<LocalDateTime, Integer> tempMap = new HashMap<>();
            mapToUpdate.put(eventName, tempMap);
        }

        Map<LocalDateTime,Integer> tempEventMap = mapToUpdate.get(eventName);

        if(!tempEventMap.containsKey(dateTime)) {
            tempEventMap.put(dateTime, 0);
        }
        tempEventMap.put(dateTime, tempEventMap.get(dateTime)+1);
    }

    /**
     * QueryCount function - Returns an arraylist of formatted timestamp with their count
     * Sample:
        2020-08-28T17:18-2020-08-28T17:19 : 2
        2020-08-28T17:19-2020-08-28T17:20 : 1
        2020-08-28T17:20-2020-08-28T17:21 : 0
        2020-08-28T17:21-2020-08-28T17:22 : 0
        2020-08-28T17:22-2020-08-28T17:23 : 0
     * @param eventName Name of event to be queried
     * @param startTime startTime in LocalDateTime format
     * @param endTime endTime in LocalDateTime format
     * @param granularity Granularity.
     * @return ArrayList
     */
    public ArrayList<String> queryCount(String eventName,
        LocalDateTime startTime, LocalDateTime endTime, Granularity granularity) {

        LocalDateTime st;
        LocalDateTime et;

        switch(granularity) {
            case MINUTE:
                st = startTime.withSecond(0);
                et = endTime.withSecond(0);
                return resultQueryCount(st, et, minuteCountMap.get(eventName), granularity);


            case HOUR:
                st = startTime.withMinute(0).withSecond(0);
                et = endTime.withMinute(0).withSecond(0);
                return resultQueryCount(st, et, hourCountMap.get(eventName), granularity);

            case DAY:
                st = startTime.withMinute(0).withHour(0).withSecond(0);
                et = endTime.withMinute(0).withHour(0).withSecond(0);
                return resultQueryCount(st, et, dayCountMap.get(eventName), granularity);
        }
        return null;
    }

    /**
     * Helper function for queryCount
     * @param startTime
     * @param endTime
     * @param localDateTimeIntegerMap
     * @param granularity
     * @return
     */
    private ArrayList<String> resultQueryCount(
        LocalDateTime startTime, LocalDateTime endTime,
        Map<LocalDateTime, Integer> localDateTimeIntegerMap, Granularity granularity) {

        ArrayList<String> result = new ArrayList<>();

        LocalDateTime ldt = startTime ;
        while (ldt.isBefore( endTime )) {
            StringBuffer s = new StringBuffer();
            s.append(ldt);
            s.append("-");

            Integer count = localDateTimeIntegerMap.get(ldt);
            switch (granularity) {
                case DAY:
                    ldt = ldt.plusDays(1L);
                    break;

                case MINUTE:
                    ldt = ldt.plusMinutes(1L);
                    break;

                case HOUR:
                    ldt = ldt.plusHours( 1 ) ;
                    break;
            }

            s.append(ldt);
            s.append(" : ");
            s.append(count != null ? count : 0);
            result.add(s.toString());
        }
        return result;
    }


}
