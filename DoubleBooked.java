package coding.exercises;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 329877575 on 2018/09/10.
 */
public class DoubleBooked {
    //Event Object
    private static class Event {
        private String eventName;
        private Date eventDate;
        private Time eventStart;
        private Time eventEnd;

        private Event(String eventNameC, Date eventDateC, Time eventStartC, Time eventEndC) {
            eventName = eventNameC;
            eventDate = eventDateC;
            eventStart = eventStartC;
            eventEnd = eventEndC;
        }

        private String getEventName() {
            return eventName;
        }

        private Date getEventDate() {
            return eventDate;
        }

        private Time getEventStart() {
            return eventStart;
        }

        private Time getEventEnd() {
            return eventEnd;
        }

    }

    //Instruction to run
    //Run main as is, you may change test data if neede be
    public static void main(String[] args) throws Exception {
        //Assumptions
        //End time will always be greater than the start time for each event
        //Format for Day is dd/MM/YYYY
        //Format for Time is hh:mm
        //Test data will not be asked from the users instead hard coded in the main method


        //Initialize Test Data
        List<Event> events = new ArrayList<Event>();

        //will not overlap - event 2 end time equal to event 1 start time
        events.add(new Event("Original Event 24/11/2009", convertStringToDate("24/11/2009"), convertStringToTime("17:30"), convertStringToTime("18:30")));
        events.add(new Event(" event 2 end time equal to event 1 start time", convertStringToDate("24/11/2009"), convertStringToTime("16:59"), convertStringToTime("17:30")));

        //will not overlap - event 2 ends 1 minute before event 1 start time
        events.add(new Event("Original Event 25/11/2009", convertStringToDate("25/11/2009"), convertStringToTime("17:30"), convertStringToTime("18:30")));
        events.add(new Event("Event ends 1 minute before Event Orig Start Time", convertStringToDate("25/11/2009"), convertStringToTime("16:59"), convertStringToTime("17:29")));

        //will overlap - event 2 ends 1 minute after event 1 start time
        events.add(new Event("Original Event 26/11/2009", convertStringToDate("26/11/2009"), convertStringToTime("17:30"), convertStringToTime("18:30")));
        events.add(new Event("Event ends 1 minute after Event Orig Start Time", convertStringToDate("26/11/2009"), convertStringToTime("16:30"), convertStringToTime("17:31")));

        //will overlap - Event 2 starts 1 minute after Event Orig Start Time
        events.add(new Event("Original Event 27/11/2009", convertStringToDate("27/11/2009"), convertStringToTime("17:30"), convertStringToTime("18:30")));
        events.add(new Event("Event 2 starts 1 minute after Event Orig Start Time", convertStringToDate("27/11/2009"), convertStringToTime("17:31"), convertStringToTime("19:30")));

        //will overlap - Event 2 starts the same time with Event Orig Start Time and ends after Event Orig Ends Time
        events.add(new Event("Original Event 28/11/2009", convertStringToDate("28/11/2009"), convertStringToTime("17:30"), convertStringToTime("18:30")));
        events.add(new Event("Event 2 starts 1 minute after Event Orig Start Time", convertStringToDate("28/11/2009"), convertStringToTime("17:30"), convertStringToTime("19:30")));


        //multiple overlaps
        events.add(new Event("Original Event 30/11/2009", convertStringToDate("30/11/2009"), convertStringToTime("17:30"), convertStringToTime("18:30")));
        events.add(new Event("Event ends 1 minute after Event Orig Start Time", convertStringToDate("30/11/2009"), convertStringToTime("16:59"), convertStringToTime("17:31")));
        events.add(new Event("Event starts 1 minute after Event Orig Start Time", convertStringToDate("30/11/2009"), convertStringToTime("17:31"), convertStringToTime("19:30")));
        events.add(new Event("Event starts 1 minute before Event Orig Start Time but ends within Event Orig Start and End Time", convertStringToDate("30/11/2009"), convertStringToTime("17:29"), convertStringToTime("19:30")));
        checkDoubleBooking(events);


    }

    //Checks doubleBooking based on input
    private static void checkDoubleBooking(List<Event> events) {
        //Loop through all events
        for (int i = 0; i < events.size(); i++) {
            //Loop through succeeding events
            for (int x = i + 1; x < events.size(); x++) {
                //Checks whether dates are the same
                if (events.get(i).getEventDate().equals(events.get(x).getEventDate())) {
                    //Checks for the condition where (E1 start < E2 end AND E1 start > E2 start ) OR
                    //(E1 end > E2 start AND E1 end < E2 end)
                    if ((events.get(i).getEventStart().getTime() < events.get(x).getEventEnd().getTime() && events.get(i).getEventStart().getTime() > events.get(x).getEventStart().getTime())
                            || (events.get(i).getEventEnd().getTime() > events.get(x).getEventStart().getTime() && events.get(i).getEventEnd().getTime() < events.get(x).getEventEnd().getTime())) {
                        System.out.println("***********************************************************************");
                        System.out.println("Overlapping events detected");
                        System.out.println("Event Name 1: " + events.get(i).getEventName());
                        System.out.println("Event Date 1: " + events.get(i).getEventDate());
                        System.out.println("Event Start Time 1: " + events.get(i).getEventStart());
                        System.out.println("Event End Time 1: " + events.get(i).getEventEnd());
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("Event Name 2: " + events.get(x).getEventName());
                        System.out.println("Event Date 2: " + events.get(x).getEventDate());
                        System.out.println("Event Start Time 2: " + events.get(x).getEventStart());
                        System.out.println("Event End Time 2: " + events.get(x).getEventEnd());

                    }

                }
            }
        }
    }

    //Converts string to date
    private static Date convertStringToDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (Exception e) {
            System.out.println("Error converting string to Date" + e);
            return null;
        }
    }
    //Converts string to time
    private static Time convertStringToTime(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm");
            Date d1 = (Date) format.parse(time);

            return new java.sql.Time(d1.getTime());
        } catch (Exception e) {
            System.out.println("Error " + e);
            return null;
        }
    }
}
