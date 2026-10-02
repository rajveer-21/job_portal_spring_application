package dtos;
import java.time.LocalDateTime;
public class JobApplicationDTO
{
    private Long id;
    private Long candidate_id;
    private Long job_id;
    private String status;
    private LocalDateTime application_time;

    public JobApplicationDTO(){}
    public JobApplicationDTO(Long id, Long candidate_id, Long job_id, String status, LocalDateTime application_time)
    {
        this.id = id;
        this.candidate_id = candidate_id;
        this.job_id = job_id;
        this.status = status;
        this.application_time = application_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Long candidate_id) {
        this.candidate_id = candidate_id;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getApplication_time() {
        return application_time;
    }

    public void setApplication_time(LocalDateTime application_time) {
        this.application_time = application_time;
    }
}
