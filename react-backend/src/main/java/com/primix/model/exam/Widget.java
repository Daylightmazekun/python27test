package com.primix.model.exam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String widgetType;

    @ManyToOne
    @JsonIgnore
    private Topic topic;
	@ManyToOne
	@JsonIgnore
	private Lesson lesson;
    public  int getId(){
       return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getWidgetType(){
        return widgetType;
    }

    public void setWidgetType(String widgetType){
        this.widgetType = widgetType;
    }

    public Topic getTopic(){
        return topic;
    }

    public void setTopic(Topic topic){
        this.topic = topic;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}