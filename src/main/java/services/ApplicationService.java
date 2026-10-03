package services;
import entities.*;
import repositories.*;
import dtos.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService
{
    private final JobRepository jobRepository;
    private final CandidateRepository candidateRepository;
    private final JobApplicationRepository jobApplicationRepository;
    public ApplicationService(JobRepository jobRepository, CandidateRepository candidateRepository, JobApplicationRepository jobApplicationRepository)
    {
        this.jobRepository = jobRepository;
        this.candidateRepository = candidateRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }
    public JobApplicationDTO createJobAppilication(JobApplicationDTO jobApplicationDTO)
    {
        Candidate candidate = candidateRepository.findById(jobApplicationDTO.getCandidate_id()).orElseThrow(()->new RuntimeException("Candidate Not Found!"));
        Job job = jobRepository.findById(jobApplicationDTO.getJob_id()).orElseThrow(()->new RuntimeException(("Job Not Found!")));
        JobApplication jobApplication = new JobApplication();
        jobApplication.setCandidate(candidate);
        jobApplication.setJob(job);
        jobApplication.setApplication_time(LocalDateTime.now());
        jobApplication.setStatus("APPLIED");
        JobApplication savedJobApplication = jobApplicationRepository.save(jobApplication);
        return convertToDTO(savedJobApplication);
    }
    public JobApplicationDTO updateJobApplication(JobApplicationDTO jobApplicationDTO, Long id)
    {
        JobApplication jobApplication = jobApplicationRepository.findById(id).orElseThrow(()->new RuntimeException(("Couldn't find a job with this id!")));
        jobApplication.setStatus(jobApplicationDTO.getStatus());
        jobApplication.setApplication_time(jobApplicationDTO.getApplication_time());
        jobApplication.setJob(jobApplication.getJob());
        jobApplication.setCandidate(jobApplication.getCandidate());
        return convertToDTO(jobApplication);
    }
    public JobApplicationDTO getById(Long id)
    {
        JobApplication jobApplication = jobApplicationRepository.findById(id).orElseThrow(()->new RuntimeException("Didn't find this id for a job application!"));
        return convertToDTO(jobApplication);
    }
    public List<JobApplicationDTO> findByCandidateId(Long candidateId)
    {
        List<JobApplication> jobApplications = jobApplicationRepository.findAll();
        List<JobApplicationDTO> jobApplicationDTOS = new ArrayList<>();
        for(int i = 0; i < jobApplications.size(); i++)
        {
            if(jobApplications.get(i).getCandidate().getId() == candidateId)
                jobApplicationDTOS.add(convertToDTO(jobApplications.get(i)));
        }
        return jobApplicationDTOS;
    }
    public List<JobApplicationDTO> findByJobId(Long jobId)
    {
        List<JobApplication> jobApplications = jobApplicationRepository.findAll();
        List<JobApplicationDTO> jobApplicationDTOS = new ArrayList<>();
        for(int i = 0; i < jobApplications.size(); i++)
        {
            if(jobApplications.get(i).getJob().getId() == jobId)
                jobApplicationDTOS.add(convertToDTO(jobApplications.get(i)));
        }
        return jobApplicationDTOS;
    }
    public List<JobApplicationDTO> getAll()
    {
        List<JobApplication> jobApplications = jobApplicationRepository.findAll();
        List<JobApplicationDTO> jobApplicationDTOS = new ArrayList<>();
        for(int i = 0; i < jobApplications.size(); i++)
        {
            jobApplicationDTOS.add(convertToDTO(jobApplications.get(i)));
        }
        return jobApplicationDTOS;
    }
    public void deleteJobApplication(Long id)
    {
        if(!jobApplicationRepository.existsById(id))
        {
            throw new RuntimeException("No such job application exists!");
        }
        jobApplicationRepository.deleteById(id);
    }
    public JobApplicationDTO convertToDTO(JobApplication jobApplication)
    {
        return new JobApplicationDTO(jobApplication.getId(), jobApplication.getCandidate().getId(), jobApplication.getJob().getId(), jobApplication.getStatus(), jobApplication.getApplication_time());
    }
}
