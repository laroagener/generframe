package config;

public class Session {

    public static int u_id;
    public static String username;
    public static String email;
    public static String type;
    public static String status;

    public static void clear() {
        u_id = 0;
        username = null;
        email = null;
        type = null;
        status = null;
    }
    
}
