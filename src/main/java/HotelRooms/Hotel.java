package HotelRooms;

import java.util.LinkedList;
import java.util.List;

public class Hotel {
    List<Room> rooms = new LinkedList<>();

    public Hotel(List<Room> rooms) {
        rooms.add(new Room(1,1, false, false));
        rooms.add(new Room(2,1, false, false));
        rooms.add(new Room(3,1, true, false));
        rooms.add(new Room(4,1, true, false));
        rooms.add(new Room(5,1, true, false));
        rooms.add(new Room(6,2, false, false));
        rooms.add(new Room(7,2, false, false));
        rooms.add(new Room(8,2, true, true));
        rooms.add(new Room(9,2, true, true));
        rooms.add(new Room(10,2, true, true));
        rooms.add(new Room(11,3, false, true));
        rooms.add(new Room(12,3, false, true));
        rooms.add(new Room(13,3, true, true));
        rooms.add(new Room(14,3, true, true));
        rooms.add(new Room(15,3, true, true));

    }


}
