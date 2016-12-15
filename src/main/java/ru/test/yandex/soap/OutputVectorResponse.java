
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
 *         &lt;element name="applicationid" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="status" type="{http://example.org/FPSPartner}StatusType"/>
 *         &lt;element name="mainrules" type="{http://example.org/FPSPartner}P1024Type"/>
 *         &lt;element name="mainscorevalue" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="specificrules" type="{http://example.org/FPSPartner}P1024Type"/>
 *         &lt;element name="applicationsfound" type="{http://example.org/FPSPartner}P15Type"/>
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
    "applicationid",
    "status",
    "mainrules",
    "mainscorevalue",
    "specificrules",
    "applicationsfound"
})
@XmlRootElement(name = "outputVectorResponse")
public class OutputVectorResponse {

    @XmlElement(required = true)
    protected String applicationid;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected String mainrules;
    @XmlElement(required = true)
    protected String mainscorevalue;
    @XmlElement(required = true)
    protected String specificrules;
    @XmlElement(required = true)
    protected String applicationsfound;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the mainrules property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainrules() {
        return mainrules;
    }

    /**
     * Sets the value of the mainrules property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainrules(String value) {
        this.mainrules = value;
    }

    /**
     * Gets the value of the mainscorevalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainscorevalue() {
        return mainscorevalue;
    }

    /**
     * Sets the value of the mainscorevalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainscorevalue(String value) {
        this.mainscorevalue = value;
    }

    /**
     * Gets the value of the specificrules property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificrules() {
        return specificrules;
    }

    /**
     * Sets the value of the specificrules property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificrules(String value) {
        this.specificrules = value;
    }

    /**
     * Gets the value of the applicationsfound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationsfound() {
        return applicationsfound;
    }

    /**
     * Sets the value of the applicationsfound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationsfound(String value) {
        this.applicationsfound = value;
    }

}
