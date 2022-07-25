package productcrudapp.controller;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	@RequestMapping("/")
	public String home(Model m) {
		List<Product>products=productDao.getAllProducts();
		m.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "add_Product_form";
	}
	
	@RequestMapping(value="/handle-product",method=RequestMethod.POST)
	public RedirectView saveProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
	}
	//delete handler
	@RequestMapping("/deleteProduct/{pid}")
	public RedirectView delelte(@PathVariable("pid")int pid,HttpServletRequest request) {
		productDao.deleteProduct(pid);
		System.out.println("deleting");
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
	}
	@RequestMapping("/editProduct/{pid}")
	public String editProduct(Model m,@PathVariable("pid")int pid) {
		Product product=productDao.getProduct(pid);
		m.addAttribute("product", product);
		return "edit_Product";
	}
	@RequestMapping("/sortBy")
	public String sortBy(HttpServletRequest request,Model m) {
		List<Product>products=productDao.getAllProducts();
		String val=(String) request.getAttribute("value");
		System.out.println(val);
		if(val.equals("Id")) {
			products.sort(new Comparator<Product>() {
				public int compare(Product p1,Product p2) {
					return Integer.compare(p1.getId(), p2.getId());
				}
			});
		}
		m.addAttribute("products", products);
		return "index";
	}
	
}
