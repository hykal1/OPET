package com.example.projectuas.feature.Veterinary;

import com.example.projectuas.R;
import com.example.projectuas.feature.Grooming.Grooming;

import java.util.ArrayList;

public class VeterinaryData {
    private static String[] VetNames = {
            "Drh. Affandra Fahrezi",
            "Drh. Karunia Agustiani",
            "Drh. M. Teguh Prananto",
            "Drh. M. Hykal Nurhakim",
            "Drh. Musthofa Dzikry"
    };

    private static String[] VetDesc ={
            "General Veterinarian",
            "General Veterinarian",
            "Veterinary Oral Specialist",
            "Veterinary Surgery Specialist",
            "Veterinary Orthopedic Specialist"
    };

    private static String[] VetPrice = {
            "Rp. 50.000",
            "Rp. 50.000",
            "Rp. 70.000",
            "Rp. 70.000",
            "Rp. 70.000"
    };

    private static int[] VetImages = {
            R.drawable.icon_affandra,
            R.drawable.icon_karun,
            R.drawable.icon_teguh,
            R.drawable.icon_hykal,
            R.drawable.icon_musthofa
    };

    static ArrayList<Veterinary> getListData(){
        ArrayList<Veterinary> list = new ArrayList<>();
        for(int position = 0; position<VetNames.length;position++){
            Veterinary veterinary = new Veterinary();
            veterinary.setName_vet(VetNames[position]);
            veterinary.setDesc_vet(VetDesc[position]);
            veterinary.setPrice_vet(VetPrice[position]);
            veterinary.setPhoto(VetImages[position]);
            list.add(veterinary);
        }
        return list;
    }
}
