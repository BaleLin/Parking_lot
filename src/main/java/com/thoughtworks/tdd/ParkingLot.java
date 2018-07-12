package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    int size;
    int number;

    Map<Receipt,Car> parkingLot = new HashMap<>();

    public Map<Receipt, Car> getParkingLot() {
        return parkingLot;
    }

    public ParkingLot(int number,int size) {
        this.size = size;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setParkingLot(Map<Receipt, Car> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Receipt park(Car car) throws ParkLotException {
        if (this.isFull()){
            throw new ParkLotException("parking_space_is_full");
        }else{
            Receipt receipt = new Receipt();
            parkingLot.put(receipt,car);
            int curruntSize = this.getSize();
            this.setSize(curruntSize--);
            return receipt;
        }
    }

    public Car unpark(Receipt recipt) {
        if(this.getParkingLot().keySet().contains(recipt)){
            Car thiscar = this.getParkingLot().get(recipt);
            this.getParkingLot().remove(recipt);
            int curruntSize = this.getSize();
            curruntSize++;
            return  thiscar;
        }
        else {
            return null;
        }
    }


    public Boolean isFull() {
        if(this.getSize()==0){
            return true;
        }else {
            return false;
        }
    }
}
