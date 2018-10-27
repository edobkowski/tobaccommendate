package com.tobaccode.tobaccommendate.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "brand")
    private List<Tobacco> tobaccos;

    public Brand() {
    }

    public Brand(String name, String description, List<Tobacco> tobaccos) {
        this.name = name;
        this.tobaccos = tobaccos;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tobacco> getTobaccos() {
        return tobaccos;
    }

    public void setTobaccos(List<Tobacco> tobaccos) {
        this.tobaccos = tobaccos;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tobaccos=" + tobaccos +
                '}';
    }
}
