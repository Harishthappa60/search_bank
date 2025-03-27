package search.repository;

import search.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
    // Search by Name
    List<Branch> findByNameContainingIgnoreCase(String name);

    // Search by Code
    List<Branch> findByCodeContainingIgnoreCase(String code);

    // Search by City
    List<Branch> findByCityContainingIgnoreCase(String city);

    // Search by State
    List<Branch> findByStateContainingIgnoreCase(String state);
}
