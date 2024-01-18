package com.pacto.teste_tecnico.domain.job;

import java.util.Date;
import java.util.List;

import com.pacto.teste_tecnico.domain.candidate.Candidate;
import com.pacto.teste_tecnico.domain.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "job")
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String tittle;
    private String description;
    private String requirements;
    private Date publish_date;
    private Date expiration_date;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(name = "job_candidate", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    private List<Candidate> candidates;

    public Job() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Job(String id, String tittle, String description, String requirements, Date publish_date,
            Date expiration_date) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.requirements = requirements;
        this.publish_date = publish_date;
        this.expiration_date = expiration_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tittle == null) ? 0 : tittle.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((requirements == null) ? 0 : requirements.hashCode());
        result = prime * result + ((publish_date == null) ? 0 : publish_date.hashCode());
        result = prime * result + ((expiration_date == null) ? 0 : expiration_date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Job other = (Job) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tittle == null) {
            if (other.tittle != null)
                return false;
        } else if (!tittle.equals(other.tittle))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (requirements == null) {
            if (other.requirements != null)
                return false;
        } else if (!requirements.equals(other.requirements))
            return false;
        if (publish_date == null) {
            if (other.publish_date != null)
                return false;
        } else if (!publish_date.equals(other.publish_date))
            return false;
        if (expiration_date == null) {
            if (other.expiration_date != null)
                return false;
        } else if (!expiration_date.equals(other.expiration_date))
            return false;
        return true;
    }

}
