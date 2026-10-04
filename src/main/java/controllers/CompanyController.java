package controllers;
import entities.*;
import dtos.*;
import services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CompanyController
{
    private final CompanyService companyService;
    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }
    @PutMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO)
    {
        CompanyDTO createdCompany = companyService.createCompany(companyDTO);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies()
    {
        List<CompanyDTO> companyDTOs = companyService.getAll();
        return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id)
    {
        CompanyDTO companyDTO = companyService.getById(id);
        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO)
    {
        CompanyDTO updatedCompany = companyService.updateCompany(companyDTO, id);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id)
    {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
