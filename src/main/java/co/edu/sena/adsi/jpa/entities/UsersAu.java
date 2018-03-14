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
@Table(name = "users_au")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersAu.findAll", query = "SELECT u FROM UsersAu u")
    , @NamedQuery(name = "UsersAu.findById", query = "SELECT u FROM UsersAu u WHERE u.id = :id")
    , @NamedQuery(name = "UsersAu.findByLastNameOld", query = "SELECT u FROM UsersAu u WHERE u.lastNameOld = :lastNameOld")
    , @NamedQuery(name = "UsersAu.findByNameOld", query = "SELECT u FROM UsersAu u WHERE u.nameOld = :nameOld")
    , @NamedQuery(name = "UsersAu.findByTelephoneOld", query = "SELECT u FROM UsersAu u WHERE u.telephoneOld = :telephoneOld")
    , @NamedQuery(name = "UsersAu.findByAddressOld", query = "SELECT u FROM UsersAu u WHERE u.addressOld = :addressOld")
    , @NamedQuery(name = "UsersAu.findByOccupationOld", query = "SELECT u FROM UsersAu u WHERE u.occupationOld = :occupationOld")
    , @NamedQuery(name = "UsersAu.findBySexOld", query = "SELECT u FROM UsersAu u WHERE u.sexOld = :sexOld")
    , @NamedQuery(name = "UsersAu.findByEmailOld", query = "SELECT u FROM UsersAu u WHERE u.emailOld = :emailOld")
    , @NamedQuery(name = "UsersAu.findByPasswordOld", query = "SELECT u FROM UsersAu u WHERE u.passwordOld = :passwordOld")
    , @NamedQuery(name = "UsersAu.findByIdDocumentsTypeOld", query = "SELECT u FROM UsersAu u WHERE u.idDocumentsTypeOld = :idDocumentsTypeOld")
    , @NamedQuery(name = "UsersAu.findByIdCitiesOld", query = "SELECT u FROM UsersAu u WHERE u.idCitiesOld = :idCitiesOld")
    , @NamedQuery(name = "UsersAu.findByNumDocumentOld", query = "SELECT u FROM UsersAu u WHERE u.numDocumentOld = :numDocumentOld")
    , @NamedQuery(name = "UsersAu.findByActiveOld", query = "SELECT u FROM UsersAu u WHERE u.activeOld = :activeOld")
    , @NamedQuery(name = "UsersAu.findByLastNameNew", query = "SELECT u FROM UsersAu u WHERE u.lastNameNew = :lastNameNew")
    , @NamedQuery(name = "UsersAu.findByNameNew", query = "SELECT u FROM UsersAu u WHERE u.nameNew = :nameNew")
    , @NamedQuery(name = "UsersAu.findByTelephoneNew", query = "SELECT u FROM UsersAu u WHERE u.telephoneNew = :telephoneNew")
    , @NamedQuery(name = "UsersAu.findByAddressNew", query = "SELECT u FROM UsersAu u WHERE u.addressNew = :addressNew")
    , @NamedQuery(name = "UsersAu.findByOccupationNew", query = "SELECT u FROM UsersAu u WHERE u.occupationNew = :occupationNew")
    , @NamedQuery(name = "UsersAu.findBySexNew", query = "SELECT u FROM UsersAu u WHERE u.sexNew = :sexNew")
    , @NamedQuery(name = "UsersAu.findByEmailNew", query = "SELECT u FROM UsersAu u WHERE u.emailNew = :emailNew")
    , @NamedQuery(name = "UsersAu.findByPasswordNew", query = "SELECT u FROM UsersAu u WHERE u.passwordNew = :passwordNew")
    , @NamedQuery(name = "UsersAu.findByIdDocumentsTypeNew", query = "SELECT u FROM UsersAu u WHERE u.idDocumentsTypeNew = :idDocumentsTypeNew")
    , @NamedQuery(name = "UsersAu.findByIdCitiesNew", query = "SELECT u FROM UsersAu u WHERE u.idCitiesNew = :idCitiesNew")
    , @NamedQuery(name = "UsersAu.findByNumDocumentNew", query = "SELECT u FROM UsersAu u WHERE u.numDocumentNew = :numDocumentNew")
    , @NamedQuery(name = "UsersAu.findByActiveNew", query = "SELECT u FROM UsersAu u WHERE u.activeNew = :activeNew")
    , @NamedQuery(name = "UsersAu.findByFechaCambio", query = "SELECT u FROM UsersAu u WHERE u.fechaCambio = :fechaCambio")})
