package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private final ApiService apiService; // TODO: A utiliser

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<User> getUsers() {
        // TODO: A modifier
        // return getUsers() of ApiService interface
        return apiService.getUsers();
    }

    public void generateRandomUser() {
        // TODO: A modifier
        // IDEM
        apiService.generateRandomUser();
    }

    public void deleteUser(User user) {
        // TODO: A modifier
        // IDEM
        apiService.deleteUser(user);
    }
}
