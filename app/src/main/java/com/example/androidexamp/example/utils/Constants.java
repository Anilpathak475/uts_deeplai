package com.example.androidexamp.example.utils;

public interface Constants {
    String Email="email";
    String AutoLogin="autoLogin";
    String Password="password";
    String Name="name";
    String Phone="PhoneNumber";
    String Birthday="Birthday";
    String RegisterPassword="RegisterPassword";
    String RegisterConfirmPassword="RegisterConfirmPassword";
    String BookPhoneNumber="BookPhoneNumber";
    String BookinpPssword="BookingPassword";
    String FROM_STATION="$FROM_STATION";
    String TO_STATION="$TO_STATION";


    public enum TicketType {
        Journey,Return
    }


    public enum TicketClass {
        First,Second;
    }
    final int TICKET_FARE_SINGLE=5;
    final int TICKET_FARE_MULTIPLE=10;
    final int TICKET_FARE_MAX=15;
    final int TICKET_FARE_FIRST_CLASS= TICKET_FARE_SINGLE* 10;

}
