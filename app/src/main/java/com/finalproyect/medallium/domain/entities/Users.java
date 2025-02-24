package com.finalproyect.medallium.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Users {
    @SerializedName("users")
    List<User> users = new ArrayList<>();
    public static class User {

        @SerializedName("firstName")
        public String name;
        @SerializedName("email")
        public String email;
        @SerializedName("lastName")
        public String lastName;

        @SerializedName("password")
        public String password;

        @SerializedName("image")
        public String image;

        @SerializedName("id_User")
        public Long id_user;

        public User(String name, String email, String lastName, String password, String image, Long id_user) {
            this.name = name;
            this.email = email;
            this.lastName = lastName;
            this.password = password;
            this.image = image;
            this.id_user = id_user;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Long getId_user() {
            return id_user;
        }

        public void setId_user(Long id_user) {
            this.id_user = id_user;
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
