package br.com.dio.transportadora.interfaces.service;

import br.com.dio.transportadora.entity.EnderecoCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface IViaCepService {
    @GetMapping("/{cep}/json")
    EnderecoCep enderecoCep(@PathVariable("cep") String cep);
}
