package com.tobaccode.tobaccommendate.entities;

import com.tobaccode.tobaccommendate.helpers.enums.BlendType;
import com.tobaccode.tobaccommendate.helpers.enums.CutType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tobaccos")
public class Tobacco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "blender_id")
    private Blender blender;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<BlendType> blendTypeContent;

    private String flavoring;

    @Enumerated(EnumType.STRING)
    @Column(name = "cut_type")
    private CutType cutType;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Tobacco() {
    }

    public Tobacco(String name, String description, Brand brand, Blender blender,
                   Manufacturer manufacturer, List<BlendType> blendTypeContent,
                   String flavoring, CutType cutType, Country country) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.blender = blender;
        this.manufacturer = manufacturer;
        this.blendTypeContent = blendTypeContent;
        this.flavoring = flavoring;
        this.cutType = cutType;
        this.country = country;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Blender getBlender() {
        return blender;
    }

    public void setBlender(Blender blender) {
        this.blender = blender;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<BlendType> getBlendTypeContent() {
        return blendTypeContent;
    }

    public void setBlendTypeContent(List<BlendType> blendTypeContent) {
        this.blendTypeContent = blendTypeContent;
    }

    public String getFlavoring() {
        return flavoring;
    }

    public void setFlavoring(String flavoring) {
        this.flavoring = flavoring;
    }

    public CutType getCutType() {
        return cutType;
    }

    public void setCutType(CutType cutType) {
        this.cutType = cutType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tobacco{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand=" + brand +
                ", blender=" + blender +
                ", manufacturer=" + manufacturer +
                ", blendTypeContent=" + blendTypeContent +
                ", flavoring='" + flavoring + '\'' +
                ", cutType=" + cutType +
                ", country=" + country +
                '}';
    }
}
