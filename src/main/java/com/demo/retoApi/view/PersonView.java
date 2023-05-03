package com.demo.retoApi.view;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_view")
@NamedQueries({
        @NamedQuery(name="PersonView.findAll", query = "SELECT p FROM PersonView p")})
public class PersonView implements Serializable {
    private static final long serialVersionUID = 2466746444860530376L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;

    @Basic(optional = false)
    @Column(name = "url", length=128)
    private String url;


    @Basic(optional = false)
    @Column(name = "results")
    private Integer results;

    @Basic(optional = false)
    @Column(name = "affiliation_name")
    private String affiliationName;

    @Column(name = "affiliation_city")
    private String affiliationCity;

    @Column(name = "affiliation_country")
    private String affiliationCountry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public String getAffiliationCity() {
        return affiliationCity;
    }

    public void setAffiliationCity(String affiliationCity) {
        this.affiliationCity = affiliationCity;
    }
    public String getAffiliationCountry() {
        return affiliationCountry;
    }
    public void setAffiliationCountry(String affiliationCountry) {
        this.affiliationCountry = affiliationCountry;
    }
}
