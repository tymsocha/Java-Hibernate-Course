package com.myprojects.javahibernatecourse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Integer idCompany;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

    //CascadeType.Remove - removing entities related without writing additional code to do so
    //CascadeType.Persist - saving entities related without writing additional code to do so
    //CascadeType.Refresh - refreshing of one object will also trigger refreshing second related object
    //CascadeType.Detach - if this entity will be detached from context related entity will be detached as well
    //CascadeType.Merge - if this entity will be merged to context related entity will be merged as well
    //CascadeType.All - All of the above
    @OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    @JoinColumn(name = "id_company_detail")
    private CompanyDetail companyDetail;

    public Company(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
