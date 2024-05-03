package franck.example.crudthymyleaf.Repository;

import franck.example.crudthymyleaf.Entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {


}
