package HotelRooms;


import UserMenu.UserSubMenu;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelService {


    private static List<Room> rooms = new LinkedList<>();// not sure if it`s done correctly but i found no other way around
    private static Hotel myHotel = new Hotel(rooms);

    public void displayAllRooms() {

        for (Room r : rooms
        ) {
            System.out.println("Room Number: " + r.roomNo +
                    ", Capacity: " + r.capacity +
                    ", BathRoom: " + booleanTranslate(r.isThereBathRoom) +
                    ", Vacant: " + booleanTranslate(r.isVacant));
        }
    }

    public void displayVacantRooms() {
        List<Room> vacantRooms = rooms.stream()
                .filter(room -> room.isVacant == true)
                .collect(Collectors.toList());
        for (Room r : vacantRooms
        ) {
            System.out.println("Room Number: " + r.roomNo +
                    ", Capacity: " + r.capacity +
                    ", BathRoom: " + booleanTranslate(r.isThereBathRoom) +
                    ", Vacant: " + booleanTranslate(r.isVacant));
        }
    }


    public static String booleanTranslate(boolean value) {
        String result;
        if (value) {
            result = "Y";
        } else {
            result = "N";
        }
        return result;
    }

    public Room selectRoom(int input) {
        List<Room> streamRoom = rooms.stream()
                .filter(room -> room.roomNo == input)
                .collect(Collectors.toList());
        return streamRoom.get(0);

    }

    public void roomCheckin(Room selectedRoom, int actionType) {
        UserSubMenu userSubMenu = new UserSubMenu();
        if (isRoomVacant(selectedRoom) == true) {
            System.out.println("Room " + selectedRoom.roomNo + " reserved");
            selectedRoom.setVacant(false);
userSubMenu.run(actionType);
        } else {
            System.out.println("This room already has tenants, please choose another one");

        }
    }

    public void roomCheckout (Room selectedRoom, int actionType) {
        UserSubMenu userSubMenu = new UserSubMenu();
        if (isRoomVacant(selectedRoom) == false) {
            System.out.println("Room " + selectedRoom.roomNo + " released");
            selectedRoom.setVacant(true);
            userSubMenu.run(actionType);
        } else {
            System.out.println("This room is already vacant, going back to main menu");

        }
    }

    private boolean isRoomVacant(Room selectedRoom) {
        return selectedRoom.isVacant;
    }

}

