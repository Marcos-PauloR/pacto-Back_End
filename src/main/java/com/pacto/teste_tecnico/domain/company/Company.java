package com.pacto.teste_tecnico.domain.company;

import java.util.List;

import com.pacto.teste_tecnico.domain.job.Job;
import com.pacto.teste_tecnico.domain.user.UserRole;
import com.pacto.teste_tecnico.domain.user.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "company")
@Table(name = "company")
public class Company extends Users {

    private String contato;
    private String cnpj;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Job> jobs;

    public Company(Users account, String contato, String cnpj) {
        super(account.getId(), account.getEmail(), account.getPassword(), account.getNome(), account.getRole());
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public Company(String contato, String cnpj) {
        this.contato = contato;
        this.cnpj = cnpj;
    }

    public Company(String email, String password, String nome, UserRole role) {
        super(email, password, nome, role);
    }

    public Company() {
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Company other = (Company) obj;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

}
