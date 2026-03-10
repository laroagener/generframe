package config;

public class Session {
    
    private static Session instance;
    private int u_id;
    private String username;
    private String email;
    private String type;
    private String status;
    
    // Private constructor to prevent instantiation
    private Session() {
        
    }

    // Get singleton instance
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
    
    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void clearSession() {
        u_id = 0;
        username = null;
        email = null;
        status = null;
        type = null;
    
    }
    
}