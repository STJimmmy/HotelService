import HotelRooms.Hotel;
import HotelRooms.Room;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

    List<Room> rooms = new LinkedList<>();// not sure if it`s done correctly but i found no other way around
    Hotel myHotel = new Hotel(rooms);

    public static void main(String[] args) {

        Test test = new Test();
        test.showRooms();
test.selectRoom(1);
    }


    public void showRooms() {
        for (Room r:rooms
             )

            {
                System.out.println("Room Number: " + r.roomNo +
                        ", Capacity: " + r.capacity +
                        ", BathRoom: " + r.isThereBathRoom+
                        ", Vacant: " +  r.isVacant);
        }

    }

   public void selectRoom(int userInput) {
       List<Room> streamRoom = rooms.stream()
                       .filter(room -> room.roomNo == userInput)
               .collect(Collectors.toList());
       Room selectedRoom = streamRoom.get(0);
       selectedRoom.setVacant(true);
       System.out.println(streamRoom.toString());

}




       public void reserveRoom(List streamRoom){
           System.out.println(streamRoom.toString());

       }
   }










