package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

public class Restaurants {
    public final static String
            TYPE_EXTRA = "restaurant_type",
            ID_EXTRA = "restaurant_id";
    private static int idCount = 0;

    private final static Restaurants[] RESTAURANTS = {
            new Restaurants(RestaurantType.Indian, "Babu Takeout and Catering", "4800 Sheppard Ave E, Toronto, ON M1S 4N5", 43.791500, -79.251590),
            new Restaurants(RestaurantType.Indian, "The Roti Hut", "351 Pitfield Rd, Scarborough, ON M1S 3E5", 43.787050, -79.258320),
            new Restaurants(RestaurantType.Indian, "The Nilgiris Restaurant", "3021 Markham Rd #50, Scarborough, ON M1X 1L8", 43.829220, -79.248756),

            new Restaurants(RestaurantType.Chinese, "Congee Queen", "3850 Sheppard Ave E, Scarborough, ON M1T 3L4", 43.787601, -79.268387),
            new Restaurants(RestaurantType.Chinese, "Yin Ji Chang Fen", "7010 Warden Ave. #17-18, Markham, ON L3R 5Y3", 43.820160, -79.325060),
            new Restaurants(RestaurantType.Chinese, "Wok and Grill", "1085 O'Connor Dr, Toronto, ON M4B 3N1", 43.71355, -79.308232),

            new Restaurants(RestaurantType.Greek, "Mr.Greek", "855 Milner Ave, Scarborough, ON M1B 5N6", 43.8113, -79.193),
            new Restaurants(RestaurantType.Greek, "Johnny's Shawarma", "1904 Kennedy Rd, Scarborough, ON M1P 2L8", 43.7688, -79.281913),
            new Restaurants(RestaurantType.Greek, "Shawarma Elsabil", "2680 Lawrence Ave E Unit 103, Scarborough, ON M1P 4Y4", 43.716987, -79.254681),

            new Restaurants(RestaurantType.Italian, "East Side Marios", "1355 Kingston Rd, Pickering, ON L1V 1B8", 43.837035, -79.088675),
            new Restaurants(RestaurantType.Italian, "Fratelli Village Pizzeria", "384 Old Kingston Rd, Scarborough, ON M1C 1B6", 43.716987, -79.254681),
            new Restaurants(RestaurantType.Italian, "Remezzo Italian Bistro\n", "3335 Sheppard Ave E, Scarborough, ON M1T 3K2", 43.784153, -79.292884),
    };


    private int restaurantId;

    private RestaurantType type;

    private String name;

    private double longitude, latitude;

    private String address;

    public Restaurants() {}

    public Restaurants(int restaurantId, RestaurantType type,
                       String name, String address, double lat, double lng) {
        this.restaurantId = restaurantId;
        this.type = type;
        this.name = name;
        this.latitude = lat;
        this.longitude = lng;
        this.address = address;
    }

    private Restaurants(RestaurantType type, String name, String address, double lat, double lng) {
        this(idCount++, type, name, address, lat, lng);
    }

    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }

    public RestaurantType getType() { return type; }
    public void setType(RestaurantType type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LatLng getLatLng() { return new LatLng(latitude, longitude); }


    public static Restaurants[] getRestaurantByType(RestaurantType type, boolean b) {
        Restaurants[] ofType = new Restaurants[3];
        int x = 0;
        for (Restaurants restaurants : Restaurants.RESTAURANTS) {
            if (restaurants.type == type) {
                Log.d("getRestaurantByType", "found: " + restaurants.name);
                ofType[x++] = restaurants;
                if (x == 3) break;
            }
        }

        return ofType;
    }


    public static int getTypeColor(RestaurantType type) {
        return type.getColor();
    }

    public static Restaurants getRestaurantById(int id) {
        for (Restaurants lm : RESTAURANTS) {
            if (lm.getRestaurantId() == id) {
                return lm;
            }
        }
        return null;
    }
}
