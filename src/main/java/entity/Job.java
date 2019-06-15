package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Bruno Fernandes
 */
@Entity
@Table(name = "TB_JOB")
@SequenceGenerator(name = "SQ_JOB", sequenceName = "SQ_JOB", allocationSize = 1)
public class Job implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_JOB", unique = true)
    @GeneratedValue(generator = "SQ_JOB", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME_JOB", length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = JobType.class)
    @JoinColumn(name = "ID_JOB_TYPE", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_JOB_JOB_TYPE"))
    private JobType jobType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = InstanceJenkins.class)
    @JoinColumn(name = "ID_INSTANCE_JENKINS", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_JOB_INSTANCE_JENKINS"))
    private InstanceJenkins instanceJenkins;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Project.class)
    @JoinColumn(name = "ID_PROJECT", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_JOB_PROJECT"))
    @JsonBackReference
    private Project project;

    /**
     * Construtor Padrao.
     */
    public Job() {

    }

    /**
     * Contrutor Auxiliar parametrizado.
     *
     * @param id
     */
    public Job(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public InstanceJenkins getInstanceJenkins() {
        return instanceJenkins;
    }

    public void setInstanceJenkins(InstanceJenkins instanceJenkins) {
        this.instanceJenkins = instanceJenkins;
    }
}
