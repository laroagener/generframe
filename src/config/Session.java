package config;

public class Session {
    public static int u_id = 0;
    public static String username = "";
    public static String email = "";
    public static String type = "";  // "admin" or "user"
    public static String status = "";
    
    public static void clearSession() {
        u_id = 0;
        username = "";
        email = "";
        type = "";
        status = "";
    }
}