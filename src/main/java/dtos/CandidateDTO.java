package dtos;

public class CandidateDTO
{
    private Long id;
    private String name;
    private String mail;
    private String phoneNo;
    private String resumeURL;

    public CandidateDTO(){}
    public CandidateDTO(Long id, String name, String mail, String phoneNo, String resumeURL)
    {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.resumeURL = resumeURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }
}

