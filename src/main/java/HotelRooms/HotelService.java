package HotelRooms;


import UserMenu.UserSubMenu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HotelService {


    private final List<Room> rooms;
    private final Hotel hotel = new Hotel();
    public HotelService() {
        System.out.println("create HotelService");
        rooms = hotel.getRooms();
    }

    public void displayAllRooms() {
        //iter
        for (Room room : rooms) {
            System.out.println("Room Number: " + room.roomNo +
                    ", Capacity: " + room.capacity +
                    ", BathRoom: " + booleanTranslate(room.isThereBathRoom) +
                    ", Vacant: " + booleanTranslate(room.isVacant));
        }
    }

    public void displayVacantRooms() {
    /*    List<Room> collect = rooms.stream()
                .collect(Collectors.toList());

        List<Room> myList = new ArrayList<>(collect);*/

        rooms.stream()
                .filter( room -> room.isVacant == true)
                .forEach(room ->  System.out.println("Room Number: " + room.roomNo +
                        ", Capacity: " + room.capacity +
                        ", BathRoom: " + booleanTranslate(room.isThereBathRoom) +
                        ", Vacant: " + booleanTranslate(room.isVacant)));
    }


    public String booleanTranslate(boolean value) {
     /*   String result;
        if (value) {
            result = "Y";
        } else {
            result = "N";
        }
        return result;*/
        return value ? "Y" : "N";
    }

    public Room selectRoom(int input) {
        return rooms.stream()
                .filter(room -> room.roomNo == input)
                .findFirst()
                .orElse(null);
    }

    public void roomCheckin(Room selectedRoom) {
        if (isRoomVacant(selectedRoom) == true) {
            System.out.println("Room " + selectedRoom.roomNo + " reserved");
            selectedRoom.setVacant(false);
        } else {
            System.out.println("This room already has tenants, please choose another one");
        }
    }

    public void roomCheckout(Room selectedRoom, int actionType) {
        UserSubMenu userSubMenu = new UserSubMenu(this);
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

    public int getHotelSize() {
        return rooms.size();
    }

}

