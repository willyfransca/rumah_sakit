/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.UserHelper;
import pojos.User;

/**
 *
 * @author basisa22
 */
public class userTes {
    public static void main(String[] args) {
        UserHelper test = new UserHelper();
        User user = test.getUser("puspa@usd.ac.id", "123456789");
        if (user != null) {
            Gson gson = new Gson();
            String json = gson.toJson(user);
            System.out.println(json);
        }
    }
}
