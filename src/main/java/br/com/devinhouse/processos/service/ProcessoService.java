package br.com.devinhouse.processos.service;

import br.com.devinhouse.processos.dto.ProcessoDTO;
import br.com.devinhouse.processos.repository.ProcessoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.devinhouse.processos.dto.ProcessoDTO.update;

@Service
public class ProcessoService  {

    @Autowired
    private ProcessoRepository repository;

    public List<ProcessoDTO> getAll() {
        return repository.all();
    }

    public ProcessoDTO getById(Integer id) throws NotFoundException {
        return getAll()
                .stream()
                .filter(proc -> proc.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Nenhum processo encontrado com o ID '" + id + "'."));
    }

    public List<ProcessoDTO> getByChaveProcesso(String chave) throws NotFoundException {
        List<ProcessoDTO> list = getAll()
                .stream()
                .filter(proc -> proc.getChaveProcesso().equalsIgnoreCase(chave))
                .collect(Collectors.toList());

        if (list.size() == 0) throw new NotFoundException("Nenhum processo encontrado com a chave '" + chave + "'.");

        return list;
    }

    public List<ProcessoDTO> add(ProcessoDTO processo) {
        List<ProcessoDTO> all = getAll();
        all.add(processo);
        return all;
    }

    public List<ProcessoDTO> updateById(Integer id, ProcessoDTO newProcesso) throws NotFoundException {
        List<ProcessoDTO> all = getAll();
        for (ProcessoDTO processo : all) {
            if (id.equals(processo.getId())) {
                update(newProcesso, processo);
                return all;
            }
        }
        throw new NotFoundException("Nenhum processo encontrado com o ID '" + id + "'.");
    }

    public List<ProcessoDTO> deleteById(Integer id) throws NotFoundException {
        List<ProcessoDTO> all = getAll();
        int index = 0;
        for (ProcessoDTO processo : all) {
            if (id.equals(processo.getId())) {
                all.remove(index);
                return all;
            }
            index++;
        }
        throw new NotFoundException("Nenhum processo encontrado com o ID '" + id + "'.");
    }
}
