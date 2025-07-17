package br.com.desafio.a;

import br.com.desafio.a.model.Order;
import br.com.desafio.a.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.desafio.a")
public class Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("Novo Pedido");

				System.out.print("Digite o valor do pedido: ");
				double basic = sc.nextDouble();

				double discount = -1.0;
				while (discount != 0.0 && discount != 10.0 && discount != 20.0) {
					System.out.print("Escolha a porcentagem de desconto (0, 10 ou 20): ");
					discount = sc.nextDouble();

					if (discount != 0.0 && discount != 10.0 && discount != 20.0) {
						System.out.println("Desconto inválido! Só são aceitos 0, 10 ou 20%");
					}
				}

				Order order = orderService.createOrder(basic, discount);

				System.out.println("Pedido gerado!");
				System.out.println("Código do pedido: " + order.getCode());
				System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));

			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Digite apenas números válidos.");
				sc.nextLine();
			}

			String opcao;
			do {
				System.out.print("Deseja inserir outro pedido? (s/n): ");
				opcao = sc.next().trim().toLowerCase();

				if (!opcao.equals("s") && !opcao.equals("n")) {
					System.out.println("Opção inválida! Digite apenas 's' para sim ou 'n' para não.");
				}
			} while (!opcao.equals("s") && !opcao.equals("n"));

			if (opcao.equals("n")) {
				System.out.println("Encerrando o sistema...");
				break;
			}
		}

		sc.close();
	}

}
