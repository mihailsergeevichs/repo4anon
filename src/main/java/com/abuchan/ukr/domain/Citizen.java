package com.abuchan.ukr.domain;

import com.abuchan.ukr.domain.enumerated.Occupation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ****** on 17.02.2016.
 */
@Entity
@Table(name = "citizen")
public class Citizen extends BaseEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 32)
    @Column(name = "last_name", length = 32, nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "occupation", nullable = false)
    private Occupation occupation;

    @ManyToMany(mappedBy = "citizens")
    @JsonIgnore
    private Set<City> citySet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Set<City> getCitySet() {
        return citySet;
    }

    public void setCitySet(Set<City> citySet) {
        this.citySet = citySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citizen)) return false;

        Citizen citizen = (Citizen) o;

        if (!getId().equals(citizen.getId())) return false;
        if (!getLastName().equals(citizen.getLastName())) return false;
        if (!getBirthDate().equals(citizen.getBirthDate())) return false;
        if (getOccupation() != citizen.getOccupation()) return false;
        return getCitySet().equals(citizen.getCitySet());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getBirthDate().hashCode();
        result = 31 * result + getOccupation().hashCode();
        result = 31 * result + getCitySet().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", occupation=" + occupation +
                ", citySet contains" + citySet.size() + "elements" +
                '}';
    }
}
