package com.thoughtworks.tdd;


import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.fest.assertions.api.Fail.fail;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestParkingLot {
    @Test
    public void should_park_successfully_given__partking_lot_is_not_full(){
        ParkingLot parkinglot =new ParkingLot(1);
        try{
            parkinglot.park(new Car());
           }catch (ParkLotException exception){
            fail("Should park sucessfully,but no");
        }
    }

    @Test
    public void should_park_fail_given_partking_lot_is_full()  {
        ParkingLot parkinglot = new ParkingLot(0);
        try{
            parkinglot.park(new Car());
            fail("should not park sucessfully");
        }catch (ParkLotException exception){

        }
    }

    @Test
    public void should_unpark_successfully_given_receipt_is_right(){

        Car myCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt recipt = parkingLot.park(myCar);
        Car car = parkingLot.unpark(recipt);
        assertThat((car), is(myCar));
    }
    @Test
    public void should_unpark_fail_given_receipt_is_worng(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car mycar = new Car();
        parkingLot.park(mycar);
        Receipt otherReceipt = new Receipt();
        Car car = parkingLot.unpark(otherReceipt);
        assertThat((car), not(mycar));
    }



    @Test
    public void should_park_be_false_given_Parking_lot_is_full(){
        ParkingLot parkingLot = new ParkingLot(0);
        assertThat(parkingLot.isFull(),is(true));
    }

    @Test
    public void should_park_be_ture_given_Parking_lot_is_no_full(){
        ParkingLot parkingLot = new ParkingLot(1);
        assertThat(parkingLot.isFull(),is(false));
    }



    @Test
    public  void should_park_be_Successfully_given_a_full_parking_take_out_car_and_park_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        parkingLot.unpark(receipt);
        try {
            parkingLot.park(new Car());
        } catch (ParkLotException exception) {
            fail("sholud Successfully");
        }
    }
        @Test
        public  void should_park_be_faill_given_a__full_parking_take_out_car_and_take_out_again(){
            ParkingLot parkingLot = new ParkingLot(1);
            Car car = new Car();
            Receipt receipt = parkingLot.park(car);
            parkingLot.unpark(receipt);
            assertThat((parkingLot.unpark(receipt)),equalTo(null));
    }


}