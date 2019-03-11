package org.ogorodin.db;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.Products.EProductType;
import org.ogorodin.entity.Stock;
import org.ogorodin.entity.Users;
import org.ogorodin.entity.Users.ERole;
import org.ogorodin.repository.IProductsRepository;
import org.ogorodin.repository.IStockRepository;
import org.ogorodin.repository.IUsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
public class DbInit implements CommandLineRunner {

	private IUsersRepository _usersRepository;
	private IStockRepository _stockRepository;
	private IProductsRepository _productsRepository;

	public DbInit(IUsersRepository _usersRepository) {
		this._usersRepository = _usersRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Users user1 = new Users("pera", "pera", "pera@foo.mail", ERole.ROLE_CUSTOMER);
			Users user2 = new Users("mika", "mika", "mika@foo.mail", ERole.ROLE_EMPLOYEE);
			Users user3 = new Users("zika", "zika", "zika@foo.mail", ERole.ROLE_ADMIN);

			_usersRepository.save(user1);
			_usersRepository.save(user2);
			_usersRepository.save(user3);

			Products product1 = new Products("Bolivian ram", "{'latin_name':'Mikrogeophagus ramirezi'}",
					EProductType.FISH);
			Products product2 = new Products("Neon tetra", "{'latin_name':'Paracheirodon innesi'}", EProductType.FISH);
			Products product3 = new Products("Kuhli loach", "{'latin_name':'Pangio kuhlii'}", EProductType.FISH);
			Products product4 = new Products("Panda cory", "{'latin_name':'Coridoras panda'}", EProductType.FISH);

			Stock stock1 = new Stock(3.4, 50, Date.from(Instant.now()), product1);
			Stock stock2 = new Stock(1.25, 400, Date.from(Instant.now()), product2);
			Stock stock3 = new Stock(2, 50, Date.from(Instant.now()), product3);
			Stock stock4 = new Stock(1.75, 50, Date.from(Instant.now()), product4);

			List<Stock> stocks = Arrays.asList(stock1, stock2, stock3, stock4);
			_stockRepository.saveAll(stocks);
			
			

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
