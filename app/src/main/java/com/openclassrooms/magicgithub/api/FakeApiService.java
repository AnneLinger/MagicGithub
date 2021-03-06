package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.ui.user_list.ListUserViewHolder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.generateUsers;

import android.view.View;

public class FakeApiService implements ApiService {

    private List<User> users = generateUsers();

    /**
     * Return a list of {@link User}
     * Those users must be generated by {@link FakeApiServiceGenerator}
     */
    @Override
    public List<User> getUsers() {
        // TODO: A modifier
        // return because getUsers() has to return the list, users because FAKE_USERS is the value of the list users in the top of the class
        return users;

        // TRIES :
        // return FAKE_USERS; First try, MagicGithub is ok on a device but generateRandomUser() and deleteUser() fail because loadData() return again and again FAKE_USERS
    }

    /**
     * Generate a random {@link User} and add it {@link FakeApiService#users} list.
     * This user must be get from the {@link FakeApiServiceGenerator#FAKE_USERS_RANDOM} list.
     */
    @Override
    public void generateRandomUser() {
        // TODO: A modifier
        // 1. New object User randomUser whose value is a random of FAKE_USERS_RANDOM list
        //      get() recovers a new Random with a random index (method nextInt recovers random index in the list size)
        // 2. Add randomUser to users list
        User randomUser = FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
        users.add(randomUser);

        // TRIES :

        // FIRST TRIES with a specific User (test before learning Random() method) but failed because no var created in this class :
        //      users.addAll(FAKE_USERS_RANDOM);
        //      users.add(FAKE_USERS_RANDOM.get(1));
        //      getUsers().add(FAKE_USERS_RANDOM.get(1));

        // SECOND TRY ok with a specific User and a new var :
        //      User userToAdd = FAKE_USERS_RANDOM.get(1);
        //      users.add(userToAdd);

        // AFTER SUCCESS try a method that always generate a different random User : failed because no random list created in this class (OK after talking with my mentor)
        //      while (FAKE_USERS_RANDOM.size()>0) {
        //          User randomUser = FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
        //          users.add(randomUser);
        //          FAKE_USERS_RANDOM.remove(randomUser);
        //      }
        // OR
        //      if(FAKE_USERS_RANDOM.size()>0){
        //          User randomUser = FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
        //          users.add(randomUser);
        //          User randomUserToDelete = randomUser;
        //          FAKE_USERS_RANDOM.remove(randomUserToDelete);
        //      }
        //      else{
        //          System.out.println("No more random User to generate");
        //      }
    }

    /**
     * Delete a {@link User} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteUser(User user) {
        // TODO: A modifier
        // remove() with the user parameter on the users list
        users.remove(user);

        // TRIES failed because my first try of getUsers() was wrong :
        //      users.remove(user);
        //      users.remove(user.getId());
        //      users.remove(users.get(user.hashCode()));
        //      users.remove(user.getId()+user.getAvatarUrl()+user.getLogin());
        //      this.users.remove(user);
        //      getUsers().remove(user);
        //      getUsers().remove(user.getId());
        //      getUsers().remove(user.hashCode());
        //      FAKE_USERS.remove(user.getId());
        //      FAKE_USERS.remove(User.id);
        //      FAKE_USERS.remove(users.remove(user));
        //      generateUsers().remove(user.hashCode());
        //      user = FAKE_USERS.remove(user);
    }
}
