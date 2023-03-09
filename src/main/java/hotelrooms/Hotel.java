package hotelrooms;

import guest.Guest;

import java.util.LinkedList;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new LinkedList<>();
    private List<Guest> guests = new LinkedList<>();

    public Hotel() {
        rooms.add(new Room(1, 1, false, false, guests));
        rooms.add(new Room(2, 1, false, false, guests));
        rooms.add(new Room(3, 1, true, false, guests));
        rooms.add(new Room(4, 1, true, false, guests));
        rooms.add(new Room(5, 1, true, false, guests));
        rooms.add(new Room(6, 2, false, false, guests));
        rooms.add(new Room(7, 2, false, false, guests));
        rooms.add(new Room(8, 2, true, true, guests));
        rooms.add(new Room(9, 2, true, true, guests));
        rooms.add(new Room(10, 2, true, true, guests));
        rooms.add(new Room(11, 3, false, true, guests));
        rooms.add(new Room(12, 3, false, true, guests));
        rooms.add(new Room(13, 3, true, true, guests));
        rooms.add(new Room(14, 3, true, true, guests));
        rooms.add(new Room(15, 3, true, true, guests));
        rooms.add(new Room(16, 3, true, true, guests));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public Room selectRoom(int input) {
        return rooms.stream()
                .filter(room -> room.getRoomNo() == input)
                .findFirst()
                .orElseThrow(() ->  new HotelServiceException("There is no such room, please choose one of the rooms from the list"));
    }
}
