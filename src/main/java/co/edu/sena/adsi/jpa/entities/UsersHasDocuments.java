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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johan
 */
@Entity
@Table(name = "users_has_documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersHasDocuments.findAll", query = "SELECT u FROM UsersHasDocuments u")
    , @NamedQuery(name = "UsersHasDocuments.findByUsuario", query = "SELECT u FROM UsersHasDocuments u WHERE u.usersHasDocumentsPK.usuario = :usuario")
    , @NamedQuery(name = "UsersHasDocuments.findByDocumento", query = "SELECT u FROM UsersHasDocuments u WHERE u.usersHasDocumentsPK.documento = :documento")
    , @NamedQuery(name = "UsersHasDocuments.findByFecha", query = "SELECT u FROM UsersHasDocuments u WHERE u.fecha = :fecha")})
public class UsersHasDocuments implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersHasDocumentsPK usersHasDocumentsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "documento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Documents documents;
    @JoinColumn(name = "usuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public UsersHasDocuments() {
    }

    public UsersHasDocuments(UsersHasDocumentsPK usersHasDocumentsPK) {
        this.usersHasDocumentsPK = usersHasDocumentsPK;
    }

    public UsersHasDocuments(UsersHasDocumentsPK usersHasDocumentsPK, Date fecha) {
        this.usersHasDocumentsPK = usersHasDocumentsPK;
        this.fecha = fecha;
    }

    public UsersHasDocuments(int usuario, int documento) {
        this.usersHasDocumentsPK = new UsersHasDocumentsPK(usuario, documento);
    }

    public UsersHasDocumentsPK getUsersHasDocumentsPK() {
        return usersHasDocumentsPK;
    }

    public void setUsersHasDocumentsPK(UsersHasDocumentsPK usersHasDocumentsPK) {
        this.usersHasDocumentsPK = usersHasDocumentsPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersHasDocumentsPK != null ? usersHasDocumentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersHasDocuments)) {
            return false;
        }
        UsersHasDocuments other = (UsersHasDocuments) object;
        if ((this.usersHasDocumentsPK == null && other.usersHasDocumentsPK != null) || (this.usersHasDocumentsPK != null && !this.usersHasDocumentsPK.equals(other.usersHasDocumentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.UsersHasDocuments[ usersHasDocumentsPK=" + usersHasDocumentsPK + " ]";
    }
    
}
