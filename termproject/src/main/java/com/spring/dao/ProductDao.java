package com.spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.beans.product;

import java.util.List;

@Repository
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            product pro = new product(rs.getInt("id"),rs.getString("name"),rs.getInt("quantity"));
            return pro;
        });
    }

    public void addOrUpdateItem(product item) {
        String selectQuery = "SELECT * FROM product WHERE id = ?";
        List<product> existingItems = jdbcTemplate.query(selectQuery, new Object[]{item.getId()}, (rs, rowNum) -> {
            product pro = new product(rs.getInt("id"),rs.getString("name"),rs.getInt("quantity"));
            return pro;
        });

        if (!existingItems.isEmpty()) {
            // Item already exists, update quantity
            int newQuantity = existingItems.get(0).getQuantity() + 1;
            String updateQuery = "UPDATE product SET quantity = ? WHERE id = ?";
            jdbcTemplate.update(updateQuery, newQuantity, item.getId());
        } else {
            // Item does not exist, insert with quantity 1
            String insertQuery = "INSERT INTO product (id, name, quantity) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertQuery, item.getId(), item.getName(), 1);
        }
    }
    
    public void removeProductById(int id) {
        String selectQuery = "SELECT * FROM product WHERE id = ?";
        jdbcTemplate.query(selectQuery, new Object[]{id}, (rs, rowNum) -> {
            int quantity = rs.getInt("quantity");
            if (quantity > 1) {
                // Decrease quantity
                String updateQuery = "UPDATE product SET quantity = ? WHERE id = ?";
                jdbcTemplate.update(updateQuery, quantity - 1, id);
            } else {
                // Delete the product
                String deleteQuery = "DELETE FROM product WHERE id = ?";
                jdbcTemplate.update(deleteQuery, id);
            }
            return null;
        });
    }

    // Add other data access methods as needed
}
