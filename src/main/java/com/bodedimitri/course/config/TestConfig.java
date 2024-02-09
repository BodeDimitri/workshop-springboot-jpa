package com.bodedimitri.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bodedimitri.course.entities.Order;
import com.bodedimitri.course.entities.User;
import com.bodedimitri.course.repositories.OrderRepository;
import com.bodedimitri.course.repositories.UserRepository;

@Configuration //Especifica que e uma classe de configuração para o Spring
@Profile("test") //Vai rodar apenas no perfil de teste
public class TestConfig implements CommandLineRunner {
	
	@Autowired //Spring vai instanciar o UserRepository aqui
	private UserRepository userRepository; //UserRepository e usado para salvar os dados

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception { //Tudo colocado dentro desse metodo vai ser executado quando a aplicação for iniciada
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
