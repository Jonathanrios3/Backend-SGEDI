/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Johan
 */
@Embeddable
public class UsersHasFoldersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users_id")
    private int usersId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "folders_id")
    private int foldersId;

    public UsersHasFoldersPK() {
    }

    public UsersHasFoldersPK(int usersId, int foldersId) {
        this.usersId = usersId;
        this.foldersId = foldersId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getFoldersId() {
        return foldersId;
    }

    public void setFoldersId(int foldersId) {
        this.foldersId = foldersId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usersId;
        hash += (int) foldersId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersHasFoldersPK)) {
            return false;
        }
        UsersHasFoldersPK other = (UsersHasFoldersPK) object;
        if (this.usersId != other.usersId) {
            return false;
        }
        if (this.foldersId != other.foldersId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.UsersHasFoldersPK[ usersId=" + usersId + ", foldersId=" + foldersId + " ]";
    }
    
}
