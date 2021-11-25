package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

public class Restaurants {
    public final static String
            TYPE_EXTRA = "restaurant_type",
            ID_EXTRA = "restaurant_id";
    private static int idCount = 0;

    private final static Restaurants[] RESTAURANTS = {
            new Restaurants(RestaurantType.Indian, "CN Tower", "290 Bremner Blvd, Toronto, ON M5V 3L9", 43.642597, -79.387121),
            new Restaurants(RestaurantType.Indian, "Ripley's Aquarium of Canada", "288 Bremner Blvd, Toronto, ON M5V 3L9", 43.642477, -79.3859608),
            new Restaurants(RestaurantType.Indian, "Toronto Zoo", "2000 Meadowvale Rd, Toronto, ON M1B 5K7", 43.820801, -79.181464),

            new Restaurants(RestaurantType.Chinese, "Varsity Centre", "299 Bloor St W, Toronto, ON M5S 1W2", 43.667074, -79.397268),
            new Restaurants(RestaurantType.Chinese, "Rogers Centre", "1 Blue Jays Way, Toronto, ON M5V 1J1", 43.641896, -79.389090),
            new Restaurants(RestaurantType.Chinese, "BMO Field", "170 Princes' Blvd, Toronto, ON M6K 3C3", 43.635511, -79.417750),

            new Restaurants(RestaurantType.Greek, "Royal Ontario Museum", "100 Queens Park, Toronto, ON M5S 2C6", 43.667984, -79.394604),
            new Restaurants(RestaurantType.Greek, "Museum of Contemporary Art", "158 Sterling Rd, Toronto, ON M6R2B7", 43.654684, -79.445215),
            new Restaurants(RestaurantType.Greek, "Art Gallery of Ontario", "322 Dundas St W, Toronto, ON M5T 1G5", 43.654526, -79.392194),

            new Restaurants(RestaurantType.Italian, "Fort York", "250 Fort York Blvd, Toronto, ON M5V 3K9", 43.637905, -79.406474),
            new Restaurants(RestaurantType.Italian, "George Brown House", "186 Beverley St, Toronto, ON M5T 1L4", 43.656951, -79.395714),
            new Restaurants(RestaurantType.Italian, "Casa loma", "1 Austin Terrace, Toronto, ON M5R 1X8", 43.678254, -79.409422),
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
