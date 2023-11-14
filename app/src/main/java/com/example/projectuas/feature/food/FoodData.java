package com.example.projectuas.feature.food;

import com.example.projectuas.R;

import java.util.ArrayList;

public class FoodData {
    private static int[] foodImage = {
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food5,
            R.drawable.food6,
            R.drawable.food7,
            R.drawable.food8,
            R.drawable.food9,
            R.drawable.food10,

    };

    private static String[] foodName = {
            "Whiskas Dry 1.2 kg",
            "Yoliverto Suplemen",
            "Yocardia Suplemen",
            "Yochito Suplemen",
            "Whiskas",
            "Sheba Can",
            "Temptations",
            "Sheba Melty",
            "Sheba Pouch",
            "Royal Canin Sterilised"
    };

    private static String[] foodDesc = {
            "Makanan Kucing Kering rasa Ocean Fish",
            "Makanan Hewan Untuk Kesehatan Hati Liver",
            "Makanan Hewan Untuk Kesehatan Jantung",
            "Makanan untuk kesehatan Ginjal Anjing dan Kucing",
            "Makanan Kucing Kering 480gr - Tuna",
            "Makanan Kucing Basah Can 85gr",
            "Snack Kucing Purrrr-ee 48 gr",
            "Snack Kucing rasa Salmon,Tuna Mix & Seafood 48gr",
            "Makanan Anak Kucing Basah rasa Chicken 70gr",
            "Makanan Kucing Dewasa Steril Dry 400gr"
    };

    private static String[] foodTokped = {
            "https://www.tokopedia.com/whiskas/whiskas-dry-1-2-kg-makanan-kucing-kering-rasa-ocean-fish?extParam=ivf%3Dfalse%26src%3Dsearch",
            "https://www.tokopedia.com/hewania-shop/yoliverto-suplemen-makanan-hewan-untuk-kesehatan-hati-liver",
            "https://www.tokopedia.com/hewania-shop/yocardia-suplemen-makanan-hewan-untuk-kesehatan-jantung",
            "https://www.tokopedia.com/hewania-shop/yochito-suplemen-makanan-hewan",
            "https://www.tokopedia.com/whiskas/whiskas-makanan-kucing-kering-480gr-tuna?extParam=src%3Dshop%26whid%3D26751",
            "https://www.tokopedia.com/whiskas/sheba-makanan-kucing-basah-can-85gr-tuna-salmon?extParam=src%3Dshop%26whid%3D26751",
            "https://www.tokopedia.com/whiskas/temptations-snack-kucing-purrr-ee-48gr-salmon-cheese?extParam=src%3Dshop%26whid%3D26751",
            "https://www.tokopedia.com/whiskas/sheba-melty-snack-kucing-rasa-salmon-tuna-mix-seafood-48gr-isi-3?extParam=src%3Dshop%26whid%3D26751",
            "https://www.tokopedia.com/whiskas/sheba-pouch-makanan-anak-kucing-basah-rasa-chicken-70gr-isi-6?extParam=src%3Dshop%26whid%3D26751",
            "https://www.tokopedia.com/royalcaninid/royal-canin-sterilised-37-makanan-kucing-dewasa-steril-dry-400gr"
    };
    private static String[] foodShopee = {
            "https://shopee.co.id/-Special-Collab-Whiskas-Makanan-Kucing-Kering-1.2-kg-i.76617760.22960044310?xptdk=dc6e1f6d-a63a-4b30-b8fc-03bc247eddac",
            "https://shopee.co.id/Yoliverto-Suplemen-Makanan-Hewan-Kesehatan-Hati-Liver-Anjing-Kucing-i.916020114.23211745713",
            "https://shopee.co.id/Yocardia-Cardiac-Treats-Suplemen-Untuk-Kesehatan-Jantung-Hewan-i.224516847.17334110350",
            "https://shopee.co.id/Yochito-Suplemen-Makanan-Hewan-Kesehatan-Ginjal-Anjing-Kucing-i.214578974.22941267352",
            "https://shopee.co.id/Whiskas-Makanan-Kucing-Kering-480-gr-i.76617760.1277530257?xptdk=675516b2-6083-458e-8d23-2d0244c14a42",
            "https://shopee.co.id/Sheba-Can-Makanan-Kucing-Basah-Premium-85-gr-i.76617760.2004494199?sp_atk=74f2d0cf-79d3-424b-a626-3e8124dda7b5&xptdk=74f2d0cf-79d3-424b-a626-3e8124dda7b5",
            "https://shopee.co.id/Temptations-Snack-Kucing-Purrrr-ee-48-gr-i.76617760.12121535796?sp_atk=a75e607c-1684-4603-9359-0bf9af782c4b&xptdk=a75e607c-1684-4603-9359-0bf9af782c4b",
            "https://shopee.co.id/Sheba-Melty-Snack-Kucing-Basah-Multivariant-48-gr-Isi-3-i.76617760.9042189934?sp_atk=8ab6ba53-18f4-4069-a6c6-c0ab58ef7108&xptdk=8ab6ba53-18f4-4069-a6c6-c0ab58ef7108",
            "https://shopee.co.id/Sheba-Pouch-Junior-Makanan-Anak-Kucing-Basah-rasa-Chicken-70-gr-Isi-6-i.76617760.10226973656?sp_atk=e4efa85f-c0a3-403c-b53f-a8d0e2393a57&xptdk=e4efa85f-c0a3-403c-b53f-a8d0e2393a57",
            "https://shopee.co.id/Royal-Canin-Sterilised-Adult-(0.4kg)-Dry-Makanan-Kucing-Dewasa-Feline-Health-Nutrition-i.91681758.7016464240?sp_atk=3487e064-56be-454b-b5e3-61bc22cba3dd&xptdk=3487e064-56be-454b-b5e3-61bc22cba3dd"
    };

    static ArrayList<Food> getListData() {
        ArrayList<Food> list = new ArrayList<>();
        for (int pos = 0; pos < foodName.length; pos++) {
            Food food = new Food();
            food.setImageResourceId(foodImage[pos]);
            food.setName(foodName[pos]);
            food.setDesc(foodDesc[pos]);
            food.setLinkTokped(foodTokped[pos]);
            food.setLinkShopee(foodShopee[pos]);
            list.add(food);
        }
        return list;
    }
}
