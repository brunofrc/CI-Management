package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_TOOL_TYPE", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_NAME_TOOL_TYPE", columnNames = {"NAME"})})
public class ToolType implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @SequenceGenerator(name = "SQ_TOOL_TYPE", sequenceName = "SQ_TOOL_TYPE", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

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
}
