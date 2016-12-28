package net.java.seven.test.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "open_date")
    private long openDate;

    @Column(name = "close_date")
    private long closeDate;

    private String condition;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOpenDate() {
        return openDate;
    }

    public void setOpenDate(long openDate) {
        this.openDate = openDate;
    }

    public long getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(long closeDate) {
        this.closeDate = closeDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", openDate=" + openDate +
                ", closeDate=" + closeDate +
                ", condition='" + condition + '\'' +
                '}';
    }
}
