//package ru.javarush.sitnikov.spring_boot_project.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import ru.javarush.sitnikov.ms_products_whiskey.util.TestUtil;
//import ru.javarush.sitnikov.spring_boot_project.client.ProductClient;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ProductService {
//
//    private final ProductClient productClient;
//
//    public List<String> getProducts() {
//
//        return productClient.getProducts();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(TestUtil.sum(3, 6));
//    }
//}
