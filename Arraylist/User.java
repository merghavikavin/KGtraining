public class User {
   
    private int user_id;

    private String username;

    private String password;

    private String email;

    private String first_name;

    private String last_name;

    private String user_type;

    public User(int user_id, String username, String password, String email, String first_name, String last_name,
            String user_type) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_type = user_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
                + ", first_name=" + first_name + ", last_name=" + last_name + ", user_type=" + user_type + "]";
    }

    
}

