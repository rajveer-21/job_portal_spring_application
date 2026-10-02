package services;
import entities.Candidate;
import dtos.CandidateDTO;
import repositories.CandidateRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService
{
    public final CandidateRepository candidateRepository;
    public CandidateService(CandidateRepository candidateRepository)
    {
        this.candidateRepository = candidateRepository;
    }
    public CandidateDTO createCandidate(CandidateDTO candidateDTO)
    {
        Candidate candidate = new Candidate();
        candidate.setName(candidateDTO.getName());
        candidate.setMail(candidateDTO.getMail());
        candidate.setPhoneNo(candidateDTO.getPhoneNo());
        candidate.setResumeUrl(candidateDTO.getResumeURL());
        Candidate savedCandidate = candidateRepository.save(candidate);
        return convertToDTO(savedCandidate);
    }
    public CandidateDTO updateCandidate(Long id,CandidateDTO candidateDTO)
    {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(()-> new RuntimeException("Candidate Not Found!"));
        candidate.setName(candidateDTO.getName());
        candidate.setMail(candidateDTO.getMail());
        candidate.setPhoneNo(candidateDTO.getPhoneNo());
        candidate.setResumeUrl(candidateDTO.getResumeURL());
        Candidate savedCandidate = candidateRepository.save(candidate);
        return convertToDTO(savedCandidate);
    }
    public CandidateDTO getById(Long id)
    {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(()-> new RuntimeException("Candidate Not Found"));
        return convertToDTO(candidate);
    }
    public List<CandidateDTO> getAll()
    {
        List<Candidate> candidates = candidateRepository.findAll();
        List<CandidateDTO> candidateDTOs = new ArrayList<>();
        for(Candidate candidate : candidates)
        {
            candidateDTOs.add(convertToDTO(candidate));
        }
        return candidateDTOs;
    }
    public void deleteCandidate(Long id)
    {
        if(!candidateRepository.existsById(id))
        {
            throw new RuntimeException("Candidate Not Found!");
        }
        candidateRepository.deleteById(id);
    }
    public CandidateDTO convertToDTO(Candidate candidate)
    {
        return new CandidateDTO(candidate.getId(), candidate.getName(), candidate.getMail(), candidate.getPhoneNo(), candidate.getResumeUrl());
    }
}
