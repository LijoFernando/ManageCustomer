package manageDetails;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.annotation.Generated;
import java.sql.Date;

public class Customer {


    //Variables
    private int Id;
    private String name;
    private Date dofBirth;

    //Getter and Setter for name and Date
    public int getId() {
        return Id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDofBirth() {
        return dofBirth;
    }

    public void setDofBirth(Date dofBirth) {
        this.dofBirth = dofBirth;
    }

}
