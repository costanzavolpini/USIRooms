package info.androidhive.recyclerview;

/**
 * Created by michelelustro on 24/05/16.
 */
public class roomData {
    private String roomNumber;
    private String roomTimeStart;
    private String roomTimeEnd;

    public roomData(String roomNumber, String roomTimeStart, String roomTimeEnd){
        this.roomNumber = roomNumber;
        this.roomTimeStart = roomTimeStart;
        this.roomTimeEnd = roomTimeEnd;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public String getRoomTimeStart(){
        return roomTimeStart;
    }

    public String getRoomTimeEnd(){
        return roomTimeEnd;
    }
}
