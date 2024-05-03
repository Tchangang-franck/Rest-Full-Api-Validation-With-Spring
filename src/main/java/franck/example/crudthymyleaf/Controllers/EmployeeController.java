package franck.example.crudthymyleaf.Controllers;

import franck.example.crudthymyleaf.Entities.Employe;
import franck.example.crudthymyleaf.Exception.ResourceNotFoundException;
import franck.example.crudthymyleaf.Repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    EmployeRepository employeRepository;

    @GetMapping("/employees")
    public List<Employe> getEmployees(){
        return  employeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employe> getEmployeeById(
            @PathVariable(value = "id")
            Long id
    )
    throws  ResourceNotFoundException{
        Employe employe= employeRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::"+ id));
        return ResponseEntity.ok().body(employe);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employees")
    public Employe createEmployee(@Valid @RequestBody Employe employe){
        return employeRepository.save(employe);
    }

    @PutMapping("/employees/{id}")
    public  ResponseEntity<Employe> updateEmployees(
            @PathVariable(value = "id")
            Long id,
            @Valid
            @RequestBody
            Employe employeDetails
    )
    throws  ResourceNotFoundException{
        Employe employe= employeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found for this id::"+ id));
        employe.setEmail(employeDetails.getEmail());
        employe.setFirstName(employeDetails.getFirstName());
        employe.setLastName(employeDetails.getLastName());
        employe.setPassportNumber(employeDetails.getPassportNumber());
        final  Employe updateEmployee= employeRepository.save(employe);
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping("/employees/{id}")
    public Map<String ,Boolean> deleteEmployee(
            @PathVariable(value="id")
            Long id)
            throws  ResourceNotFoundException {
                Employe employe= employeRepository.findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Employee not found for this id::"+ id));
                employeRepository.delete(employe);
                Map<String ,Boolean> response = new HashMap<>();
                response.put("delete",Boolean.TRUE);
                return  response;
    }
}
