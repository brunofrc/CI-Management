package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_REPOSITORY", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_URL_REPOSITORY", columnNames = "URL_REPOSITORY")})
@SequenceGenerator(name = "SQ_REPOSITORY", sequenceName = "SQ_REPOSITORY", allocationSize = 1, initialValue = 1)
public class Repository implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_REPOSITORY", unique = true)
    @GeneratedValue(generator = "SQ_REPOSITORY", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "URL_REPOSITORY", length = 300)
    private String url;

    @Column(name = "FIRST_REVISION")
    private String firstRevision;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Authentication.class)
    @JoinColumn(name = "ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_REPOSITORY_AUTHENTICATION"))
    private Authentication authentication;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Project.class)
    @JoinColumn(name = "ID_PROJECT", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_REPOSITORY_PROJECT"))
    @JsonBackReference
    private Project project;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFirstRevision() {
        return firstRevision;
    }

    public void setFirstRevision(String firstRevision) {
        this.firstRevision = firstRevision;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
