package controllers;
import entities.Candidate;
import dtos.CandidateDTO;
import services.CandidateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController
{
    private final CandidateService candidateService;
    public CandidateController(CandidateService candidateService)
    {
        this.candidateService = candidateService;
    }
    @PostMapping
    public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateDTO candidateDTO)
    {
        CandidateDTO createdCandidate = candidateService.createCandidate(candidateDTO);
        return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CandidateDTO>> getAllCandidates()
    {
        List<CandidateDTO> candidateDTOs = candidateService.getAll();
        return new ResponseEntity<>(candidateDTOs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CandidateDTO> getCandidate(@PathVariable Long id)
    {
        CandidateDTO candidateDTO = candidateService.getById(id);
        return new ResponseEntity<>(candidateDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CandidateDTO> updateCandidate(@PathVariable Long id, @RequestBody CandidateDTO candidateDTO)
    {
        CandidateDTO updatedCandidate = candidateService.updateCandidate(id, candidateDTO);
        return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id)
    {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }
}

