package tracking.dao;

import tracking.model.Category;
import tracking.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends BaseDao {
	public List<Product> getAllProductByCategory(int categoryId) {
		List<Product> productList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE 1 = 1 ");
			if (categoryId > 0) {
				sql.append("AND category_id = ? ");
			}
			sql.append("ORDER BY discount DESC");
			ps = connection.prepareStatement(sql.toString());
			if (categoryId > 0) {
				ps.setInt(1, categoryId);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int catId = rs.getInt("category_id");
				Category category = new Category();
				category.setId(catId);
				String name = rs.getString("name");
				String price = rs.getString("price");
				int rate = rs.getInt("rate");
				int sold = rs.getInt("sold");
				String image = rs.getString("image");
				int discount = rs.getInt("discount");
				String discountPrice = rs.getString("discount_price");

				Product product = new Product(id, category, name, price, rate, sold, image, discount, discountPrice);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, ps, null);
		}
		return productList;
	}

	public Product getAllProductById(int productId) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE id = ? ");
			ps = connection.prepareStatement(sql.toString());
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int catId = rs.getInt("category_id");
				Category category = new Category();
				category.setId(catId);
				String name = rs.getString("name");
				String price = rs.getString("price");
				int rate = rs.getInt("rate");
				int sold = rs.getInt("sold");
				String image = rs.getString("image");
				int discount = rs.getInt("discount");
				String discountPrice = rs.getString("discount_price");

				Product product = new Product(id, category, name, price, rate, sold, image, discount, discountPrice);
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, ps, null);
		}
		return null;
	}
}
