package dtos;

public class CompanyDTO
{
    private Long id;
    private String name;
    private String websiteURL;
    private String desription;
    private String location;

    public CompanyDTO(){}
    public CompanyDTO(Long id, String name, String websiteURL, String desription, String location)
    {
        this.id = id;
        this.name = name;
        this.websiteURL = websiteURL;
        this.desription = desription;
        this.location = location;
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

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
