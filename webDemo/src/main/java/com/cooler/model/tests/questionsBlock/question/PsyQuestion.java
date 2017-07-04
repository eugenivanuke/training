package com.cooler.model.tests.questionsBlock.question;

import com.cooler.model.tests.questionsBlock.PsyQuestionsBlock;
import com.cooler.model.tests.questionsBlock.question.answer.PsyAnswer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by clr on 02.06.2017.
 */

@Entity
@Table(name = "psyQuestion")
public class PsyQuestion implements Serializable {

    private Long id;
    private String content;
    private PsyQuestionsBlock psyQuestionBlock;
    private Set<PsyAnswer> psyAnswerSet = new HashSet<PsyAnswer>();

    protected PsyQuestion(){}

    public PsyQuestion(Long id, String content) {
        this.setId(id);
        this.setContent(content);
    }

    @Column(name = "psyQuestionContent")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "psyQuestionBlock_id")
    public PsyQuestionsBlock getPsyQuestionBlock() {
        return psyQuestionBlock;
    }

    public void setPsyQuestionBlock (PsyQuestionsBlock psyQuestionBlock) {
        this.psyQuestionBlock = psyQuestionBlock;
    }

    public void setPsyAnswerSet(Set<PsyAnswer> psyAnswerSet) {
        this.psyAnswerSet = psyAnswerSet;
    }

    @OneToMany(mappedBy = "psyQuestion")
    public Set<PsyAnswer> getPsyAnswerSet() {
        return psyAnswerSet;
    }

    public void addAnswer(PsyAnswer psyAnswer) {
        psyAnswer.setPsyQuestion(this);
        psyAnswerSet.add(psyAnswer);
    }

    public void removeAnswer (PsyAnswer psyAnswer) {
        getPsyAnswerSet().remove(psyAnswer);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
