package com.example.projectuas.feature.Grooming;

import java.util.ArrayList;

public class GroomingData {
    private static String[] GroomNames = {
            "Dry Grooming",
            "Basic Grooming",
            "Basic Grooming + Treatment",
            "Full Grooming"
    };

    private static String[] GroomDesc ={
            "Specialized in Sick / Pregnant Animals",
            "Ordinary Shampoo",
            "Anti Lice / Anti Fungal Shampoo",
            "Shampoo and Full Treatment"
    };

    private static String[] GroomPrice = {
            "Rp. 25.000",
            "Rp. 60.000",
            "Rp. 100.000",
            "Rp. 110.000"
    };

    static ArrayList<Grooming> getListData(){
        ArrayList<Grooming> list = new ArrayList<>();
        for(int position = 0; position<GroomNames.length;position++){
            Grooming grooming = new Grooming();
            grooming.setName_groom(GroomNames[position]);
            grooming.setDesc_groom(GroomDesc[position]);
            grooming.setPrice_groom(GroomPrice[position]);
            list.add(grooming);
        }
        return list;
    }
}
