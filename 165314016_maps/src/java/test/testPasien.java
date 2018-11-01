/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.pasienHelper;
import java.util.List;
import pojos.Pasien;

/**
 *
 * @author basisa22
 */
public class testPasien {
    public static void main(String[] args) {
        pasienHelper test= new pasienHelper();
        List<Pasien> list = test.getAllPasien();
        Gson gson = new Gson();
        String json= gson.toJson(list);
        System.out.println(json);
    }
}
