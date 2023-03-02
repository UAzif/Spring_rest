package com.example.Spring_rest.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "News")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "news")
    private String news;

    @Column(name = "themes_id")
    private Long themesId;

    @Column(name = "source_id")
    private Long sourceId;



    @ManyToOne
    @JoinColumn(name = "source_id")
    private List<Source> source;

    @ManyToOne
    @JoinColumn(name = "themes_id")
    private List<Themes> themes;

    public List<Themes> getThemes() {
        return themes;
    }
    public List<Source> getSource() {
        return source;
    }


    public News() {
    }

    public News(Long id, String news, Long themesId, Long sourceId) {
        this.id = id;
        this.news = news;
        this.themesId = themesId;
        this.sourceId = sourceId;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Long getThemesId() {
        return themesId;
    }

    public void setThemesId(Long themesId) {
        this.themesId = themesId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", news='" + news + '\'' +
                '}';
    }
}
