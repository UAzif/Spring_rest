package com.example.Spring_rest.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Themes")
public class Themes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_of_themes")
    private String nameOfThemes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "themes")
    private List<News> news;

    public List<News> getNews() {
        return news;
    }

    public Themes() {

    }

    public Themes(Long id, String nameOfThemes) {
        this.id = id;
        this.nameOfThemes = nameOfThemes;
    }

    public void addNewsToThemes(News nextNews) {
        if (news == null) {
            news = new ArrayList<>();
        }
        news.add(nextNews);
        nextNews.setThemesId(this.id);
    }

    public String getNameOfThemes() {
        return nameOfThemes;
    }

    public void setNameOfThemes(String nameOfThemes) {
        this.nameOfThemes = nameOfThemes;
    }

    @Override
    public String toString() {
        return "Themes{" +
                "id=" + id +
                ", nameOfThemes='" + nameOfThemes + '\'' +
                '}';
    }
}
