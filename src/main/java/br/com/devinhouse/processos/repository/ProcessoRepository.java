package br.com.devinhouse.processos.repository;

import br.com.devinhouse.processos.dto.ProcessoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcessoRepository  {

    private List<ProcessoDTO> repository;

    public void init(List<ProcessoDTO> listProcessos) {

        this.repository = listProcessos;
    }

    public List<ProcessoDTO> all() {

        return this.repository;
    }
}
