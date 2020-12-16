package model;

import javax.persistence.*;

@Entity
@Table(schema = "theatre", name = "shows")

public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "show_id")
    private int showId;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 1200)
    private String description;

    @Column(name = "duration")
    private int duration;

    @Column(name = "type")
    private String type;

    @Column(name = "director")
    private String director;

    public Shows() {
    }

    public Shows(String title, String description, int duration, String type, String director) {
        this.director = director;
        this.duration = duration;
        this.description = description;
        this.title = title;
        this.type = type;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}

