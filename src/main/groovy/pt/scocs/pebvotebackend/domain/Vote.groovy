package pt.scocs.pebvotebackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;

@Entity
@Table(
    name="Vote", 
    uniqueConstraints=@UniqueConstraint(columnNames=[ "band", "ip", "juri"])
)
public class Vote {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

    
	Integer band;
    String bandName;
	String ip;
    Integer rate;
    Date createDate = new Date()
    Boolean juri = false;

}