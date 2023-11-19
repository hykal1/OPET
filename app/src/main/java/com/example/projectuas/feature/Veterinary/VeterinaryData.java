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

    private static int[] VetPrice = {
            50000,
            50000,
            70000,
            70000,
            70000
    };

    private static int[] VetIds = {
            1,
            2,
            3,
            4,
            5
    };

    private static int[] VetImages = {
            R.drawable.icon_affandra,
            R.drawable.icon_karun,
            R.drawable.icon_teguh,
            R.drawable.icon_hykal,
            R.drawable.icon_musthofa
    };

    private static int[] VetImagesLandscape = {
            R.drawable.icon_land_affandra,
            R.drawable.icon_land_karun,
            R.drawable.icon_land_teguh,
            R.drawable.icon_land_hykal,
            R.drawable.icon_land_musthofa
    };

    private static String[] VetDetail = {
            "A General Veterinarian is a versatile animal health professional responsible for providing comprehensive care to various animals, conducting routine check-ups, and administering vaccinations. Their expertise encompasses the diagnosis and treatment of common illnesses, contributing to the overall well-being of both companion and farm animals.",
            "A General Veterinarian is a versatile animal health professional responsible for providing comprehensive care to various animals, conducting routine check-ups, and administering vaccinations. Their expertise encompasses the diagnosis and treatment of common illnesses, contributing to the overall well-being of both companion and farm animals.",
            "A Veterinary Oral Specialist is a highly trained professional who specializes in the dental care of animals, focusing on oral health and dental issues specific to various species. They perform procedures such as dental cleanings, extractions, and oral surgeries to ensure the overall well-being of animals by addressing and preventing dental problems.",
            "A Veterinary Surgery Specialist is an expert in performing surgical procedures on animals, ranging from routine surgeries to complex interventions. Their specialized training equips them to handle diverse surgical cases, addressing conditions such as orthopedic injuries, soft tissue disorders, and other surgical needs in both companion and farm animals.",
            "A Veterinary Orthopedic Specialist is a highly skilled professional who specializes in diagnosing and treating musculoskeletal issues in animals, with a particular focus on bones, joints, and soft tissues. They are trained to address conditions such as fractures, ligament injuries, and joint disorders, providing specialized orthopedic care to enhance the mobility and comfort of their animal patients."
    };

    public static ArrayList<Veterinary> getListData(){
        ArrayList<Veterinary> list = new ArrayList<>();
        for(int position = 0; position<VetNames.length;position++){
            Veterinary veterinary = new Veterinary();
            veterinary.setName_vet(VetNames[position]);
            veterinary.setDesc_vet(VetDesc[position]);
            veterinary.setPrice_vet(VetPrice[position]);
            veterinary.setPhoto(VetImages[position]);
            veterinary.setId_vet(VetIds[position]);
            veterinary.setPhoto_land(VetImagesLandscape[position]);
            veterinary.setDetail_vet(VetDetail[position]);
            list.add(veterinary);
        }
        return list;
    }
}
