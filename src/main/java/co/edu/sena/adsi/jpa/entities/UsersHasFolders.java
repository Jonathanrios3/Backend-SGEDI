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
@Table(name = "users_has_folders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersHasFolders.findAll", query = "SELECT u FROM UsersHasFolders u")
    , @NamedQuery(name = "UsersHasFolders.findByUsersId", query = "SELECT u FROM UsersHasFolders u WHERE u.usersHasFoldersPK.usersId = :usersId")
    , @NamedQuery(name = "UsersHasFolders.findByFoldersId", query = "SELECT u FROM UsersHasFolders u WHERE u.usersHasFoldersPK.foldersId = :foldersId")
    , @NamedQuery(name = "UsersHasFolders.findByFecha", query = "SELECT u FROM UsersHasFolders u WHERE u.fecha = :fecha")})
public class UsersHasFolders implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersHasFoldersPK usersHasFoldersPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "folders_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Folders folders;
    @JoinColumn(name = "users_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public UsersHasFolders() {
    }

    public UsersHasFolders(UsersHasFoldersPK usersHasFoldersPK) {
        this.usersHasFoldersPK = usersHasFoldersPK;
    }

    public UsersHasFolders(UsersHasFoldersPK usersHasFoldersPK, Date fecha) {
        this.usersHasFoldersPK = usersHasFoldersPK;
        this.fecha = fecha;
    }

    public UsersHasFolders(int usersId, int foldersId) {
        this.usersHasFoldersPK = new UsersHasFoldersPK(usersId, foldersId);
    }

    public UsersHasFoldersPK getUsersHasFoldersPK() {
        return usersHasFoldersPK;
    }

    public void setUsersHasFoldersPK(UsersHasFoldersPK usersHasFoldersPK) {
        this.usersHasFoldersPK = usersHasFoldersPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Folders getFolders() {
        return folders;
    }

    public void setFolders(Folders folders) {
        this.folders = folders;
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
        hash += (usersHasFoldersPK != null ? usersHasFoldersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersHasFolders)) {
            return false;
        }
        UsersHasFolders other = (UsersHasFolders) object;
        if ((this.usersHasFoldersPK == null && other.usersHasFoldersPK != null) || (this.usersHasFoldersPK != null && !this.usersHasFoldersPK.equals(other.usersHasFoldersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.UsersHasFolders[ usersHasFoldersPK=" + usersHasFoldersPK + " ]";
    }
    
}
