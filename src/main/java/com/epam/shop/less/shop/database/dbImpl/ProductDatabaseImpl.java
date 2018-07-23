package com.epam.shop.less.shop.database.dbImpl;

import com.epam.shop.less.shop.database.ProductDatabase;
import com.epam.shop.less.shop.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("prototype")
public class ProductDatabaseImpl implements ProductDatabase {

    private ArrayList<Product> productList = new ArrayList<>();

    @Override
    public Product getProductById(int productId) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == productId) {
                productId = i;
                break;
            }
        }
        return productList.get(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        ArrayList<Product> list = new ArrayList();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                list.add(productList.get(i));
            }
        }
        return list;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                productList.remove(i);
            }
        }
    }

    @Override
    public void deleteProduct(int productId) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == productId) {
                productList.remove(i);
            }
        }
    }
}
