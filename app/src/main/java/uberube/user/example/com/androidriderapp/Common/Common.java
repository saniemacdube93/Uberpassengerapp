package uberube.user.example.com.androidriderapp.Common;

import uberube.user.example.com.androidriderapp.Remote.FCMClient;
import uberube.user.example.com.androidriderapp.Remote.GoogleMapsAPI;
import uberube.user.example.com.androidriderapp.Remote.IFCMService;
import uberube.user.example.com.androidriderapp.Remote.IGoogleAPI;

/**
 * Created by User on 1/3/2018.
 */

public class Common {

    public static final String driver_tb1 = "Drivers";
    public static final String user_driver_tb1 = "DriversInformation";
    public static final String user_rider_tb1 = "RidersInformation";
    public static final String pickup_request_tb1 = "PickupRequest";
    public static final String token_tb1 = "Tokens";

    public static final String fcmURL = "https://fcm.googleapis.com/";
    public static final String googleAPIUrl = "https://maps.googleapis.com";


    private static double base_fare = 2.55;
    private static double time_rate = 0.35;
    private static double distance_rate = 1.75;

    public static double getPrice(double km, int min)
    {
        return (base_fare+(time_rate*min) + (distance_rate*km));
    }






    public static IFCMService getFCMService()
    {
        return FCMClient.getClient(fcmURL).create(IFCMService.class);
    }

    public static IGoogleAPI getGoogleService()
    {
        return GoogleMapsAPI.getClient(googleAPIUrl).create(IGoogleAPI.class);

    }

}
