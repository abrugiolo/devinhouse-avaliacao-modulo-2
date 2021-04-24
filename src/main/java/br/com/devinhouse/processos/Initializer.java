package br.com.devinhouse.processos;

import br.com.devinhouse.processos.dto.ProcessoDTO;
import br.com.devinhouse.processos.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Initializer implements CommandLineRunner {

    @Autowired
    ProcessoRepository repository;

    @Override
    public void run(String... args) {

        List<ProcessoDTO> listProcessos = new ArrayList<ProcessoDTO>();
        int qtdProcessos = 40;

        for (int i = 1; i <= qtdProcessos; i++) {
            ProcessoDTO processo = new ProcessoDTO();
            processo.setCdAssunto(i);
            processo.setCdInteressado(i);
            processo.setDescricao("Processo " + i + " de testes DEV in House.");
            processo.setDescricaoAssunto("Assunto " + i + " de testes DEV in House.");
            processo.setNmInteressado("Fulano de Tal ::: " + i);
            processo.setNuAnoProcesso(i % 3 == 0 ? "2019" : i % 3 == 1 ? "2021" : "2020");
            processo.setNuProcesso(i);
            processo.setSgOrgaoProcesso("SOFT");
            processo.setChaveProcesso(processo.getSgOrgaoProcesso() + " " + processo.getNuProcesso() + "/" + processo.getNuAnoProcesso());
            listProcessos.add(processo);
        }
        repository.init(listProcessos);
    }
}