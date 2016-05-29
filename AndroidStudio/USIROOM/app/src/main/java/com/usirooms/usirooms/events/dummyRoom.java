package com.usirooms.usirooms.events;

/**
 * Created by Marco on 5/29/16.
 */
public class dummyRoom {
    private int roomId;
    private String roomName;
    private String roomImg;
    private int roomSize;
    private Boolean roomProjector;
    private String HowToReach;
    private String roomBuilding;


    public void setId(int roomId){
        this.roomId = roomId;
    }

    public void setName(String roomName){
        this.roomName = roomName;
    }

    public void setImg(String roomImg){
        this.roomImg = roomImg;
    }

    public void setSize(int roomSize){
        this.roomSize = roomSize;
    }

    public void setHasProjector(boolean roomProjector){
        this.roomProjector = roomProjector;
    }

    public void setHowToReach(String HowToReach){
        this.HowToReach = HowToReach;
    }

    public void setBuilding(String roomBuilding){
        this.roomBuilding = roomBuilding;
    }

    public int getId(){
        return roomId;
    }

    public String getName(){
        return roomName;
    }

    public String getImg(){
        return roomImg;
    }

    public int getSize(){
        return roomSize;
    }

    public Boolean getHasProjector(){
        return roomProjector;
    }

    public String getHowToReach(){
        return HowToReach;
    }

    public String getBuilding(){
        return roomBuilding;
    }
}
