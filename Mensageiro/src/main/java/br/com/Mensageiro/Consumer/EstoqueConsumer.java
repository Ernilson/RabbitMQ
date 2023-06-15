package br.com.Mensageiro.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.ComponentScan;

import br.com.librabbitmq.Constantes.RabbitmqConstantes;
import br.com.librabbitmq.dto.EstoqueDto;






@ComponentScan({"br.com.Mensageiro.Consumer"})
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
	private void consumidor(EstoqueDto dto) {
		System.out.println(dto.codigoProduto);
		System.out.println(dto.quantidade);
		System.out.println("//--------------------------------------------------------\\");
	}

}
