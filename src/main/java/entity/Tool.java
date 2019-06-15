package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_TOOL", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_NAME_TOOL", columnNames = {"NAME"})})
public class Tool implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @SequenceGenerator(name = "SQ_TOOL", sequenceName = "SQ_TOOL", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "SQ_TOOL", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ToolType.class)
    @JoinColumn(name = "ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TOOL_TOOLTYPE"))
    private ToolType toolType;

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

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }
}
