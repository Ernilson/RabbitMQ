package br.com.Mensageiro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Mensageiro.Service.MensageiroService;
import br.com.librabbitmq.Constantes.RabbitmqConstantes;
import br.com.librabbitmq.dto.PecoDto;


@RestController
@RequestMapping(value = "preco")
public class PrecoController {

	@Autowired
	private MensageiroService service;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody PecoDto dto) {
		
		System.out.println(dto.codigoProduto);
		
		this.service.enviaMensagem(RabbitmqConstantes.FILA_PRECO, dto);
		
		return new ResponseEntity(HttpStatus.OK);
	}
}
