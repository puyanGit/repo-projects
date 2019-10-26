package model;

import shared.SpeciesCategory;

public class Species {

    private Integer id;
    private String kingdom_name;
    private String phylum_name;
    private String class_name;
    private String order_name;
    private String family_name;
    private String genus_name;
    private String scientific_name;
    private String infra_rank;
    private String infra_name;
    private String population;
    private SpeciesCategory category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKingdom_name() {
        return kingdom_name;
    }

    public void setKingdom_name(String kingdom_name) {
        this.kingdom_name = kingdom_name;
    }

    public String getPhylum_name() {
        return phylum_name;
    }

    public void setPhylum_name(String phylum_name) {
        this.phylum_name = phylum_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGenus_name() {
        return genus_name;
    }

    public void setGenus_name(String genus_name) {
        this.genus_name = genus_name;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public String getInfra_rank() {
        return infra_rank;
    }

    public void setInfra_rank(String infra_rank) {
        this.infra_rank = infra_rank;
    }

    public String getInfra_name() {
        return infra_name;
    }

    public void setInfra_name(String infra_name) {
        this.infra_name = infra_name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public SpeciesCategory getCategory() {
        return category;
    }

    public void setCategory(SpeciesCategory category) {
        this.category = category;
    }
}
