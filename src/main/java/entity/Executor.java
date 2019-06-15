package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_EXECUTOR")
@SequenceGenerator(name = "SQ_EXECUTOR", sequenceName = "SQ_EXECUTOR", allocationSize = 1, initialValue = 1)
public class Executor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_EXECUTOR", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Tool.class)
    @JoinColumn(name = "ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_EXECUTOR_TOOL"))
    private Tool tool;

    @Column(name = "DAT_EXECUTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "RESULT", length = 200)
    private String result;

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

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
