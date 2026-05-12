package com.bn.spring_security.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity (name = "Job")
@Table (name = "tb_job")
@Data
public class JobEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "job")
    private List<JobEntity> jobEntitiesList;
}
