package br.com.devinhouse.processos.dto;

import java.io.Serializable;

public class ProcessoDTO implements Serializable {
    private static final long serialVersionUID = -8580528558477117582L;

    static Integer idUnico = 0;

    private final Integer id;
    private Integer nuProcesso;
    private String chaveProcesso;
    private String sgOrgaoProcesso;
    private String nuAnoProcesso;
    private String descricao;
    private Integer cdAssunto;
    private String descricaoAssunto;
    private Integer cdInteressado;
    private String nmInteressado;

    public ProcessoDTO() {
        this.id = ++idUnico;
        this.chaveProcesso = "SOFT " + this.id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNuProcesso() {
        return nuProcesso;
    }

    public void setNuProcesso(Integer nuProcesso) {
        this.nuProcesso = nuProcesso;
    }

    public String getChaveProcesso() {
        return chaveProcesso;
    }

    public void setChaveProcesso(String chaveProcesso) {
        this.chaveProcesso = chaveProcesso;
    }

    public String getSgOrgaoProcesso() {
        return sgOrgaoProcesso;
    }

    public void setSgOrgaoProcesso(String sgOrgaoProcesso) {
        this.sgOrgaoProcesso = sgOrgaoProcesso;
    }

    public String getNuAnoProcesso() {
        return nuAnoProcesso;
    }

    public void setNuAnoProcesso(String nuAnoProcesso) {
        this.nuAnoProcesso = nuAnoProcesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCdAssunto() {
        return cdAssunto;
    }

    public void setCdAssunto(Integer cdAssunto) {
        this.cdAssunto = cdAssunto;
    }

    public String getDescricaoAssunto() {
        return descricaoAssunto;
    }

    public void setDescricaoAssunto(String descricaoAssunto) {
        this.descricaoAssunto = descricaoAssunto;
    }

    public Integer getCdInteressado() { return cdInteressado; }

    public void setCdInteressado(Integer cdInteressado) {
        this.cdInteressado = cdInteressado;
    }

    public String getNmInteressado() {
        return nmInteressado;
    }

    public void setNmInteressado(String nmInteressado) {
        this.nmInteressado = nmInteressado;
    }

    static public void update(ProcessoDTO from, ProcessoDTO to) {
        Integer nuProc = from.getNuProcesso();
        String chaveProc = from.getChaveProcesso();
        String sgOrgaoProc = from.getSgOrgaoProcesso();
        String nuAnoProc = from.getNuAnoProcesso();
        String descricao = from.getDescricao();
        Integer cdAssunto = from.getCdAssunto();
        String descricaoAssunto = from.getDescricaoAssunto();
        Integer cdInteressado = from.getCdInteressado();
        String nmInteressado = from.getNmInteressado();

        if (nuProc != null) to.setNuProcesso(nuProc);
        if (chaveProc != null) to.setChaveProcesso(chaveProc);
        if (sgOrgaoProc != null) to.setSgOrgaoProcesso(sgOrgaoProc);
        if (nuAnoProc != null) to.setNuAnoProcesso(nuAnoProc);
        if (descricao != null) to.setDescricao(descricao);
        if (cdAssunto != null) to.setCdAssunto(cdAssunto);
        if (descricaoAssunto != null) to.setDescricaoAssunto(descricaoAssunto);
        if (cdInteressado != null) to.setCdInteressado(cdInteressado);
        if (nmInteressado != null) to.setNmInteressado(nmInteressado);
    }
}