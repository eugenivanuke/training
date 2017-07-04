package com.cooler.model.tests.questionsBlock.question.answer;

import com.cooler.model.tests.questionsBlock.question.PsyQuestion;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by clr on 02.06.2017.
 */

@Entity
@Table(name = "psyAnswer")
public class PsyAnswer implements Serializable {

    private Long id;
    private String content;
    private PsyQuestion psyQuestion;

    protected PsyAnswer(){}

    public PsyAnswer(Long id, String content) {
        this.setId(id);
        this.setContent(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "psyAnswerContent")
    public String getContent() {
        return content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPsyQuestion(PsyQuestion psyQuestion) {
        this.psyQuestion = psyQuestion;
    }

    @ManyToOne
    @JoinColumn(name = "psyQuestion_id")
    public PsyQuestion getPsyQuestion() {
        return psyQuestion;
    }
}
