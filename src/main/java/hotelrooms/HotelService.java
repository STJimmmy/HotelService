package hotelrooms;


import guest.Guest;

import java.util.List;

//nie ma żadnych wyświetleń ani scannera - jest niezależna od frontendu - sposobu interakcji z aplikacja
public class HotelService {
    private final List<Room> rooms;

    private final Hotel hotel = new Hotel();

    public HotelService() {// constructor to check when hotelservice instance is created
        //System.out.println("create HotelService");
        rooms = hotel.getRooms();
    }


    public void register(int roomNr, List<Guest> guests) {
        Room room = hotel.selectRoom(roomNr);
        if (!room.isVacant()) {
            throw new HotelServiceException("This room already has tenants, please choose another one");
        }

        guests.stream()
                .filter(guest -> guest.getAge() >= 18)
                .findFirst()
                .orElseThrow(() -> new HotelServiceException("There is no adult person in guests list"));

        room.setVacant(false);
    }

    public void unregister(int roomNr) {
        Room room = hotel.selectRoom(roomNr);
        if (room.isVacant()) {
            throw new HotelServiceException("This room is already vacant, going back to main menu");
        }
        room.setVacant(true);
    }
    

    public List<Room> getVacantRooms() {
        return rooms.stream()
                .filter(room -> room.isVacant())
                .toList();
    }

    public int getHotelSize() {
        return rooms.size();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void validateRoomNumber(int roomNumber) {
        hotel.selectRoom(roomNumber); //will throw exception if not valid
    }
}

