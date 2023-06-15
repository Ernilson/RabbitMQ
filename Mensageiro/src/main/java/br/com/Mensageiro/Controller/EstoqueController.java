package br.com.Mensageiro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Mensageiro.Service.MensageiroService;
import br.com.librabbitmq.Constantes.RabbitmqConstantes;
import br.com.librabbitmq.dto.EstoqueDto;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {

    @Autowired
    private MensageiroService service;

    @PutMapping
    private ResponseEntity<?> alteraEstoque(@RequestBody EstoqueDto dto) {
                  
    	System.out.println(dto.codigoProduto);
		System.out.println(dto.quantidade);
		System.out.println("//--------------------------------------------------------\\");
            
            this.service.enviaMensagem(RabbitmqConstantes.FILA_ESTOQUE, dto.codigoProduto);
            
            return ResponseEntity.ok().build();
       
    }
}
