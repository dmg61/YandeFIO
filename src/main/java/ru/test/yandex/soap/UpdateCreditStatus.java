
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
 *         &lt;element name="applicationstatus" type="{http://example.org/FPSPartner}ApplicationstatusType"/>
 *         &lt;element name="applicantid" type="{http://example.org/FPSPartner}ApplicantidType"/>
 *         &lt;element name="tradedate" type="{http://example.org/FPSPartner}DateType"/>
 *         &lt;element name="initialsumlimit" type="{http://example.org/FPSPartner}P15_2Type"/>
 *         &lt;element name="initialsumcurrency" type="{http://example.org/FPSPartner}ProductsumcurrencyType"/>
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
    "applicationstatus",
    "applicantid",
    "tradedate",
    "initialsumlimit",
    "initialsumcurrency"
})
@XmlRootElement(name = "updateCreditStatus")
public class UpdateCreditStatus {

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
    protected String applicationstatus;
    @XmlElement(required = true)
    protected String applicantid;
    @XmlElement(required = true)
    protected String tradedate;
    @XmlElement(required = true)
    protected String initialsumlimit;
    @XmlElement(required = true)
    protected String initialsumcurrency;

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
     * Gets the value of the applicationstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationstatus() {
        return applicationstatus;
    }

    /**
     * Sets the value of the applicationstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationstatus(String value) {
        this.applicationstatus = value;
    }

    /**
     * Gets the value of the applicantid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantid() {
        return applicantid;
    }

    /**
     * Sets the value of the applicantid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantid(String value) {
        this.applicantid = value;
    }

    /**
     * Gets the value of the tradedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradedate() {
        return tradedate;
    }

    /**
     * Sets the value of the tradedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradedate(String value) {
        this.tradedate = value;
    }

    /**
     * Gets the value of the initialsumlimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialsumlimit() {
        return initialsumlimit;
    }

    /**
     * Sets the value of the initialsumlimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialsumlimit(String value) {
        this.initialsumlimit = value;
    }

    /**
     * Gets the value of the initialsumcurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialsumcurrency() {
        return initialsumcurrency;
    }

    /**
     * Sets the value of the initialsumcurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialsumcurrency(String value) {
        this.initialsumcurrency = value;
    }

}
