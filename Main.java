package com.mcd;

import java.util.*;

public class Main {

    public static class Car implements Comparable<Car> {
        private final Integer year;
        private final String carName;


        public Car(Integer year, String carName) {
            this.year = year;
            this.carName = carName;
        }

        @Override
        public int compareTo(Car o) {
            // i didnt knew about this compareTo function seems cool to save some lines
            return this.year.compareTo(o.year);
//            if(this.year > o.year)
//                return 1;
//            else if(this.year < o.year)
//                return -1;
//            else
//                return 0;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "year=" + year +
                    ", carName='" + carName + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {

        simpleSorting();
        customizedSorting();
        customizedSortingForStringLength();
        customizedSortingForObject();
    }

    public static void simpleSorting(){
        // this is how to do the sorting with java types
        List<Integer> nums = new ArrayList<>();
        nums.add(42);
        nums.add(31);
        nums.add(10);
        nums.add(77);
        nums.add(29);

        Collections.sort(nums);

        System.out.println(nums);
    }

    public static void customizedSorting(){
        // this is comparing one value with another and swaping with the first one compared is greater then the second one and this goes until the list is sorted.
        Comparator<Integer> com = (o1, o2) -> {
            // if you return 1 will swap, if return minus then 1 not swap
            if(o1%10 > o2%10)
                return 1;
            else
                return -1;
        };

        // this is how to do the sorting with java types
        List<Integer> nums = new ArrayList<>();
        nums.add(42);
        nums.add(31);
        nums.add(10);
        nums.add(77);
        nums.add(29);

        Collections.sort(nums, com);

        System.out.println(nums);
    }

    public static void customizedSortingForStringLength(){

        //comparingInt its a cool thing to do too
        Comparator<String> comparator = Comparator.comparingInt(String::length);

//        Comparator<String> comparator = (o1, o2) -> {
//            return Integer.compare(o1.length(), o2.length());
//        };

//        Comparator<String> comparator = (o1, o2) -> {
//            if (o1.length() > o2.length())
//                return 1;
//            else if(o1.length() < o2.length())
//                return -1;
//            else
//                return 0;
//        };

//        Comparator<String> comparator = (o1, o2) -> o1.length() > o2.length() ? 1 : -1;

        List<String> strings = new ArrayList<>();
        strings.add("XXXXXXXXXXXXXXXXXXXXXXXXX");
        strings.add("Testing");
        strings.add("Your name");
        strings.add("A");
        strings.add("Abacadabra");


        Collections.sort(strings, comparator);
        System.out.println(strings);
    }

    public static void customizedSortingForObject(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2001, "Toyota Corolla"));
        cars.add(new Car(1988, "Fusca Azul"));
        cars.add(new Car(2011, "Peagout 207"));
        cars.add(new Car(2020, "Toyota Yaris"));
        cars.add(new Car(2030, "BWM X1"));

        System.out.println(cars);
        Collections.sort(cars);
        System.out.println(cars);
    }
}