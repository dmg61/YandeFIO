
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
 *         &lt;element name="photoid" type="{http://example.org/FPSPartner}P100Type" minOccurs="0"/>
 *         &lt;element name="lastname" type="{http://example.org/FPSPartner}P50Type"/>
 *         &lt;element name="firstname" type="{http://example.org/FPSPartner}P50Type"/>
 *         &lt;element name="middlename" type="{http://example.org/FPSPartner}P50Type"/>
 *         &lt;element name="pastlastname" type="{http://example.org/FPSPartner}P50Type"/>
 *         &lt;element name="birthday" type="{http://example.org/FPSPartner}DateType"/>
 *         &lt;element name="birthplace" type="{http://example.org/FPSPartner}P255Type"/>
 *         &lt;element name="doctype" type="{http://example.org/FPSPartner}DoctypeType"/>
 *         &lt;element name="docno" type="{http://example.org/FPSPartner}P20Type"/>
 *         &lt;element name="docplace" type="{http://example.org/FPSPartner}P255Type"/>
 *         &lt;element name="docdate" type="{http://example.org/FPSPartner}DateType"/>
 *         &lt;element name="doccode" type="{http://example.org/FPSPartner}P6Type"/>
 *         &lt;element name="pastdoctype" type="{http://example.org/FPSPartner}DoctypeType"/>
 *         &lt;element name="pastdocno" type="{http://example.org/FPSPartner}P20Type"/>
 *         &lt;element name="pastdocplace" type="{http://example.org/FPSPartner}P255Type"/>
 *         &lt;element name="pastdocdate" type="{http://example.org/FPSPartner}DateType"/>
 *         &lt;element name="sex" type="{http://example.org/FPSPartner}SexType"/>
 *         &lt;element name="citizenship" type="{http://example.org/FPSPartner}CitizenshipType"/>
 *         &lt;element name="inn" type="{http://example.org/FPSPartner}P12Type"/>
 *         &lt;element name="pfr" type="{http://example.org/FPSPartner}PfrType"/>
 *         &lt;element name="driverno" type="{http://example.org/FPSPartner}DrivernoType"/>
 *         &lt;element name="education" type="{http://example.org/FPSPartner}EducationType"/>
 *         &lt;element name="marital" type="{http://example.org/FPSPartner}MaritalType"/>
 *         &lt;element name="numchildren" type="{http://example.org/FPSPartner}P5Type"/>
 *         &lt;element name="email" type="{http://example.org/FPSPartner}P50Type"/>
 *         &lt;element name="homephone" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="mobilephone" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="la_country" type="{http://example.org/FPSPartner}CitizenshipType"/>
 *         &lt;element name="la_index" type="{http://example.org/FPSPartner}P6Type"/>
 *         &lt;element name="la_region" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="la_district" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="la_city" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="la_settlement" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="la_street" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="la_house" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="la_building" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="la_structure" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="la_apartment" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="la_years" type="{http://example.org/FPSPartner}P5Type"/>
 *         &lt;element name="la_month" type="{http://example.org/FPSPartner}P5Type"/>
 *         &lt;element name="la_date" type="{http://example.org/FPSPartner}DateType"/>
 *         &lt;element name="ra_phone" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ra_country" type="{http://example.org/FPSPartner}CitizenshipType"/>
 *         &lt;element name="ra_index" type="{http://example.org/FPSPartner}P6Type"/>
 *         &lt;element name="ra_region" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ra_district" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ra_city" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ra_settlement" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ra_street" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ra_house" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ra_building" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ra_structure" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ra_apartment" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="employername" type="{http://example.org/FPSPartner}P255Type"/>
 *         &lt;element name="employersize" type="{http://example.org/FPSPartner}EmployersizeType"/>
 *         &lt;element name="businessindustry" type="{http://example.org/FPSPartner}BusinessindustryType"/>
 *         &lt;element name="position" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="employment_year" type="{http://example.org/FPSPartner}P5Type"/>
 *         &lt;element name="employment_month" type="{http://example.org/FPSPartner}P5Type"/>
 *         &lt;element name="employment_date" type="{http://example.org/FPSPartner}DateType"/>
 *         &lt;element name="employment_inn" type="{http://example.org/FPSPartner}P12Type"/>
 *         &lt;element name="incomeproof" type="{http://example.org/FPSPartner}IncomeproofType"/>
 *         &lt;element name="monthlyincome" type="{http://example.org/FPSPartner}P15_2Type"/>
 *         &lt;element name="ba_phone" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ba_country" type="{http://example.org/FPSPartner}CitizenshipType"/>
 *         &lt;element name="ba_index" type="{http://example.org/FPSPartner}P6Type"/>
 *         &lt;element name="ba_region" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ba_district" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ba_city" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ba_settlement" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ba_street" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="ba_house" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ba_building" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ba_structure" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="ba_apartment" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="producttype" type="{http://example.org/FPSPartner}ProducttypeType"/>
 *         &lt;element name="productname" type="{http://example.org/FPSPartner}P255Type"/>
 *         &lt;element name="originalchannel" type="{http://example.org/FPSPartner}OriginalchannelType"/>
 *         &lt;element name="productsumlimit" type="{http://example.org/FPSPartner}P15_2Type"/>
 *         &lt;element name="productsumcurrency" type="{http://example.org/FPSPartner}ProductsumcurrencyType"/>
 *         &lt;element name="downpaymentamount" type="{http://example.org/FPSPartner}P15_2Type"/>
 *         &lt;element name="collateralexistence" type="{http://example.org/FPSPartner}CollateralexistenceType"/>
 *         &lt;element name="collateralvalue" type="{http://example.org/FPSPartner}P15_2Type"/>
 *         &lt;element name="purchaseexistence" type="{http://example.org/FPSPartner}PurchaseexistenceType"/>
 *         &lt;element name="purchasevalue" type="{http://example.org/FPSPartner}P15_2Type"/>
 *         &lt;element name="purchasemodel" type="{http://example.org/FPSPartner}P255Type"/>
 *         &lt;element name="operator_code" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="operator_name" type="{http://example.org/FPSPartner}P255Type"/>
 *         &lt;element name="pos_code" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="pos_phone" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="pos_country" type="{http://example.org/FPSPartner}CitizenshipType"/>
 *         &lt;element name="pos_index" type="{http://example.org/FPSPartner}P6Type"/>
 *         &lt;element name="pos_region" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="pos_district" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="pos_city" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="pos_settlement" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="pos_street" type="{http://example.org/FPSPartner}P100Type"/>
 *         &lt;element name="pos_house" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="pos_building" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="pos_structure" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="pos_apartment" type="{http://example.org/FPSPartner}P15Type"/>
 *         &lt;element name="newapplicant" type="{http://example.org/FPSPartner}NewapplicantType"/>
 *         &lt;element name="applicanttype" type="{http://example.org/FPSPartner}ApplicanttypeType"/>
 *         &lt;element name="applicanttypenum" type="{http://example.org/FPSPartner}ApplicanttypenumType"/>
 *         &lt;element name="responseisneeded" type="{http://example.org/FPSPartner}ResponseisneededType"/>
 *         &lt;element name="applicationstatus" type="{http://example.org/FPSPartner}ApplicationstatusType"/>
 *         &lt;element name="applicantid" type="{http://example.org/FPSPartner}ApplicantidType"/>
 *         &lt;element name="tradedate" type="{http://example.org/FPSPartner}DateType"/>
 *         &lt;element name="initialsumlimit" type="{http://example.org/FPSPartner}P15_2Type"/>
 *         &lt;element name="initialsumcurrency" type="{http://example.org/FPSPartner}ProductsumcurrencyType"/>
 *         &lt;element name="applicationfraudstatus" type="{http://example.org/FPSPartner}ApplicationfraudstatusType"/>
 *         &lt;element name="applicationfraudstatusdescr" type="{http://example.org/FPSPartner}P1024Type"/>
 *         &lt;element name="defaultstatus" type="{http://example.org/FPSPartner}DefaultstatusType"/>
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
    "photoid",
    "lastname",
    "firstname",
    "middlename",
    "pastlastname",
    "birthday",
    "birthplace",
    "doctype",
    "docno",
    "docplace",
    "docdate",
    "doccode",
    "pastdoctype",
    "pastdocno",
    "pastdocplace",
    "pastdocdate",
    "sex",
    "citizenship",
    "inn",
    "pfr",
    "driverno",
    "education",
    "marital",
    "numchildren",
    "email",
    "homephone",
    "mobilephone",
    "laCountry",
    "laIndex",
    "laRegion",
    "laDistrict",
    "laCity",
    "laSettlement",
    "laStreet",
    "laHouse",
    "laBuilding",
    "laStructure",
    "laApartment",
    "laYears",
    "laMonth",
    "laDate",
    "raPhone",
    "raCountry",
    "raIndex",
    "raRegion",
    "raDistrict",
    "raCity",
    "raSettlement",
    "raStreet",
    "raHouse",
    "raBuilding",
    "raStructure",
    "raApartment",
    "employername",
    "employersize",
    "businessindustry",
    "position",
    "employmentYear",
    "employmentMonth",
    "employmentDate",
    "employmentInn",
    "incomeproof",
    "monthlyincome",
    "baPhone",
    "baCountry",
    "baIndex",
    "baRegion",
    "baDistrict",
    "baCity",
    "baSettlement",
    "baStreet",
    "baHouse",
    "baBuilding",
    "baStructure",
    "baApartment",
    "producttype",
    "productname",
    "originalchannel",
    "productsumlimit",
    "productsumcurrency",
    "downpaymentamount",
    "collateralexistence",
    "collateralvalue",
    "purchaseexistence",
    "purchasevalue",
    "purchasemodel",
    "operatorCode",
    "operatorName",
    "posCode",
    "posPhone",
    "posCountry",
    "posIndex",
    "posRegion",
    "posDistrict",
    "posCity",
    "posSettlement",
    "posStreet",
    "posHouse",
    "posBuilding",
    "posStructure",
    "posApartment",
    "newapplicant",
    "applicanttype",
    "applicanttypenum",
    "responseisneeded",
    "applicationstatus",
    "applicantid",
    "tradedate",
    "initialsumlimit",
    "initialsumcurrency",
    "applicationfraudstatus",
    "applicationfraudstatusdescr",
    "defaultstatus"
})
@XmlRootElement(name = "newApplication")
public class NewApplication {

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
    protected String photoid;
    @XmlElement(required = true)
    protected String lastname;
    @XmlElement(required = true)
    protected String firstname;
    @XmlElement(required = true)
    protected String middlename;
    @XmlElement(required = true)
    protected String pastlastname;
    @XmlElement(required = true)
    protected String birthday;
    @XmlElement(required = true)
    protected String birthplace;
    @XmlElement(required = true)
    protected String doctype;
    @XmlElement(required = true)
    protected String docno;
    @XmlElement(required = true)
    protected String docplace;
    @XmlElement(required = true)
    protected String docdate;
    @XmlElement(required = true)
    protected String doccode;
    @XmlElement(required = true)
    protected String pastdoctype;
    @XmlElement(required = true)
    protected String pastdocno;
    @XmlElement(required = true)
    protected String pastdocplace;
    @XmlElement(required = true)
    protected String pastdocdate;
    @XmlElement(required = true)
    protected String sex;
    @XmlElement(required = true)
    protected String citizenship;
    @XmlElement(required = true)
    protected String inn;
    @XmlElement(required = true)
    protected String pfr;
    @XmlElement(required = true)
    protected String driverno;
    @XmlElement(required = true)
    protected String education;
    @XmlElement(required = true)
    protected String marital;
    @XmlElement(required = true)
    protected String numchildren;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String homephone;
    @XmlElement(required = true)
    protected String mobilephone;
    @XmlElement(name = "la_country", required = true)
    protected String laCountry;
    @XmlElement(name = "la_index", required = true)
    protected String laIndex;
    @XmlElement(name = "la_region", required = true)
    protected String laRegion;
    @XmlElement(name = "la_district", required = true)
    protected String laDistrict;
    @XmlElement(name = "la_city", required = true)
    protected String laCity;
    @XmlElement(name = "la_settlement", required = true)
    protected String laSettlement;
    @XmlElement(name = "la_street", required = true)
    protected String laStreet;
    @XmlElement(name = "la_house", required = true)
    protected String laHouse;
    @XmlElement(name = "la_building", required = true)
    protected String laBuilding;
    @XmlElement(name = "la_structure", required = true)
    protected String laStructure;
    @XmlElement(name = "la_apartment", required = true)
    protected String laApartment;
    @XmlElement(name = "la_years", required = true)
    protected String laYears;
    @XmlElement(name = "la_month", required = true)
    protected String laMonth;
    @XmlElement(name = "la_date", required = true)
    protected String laDate;
    @XmlElement(name = "ra_phone", required = true)
    protected String raPhone;
    @XmlElement(name = "ra_country", required = true)
    protected String raCountry;
    @XmlElement(name = "ra_index", required = true)
    protected String raIndex;
    @XmlElement(name = "ra_region", required = true)
    protected String raRegion;
    @XmlElement(name = "ra_district", required = true)
    protected String raDistrict;
    @XmlElement(name = "ra_city", required = true)
    protected String raCity;
    @XmlElement(name = "ra_settlement", required = true)
    protected String raSettlement;
    @XmlElement(name = "ra_street", required = true)
    protected String raStreet;
    @XmlElement(name = "ra_house", required = true)
    protected String raHouse;
    @XmlElement(name = "ra_building", required = true)
    protected String raBuilding;
    @XmlElement(name = "ra_structure", required = true)
    protected String raStructure;
    @XmlElement(name = "ra_apartment", required = true)
    protected String raApartment;
    @XmlElement(required = true)
    protected String employername;
    @XmlElement(required = true)
    protected String employersize;
    @XmlElement(required = true)
    protected String businessindustry;
    @XmlElement(required = true)
    protected String position;
    @XmlElement(name = "employment_year", required = true)
    protected String employmentYear;
    @XmlElement(name = "employment_month", required = true)
    protected String employmentMonth;
    @XmlElement(name = "employment_date", required = true)
    protected String employmentDate;
    @XmlElement(name = "employment_inn", required = true)
    protected String employmentInn;
    @XmlElement(required = true)
    protected String incomeproof;
    @XmlElement(required = true)
    protected String monthlyincome;
    @XmlElement(name = "ba_phone", required = true)
    protected String baPhone;
    @XmlElement(name = "ba_country", required = true)
    protected String baCountry;
    @XmlElement(name = "ba_index", required = true)
    protected String baIndex;
    @XmlElement(name = "ba_region", required = true)
    protected String baRegion;
    @XmlElement(name = "ba_district", required = true)
    protected String baDistrict;
    @XmlElement(name = "ba_city", required = true)
    protected String baCity;
    @XmlElement(name = "ba_settlement", required = true)
    protected String baSettlement;
    @XmlElement(name = "ba_street", required = true)
    protected String baStreet;
    @XmlElement(name = "ba_house", required = true)
    protected String baHouse;
    @XmlElement(name = "ba_building", required = true)
    protected String baBuilding;
    @XmlElement(name = "ba_structure", required = true)
    protected String baStructure;
    @XmlElement(name = "ba_apartment", required = true)
    protected String baApartment;
    @XmlElement(required = true)
    protected String producttype;
    @XmlElement(required = true)
    protected String productname;
    @XmlElement(required = true)
    protected String originalchannel;
    @XmlElement(required = true)
    protected String productsumlimit;
    @XmlElement(required = true)
    protected String productsumcurrency;
    @XmlElement(required = true)
    protected String downpaymentamount;
    @XmlElement(required = true)
    protected String collateralexistence;
    @XmlElement(required = true)
    protected String collateralvalue;
    @XmlElement(required = true)
    protected String purchaseexistence;
    @XmlElement(required = true)
    protected String purchasevalue;
    @XmlElement(required = true)
    protected String purchasemodel;
    @XmlElement(name = "operator_code", required = true)
    protected String operatorCode;
    @XmlElement(name = "operator_name", required = true)
    protected String operatorName;
    @XmlElement(name = "pos_code", required = true)
    protected String posCode;
    @XmlElement(name = "pos_phone", required = true)
    protected String posPhone;
    @XmlElement(name = "pos_country", required = true)
    protected String posCountry;
    @XmlElement(name = "pos_index", required = true)
    protected String posIndex;
    @XmlElement(name = "pos_region", required = true)
    protected String posRegion;
    @XmlElement(name = "pos_district", required = true)
    protected String posDistrict;
    @XmlElement(name = "pos_city", required = true)
    protected String posCity;
    @XmlElement(name = "pos_settlement", required = true)
    protected String posSettlement;
    @XmlElement(name = "pos_street", required = true)
    protected String posStreet;
    @XmlElement(name = "pos_house", required = true)
    protected String posHouse;
    @XmlElement(name = "pos_building", required = true)
    protected String posBuilding;
    @XmlElement(name = "pos_structure", required = true)
    protected String posStructure;
    @XmlElement(name = "pos_apartment", required = true)
    protected String posApartment;
    @XmlElement(required = true)
    protected String newapplicant;
    @XmlElement(required = true)
    protected String applicanttype;
    @XmlElement(required = true)
    protected String applicanttypenum;
    @XmlElement(required = true)
    protected String responseisneeded;
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
    @XmlElement(required = true)
    protected String applicationfraudstatus;
    @XmlElement(required = true)
    protected String applicationfraudstatusdescr;
    @XmlElement(required = true)
    protected String defaultstatus;

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
     * Gets the value of the photoid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhotoid() {
        return photoid;
    }

