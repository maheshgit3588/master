package com.learn.eureka.service.discovery;

import java.io.*;
import java.util.*;

public class TestClass {

    static class Slots{
        int slotBegin;
        int slotEnd;
        int bookingsCount;

        public Slots(int slotBegin, int slotEnd, int bookingsCount) {
            this.slotBegin = slotBegin;
            this.slotEnd = slotEnd;
            this.bookingsCount = bookingsCount;
        }

        public void setBookingsCount(int bookingsCount) {
            this.bookingsCount = bookingsCount;
        }

        public int getBookingsCount() {
            return bookingsCount;
        }

        public void setSlotBegin(int slotBegin) {
            this.slotBegin = slotBegin;
        }

        public int getSlotBegin() {
            return slotBegin;
        }

        public void setSlotEnd(int slotEnd) {
            this.slotEnd = slotEnd;
        }

        public int getSlotEnd() {
            return slotEnd;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Slots slots = (Slots) o;
            return slotBegin == slots.slotBegin &&
                    slotEnd == slots.slotEnd;
        }

        @Override
        public int hashCode() {
            return Objects.hash(slotBegin, slotEnd);
        }
    }

    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        List<Slots> parkingSlots = plotTheParkingSlots(parkingStartEndTimes);
        for(int i=0;i<parkingStartEndTimes.length;i++){
            for(int j=0;j<parkingStartEndTimes[i].length;j++){

                int startTime=parkingStartEndTimes[i][0];
                int endTime=parkingStartEndTimes[i][1];

                for(Slots slot:parkingSlots){
                    if(slot.getSlotBegin()>startTime && slot.getSlotEnd()<endTime){
                       // slot.getBookingsCount()++;
                    }
                }
            }
        }

        return 0;
    }

    static List<Slots> plotTheParkingSlots(int[][] parkingStartEndTimes){
        int openingTime=findOpeningTime(parkingStartEndTimes);
        int closingTime=findClosingTime(parkingStartEndTimes);
        int parkingTimeSlots=closingTime-openingTime;
        List<Slots> slots=new ArrayList<>();
        for(int i=openingTime;i<parkingTimeSlots;i++){
            slots.add(new Slots(i,i+1,0));
        }
        return slots;
    }

    static int findOpeningTime(int[][] parkingStartEndTimes) {
        TreeSet<Integer> allStarts=new TreeSet<>();
        for (int i = 0; i < parkingStartEndTimes.length; i++) {
            allStarts.add(parkingStartEndTimes[i][0]);
        }
        return allStarts.first();
    }

    static int findClosingTime(int[][] parkingStartEndTimes) {
        TreeSet<Integer> allStarts=new TreeSet<>();
        for (int i = 0; i < parkingStartEndTimes.length; i++) {
            allStarts.add(parkingStartEndTimes[i][1]);
        }
        return allStarts.last();
    }
    // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] parkingStartEndTimeList = new int[n][2];
        String[] parkingStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
            for (int j = 0; j < parkingStartEndTime.length; j++) {
                parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
            }
        }

        int out = minParkingSpaces(parkingStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}