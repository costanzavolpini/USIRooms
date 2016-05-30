package com.usirooms.usirooms.events;

import java.util.ArrayList;

/**
 * Created by Marco on 5/29/16.
 */
public class Rooms {
    private ArrayList<dummyRoom> rooms = new ArrayList<>();

    public Rooms(){
        rooms.add(createSI003());
        rooms.add(createSI004());
        rooms.add(createSI006());
        rooms.add(createSI007());
        rooms.add(createSI008());
        rooms.add(createSI013());
        rooms.add(createSI015());

        rooms.add(createA11());
        rooms.add(createA12());
        rooms.add(createA13());
        rooms.add(createA14());
        rooms.add(createA21());
        rooms.add(createA22());
        rooms.add(createA23());
        rooms.add(createA24());
        rooms.add(createA31());
        rooms.add(createA32());
        rooms.add(createA33());
        rooms.add(createA34());

        rooms.add(createR120());
        rooms.add(createR128());
        rooms.add(createR156());
        rooms.add(createR159());
        rooms.add(createR250());
        rooms.add(createR253());
        rooms.add(createR254());
        rooms.add(createR354());
        rooms.add(createR355());
    }

    public ArrayList<dummyRoom> getRooms(){
        return rooms;
    }

    public dummyRoom getRoom(String name) {
        // given the name of the room, return the dummy room
        for (dummyRoom room : rooms){
            if (room.getName().equals(name)){
                return room;
            }
        }
        return null;
    }

    public dummyRoom getRoom(int id){
        // given the id of the room, return the dummy room
        for (dummyRoom room : rooms){
            if (room.getId() == id){
                return room;
            }
        }
        return null;
    }

    public dummyRoom getRoomBuilding(String building){
        for (dummyRoom room : rooms){
            if (room.getBuilding().equals(building)){
                return room;
            }
        }
        return null;
    }

/////////////////INF-ROOMS/////////////////

    private dummyRoom createSI003(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("SI-003");
        dr.setImg("si013.png");
        dr.setSize(60);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Black Building");

        return dr;
    }

    private dummyRoom createSI004(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("SI-004");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Black Building");

        return dr;
    }

    private dummyRoom createSI006(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("SI-006");
        dr.setImg("A101.img");
        dr.setSize(60);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Black Building");

        return dr;
    }

    private dummyRoom createSI007(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("SI-007");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Black Building");

        return dr;
    }

    private dummyRoom createSI008(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("SI-008");
        dr.setImg("A101.img");
        dr.setSize(60);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Black Building");

        return dr;
    }

    private dummyRoom createSI013(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("SI-013");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Black Building");

        return dr;
    }

    private dummyRoom createSI015(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("SI-015");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Black Building");

        return dr;
    }

/////////////////ECO-ROOMS/////////////////

    private dummyRoom createA11(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A11");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA12(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A12");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA13(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A13");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA14(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A14");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA21(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A21");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA22(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A22");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA23(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A23");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA24(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A24");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA31(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A31");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA32(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A32");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA33(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A33");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

    private dummyRoom createA34(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("A34");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Red Building");

        return dr;
    }

/////////////////MAIN-ROOMS/////////////////

    private dummyRoom createR120(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("120");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR128(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("128");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR156(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("156");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR159(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("159");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR250(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("250");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR253(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("253");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR254(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("254");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR354(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("354");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }

    private dummyRoom createR355(){
        dummyRoom dr = new dummyRoom();

        dr.setId(1487);
        dr.setName("355");
        dr.setImg("A101.img");
        dr.setSize(30);
        dr.setHasProjector(true);
        dr.setHowToReach("By feet");
        dr.setBuilding("Main Building");

        return dr;
    }
}
