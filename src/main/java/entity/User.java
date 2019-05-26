package entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TB_USER", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_LOGIN_USER", columnNames = "LOGIN_USER"),
        @UniqueConstraint(name = "UNQ_MAIL_USER", columnNames = "MAIL_USER")})
@SequenceGenerator(name = "SQ_USER", sequenceName = "SQ_USER", allocationSize = 1, initialValue = 1)
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(generator = "SQ_USER", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME_USER", length = 100, nullable = false)
    private String nome;

    @Column(name = "LOGIN_USER", length = 25, nullable = false)
    private String login;

    @Column(name = "PASSWORD_USER", length = 50, nullable = false)
    private String password;

    @Column(name = "MAIL_USER", length = 70, nullable = false)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
