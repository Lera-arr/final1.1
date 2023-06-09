package com.example.finalapp.services;

import com.example.finalapp.models.Category;
import com.example.finalapp.models.Product;
import com.example.finalapp.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // Данный метод позволяет получить список всех товаров
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    // Данный метод позволяет получить товар по id
    public Product getProductId(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    // Данный метод позволяет сохранить товар
    @Transactional
    public void saveProduct(Product product, Category category){
        product.setCategory(category);
        productRepository.save(product);}

    // Данный метод позволяет обновить данные о товаре
    @Transactional
    public void updateProduct(int id, Product product){
        product.setId(id);
        productRepository.save(product);
    }

    // Данный метод позволяет удалить товар по id
    @Transactional
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
//    public List<Product> getfindByTitleContainingIgnoreCase(String name){
//        return productRepository.findByTitleContainingIgnoreCase(name);
//    }
//    public List<Product> getfindByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(String title, float ot, float Do){
//        return productRepository.findByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(title, ot, Do);
//    }
//
//    public List<Product> getfindByTitleOrderByPriceAsc(String title, float ot, float Do){
//        return productRepository.findByTitleOrderByPriceAsc(title, ot,  Do);
//    }
//    public List<Product> getfindByTitleOrderByPriceDesc(String title, float ot, float Do) {
//        return productRepository.findByTitleOrderByPriceDesc( title,  ot,  Do);
//    }
//
//    public List<Product> getfindByTitleAndCategoryOrderByPriceAsc(String title, float ot, float Do, int category){
//        return productRepository.findByTitleAndCategoryOrderByPriceAsc( title,  ot, Do,  category);
//    }
//
//    public List<Product> getfindByTitleAndCategoryOrderByPriceDesc(String title, float ot, float Do, int category) {
//        return productRepository.findByTitleAndCategoryOrderByPriceDesc( title,  ot,  Do,  category);
//    }


}
