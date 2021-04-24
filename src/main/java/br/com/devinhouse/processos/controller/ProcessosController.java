package br.com.devinhouse.processos.controller;

import br.com.devinhouse.processos.dto.ProcessoDTO;
import br.com.devinhouse.processos.service.ProcessoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/processos")
public class ProcessosController  {

    @Autowired
    private ProcessoService service;

    @ResponseStatus(CREATED)
    @PostMapping(value = "/v1/cadastrar", headers = "api-version=v1", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<ProcessoDTO> cadastrarNovoProcesso(@RequestBody ProcessoDTO processo) {

        return service.add(processo);
    }

    @GetMapping(value = "/v1/listar", headers = "api-version=v1", produces = APPLICATION_JSON_VALUE)
    public List<ProcessoDTO> listarTodos() {

        return service.getAll();
    }

    @GetMapping(value = "/v1/buscar/id/{id}", headers = "api-version=v1", produces = APPLICATION_JSON_VALUE)
    public ProcessoDTO buscarProcessoPeloID(@PathVariable String id) {
        try {
            return service.getById(Integer.parseInt(id));

        } catch (NumberFormatException formatException) {
            throw new ResponseStatusException(BAD_REQUEST, "Formato inválido: ID deve ser um número inteiro.");
        } catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
    }

    @GetMapping(value = "/v1/buscar/chave", headers = "api-version=v1", produces = APPLICATION_JSON_VALUE)
    public List<ProcessoDTO> buscarProcessoPelaChave(@RequestParam String chave) {
        try {
            return service.getByChaveProcesso(chave);

        } catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
    }

    @PutMapping(value = "/v1/atualizar/{id}", headers = "api-version=v1", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<ProcessoDTO> atualizarProcessoPeloID(@PathVariable String id, @RequestBody ProcessoDTO processo) {
        try {
            return service.updateById(Integer.parseInt(id), processo);

        } catch (NumberFormatException formatException) {
            throw new ResponseStatusException(BAD_REQUEST, "Formato inválido: ID deve ser um número inteiro.");
        } catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
    }

    @DeleteMapping(value = "/v1/excluir/{id}", headers = "api-version=v1", produces = APPLICATION_JSON_VALUE)
    public List<ProcessoDTO> excluirProcessoPeloID(@PathVariable String id) {
        try {
            return service.deleteById(Integer.parseInt(id));

        } catch (NumberFormatException formatException) {
            throw new ResponseStatusException(BAD_REQUEST, "Formato inválido: ID deve ser um número inteiro.");
        } catch (NotFoundException foundException) {
            throw new ResponseStatusException(NOT_FOUND, foundException.getMessage());
        }
    }
}
