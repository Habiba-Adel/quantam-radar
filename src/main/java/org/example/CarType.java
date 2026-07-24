package org.example;

//for define the enum we have 2 options the first to put it outside the carinfo class but in the same file
//but this is not good cause it will not be public so if there is any other classes want to use it too they will cannot
//so the second option which is this one is the best one that to make it seperate to can be called in any where
public enum CarType {
    PRIVATE, TRUCK, BUS
}
