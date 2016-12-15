
package ru.test.yandex.soap;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="login" type="{http://example.org/FPSPartner}P50Type"/>
 *         &lt;element name="password" type="{http://example.org/FPSPartner}P50Type"/>
 *         &lt;element name="partnerid" type="{http://example.org/FPSPartner}PartneridType"/>
 *         &lt;element name="applicationid" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="applicationdate" type="{http://example.org/FPSPartner}DatetimeType"/>
 *         &lt;element name="applicanttype" type="{http://example.org/FPSPartner}ApplicanttypeType"/>
 *         &lt;element name="applicanttypenum" type="{http://example.org/FPSPartner}ApplicanttypenumType"/>
 *         &lt;element name="responseisneeded" type="{http://example.org/FPSPartner}ResponseisneededType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "login",
    "password",
    "partnerid",
    "applicationid",
    "applicationdate",
    "applicanttype",
    "applicanttypenum",
    "responseisneeded"
})
@XmlRootElement(name = "processingApplication")
public class ProcessingApplication {

    @XmlElement(required = true)
    protected String login;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String partnerid;
    @XmlElement(required = true)
    protected String applicationid;
    @XmlElement(required = true)
    protected String applicationdate;
    @XmlElement(required = true)
    protected String applicanttype;
    @XmlElement(required = true)
    protected String applicanttypenum;
    @XmlElement(required = true)
    protected String responseisneeded;

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the partnerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerid() {
        return partnerid;
    }

    /**
     * Sets the value of the partnerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerid(String value) {
        this.partnerid = value;
    }

    /**
     * Gets the value of the applicationid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationid() {
        return applicationid;
    }

    /**
     * Sets the value of the applicationid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationid(String value) {
        this.applicationid = value;
    }

    /**
     * Gets the value of the applicationdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationdate() {
        return applicationdate;
    }

    /**
     * Sets the value of the applicationdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationdate(String value) {
        this.applicationdate = value;
    }

    /**
     * Gets the value of the applicanttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicanttype() {
        return applicanttype;
    }

    /**
     * Sets the value of the applicanttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicanttype(String value) {
        this.applicanttype = value;
    }

    /**
     * Gets the value of the applicanttypenum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicanttypenum() {
        return applicanttypenum;
    }

    /**
     * Sets the value of the applicanttypenum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicanttypenum(String value) {
        this.applicanttypenum = value;
    }

    /**
     * Gets the value of the responseisneeded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseisneeded() {
        return responseisneeded;
    }

    /**
     * Sets the value of the responseisneeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseisneeded(String value) {
        this.responseisneeded = value;
    }

}
