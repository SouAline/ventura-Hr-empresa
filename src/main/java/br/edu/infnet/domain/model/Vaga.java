package br.edu.infnet.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Vaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cargo;
    private String cidade;
    private String tipoContratacao;
    private Integer usuarioId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Criterio> listaCriterio;

    public Vaga() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(String tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Criterio> getListaCriterio() {
        return listaCriterio;
    }

    public void setListaCriterio(List<Criterio> listaCriterio) {
        this.listaCriterio = listaCriterio;
    }
}