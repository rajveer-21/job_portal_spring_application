package entities;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_applications")
public class JobApplication
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    @Column(nullable = false)
    private String status;
    private LocalDateTime application_time;

    public JobApplication(){}
    public JobApplication(Candidate candidate, Job job, String status, LocalDateTime application_time)
    {
        this.candidate = candidate;
        this.job = job;
        this.status = status;
        this.application_time = application_time;
    }

    public Long getId() {
        return id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
