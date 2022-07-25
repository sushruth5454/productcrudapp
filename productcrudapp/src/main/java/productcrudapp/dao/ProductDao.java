package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
		
	}
	
	public List<Product> getAllProducts(){
		List<Product> products=this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete product
	@Transactional
	public void deleteProduct(int pid) {
		Product product=this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(product);
	}
	
	//get single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}

}
