package entity;

import javax.persistence.*;

@Entity
@Table(name = "INSTANCE_JENKINS", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_INSTANCE_JENKINS", columnNames = {"NAME",
                "NAME"})})
@SequenceGenerator(name = "SQ_INSTANCE_JENKINS", sequenceName = "SQ_INSTANCE_JENKINS", allocationSize = 1)
public class InstanceJenkins {

    @Column(name = "ID")
    @Id
    @SequenceGenerator(name = "SQ_INSTANCE_JENKINS", sequenceName = "SQ_INSTANCE_JENKINS", allocationSize = 1)
    @GeneratedValue(generator = "SQ_INSTANCE_JENKINS", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "URL")
    private String url;

    @Column(name = "NAME", length = 150)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Tool.class)
    @JoinColumn(name = "ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_INSTJENKINS_TOOL"))
    private Tool tool;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Authentication.class)
    @JoinColumn(name = "ID", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_INSTJENKINS_AUTHENTICATION"))
    private Authentication authentication;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
