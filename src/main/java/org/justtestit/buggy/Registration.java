package org.justtestit.buggy;

public class Registration {
    public String loginID;
    public String firstName;
    public String lastName;
    public String password;
    public String confirmPassword;
    
    
        public static class RegistrationMainBuilder {
            private String userName;
            private String firstName;
            private String lastName;
            private String password;
            private String confirmPassword;

            public RegistrationMainBuilder username(String username){
                this.userName = username;
                return this;
            }

        public RegistrationMainBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public RegistrationMainBuilder lastname(String lastName){
            this.lastName = lastName;
            return this;
        }

        public RegistrationMainBuilder password(String password){
            this.password = password;
            return this;
        }

        public RegistrationMainBuilder confirmPassword(String password){
            this.confirmPassword = password;
            return this;
        }

        public Registration build() {
            return new Registration(this);
        }
    }
    private Registration (RegistrationMainBuilder builder){
        loginID = builder.userName;
        firstName = builder.firstName;
        lastName = builder.lastName;
        password = builder.password;
        confirmPassword = builder.confirmPassword;
    }

}
