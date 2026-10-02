package entities;
import jakarta.persistence.*;
@Entity
@Table(name = "candidates")
public class Candidate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String mail;
    @Column(nullable = false)
    private String phoneNo;
    @Column(nullable = false)
    private String resumeUrl;

    Candidate(){}
    Candidate(String name, String mail, String phoneNo, String resumeUrl)
    {
        this.name = name;
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.resumeUrl = resumeUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
}
