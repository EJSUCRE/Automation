package com.globant.web.data;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataEspn {
    @DataProvider(name = "users")
    public Object[][] inputData() {
        Random rand = new Random();
        int upperbound=10000;
        int int_rand= rand.nextInt(upperbound);
        String email= "Luis_Cepeda_"+int_rand+"@gmail.com";
        return new Object[][]{
                {"Luis", "Cepeda",email, "Cepeda2311*"},
        };

    }
}