    /**
     * Sets the value of the photoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhotoid(String value) {
        this.photoid = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the middlename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * Sets the value of the middlename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddlename(String value) {
        this.middlename = value;
    }

    /**
     * Gets the value of the pastlastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPastlastname() {
        return pastlastname;
    }

    /**
     * Sets the value of the pastlastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPastlastname(String value) {
        this.pastlastname = value;
    }

    /**
     * Gets the value of the birthday property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets the value of the birthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthday(String value) {
        this.birthday = value;
    }

    /**
     * Gets the value of the birthplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * Sets the value of the birthplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthplace(String value) {
        this.birthplace = value;
    }

    /**
     * Gets the value of the doctype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctype() {
        return doctype;
    }

    /**
     * Sets the value of the doctype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctype(String value) {
        this.doctype = value;
    }

    /**
     * Gets the value of the docno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocno() {
        return docno;
    }

    /**
     * Sets the value of the docno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocno(String value) {
        this.docno = value;
    }

    /**
     * Gets the value of the docplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocplace() {
        return docplace;
    }

    /**
     * Sets the value of the docplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocplace(String value) {
        this.docplace = value;
    }

    /**
     * Gets the value of the docdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocdate() {
        return docdate;
    }

    /**
     * Sets the value of the docdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocdate(String value) {
        this.docdate = value;
    }

    /**
     * Gets the value of the doccode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoccode() {
        return doccode;
    }

    /**
     * Sets the value of the doccode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoccode(String value) {
        this.doccode = value;
    }

    /**
     * Gets the value of the pastdoctype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPastdoctype() {
        return pastdoctype;
    }

    /**
     * Sets the value of the pastdoctype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPastdoctype(String value) {
        this.pastdoctype = value;
    }

    /**
     * Gets the value of the pastdocno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPastdocno() {
        return pastdocno;
    }

    /**
     * Sets the value of the pastdocno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPastdocno(String value) {
        this.pastdocno = value;
    }

    /**
     * Gets the value of the pastdocplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPastdocplace() {
        return pastdocplace;
    }

    /**
     * Sets the value of the pastdocplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPastdocplace(String value) {
        this.pastdocplace = value;
    }

    /**
     * Gets the value of the pastdocdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPastdocdate() {
        return pastdocdate;
    }

    /**
     * Sets the value of the pastdocdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPastdocdate(String value) {
        this.pastdocdate = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the citizenship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * Sets the value of the citizenship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitizenship(String value) {
        this.citizenship = value;
    }

    /**
     * Gets the value of the inn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInn() {
        return inn;
    }

    /**
     * Sets the value of the inn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInn(String value) {
        this.inn = value;
    }

    /**
     * Gets the value of the pfr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPfr() {
        return pfr;
    }

    /**
     * Sets the value of the pfr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPfr(String value) {
        this.pfr = value;
    }

    /**
     * Gets the value of the driverno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverno() {
        return driverno;
    }

    /**
     * Sets the value of the driverno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverno(String value) {
        this.driverno = value;
    }

    /**
     * Gets the value of the education property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEducation() {
        return education;
    }

    /**
     * Sets the value of the education property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEducation(String value) {
        this.education = value;
    }

    /**
     * Gets the value of the marital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarital() {
        return marital;
    }

    /**
     * Sets the value of the marital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarital(String value) {
        this.marital = value;
    }

    /**
     * Gets the value of the numchildren property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumchildren() {
        return numchildren;
    }

    /**
     * Sets the value of the numchildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumchildren(String value) {
        this.numchildren = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the homephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomephone() {
        return homephone;
    }

    /**
     * Sets the value of the homephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomephone(String value) {
        this.homephone = value;
    }

    /**
     * Gets the value of the mobilephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * Sets the value of the mobilephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilephone(String value) {
        this.mobilephone = value;
    }

    /**
     * Gets the value of the laCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaCountry() {
        return laCountry;
    }

    /**
     * Sets the value of the laCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaCountry(String value) {
        this.laCountry = value;
    }

    /**
     * Gets the value of the laIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaIndex() {
        return laIndex;
    }

    /**
     * Sets the value of the laIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaIndex(String value) {
        this.laIndex = value;
    }

    /**
     * Gets the value of the laRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaRegion() {
        return laRegion;
    }

    /**
     * Sets the value of the laRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaRegion(String value) {
        this.laRegion = value;
    }

    /**
     * Gets the value of the laDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaDistrict() {
        return laDistrict;
    }

    /**
     * Sets the value of the laDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaDistrict(String value) {
        this.laDistrict = value;
    }

    /**
     * Gets the value of the laCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaCity() {
        return laCity;
    }

    /**
     * Sets the value of the laCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaCity(String value) {
        this.laCity = value;
    }

    /**
     * Gets the value of the laSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaSettlement() {
        return laSettlement;
    }

    /**
     * Sets the value of the laSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaSettlement(String value) {
        this.laSettlement = value;
    }

    /**
     * Gets the value of the laStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaStreet() {
        return laStreet;
    }

    /**
     * Sets the value of the laStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaStreet(String value) {
        this.laStreet = value;
    }

    /**
     * Gets the value of the laHouse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaHouse() {
        return laHouse;
    }

    /**
     * Sets the value of the laHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaHouse(String value) {
        this.laHouse = value;
    }

    /**
     * Gets the value of the laBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaBuilding() {
        return laBuilding;
    }

    /**
     * Sets the value of the laBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaBuilding(String value) {
        this.laBuilding = value;
    }

    /**
     * Gets the value of the laStructure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaStructure() {
        return laStructure;
    }

    /**
     * Sets the value of the laStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaStructure(String value) {
        this.laStructure = value;
    }

    /**
     * Gets the value of the laApartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaApartment() {
        return laApartment;
    }

    /**
     * Sets the value of the laApartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaApartment(String value) {
        this.laApartment = value;
    }

    /**
     * Gets the value of the laYears property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaYears() {
        return laYears;
    }

    /**
     * Sets the value of the laYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaYears(String value) {
        this.laYears = value;
    }

    /**
     * Gets the value of the laMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaMonth() {
        return laMonth;
    }

    /**
     * Sets the value of the laMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaMonth(String value) {
        this.laMonth = value;
    }

    /**
     * Gets the value of the laDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaDate() {
        return laDate;
    }

    /**
     * Sets the value of the laDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaDate(String value) {
        this.laDate = value;
    }

    /**
     * Gets the value of the raPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaPhone() {
        return raPhone;
    }

    /**
     * Sets the value of the raPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaPhone(String value) {
        this.raPhone = value;
    }

    /**
     * Gets the value of the raCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaCountry() {
        return raCountry;
    }

    /**
     * Sets the value of the raCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaCountry(String value) {
        this.raCountry = value;
    }

    /**
     * Gets the value of the raIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaIndex() {
        return raIndex;
    }

    /**
     * Sets the value of the raIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaIndex(String value) {
        this.raIndex = value;
    }

    /**
     * Gets the value of the raRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaRegion() {
        return raRegion;
    }

    /**
     * Sets the value of the raRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaRegion(String value) {
        this.raRegion = value;
    }

    /**
     * Gets the value of the raDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaDistrict() {
        return raDistrict;
    }

    /**
     * Sets the value of the raDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaDistrict(String value) {
        this.raDistrict = value;
    }

    /**
     * Gets the value of the raCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaCity() {
        return raCity;
    }

    /**
     * Sets the value of the raCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaCity(String value) {
        this.raCity = value;
    }

    /**
     * Gets the value of the raSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaSettlement() {
        return raSettlement;
    }

    /**
     * Sets the value of the raSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaSettlement(String value) {
        this.raSettlement = value;
    }

    /**
     * Gets the value of the raStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaStreet() {
        return raStreet;
    }

    /**
     * Sets the value of the raStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaStreet(String value) {
        this.raStreet = value;
    }

    /**
     * Gets the value of the raHouse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaHouse() {
        return raHouse;
    }

    /**
     * Sets the value of the raHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaHouse(String value) {
        this.raHouse = value;
    }

    /**
     * Gets the value of the raBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaBuilding() {
        return raBuilding;
    }

    /**
     * Sets the value of the raBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaBuilding(String value) {
        this.raBuilding = value;
    }

    /**
     * Gets the value of the raStructure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaStructure() {
        return raStructure;
    }

    /**
     * Sets the value of the raStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaStructure(String value) {
        this.raStructure = value;
    }

    /**
     * Gets the value of the raApartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaApartment() {
        return raApartment;
    }

    /**
     * Sets the value of the raApartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaApartment(String value) {
        this.raApartment = value;
    }

    /**
     * Gets the value of the employername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployername() {
        return employername;
    }

    /**
     * Sets the value of the employername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployername(String value) {
        this.employername = value;
    }

    /**
     * Gets the value of the employersize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployersize() {
        return employersize;
    }

    /**
     * Sets the value of the employersize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployersize(String value) {
        this.employersize = value;
    }

    /**
     * Gets the value of the businessindustry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessindustry() {
        return businessindustry;
    }

    /**
     * Sets the value of the businessindustry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessindustry(String value) {
        this.businessindustry = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the employmentYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentYear() {
        return employmentYear;
    }

    /**
     * Sets the value of the employmentYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentYear(String value) {
        this.employmentYear = value;
    }

    /**
     * Gets the value of the employmentMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentMonth() {
        return employmentMonth;
    }

    /**
     * Sets the value of the employmentMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentMonth(String value) {
        this.employmentMonth = value;
    }

    /**
     * Gets the value of the employmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentDate() {
        return employmentDate;
    }

    /**
     * Sets the value of the employmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentDate(String value) {
        this.employmentDate = value;
    }

    /**
     * Gets the value of the employmentInn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentInn() {
        return employmentInn;
    }

    /**
     * Sets the value of the employmentInn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentInn(String value) {
        this.employmentInn = value;
    }

    /**
     * Gets the value of the incomeproof property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeproof() {
        return incomeproof;
    }

    /**
     * Sets the value of the incomeproof property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeproof(String value) {
        this.incomeproof = value;
    }

    /**
     * Gets the value of the monthlyincome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthlyincome() {
        return monthlyincome;
    }

    /**
     * Sets the value of the monthlyincome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthlyincome(String value) {
        this.monthlyincome = value;
    }

    /**
     * Gets the value of the baPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaPhone() {
        return baPhone;
    }

    /**
     * Sets the value of the baPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaPhone(String value) {
        this.baPhone = value;
    }

    /**
     * Gets the value of the baCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaCountry() {
        return baCountry;
    }

    /**
     * Sets the value of the baCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaCountry(String value) {
        this.baCountry = value;
    }

    /**
     * Gets the value of the baIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaIndex() {
        return baIndex;
    }

    /**
     * Sets the value of the baIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaIndex(String value) {
        this.baIndex = value;
    }

    /**
     * Gets the value of the baRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaRegion() {
        return baRegion;
    }

    /**
     * Sets the value of the baRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaRegion(String value) {
        this.baRegion = value;
    }

    /**
     * Gets the value of the baDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaDistrict() {
        return baDistrict;
    }

    /**
     * Sets the value of the baDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaDistrict(String value) {
        this.baDistrict = value;
    }

    /**
     * Gets the value of the baCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaCity() {
        return baCity;
    }

    /**
     * Sets the value of the baCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaCity(String value) {
        this.baCity = value;
    }

    /**
     * Gets the value of the baSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaSettlement() {
        return baSettlement;
    }

    /**
     * Sets the value of the baSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaSettlement(String value) {
        this.baSettlement = value;
    }

    /**
     * Gets the value of the baStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaStreet() {
        return baStreet;
    }

    /**
     * Sets the value of the baStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaStreet(String value) {
        this.baStreet = value;
    }

    /**
     * Gets the value of the baHouse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaHouse() {
        return baHouse;
    }

    /**
     * Sets the value of the baHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaHouse(String value) {
        this.baHouse = value;
    }

    /**
     * Gets the value of the baBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaBuilding() {
        return baBuilding;
    }

    /**
     * Sets the value of the baBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaBuilding(String value) {
        this.baBuilding = value;
    }

    /**
     * Gets the value of the baStructure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaStructure() {
        return baStructure;
    }

    /**
     * Sets the value of the baStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaStructure(String value) {
        this.baStructure = value;
    }

    /**
     * Gets the value of the baApartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaApartment() {
        return baApartment;
    }

    /**
     * Sets the value of the baApartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaApartment(String value) {
        this.baApartment = value;
    }

    /**
     * Gets the value of the producttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducttype() {
        return producttype;
    }

    /**
     * Sets the value of the producttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducttype(String value) {
        this.producttype = value;
    }

    /**
     * Gets the value of the productname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductname() {
        return productname;
    }

    /**
     * Sets the value of the productname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductname(String value) {
        this.productname = value;
    }

    /**
     * Gets the value of the originalchannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalchannel() {
        return originalchannel;
    }

    /**
     * Sets the value of the originalchannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalchannel(String value) {
        this.originalchannel = value;
    }

    /**
     * Gets the value of the productsumlimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductsumlimit() {
        return productsumlimit;
    }

    /**
     * Sets the value of the productsumlimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductsumlimit(String value) {
        this.productsumlimit = value;
    }

    /**
     * Gets the value of the productsumcurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductsumcurrency() {
        return productsumcurrency;
    }

    /**
     * Sets the value of the productsumcurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductsumcurrency(String value) {
        this.productsumcurrency = value;
    }

    /**
     * Gets the value of the downpaymentamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownpaymentamount() {
        return downpaymentamount;
    }

    /**
     * Sets the value of the downpaymentamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownpaymentamount(String value) {
        this.downpaymentamount = value;
    }

    /**
     * Gets the value of the collateralexistence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollateralexistence() {
        return collateralexistence;
    }

    /**
     * Sets the value of the collateralexistence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollateralexistence(String value) {
        this.collateralexistence = value;
    }

    /**
     * Gets the value of the collateralvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollateralvalue() {
        return collateralvalue;
    }

    /**
     * Sets the value of the collateralvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollateralvalue(String value) {
        this.collateralvalue = value;
    }

    /**
     * Gets the value of the purchaseexistence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseexistence() {
        return purchaseexistence;
    }

    /**
     * Sets the value of the purchaseexistence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseexistence(String value) {
        this.purchaseexistence = value;
    }

    /**
     * Gets the value of the purchasevalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchasevalue() {
        return purchasevalue;
    }

    /**
     * Sets the value of the purchasevalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchasevalue(String value) {
        this.purchasevalue = value;
    }

    /**
     * Gets the value of the purchasemodel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchasemodel() {
        return purchasemodel;
    }

    /**
     * Sets the value of the purchasemodel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchasemodel(String value) {
        this.purchasemodel = value;
    }

    /**
     * Gets the value of the operatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * Sets the value of the operatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorCode(String value) {
        this.operatorCode = value;
    }

    /**
     * Gets the value of the operatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Sets the value of the operatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    /**
     * Gets the value of the posCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosCode() {
        return posCode;
    }

    /**
     * Sets the value of the posCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosCode(String value) {
        this.posCode = value;
    }

    /**
     * Gets the value of the posPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosPhone() {
        return posPhone;
    }

    /**
     * Sets the value of the posPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosPhone(String value) {
        this.posPhone = value;
    }

    /**
     * Gets the value of the posCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosCountry() {
        return posCountry;
    }

    /**
     * Sets the value of the posCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosCountry(String value) {
        this.posCountry = value;
    }

    /**
     * Gets the value of the posIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosIndex() {
        return posIndex;
    }

    /**
     * Sets the value of the posIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosIndex(String value) {
        this.posIndex = value;
    }

    /**
     * Gets the value of the posRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosRegion() {
        return posRegion;
    }

    /**
     * Sets the value of the posRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosRegion(String value) {
        this.posRegion = value;
    }

    /**
     * Gets the value of the posDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosDistrict() {
        return posDistrict;
    }

    /**
     * Sets the value of the posDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosDistrict(String value) {
        this.posDistrict = value;
    }

    /**
     * Gets the value of the posCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosCity() {
        return posCity;
    }

    /**
     * Sets the value of the posCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosCity(String value) {
        this.posCity = value;
    }

    /**
     * Gets the value of the posSettlement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosSettlement() {
        return posSettlement;
    }

    /**
     * Sets the value of the posSettlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosSettlement(String value) {
        this.posSettlement = value;
    }

    /**
     * Gets the value of the posStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosStreet() {
        return posStreet;
    }

    /**
     * Sets the value of the posStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosStreet(String value) {
        this.posStreet = value;
    }

    /**
     * Gets the value of the posHouse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosHouse() {
        return posHouse;
    }

    /**
     * Sets the value of the posHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosHouse(String value) {
        this.posHouse = value;
    }

    /**
     * Gets the value of the posBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosBuilding() {
        return posBuilding;
    }

    /**
     * Sets the value of the posBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosBuilding(String value) {
        this.posBuilding = value;
    }

    /**
     * Gets the value of the posStructure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosStructure() {
        return posStructure;
    }

    /**
     * Sets the value of the posStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosStructure(String value) {
        this.posStructure = value;
    }

    /**
     * Gets the value of the posApartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosApartment() {
        return posApartment;
    }

    /**
     * Sets the value of the posApartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosApartment(String value) {
        this.posApartment = value;
    }

    /**
     * Gets the value of the newapplicant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewapplicant() {
        return newapplicant;
    }

    /**
     * Sets the value of the newapplicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewapplicant(String value) {
        this.newapplicant = value;
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

    /**
     * Gets the value of the applicationfraudstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationfraudstatus() {
        return applicationfraudstatus;
    }

    /**
     * Sets the value of the applicationfraudstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationfraudstatus(String value) {
        this.applicationfraudstatus = value;
    }

    /**
     * Gets the value of the applicationfraudstatusdescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationfraudstatusdescr() {
        return applicationfraudstatusdescr;
    }

    /**
     * Sets the value of the applicationfraudstatusdescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationfraudstatusdescr(String value) {
        this.applicationfraudstatusdescr = value;
    }

    /**
     * Gets the value of the defaultstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultstatus() {
        return defaultstatus;
    }

    /**
     * Sets the value of the defaultstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultstatus(String value) {
        this.defaultstatus = value;
    }

}
