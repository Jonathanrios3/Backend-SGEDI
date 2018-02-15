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
public class UsersHasDocumentsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private int usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento")
    private int documento;

    public UsersHasDocumentsPK() {
    }

    public UsersHasDocumentsPK(int usuario, int documento) {
        this.usuario = usuario;
        this.documento = documento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuario;
        hash += (int) documento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersHasDocumentsPK)) {
            return false;
        }
        UsersHasDocumentsPK other = (UsersHasDocumentsPK) object;
        if (this.usuario != other.usuario) {
            return false;
        }
        if (this.documento != other.documento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.UsersHasDocumentsPK[ usuario=" + usuario + ", documento=" + documento + " ]";
    }
    
}
