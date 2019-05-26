package entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_PROJECT", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_NAME_PROJECT", columnNames = {"NAME_PROJECT"})})
@SequenceGenerator(name = "SQ_PROJECT", sequenceName = "SQ_PROJECT", allocationSize = 1)
public class Project implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "ID_PROJECT")
    @Id
    @SequenceGenerator(name = "SQ_PROJECT", sequenceName = "SQ_PROJECT", allocationSize = 1)
    @GeneratedValue(generator = "SQ_PROJECT", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME_PROJECT", length = 100, nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Job.class)
    @JoinColumn(name = "ID_JOB")
    @JsonManagedReference
    private List<Job> jobs;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Manager.class)
    @JoinColumn(name = "ID_MANAGER")
    @JsonManagedReference
    private List<Manager> manager;
/*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Repositorio.class)
    @JoinColumn(name = "COD_ESTEIRA_IC")
    @JsonSerialize(using = SetSerializer.class)
    @FieldRequired(operations = { FieldRequiredOperation.SAVE_UPDATE })
    @FieldMin(min = 1)
    private Set<Repository> repositorios;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Sonar.class)
    @JoinColumn(name = "COD_ESTEIRA_IC")
    @JsonSerialize(using = SetSerializer.class)
    @FieldRequired(operations = { FieldRequiredOperation.SAVE_UPDATE })
    @FieldMin(min = 1)
    private Set<Sonar> sonares;
*/

    /**
     * Construtor Padrao.
     */
    public Project() {
    }

    /**
     * Construtor Auxiliar.
     */
    public Project(Integer id) {
        this.id = id;
    }

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

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Manager> getManager() {
        return manager;
    }

    public void setManager(List<Manager> manager) {
        this.manager = manager;
    }
}
