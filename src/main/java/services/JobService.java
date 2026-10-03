package services;
import dtos.CompanyDTO;
import dtos.JobDTO;
import entities.Company;
import entities.Job;
import repositories.CompanyRepository;
import repositories.JobRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JobService
{
    private final CompanyRepository companyRepository;
    private final JobRepository jobRepository;
    public JobService(CompanyRepository companyRepository, JobRepository jobRepository)
    {
        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
    }
    public JobDTO createJob(JobDTO jobDTO)
    {
        Company company = companyRepository.findbyId(jobDTO.getCompany_id()).orElseThrow(()-> new RuntimeException("Didn't find the company!"));
        Job job = new Job();
        job.setCompany(company);
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setJobtype(jobDTO.getJobtype());
        job.setLocation(jobDTO.getLocation());
        job.setPostedAt(jobDTO.getPostedAt());
        job.setSalary(jobDTO.getSalary());
        Job savedJob = jobRepository.save(job);
        return convertToDTO(savedJob);
    }
    public JobDTO updateJob(JobDTO jobDTO, Long id)
    {
        Job foundJob = jobRepository.findById(id).orElseThrow(()-> new RuntimeException("Couldn't find job!"));
        Company company = companyRepository.findById(jobDTO.getCompany_id()).orElseThrow(()-> new RuntimeException("Couldn't find company!"));
        foundJob.setTitle(jobDTO.getTitle());
        foundJob.setDescription(jobDTO.getDescription());
        foundJob.setJobtype(jobDTO.getJobtype());
        foundJob.setLocation(jobDTO.getLocation());
        foundJob.setPostedAt(jobDTO.getPostedAt());
        foundJob.setSalary(jobDTO.getSalary());
        Job savedJob = jobRepository.save(foundJob);
        return convertToDTO(savedJob);
    }
    public JobDTO getById(Long id)
    {
        Job job = jobRepository.findById(id).orElseThrow(()->new RuntimeException(("Couldn't find job with this id!")));
        return convertToDTO(job);
    }
    public List<JobDTO> getAll()
    {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOs = new ArrayList<>();
        for(int i = 0; i < jobs.size(); i++)
        {
            jobDTOs.add(convertToDTO(jobs.get(i)));
        }
        return jobDTOs;
    }
    public void deleteJob(Long id)
    {
        if(!jobRepository.existsById(id))
        {
            throw new RuntimeException("Couldn't find job!");
        }
        jobRepository.deleteById(id);
    }
    public JobDTO convertToDTO(Job job)
    {
        return new JobDTO(job.getId(), job.getTitle(), job.getDescription(), job.getLocation(), job.getDescription(), job.getSalary(), job.getPostedAt(), job.getCompany().getId());
    }
}
