package tracking.controller;

import tracking.dao.ProductDao;
import tracking.model.Product;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "dashboard", urlPatterns = {"/dashboard"})
public class DashboardController extends HttpServlet {
	private ProductDao productDao;

	@Override
	public void init() throws ServletException {
		productDao = new ProductDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			int categoryId = request.getParameter("categoryId") == null ? 0 : Integer.parseInt(request.getParameter("categoryId"));
			List<Product> productList = productDao.getAllProductByCategory(categoryId);
			request.setAttribute("productList", productList);
			request.setAttribute("categoryId", categoryId);
			request.getRequestDispatcher("/shop.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			log("Err: ", e);
		}
	}
}