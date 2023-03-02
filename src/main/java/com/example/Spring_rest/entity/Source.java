package com.example.Spring_rest.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="source")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name_of_source")
    private String nameOfSource;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "source")
    private List<News> news;

    public List<News> getNews() {
        return news;
    }

    public Source() {
    }

    public Source(Long id, String nameOfSource) {
        this.id = id;
        this.nameOfSource = nameOfSource;
    }

    public void addNewsToSource(News nextNews){
        if (news==null){
            news=new ArrayList<>();
        }
        news.add(nextNews);
        nextNews.setSourceId(this.id);
    }

    public String getNameOfSource() {
        return nameOfSource;
    }

    public void setNameOfSource(String nameOfSource) {
        this.nameOfSource = nameOfSource;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", nameOfSource='" + nameOfSource + '\'' +
                '}';
    }
}
