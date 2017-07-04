package com.cooler.model.tests.questionsBlock;

import com.cooler.model.tests.PsyTest;
import com.cooler.model.tests.questionsBlock.question.PsyQuestion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by clr on 30.05.2017.
 */

@Entity
@Table(name = "psyQuestionBlock")
public class PsyQuestionsBlock implements Serializable {

    private Long id;
    private PsyTest psyTest;
    private Set<PsyQuestion> psyQuestionSet = new HashSet<PsyQuestion>();

    protected PsyQuestionsBlock(){}

    public PsyQuestionsBlock(Long id) {
        this.setId(id);
    }

    public void setPsyQuestionSet(Set<PsyQuestion> psyQuestionSet) {
        this.psyQuestionSet = psyQuestionSet;
    }

    @OneToMany(mappedBy = "psyQuestionBlock")
    public Set<PsyQuestion> getPsyQuestionSet() {
        return psyQuestionSet;
    }

    public void addQuestion (PsyQuestion psyQuestion) {
        psyQuestion.setPsyQuestionBlock(this);
        getPsyQuestionSet().add(psyQuestion);
    }

    public void removeQuestion (PsyQuestion psyQuestion) {
        getPsyQuestionSet().remove(psyQuestion);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPsyTest (PsyTest psyTest) {
        this.psyTest = psyTest;
    }

    @ManyToOne
    @JoinColumn(name = "psyTest_id")
    public PsyTest getPsyTest() {
        return psyTest;
    }
}
