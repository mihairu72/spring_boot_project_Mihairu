//package ru.javarush.sitnikov.spring_boot_project.client;
//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import ru.javarush.sitnikov.spring_boot_project.config.ClientConfiguration;
//
//import java.util.List;
//
//@FeignClient(name = "api-product", url = "${api.product}",
//        configuration = ClientConfiguration.class)
//public interface ProductClient {
//
//    @GetMapping("/products")
//    List<String> getProducts();
//}
