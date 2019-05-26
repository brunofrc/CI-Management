package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "TB_MANAGER")
@SequenceGenerator(name = "SQ_MANAGER", sequenceName = "SQ_MANAGER", allocationSize = 1)
public class Manager implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_MANAGER", unique = true)
    @GeneratedValue(generator = "SQ_MANAGER", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Project.class)
    @JoinColumn(name = "ID_PROJECT", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_MANAGER_TB_PROJECT"))
    @JsonBackReference
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "ID_USER", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_MANAGER_TB_USER"))
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
