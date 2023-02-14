package HotelRooms;

public class Room {
    public int roomNo;
    public int capacity;
    public boolean isThereBathRoom;
    public boolean isVacant;

    public Room(int roomNo, int capacity, boolean isThereBathRoom, boolean isVacant) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.isThereBathRoom = isThereBathRoom;
        this.isVacant = isVacant;
    }

    public void setVacant(boolean vacant) {
        isVacant = vacant;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNo +
                ", Capacity: " + capacity +
                ", BathRoom: " + isThereBathRoom+
                ", Vacant: " + isVacant;

    }

}
