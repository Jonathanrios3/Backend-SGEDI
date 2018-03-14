/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johan
 */
@Entity
@Table(name = "documents_au")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentsAu.findAll", query = "SELECT d FROM DocumentsAu d")
    , @NamedQuery(name = "DocumentsAu.findById", query = "SELECT d FROM DocumentsAu d WHERE d.id = :id")
    , @NamedQuery(name = "DocumentsAu.findByNameOld", query = "SELECT d FROM DocumentsAu d WHERE d.nameOld = :nameOld")
    , @NamedQuery(name = "DocumentsAu.findByDescriptionOld", query = "SELECT d FROM DocumentsAu d WHERE d.descriptionOld = :descriptionOld")
    , @NamedQuery(name = "DocumentsAu.findByDateOld", query = "SELECT d FROM DocumentsAu d WHERE d.dateOld = :dateOld")
    , @NamedQuery(name = "DocumentsAu.findByFormatOld", query = "SELECT d FROM DocumentsAu d WHERE d.formatOld = :formatOld")
    , @NamedQuery(name = "DocumentsAu.findByFolioOld", query = "SELECT d FROM DocumentsAu d WHERE d.folioOld = :folioOld")
    , @NamedQuery(name = "DocumentsAu.findByWeightOld", query = "SELECT d FROM DocumentsAu d WHERE d.weightOld = :weightOld")
    , @NamedQuery(name = "DocumentsAu.findByFileOld", query = "SELECT d FROM DocumentsAu d WHERE d.fileOld = :fileOld")
    , @NamedQuery(name = "DocumentsAu.findByIdUsersOld", query = "SELECT d FROM DocumentsAu d WHERE d.idUsersOld = :idUsersOld")
    , @NamedQuery(name = "DocumentsAu.findByFechaIngreso", query = "SELECT d FROM DocumentsAu d WHERE d.fechaIngreso = :fechaIngreso")})
public class DocumentsAu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name_old")
    private String nameOld;
    @Size(max = 45)
    @Column(name = "description_old")
    private String descriptionOld;
    @Column(name = "date_old")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOld;
    @Size(max = 45)
    @Column(name = "format_old")
    private String formatOld;
    @Column(name = "folio_old")
    private Integer folioOld;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight_old")
    private Double weightOld;
    @Size(max = 200)
    @Column(name = "file_old")
    private String fileOld;
    @Column(name = "id_users_old")
    private Integer idUsersOld;
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    public DocumentsAu() {
    }

    public DocumentsAu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOld() {
        return nameOld;
    }

    public void setNameOld(String nameOld) {
        this.nameOld = nameOld;
    }

    public String getDescriptionOld() {
        return descriptionOld;
    }

    public void setDescriptionOld(String descriptionOld) {
        this.descriptionOld = descriptionOld;
    }

    public Date getDateOld() {
        return dateOld;
    }

    public void setDateOld(Date dateOld) {
        this.dateOld = dateOld;
    }

    public String getFormatOld() {
        return formatOld;
    }

    public void setFormatOld(String formatOld) {
        this.formatOld = formatOld;
    }

    public Integer getFolioOld() {
        return folioOld;
    }

    public void setFolioOld(Integer folioOld) {
        this.folioOld = folioOld;
    }

    public Double getWeightOld() {
        return weightOld;
    }

    public void setWeightOld(Double weightOld) {
        this.weightOld = weightOld;
    }

    public String getFileOld() {
        return fileOld;
    }

    public void setFileOld(String fileOld) {
        this.fileOld = fileOld;
    }

    public Integer getIdUsersOld() {
        return idUsersOld;
    }

    public void setIdUsersOld(Integer idUsersOld) {
        this.idUsersOld = idUsersOld;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
        if (!(object instanceof DocumentsAu)) {
            return false;
        }
        DocumentsAu other = (DocumentsAu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.DocumentsAu[ id=" + id + " ]";
    }
    
}
