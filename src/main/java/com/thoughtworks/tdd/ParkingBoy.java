package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
     List<ParkingLot> parkingLotList;
     int number;

    public ParkingBoy(int number,List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        this.number = number;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public Receipt park(Car car) throws ParkLotException {
        ParkingLot parkingLotObject = parkingLotList.get(this.getNumber()-1);
        Map<Receipt,Car> parkingLot=parkingLotObject.getParkingLot();
        int size = parkingLotObject.getSize();
        if (size==0){
            throw new ParkLotException("parking_space_is_full");
        }else{
            Receipt receipt = new Receipt();
            parkingLot.put(receipt,car);
            int curruntSize = parkingLotObject.getSize();
            parkingLotObject.setSize(curruntSize--);
            return receipt;
      }
    }

    public Car unpark(Receipt recipt) {
        ParkingLot parkingLotObject = parkingLotList.get(this.getNumber()-1);
        if(parkingLotObject.getParkingLot().keySet().contains(recipt)){
            Car thiscar = parkingLotObject.getParkingLot().get(recipt);
            parkingLotObject.getParkingLot().remove(recipt);
            int curruntSize = parkingLotObject.getSize();
            curruntSize++;
            return  thiscar;
        }
        else {
            return null;
        }
    }
}
