package com.pacto.teste_tecnico.domain.candidate;

import java.util.List;

import com.pacto.teste_tecnico.domain.job.Job;
import com.pacto.teste_tecnico.domain.user.UserRole;
import com.pacto.teste_tecnico.domain.user.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name = "candidate")
@Table(name = "candidate")
public class Candidate extends Users {

    private String contato;
    @Column(nullable = false)
    private String habilidade;

    @ManyToMany(mappedBy = "candidates", cascade = CascadeType.ALL)
    private List<Job> jobs;

    public Candidate() {
        
    }

    public Candidate(String id, String email, String password, String nome, UserRole role, String contato, String habilidade, List<Job> jobs) {
        super(id, email, password, nome, role);
        this.contato = contato;
        this.habilidade = habilidade;
        this.jobs = jobs;
    }

    public Candidate( String email, String password, String nome, UserRole role, String contato,
            String habilidade, List<Job> jobs) {
        super(email, password, nome, role);
        this.contato = contato;
        this.habilidade = habilidade;
        this.jobs = jobs;
    }

    public Candidate(String email, String password, String nome, UserRole role){
        super(email, password, nome, role);
    }

    public Candidate(String contato, String habilidade, List<Job> jobs) {
        this.contato = contato;
        this.habilidade = habilidade;
        this.jobs = jobs;
    }


    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
        result = prime * result + ((habilidade == null) ? 0 : habilidade.hashCode());
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
        Candidate other = (Candidate) obj;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        if (habilidade == null) {
            if (other.habilidade != null)
                return false;
        } else if (!habilidade.equals(other.habilidade))
            return false;
        return true;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    @Override
    public String toString() {
        return "Candidate [contato=" + contato + ", habilidade=" + habilidade + ", jobs=" + jobs + "]";
    }

}
