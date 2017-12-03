/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobajpa;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "divisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisi.findAll", query = "SELECT d FROM Divisi d")
    , @NamedQuery(name = "Divisi.findByIddivisi", query = "SELECT d FROM Divisi d WHERE d.iddivisi = :iddivisi")
    , @NamedQuery(name = "Divisi.findByNamadivisi", query = "SELECT d FROM Divisi d WHERE d.namadivisi = :namadivisi")
    , @NamedQuery(name = "Divisi.findByJobdesc", query = "SELECT d FROM Divisi d WHERE d.jobdesc = :jobdesc")})
public class Divisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_divisi")
    private Integer iddivisi;
    @Column(name = "Nama_divisi")
    private String namadivisi;
    @Column(name = "Job_desc")
    private String jobdesc;

    public Divisi() {
    }

    public Divisi(Integer iddivisi) {
        this.iddivisi = iddivisi;
    }

    public Integer getIddivisi() {
        return iddivisi;
    }

    public void setIddivisi(Integer iddivisi) {
        this.iddivisi = iddivisi;
    }

    public String getNamadivisi() {
        return namadivisi;
    }

    public void setNamadivisi(String namadivisi) {
        this.namadivisi = namadivisi;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddivisi != null ? iddivisi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisi)) {
            return false;
        }
        Divisi other = (Divisi) object;
        if ((this.iddivisi == null && other.iddivisi != null) || (this.iddivisi != null && !this.iddivisi.equals(other.iddivisi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cobajpa.Divisi[ iddivisi=" + iddivisi + " ]";
    }
    
}
