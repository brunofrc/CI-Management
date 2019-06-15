package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_BUILD")
public class Build {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_BUILD", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_BUILD", sequenceName = "SQ_BUILD", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Job.class)
    @JoinColumn(name = "COD_JOB", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_JOB_BUILD"))
    private Job job;

    @Column(name = "NUM_BUILD", nullable = false)
    private Integer number;

    @Column(name = "DAT_REGISTER", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateRegister;

    @Column(name = "TIME_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStart;

    @Column(name = "TIME_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeEnd;

    @Column(name = "RES_BUILD", length = 20)
    private String result;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
