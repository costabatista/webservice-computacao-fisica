/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.costabatista.webservicecorrente;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "CORRENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corrente.findAll", query = "SELECT c FROM Corrente c")
    , @NamedQuery(name = "corrente.consultarPorNaoEnviadaAoWebservice", query = "SELECT c FROM Corrente c WHERE c.webservice = :enviadoparawebservice")    
    , @NamedQuery(name = "Corrente.findById", query = "SELECT c FROM Corrente c WHERE c.id = :id")
    , @NamedQuery(name = "Corrente.findByValor", query = "SELECT c FROM Corrente c WHERE c.valor = :valor")
    , @NamedQuery(name = "Corrente.findByWebservice", query = "SELECT c FROM Corrente c WHERE c.webservice = :webservice")})
public class Corrente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "webservice")
    private boolean webservice;

    public Corrente() {
    }

    public Corrente(Long id) {
        this.id = id;
    }

    public Corrente(Long id, double valor, boolean webservice) {
        this.id = id;
        this.valor = valor;
        this.webservice = webservice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getWebservice() {
        return webservice;
    }

    public void setWebservice(boolean webservice) {
        this.webservice = webservice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corrente)) {
            return false;
        }
        Corrente other = (Corrente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.costabatista.webservicecorrente.Corrente[ id=" + id + " ]";
    }
    
}
