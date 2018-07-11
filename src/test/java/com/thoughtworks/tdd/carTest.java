package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;

import static org.fest.assertions.api.Fail.fail;

public class carTest {
    @Test
    public void should_park_successfully_given_partking_lot_is_not_full(){
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
    public void should_unpark_successfully_given_ticket_is_right(){

        Car thisCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt recipt = parkingLot.park(thisCar);
        assertThat(parkingLot.unpark(recipt), is(thisCar));
 }
    @Test
    public void should_unpark_fail_given_ticket_is_worng(){
        Car thisCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt recipt = parkingLot.park(thisCar);
        Receipt otherReceipt = new Receipt();
        assertThat(parkingLot.unpark(otherReceipt), not(thisCar));
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
    public void should_park_be_false_given_Parking_lot_is_no_full(){
        ParkingLot parkingLot = new ParkingLot(0);
        assertThat(parkingLot.isFull(),is(true));
    }

    @Test
    public void should_park_be_false_given_a_full_Parking_lot_take_out_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        parkingLot.unpark(receipt);
        assertThat(parkingLot.isFull(),is(false));
    }

    @Test
    public  void should_park_be_Successfully_given_a__full_parking_take_out_car_and_park_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        parkingLot.unpark(receipt);
        try{
            parkingLot.park(new Car());
        }catch (ParkLotException exception){
            fail("sholud Successfully");
        }
    }

}
