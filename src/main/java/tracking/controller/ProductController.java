package tracking.controller;

import tracking.dao.ProductDao;
import tracking.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", urlPatterns = {"/product/*"})
public class ProductController extends HttpServlet {
	private ProductDao productDao;

	@Override
	public void init() throws ServletException {
		super.init();
		productDao = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String[] pathInfos = req.getPathInfo().split("/");
			int productId = Integer.parseInt(pathInfos[pathInfos.length - 1]);
			Product product = productDao.getAllProductById(productId);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/product_detail.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			log("Err: ", e);
		}
	}
}
