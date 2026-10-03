package services;
import dtos.CompanyDTO;
import entities.Company;
import repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyService
{
    private final CompanyRepository companyRepository;
    public CompanyService(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }
    public CompanyDTO createCompany(CompanyDTO companyDTO)
    {
        Company company = new Company();
        company.setDescription(companyDTO.getDesription());
        company.setLocation(companyDTO.getLocation());
        company.setName(companyDTO.getName());
        company.setWebsiteUrl(companyDTO.getWebsiteURL());
        company.setName(companyDTO.getName());
        Company savedCompany = companyRepository.save(company);
        return convertToDTO(savedCompany);
    }
    public CompanyDTO updateCompany(CompanyDTO companyDTO, Long id)
    {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException(("Can't find company with this id.")));
        company.setDescription(companyDTO.getDesription());
        company.setLocation(companyDTO.getLocation());
        company.setWebsiteUrl(companyDTO.getWebsiteURL());
        company.setName(companyDTO.getName());
        Company savedCompany = companyRepository.save(company);
        return convertToDTO(savedCompany);
    }
    public CompanyDTO getById(Long id)
    {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException(("Can't find company with this id.")));
        return convertToDTO(company);
    }
    public List<CompanyDTO> getAll()
    {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companiesDTO = new ArrayList<>();
        for(int i = 0; i < companies.size(); i++)
        {
            companiesDTO.add(convertToDTO(companies.get(i)));
        }
        return companiesDTO;
    }
    public void deleteCompany(Long id)
    {
        if(!companyRepository.existsById(id))
        {
            throw new RuntimeException("Company doesn't exist yet with this id.");
        }
        companyRepository.deleteById(id);
    }
    public CompanyDTO convertToDTO(Company company)
    {
        return new CompanyDTO(company.getId(), company.getName(), company.getWebsiteUrl(), company.getDescription(), company.getLocation());
    }
}
