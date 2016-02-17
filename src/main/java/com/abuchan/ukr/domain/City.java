package com.abuchan.ukr.domain;

import com.fasterxml.jackson.databind.deser.Deserializers;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ******* on 17.02.2016.
 */
@Entity
@Table(name = "city")
public class City extends BaseEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 32)
    @Column(name = "title", length = 32, nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(name = "city_citizen",
            joinColumns = @JoinColumn(name="citySet_id", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="citizens_id", referencedColumnName="ID"))
    private Set<Citizen> citizens = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(Set<Citizen> citizens) {
        this.citizens = citizens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city = (City) o;

        if (!getId().equals(city.getId())) return false;
        if (!getTitle().equals(city.getTitle())) return false;
        return getCitizens().equals(city.getCitizens());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getCitizens().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", citizens " + citizens.size() + "count" +
                '}';
    }
}
