class User {
        public int user_id;
        public String username;
        public String password;
        public String email;
        public String firstname;
        public String lastname;
        public String usertype;
        
        
        public User(int user_id, String username, String password, String email, String firstname, String lastname,
                String usertype) {
            this.user_id = user_id;
            this.username = username;
            this.password = password;
            this.email = email;
            this.firstname = firstname;
            this.lastname = lastname;
            this.usertype = usertype;
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
        public String getFirstname() {
            return firstname;
        }
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
        public String getUsertype() {
            return usertype;
        }
        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }
        @Override
        public String toString() {
            return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
                    + ", firstname=" + firstname + ", lastname=" + lastname + ", usertype=" + usertype + "]";
        }
        
        
       


}















