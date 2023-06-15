package br.com.Mensageiro.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class MensageiroService {	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	public void enviaMensagem(String nomeFila, Object messagem) {
		try {
			String mensagenJson = this.mapper.writeValueAsString(messagem);
			this.rabbitTemplate.convertAndSend(nomeFila, mensagenJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
