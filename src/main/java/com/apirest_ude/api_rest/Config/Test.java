package com.apirest_ude.api_rest.Config;

import com.apirest_ude.api_rest.entities.Category;
import com.apirest_ude.api_rest.entities.Order;
import com.apirest_ude.api_rest.entities.Product;
import com.apirest_ude.api_rest.entities.User;
import com.apirest_ude.api_rest.repository.Category_repository;
import com.apirest_ude.api_rest.repository.Order_repository;
import com.apirest_ude.api_rest.repository.Product_reposytory;
import com.apirest_ude.api_rest.repository.User_repository;
import com.apirest_ude.api_rest.utils.Orders_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner {
@Autowired
    private User_repository user_repository;
@Autowired
    private Order_repository order_repository;
@Autowired
    private Category_repository category_repository;
@Autowired
    private Product_reposytory product_reposytory;

    @Override
    public void run(String... args) throws Exception {
        //USER
        User user = new User();
        user.setName("Adrian");
        user.setEmail("adrianmarlison@gmail.com");
        user.setPassword("Amoeba852+");
        user.setPhone("(62)9-9844-9857");
        user_repository.save(user);
        //Order
        Order order = new Order();
        order.setMoment(Instant.parse("2019-06-20T19:53:07Z"));
        order.setOrders_status(Orders_status.WAITTTING_PAYMENT);
        order.setUser(user);//RELACIONAMDO USER COM ORDER
        order_repository.save(order);
        //CATEGORY
        Category category = new Category();
        category.setName("Livro");
        category_repository.save(category);
        //PRODUCT
        Product product = new Product();
        product.setName("Lord of the rings");
        product.setPrice(55.64);
        product.setDesccription("Livro do frondo");
        product.setIgmUri("asdsadasd");
        product_reposytory.save(product);
        //ASSOCIANDO A TB_PROD COM TB_CAT NA TB_PROD_CAT//ASSOCIANDO A TB_PROD COM A TB_ORDER NA TB_PROD_ORDER
        product.getCategories().add(category);
        product.getOrders().add(order);
        product_reposytory.save(product);






    }
}
