package hotelrooms;

import guest.Guest;

import java.util.List;

public class Room {
    //todo set to private and use getter/setters and custom methods
    private int roomNo;
    private int capacity;
    private boolean isThereBathRoom;
    private boolean vacant;

    private List<Guest> guests;

    public Room(int roomNo, int capacity, boolean isThereBathRoom, boolean vacant, List<Guest> guests) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.isThereBathRoom = isThereBathRoom;
        this.vacant = vacant;
        this.guests = guests;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNo +
                ", Capacity: " + capacity +
                ", BathRoom: " + isThereBathRoom+
                ", Vacant: " + vacant;

    }

    public List<Guest> getGuests() {
        return guests;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isThereBathRoom() {
        return isThereBathRoom;
    }

    public void setThereBathRoom(boolean thereBathRoom) {
        isThereBathRoom = thereBathRoom;
    }

    public boolean isVacant() {
        return vacant;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
