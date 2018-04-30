
package pt.scocs.pebvotebackend.domain;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vote", path = "vote")
public interface VoteRepository extends PagingAndSortingRepository<Vote, Long> {
    
    	List<Vote> findByIpAndJuri(@Param("ip") String ip, @Param("juri") Boolean juri);


}