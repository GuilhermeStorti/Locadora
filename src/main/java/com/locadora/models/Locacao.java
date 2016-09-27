/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "Locacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
    @NamedQuery(name = "Locacao.findByIdLocacao", query = "SELECT l FROM Locacao l WHERE l.idLocacao = :idLocacao")})
public class Locacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLocacao")
    private Integer idLocacao;
    @ManyToMany(mappedBy = "locacaoCollection")
    private Collection<Avaria> avariaCollection;
    @JoinTable(name = "Locacao_Multa", joinColumns = {
        @JoinColumn(name = "idLocacao", referencedColumnName = "idLocacao")}, inverseJoinColumns = {
        @JoinColumn(name = "idMulta", referencedColumnName = "idMulta")})
    @ManyToMany
    private Collection<Multa> multaCollection;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idFuncionario_cad", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionariocad;
    @JoinColumn(name = "idFuncionario_rec", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario idFuncionariorec;
    @JoinColumn(name = "idVeiculo", referencedColumnName = "idVeiculo")
    @ManyToOne(optional = false)
    private Veiculo idVeiculo;

    public Locacao() {
    }

    public Locacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Integer getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    @XmlTransient
    public Collection<Avaria> getAvariaCollection() {
        return avariaCollection;
    }

    public void setAvariaCollection(Collection<Avaria> avariaCollection) {
        this.avariaCollection = avariaCollection;
    }

    @XmlTransient
    public Collection<Multa> getMultaCollection() {
        return multaCollection;
    }

    public void setMultaCollection(Collection<Multa> multaCollection) {
        this.multaCollection = multaCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Funcionario getIdFuncionariocad() {
        return idFuncionariocad;
    }

    public void setIdFuncionariocad(Funcionario idFuncionariocad) {
        this.idFuncionariocad = idFuncionariocad;
    }

    public Funcionario getIdFuncionariorec() {
        return idFuncionariorec;
    }

    public void setIdFuncionariorec(Funcionario idFuncionariorec) {
        this.idFuncionariorec = idFuncionariorec;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocacao != null ? idLocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.idLocacao == null && other.idLocacao != null) || (this.idLocacao != null && !this.idLocacao.equals(other.idLocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Locacao[ idLocacao=" + idLocacao + " ]";
    }
    
}
