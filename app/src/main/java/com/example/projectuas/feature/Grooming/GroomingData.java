package com.example.projectuas.feature.Grooming;

import java.util.ArrayList;

public class GroomingData {
    public static String[] GroomNames = {
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

    private static int[] GroomPrice = {
            25000,
            60000,
            100000,
            110000
    };

    private static int[] GroomId = {1,2,3,4};

    private static String[] GroomDetail = {
            "Dry grooming involves grooming pets without the use of water, relying on techniques like brushing, combing, and other dry cleaning methods to maintain their hygiene and appearance. This method is particularly suitable for animals that may be averse to water or for situations where traditional bathing is not practical.",
            "Basic grooming is an essential routine for maintaining the overall cleanliness and health of pets, involving activities such as brushing, nail trimming, and ear cleaning. Regular basic grooming not only enhances the appearance of animals but also contributes to their well-being by preventing issues like matting, overgrown nails, and ear infections.",
            "Basic grooming, combined with lice or fungal treatment, includes routine grooming practices like brushing and nail trimming, complemented by specialized treatments to address issues such as lice infestations or fungal infections in pets. This comprehensive approach ensures both the general well-being and specific health needs of the animals, promoting a clean and healthy coat while targeting and resolving particular skin-related concerns.",
            "Full grooming is a comprehensive pet care service that goes beyond basic grooming, encompassing activities such as bathing, hair trimming, nail clipping, and ear cleaning to ensure the overall cleanliness and aesthetic appearance of the animal. This thorough grooming process is particularly beneficial for long-haired breeds or those requiring more extensive care to maintain their coat health and hygiene."
    };

    public static ArrayList<Grooming> getListData(){
        ArrayList<Grooming> list = new ArrayList<>();
        for(int position = 0; position<GroomNames.length;position++){
            Grooming grooming = new Grooming();
            grooming.setName_groom(GroomNames[position]);
            grooming.setDesc_groom(GroomDesc[position]);
            grooming.setPrice_groom(GroomPrice[position]);
            grooming.setDetail_groom(GroomDetail[position]);
            grooming.setId_groom(GroomId[position]);
            list.add(grooming);
        }
        return list;
    }
}
