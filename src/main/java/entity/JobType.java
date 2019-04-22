package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_JOB_TYPE", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_TB_JOB_TYPE", columnNames = "NAME_JOB_TYPE")})
@SequenceGenerator(name = "SQ_JOB_TYPE", sequenceName = "SQ_JOB_TYPE", allocationSize = 1)
public class JobType implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_JOB_TYPE", unique = true)
    @GeneratedValue(generator = "SQ_JOB_TYPE", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME_JOB_TYPE", length = 50)
    private String name;
}
