/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.pasienHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import pojos.Pasien;

/**
 *
 * @author basisa22
 */
public class testPasienNew {
    public static void main(String[] args) throws ParseException {
       try{
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String tglLahir = "19741230";
       Date date = format.parse(tglLahir);
       String noRm="123456";
       String nama="andi";
       String alamat = "paingan";
       String kelamin="Pria";
        Pasien test = new Pasien("123456", "adi", "paingan", "123456", date, "pria");
        pasienHelper helper = new pasienHelper();
        helper.addNewPasien(noRm, nama, alamat, noRm, date, kelamin);
       } catch(ParseException ex){
           
       }
    }
}
