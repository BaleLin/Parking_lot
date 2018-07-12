package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Fail.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class carText2 {

    @Test
    public void should_parkingboy_can_park_be_Successfully_given_partking_lot_1_is_not_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        try {
            parkingBoy.park(new Car());
        } catch (ParkLotException exception) {
            fail("Should park sucessfully");
        }
    }

    @Test
    public void should_parkingboy_should_park_be_Fail_given_partking_lot_1_is__full() {
        ParkingLot parkingLot = new ParkingLot(0);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        try {
            parkingBoy.park(new Car());
            fail("Should no park, sucessfully");
        } catch (ParkLotException exception) {

        }
    }

    @Test
    public void should_parkingboy_unpark_successfully_given_ticket_is_right() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        parkingBoy.park(new Car());
        Car thisCar = new Car();
        Receipt recipt = parkingBoy.park(thisCar);
        assertThat(parkingLot.unpark(recipt), is(thisCar));
    }

    @Test
    public void should_parkingboy_unpark_fail_given_ticket_is_wrong() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        Car thisCar = new Car();
        Receipt recipt = parkingBoy.park(thisCar);
        Receipt otherrecipt = new Receipt();
        assertThat(parkingLot.unpark(otherrecipt), not(thisCar));
    }

    @Test
    public void should_parkingboy_be_ture_given_Parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(0);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        assertThat(parkingBoy.isFull(), is(true));
    }

    @Test
    public void should_parkingboy_be_false_given_Parking_lot_is_no_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        assertThat(parkingBoy.isFull(), is(false));
    }

    @Test
    public void should_parkingboy_can_park_Successfully_given_more_partking_lot_is_not_full() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot1);
        parkingLotlist.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        try {
            parkingBoy.park(new Car());
            parkingBoy.park(new Car());
        } catch (ParkLotException exception) {
            fail("Should park sucessfully");
        }
    }

    @Test
    public void should_parkingboy_can_unpark_be_Successfully_given_more_partking_lot__is_not_full() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot1);
        parkingLotlist.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        Car car1 = new Car();
        Car car2 = new Car();
        Receipt recipt1 = parkingBoy.park(car1);
        Receipt recipt2 = parkingBoy.park(car2);
        assertThat(parkingBoy.unpark(recipt1), is(car1));
        assertThat(parkingBoy.unpark(recipt2), is(car2));
    }

    @Test
    public void should_parkingboy_can_park_be_successful_given_more_partking_lot__is_not_full() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot1);
        parkingLotlist.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        Car car1 = new Car();
        Car car2 = new Car();
        Receipt recipt1 = parkingBoy.park(car1);
        Receipt recipt2 = parkingBoy.park(car2);
        assertThat(parkingBoy.unpark(recipt1), is(car1));
        assertThat(parkingBoy.unpark(recipt2), is(car2));
    }

    @Test
    public void should_parkingboy_can_park_order_when__given_more_partking_lot__is_not_full() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot1);
        parkingLotlist.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        Car car1 = new Car();
        Receipt recipt1 = parkingBoy.park(car1);
        assertThat(parkingLotlist.get(0).unpark(recipt1), is(car1));

    }
    @Test
    public void should_park_successfully_when_call_park_again_given_a_full_parking_lot_take_out_of_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotlist = new ArrayList<>();
        parkingLotlist.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotlist);
        Receipt receipt = parkingBoy.park(new Car());
        parkingBoy.unpark(receipt);
        try {
            parkingBoy.park(new Car());
        } catch (ParkLotException e) {
            fail("should park successfully");
        }
    }

}
