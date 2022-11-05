package rsoi.lab2.bonus.model;

import javax.persistence.Entity;
import javax.persistence.*;
@Entity
@Table(name = "privilege")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, length = 80)
    private String username;

    @Column(name = "status", nullable = false, length = 80)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Privilege() {
    }

    public Privilege(Long id, String username, Status status, int balance) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.balance = balance;
    }

    @Column(name = "balance")
    private int balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }
}
