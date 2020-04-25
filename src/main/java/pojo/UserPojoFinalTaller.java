package pojo;

import lombok.Builder;

/**
 * Class that represent a response after a get request
 * @author eliecer.martinez@globant.com
 */
@Builder
public class UserPojoFinalTaller {

    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String final_note;
    private boolean approved;

    /**
     * Constructor.
     */
    public UserPojoFinalTaller() {}

    /**
     * Constructor.
     * @param id String
     * @param first_name String
     * @param last_name String
     * @param email String
     * @param final_note String
     * @param approved boolean
     */
    public UserPojoFinalTaller(String id, String first_name, String last_name, String email,
                               String final_note, boolean approved) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.final_note = final_note;
        this.approved = approved;
    }

    /**
     * Constructor.
     * @param first_name String
     * @param last_name String
     * @param email String
     * @param final_note String
     * @param approved boolean
     */
    public UserPojoFinalTaller(String first_name, String last_name, String email,
                               String final_note, boolean approved) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.final_note = final_note;
        this.approved = approved;
    }

    /**
     * Get id.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Set id.
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get first name.
     * @return String
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Set first name.
     * @param first_name String
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Get last name.
     * @return String
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Set last name
     * @param last_name String
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Get email.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get final_note.
     * @return String
     */
    public String getFinal_note() {
        return final_note;
    }

    /**
     * Set country.
     * @param final_note String
     */
    public void setFinal_note(String final_note) {
        this.final_note = final_note;
    }


    /**
     * Get approved.
     * @return boolean
     */
    public boolean getApproved() {
        return approved;
    }

    /**
     * Set active.
     * @param approved boolean
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * Override method toSting object.
     * @return String
     */
    @Override
    public String toString() {
        return "\nUser{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", final_note='" + final_note + '\'' +
                ", approved='" + approved + '\'' +
                '}';
    }
}
