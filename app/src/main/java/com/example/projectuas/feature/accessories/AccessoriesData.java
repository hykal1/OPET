package com.example.projectuas.feature.accessories;
import com.example.projectuas.R;

import java.util.ArrayList;

public class AccessoriesData {
    private static int[] toysImage = {
            R.drawable.toy1,
            R.drawable.toy2,
            R.drawable.toy3,
            R.drawable.toy4,
            R.drawable.toy5,
            R.drawable.toy6,
            R.drawable.toy7,
            R.drawable.toy8,
            R.drawable.toy9,
            R.drawable.toy10

    };

    private static String[] toysName = {
            "Pet Dog Rubber Chew Toys",
            "Cat Tower Toy",
            "Pet Dog Rubber Chew Toys",
            "Mainan Terowongan Hamster",
            "Dot Teeth Dog Toys",
            "Cat Kitten Toy Teaser",
            "Pawify Multifunctional",
            "Pet Dog Dental Care Brushing",
            "Boneka Catnip",
            "Laser Mainan Kucing Anjing"
    };

    private static String[] toysDesc = {
            "Mainan gigit karet anjing hewan",
            "Mainan menara kucing",
            "Mainan gigit karet anjing hewan",
            "Diameter 5.5 cm",
            "Mainan gigitan anjing empeng",
            "Mainan kucing tikus bergerak",
            "Mainan tali hewan bulat",
            "Mainan & pembersih gigi anjing",
            "Boneka Mainan Kesukaan Kucing",
            "Untuk mainan anabul imut-imut"
    };

    private static String[] toysTokped = {
            "https://www.tokopedia.com/javapetcotangerang/mainan-gigit-karet-anjing-hewan-pet-dog-rubber-chew-toys-toy13-merah-muda",
            "https://www.tokopedia.com/javapetcotangerang/cat-tower-toy-mainan-menara-kucing-toy01-hijau",
            "https://www.tokopedia.com/javapetcotangerang/mainan-gigit-karet-anjing-hewan-pet-dog-rubber-chew-toys-toy14-merah-muda",
            "https://www.tokopedia.com/javapetcotangerang/mainan-terowongan-hamster-5-5-x07-hijau",
            "https://www.tokopedia.com/javapetcotangerang/gigitan-anjing-empeng-gigitan-anjing-dot-teeth-dog-toys-mainan-toy11-biru?extParam=src%3Dshop%26whid%3D3510834",
            "https://www.tokopedia.com/javapetcotangerang/mainan-kucing-interaktif-cat-kitten-toy-teaser-catch-the-mouse-toy6?extParam=src%3Dshop%26whid%3D3510834",
            "https://www.tokopedia.com/petpalaceindonesia/pawify-multifunctional-pet-molar-dog-bite-toy-mainan-tali-hewan-bulat-bulat-merah-putih?extParam=src%3Dshop%26whid%3D11656025",
            "https://www.tokopedia.com/petpalaceindonesia/pawify-pet-dog-dental-care-brushing-toy-mainan-pembersih-gigi-anjing-m-pink?extParam=src%3Dshop%26whid%3D11656025",
            "https://www.tokopedia.com/babahcathouse/boneka-catnip-kecil-kucing-mainan-cat-nip-toys-bantal-gigitan-toy-lucu-random?extParam=src%3Dshop%26whid%3D6155727",
            "https://www.tokopedia.com/babahcathouse/laser-mainan-kucing-anjing-murah-cat-toy-toys-interaktif"
    };
    private static String[] toysShopee = {
            "https://shopee.co.id/Mainan-gigit-karet-anjing-hewan-pet-dog-rubber-chew-toys-TOY13-i.503688332.17075161577?sp_atk=41388133-3c43-45a8-92ed-37fdf5ef93b1&xptdk=41388133-3c43-45a8-92ed-37fdf5ef93b1",
            "https://shopee.co.id/Cat-Tower-Toy-Mainan-Menara-Kucing-TOY01-i.503688332.13628189841?sp_atk=7d2055c4-9b5b-4009-b86a-8453f402b5c2&xptdk=7d2055c4-9b5b-4009-b86a-8453f402b5c2",
            "https://shopee.co.id/Mainan-gigit-karet-anjing-hewan-pet-dog-rubber-chew-toys-TOY14-i.503688332.12894074392?sp_atk=020f7bdf-ab2f-40f0-83b1-db21b9a858b8&xptdk=020f7bdf-ab2f-40f0-83b1-db21b9a858b8",
            "https://shopee.co.id/Mainan-Terowongan-Hamster-5.5-X07-i.503688332.12528149727?sp_atk=012c106a-8ff6-409f-bfea-1163f847c86d&xptdk=012c106a-8ff6-409f-bfea-1163f847c86d",
            "https://shopee.co.id/Gigitan-Anjing-Empeng-Gigitan-Anjing-Dot-Teeth-Dog-Toys-Mainan-TOY11-i.503688332.18712008432?sp_atk=9c16d588-5c2f-4485-b710-ba9a89e06dbc&xptdk=9c16d588-5c2f-4485-b710-ba9a89e06dbc",
            "https://shopee.co.id/Mainan-Kucing-Interaktif-Cat-Kitten-Toy-Teaser-Catch-The-Mouse-TOY6-i.503688332.17375163247?sp_atk=76176112-ff5d-4c24-9b1e-80b0296bea8d&xptdk=76176112-ff5d-4c24-9b1e-80b0296bea8d",
            "https://shopee.co.id/Pawify-Multifunctional-pet-molar-dog-bite-toy-Mainan-Tali-Hewan-Bulat-i.468840754.10928290221?sp_atk=d9cd254d-bdd7-41da-ad8b-db332869ce0f&xptdk=d9cd254d-bdd7-41da-ad8b-db332869ce0f",
            "https://shopee.co.id/Pawify-Pet-Dog-Dental-Care-Brushing-Toy-Mainan-Pembersih-Gigi-Anjing-i.468840754.6197453338?sp_atk=228aa1a8-af86-4241-b0b4-eccd647de921&xptdk=228aa1a8-af86-4241-b0b4-eccd647de921",
            "https://shopee.co.id/Boneka-Catnip-KECIL-Kucing-Mainan-Cat-Nip-Toys-Bantal-Gigitan-Penenang-Toy-Aksesoris-Doll-Murah-Lucu-i.167334541.8004288264?sp_atk=eb853af8-44ff-4424-8c7d-ec7bbdf8716e&xptdk=eb853af8-44ff-4424-8c7d-ec7bbdf8716e",
            "https://shopee.co.id/LASER-Mainan-Kucing-Anjing-Murah-Scratcher-Bergerak-Berjalan-Cat-Toy-Toys-Untuk-Aksesoris-Interaktif-i.167334541.4137926969?sp_atk=8fe6d1cb-30ee-48d7-97b2-86391996e936&xptdk=8fe6d1cb-30ee-48d7-97b2-86391996e936"
    };

    static ArrayList<Accessories> getListData() {
        ArrayList<Accessories> list = new ArrayList<>();
        for (int pos = 0; pos < toysName.length; pos++) {
            Accessories accessories = new Accessories();
            accessories.setImageResourceId(toysImage[pos]);
            accessories.setName(toysName[pos]);
            accessories.setDesc(toysDesc[pos]);
            accessories.setLinkTokped(toysTokped[pos]);
            accessories.setLinkShopee(toysShopee[pos]);
            list.add(accessories);
        }
        return list;
    }
}

