package com.cooler.model.tests;

import com.cooler.model.tests.questionsBlock.PsyQuestionsBlock;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "psyTest")
public class PsyTest implements Serializable {

    private Long id;
    private String name;
    private Set<PsyQuestionsBlock> psyQuestionsBlockSet = new HashSet<PsyQuestionsBlock>();

    protected PsyTest(){}

    public PsyTest(Long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "psyTest")
    public Set<PsyQuestionsBlock> getPsyQuestionsBlockSet() {
        return psyQuestionsBlockSet;
    }

    public void setPsyQuestionsBlockSet (Set<PsyQuestionsBlock> psyQuestionsBlockSet) {
        this.psyQuestionsBlockSet = psyQuestionsBlockSet;
    }

    public void addPsyQuestionBlock (PsyQuestionsBlock psyQuestionsBlock) {
        psyQuestionsBlock.setPsyTest(this);
        getPsyQuestionsBlockSet().add(psyQuestionsBlock);
    }

    public void removePsyQuestionsBlock(PsyQuestionsBlock psyQuestionsBlock) {
        getPsyQuestionsBlockSet().remove(psyQuestionsBlock);
    }

}
