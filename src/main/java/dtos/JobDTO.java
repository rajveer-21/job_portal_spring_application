package dtos;
import java.time.LocalDateTime;
public class JobDTO
{
    private Long id;
    private String title;
    private String description;
    private String location;
    private String jobtype;
    private Double salary;
    private LocalDateTime postedAt;
    private Long company_id;

    public JobDTO(){}
    public JobDTO(Long id, String title, String description, String location, String jobtype, Double salary, LocalDateTime postedAt, Long company_id)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.jobtype = jobtype;
        this.salary = salary;
        this.postedAt = postedAt;
        this.company_id = company_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }
}