public class UsersAu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "last_name_old")
    private String lastNameOld;
    @Size(max = 45)
    @Column(name = "name_old")
    private String nameOld;
    @Column(name = "telephone_old")
    private Integer telephoneOld;
    @Size(max = 45)
    @Column(name = "address_old")
    private String addressOld;
    @Size(max = 45)
    @Column(name = "occupation_old")
    private String occupationOld;
    @Size(max = 2)
    @Column(name = "sex_old")
    private String sexOld;
    @Size(max = 45)
    @Column(name = "email_old")
    private String emailOld;
    @Size(max = 100)
    @Column(name = "password_old")
    private String passwordOld;
    @Column(name = "id_documents_type_old")
    private Integer idDocumentsTypeOld;
    @Column(name = "id_cities_old")
    private Integer idCitiesOld;
    @Column(name = "num_document_old")
    private Integer numDocumentOld;
    @Column(name = "active_old")
    private Boolean activeOld;
    @Size(max = 45)
    @Column(name = "last_name_new")
    private String lastNameNew;
    @Size(max = 45)
    @Column(name = "name_new")
    private String nameNew;
    @Column(name = "telephone_new")
    private Integer telephoneNew;
    @Size(max = 45)
    @Column(name = "address_new")
    private String addressNew;
    @Size(max = 45)
    @Column(name = "occupation_new")
    private String occupationNew;
    @Size(max = 2)
    @Column(name = "sex_new")
    private String sexNew;
    @Size(max = 45)
    @Column(name = "email_new")
    private String emailNew;
    @Size(max = 100)
    @Column(name = "password_new")
    private String passwordNew;
    @Size(max = 45)
    @Column(name = "id_documents_type_new")
    private String idDocumentsTypeNew;
    @Size(max = 45)
    @Column(name = "id_cities_new")
    private String idCitiesNew;
    @Size(max = 11)
    @Column(name = "num_document_new")
    private String numDocumentNew;
    @Column(name = "active_new")
    private Boolean activeNew;
    @Column(name = "fechaCambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;

    public UsersAu() {
    }

    public UsersAu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastNameOld() {
        return lastNameOld;
    }

    public void setLastNameOld(String lastNameOld) {
        this.lastNameOld = lastNameOld;
    }

    public String getNameOld() {
        return nameOld;
    }

    public void setNameOld(String nameOld) {
        this.nameOld = nameOld;
    }

    public Integer getTelephoneOld() {
        return telephoneOld;
    }

    public void setTelephoneOld(Integer telephoneOld) {
        this.telephoneOld = telephoneOld;
    }

    public String getAddressOld() {
        return addressOld;
    }

    public void setAddressOld(String addressOld) {
        this.addressOld = addressOld;
    }

    public String getOccupationOld() {
        return occupationOld;
    }

    public void setOccupationOld(String occupationOld) {
        this.occupationOld = occupationOld;
    }

    public String getSexOld() {
        return sexOld;
    }

    public void setSexOld(String sexOld) {
        this.sexOld = sexOld;
    }

    public String getEmailOld() {
        return emailOld;
    }

    public void setEmailOld(String emailOld) {
        this.emailOld = emailOld;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public Integer getIdDocumentsTypeOld() {
        return idDocumentsTypeOld;
    }

    public void setIdDocumentsTypeOld(Integer idDocumentsTypeOld) {
        this.idDocumentsTypeOld = idDocumentsTypeOld;
    }

    public Integer getIdCitiesOld() {
        return idCitiesOld;
    }

    public void setIdCitiesOld(Integer idCitiesOld) {
        this.idCitiesOld = idCitiesOld;
    }

    public Integer getNumDocumentOld() {
        return numDocumentOld;
    }

    public void setNumDocumentOld(Integer numDocumentOld) {
        this.numDocumentOld = numDocumentOld;
    }

    public Boolean getActiveOld() {
        return activeOld;
    }

    public void setActiveOld(Boolean activeOld) {
        this.activeOld = activeOld;
    }

    public String getLastNameNew() {
        return lastNameNew;
    }

    public void setLastNameNew(String lastNameNew) {
        this.lastNameNew = lastNameNew;
    }

    public String getNameNew() {
        return nameNew;
    }

    public void setNameNew(String nameNew) {
        this.nameNew = nameNew;
    }

    public Integer getTelephoneNew() {
        return telephoneNew;
    }

    public void setTelephoneNew(Integer telephoneNew) {
        this.telephoneNew = telephoneNew;
    }

    public String getAddressNew() {
        return addressNew;
    }

    public void setAddressNew(String addressNew) {
        this.addressNew = addressNew;
    }

    public String getOccupationNew() {
        return occupationNew;
    }

    public void setOccupationNew(String occupationNew) {
        this.occupationNew = occupationNew;
    }

    public String getSexNew() {
        return sexNew;
    }

    public void setSexNew(String sexNew) {
        this.sexNew = sexNew;
    }

    public String getEmailNew() {
        return emailNew;
    }

    public void setEmailNew(String emailNew) {
        this.emailNew = emailNew;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getIdDocumentsTypeNew() {
        return idDocumentsTypeNew;
    }

    public void setIdDocumentsTypeNew(String idDocumentsTypeNew) {
        this.idDocumentsTypeNew = idDocumentsTypeNew;
    }

    public String getIdCitiesNew() {
        return idCitiesNew;
    }

    public void setIdCitiesNew(String idCitiesNew) {
        this.idCitiesNew = idCitiesNew;
    }

    public String getNumDocumentNew() {
        return numDocumentNew;
    }

    public void setNumDocumentNew(String numDocumentNew) {
        this.numDocumentNew = numDocumentNew;
    }

    public Boolean getActiveNew() {
        return activeNew;
    }

    public void setActiveNew(Boolean activeNew) {
        this.activeNew = activeNew;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
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
        if (!(object instanceof UsersAu)) {
            return false;
        }
        UsersAu other = (UsersAu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.UsersAu[ id=" + id + " ]";
    }
    
}
