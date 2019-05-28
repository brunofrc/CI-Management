package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe responsavel por garantir o mapeamento objeto relacional.
 *
 * @author Rubens Lopes Viana Junior
 * @version 1.0
 * @since 16/02/2017
 */
@Entity
@Table(name = "TB_AUTHENTICATION", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_DESCRIPTION", columnNames = "DESCRIPTION")})
@SequenceGenerator(name = "SQ_AUTHENTICATION", sequenceName = "SQ_AUTHENTICATION", allocationSize = 1, initialValue = 1)
public class Authentication implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue(generator = "SQ_AUTHENTICATION", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "DESCRIPTION", length = 50, nullable = false)
    private String description;

    @Column(name = "USER", length = 50, nullable = false)
    private String user;

    @Column(name = "PASSWORD", length = 50, nullable = false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
