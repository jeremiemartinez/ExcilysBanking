
package com.excilys.excilysbanking.webservices.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.excilys.excilysbanking.webservices.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetComptesByUsername_QNAME = new QName("http://soap.webservices.excilysbanking.excilys.com/", "getComptesByUsername");
    private final static QName _GetAllComptesResponse_QNAME = new QName("http://soap.webservices.excilysbanking.excilys.com/", "getAllComptesResponse");
    private final static QName _GetComptesByUsernameResponse_QNAME = new QName("http://soap.webservices.excilysbanking.excilys.com/", "getComptesByUsernameResponse");
    private final static QName _GetAllComptes_QNAME = new QName("http://soap.webservices.excilysbanking.excilys.com/", "getAllComptes");
    private final static QName _GetCompteById_QNAME = new QName("http://soap.webservices.excilysbanking.excilys.com/", "getCompteById");
    private final static QName _GetCompteByIdResponse_QNAME = new QName("http://soap.webservices.excilysbanking.excilys.com/", "getCompteByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.excilys.excilysbanking.webservices.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCompteByIdResponse }
     * 
     */
    public GetCompteByIdResponse createGetCompteByIdResponse() {
        return new GetCompteByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllComptesResponse }
     * 
     */
    public GetAllComptesResponse createGetAllComptesResponse() {
        return new GetAllComptesResponse();
    }

    /**
     * Create an instance of {@link GetCompteById }
     * 
     */
    public GetCompteById createGetCompteById() {
        return new GetCompteById();
    }

    /**
     * Create an instance of {@link GetAllComptes }
     * 
     */
    public GetAllComptes createGetAllComptes() {
        return new GetAllComptes();
    }

    /**
     * Create an instance of {@link CompteDTO }
     * 
     */
    public CompteDTO createCompteDTO() {
        return new CompteDTO();
    }

    /**
     * Create an instance of {@link GetComptesByUsernameResponse }
     * 
     */
    public GetComptesByUsernameResponse createGetComptesByUsernameResponse() {
        return new GetComptesByUsernameResponse();
    }

    /**
     * Create an instance of {@link GetComptesByUsername }
     * 
     */
    public GetComptesByUsername createGetComptesByUsername() {
        return new GetComptesByUsername();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComptesByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservices.excilysbanking.excilys.com/", name = "getComptesByUsername")
    public JAXBElement<GetComptesByUsername> createGetComptesByUsername(GetComptesByUsername value) {
        return new JAXBElement<GetComptesByUsername>(_GetComptesByUsername_QNAME, GetComptesByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllComptesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservices.excilysbanking.excilys.com/", name = "getAllComptesResponse")
    public JAXBElement<GetAllComptesResponse> createGetAllComptesResponse(GetAllComptesResponse value) {
        return new JAXBElement<GetAllComptesResponse>(_GetAllComptesResponse_QNAME, GetAllComptesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComptesByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservices.excilysbanking.excilys.com/", name = "getComptesByUsernameResponse")
    public JAXBElement<GetComptesByUsernameResponse> createGetComptesByUsernameResponse(GetComptesByUsernameResponse value) {
        return new JAXBElement<GetComptesByUsernameResponse>(_GetComptesByUsernameResponse_QNAME, GetComptesByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllComptes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservices.excilysbanking.excilys.com/", name = "getAllComptes")
    public JAXBElement<GetAllComptes> createGetAllComptes(GetAllComptes value) {
        return new JAXBElement<GetAllComptes>(_GetAllComptes_QNAME, GetAllComptes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompteById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservices.excilysbanking.excilys.com/", name = "getCompteById")
    public JAXBElement<GetCompteById> createGetCompteById(GetCompteById value) {
        return new JAXBElement<GetCompteById>(_GetCompteById_QNAME, GetCompteById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompteByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservices.excilysbanking.excilys.com/", name = "getCompteByIdResponse")
    public JAXBElement<GetCompteByIdResponse> createGetCompteByIdResponse(GetCompteByIdResponse value) {
        return new JAXBElement<GetCompteByIdResponse>(_GetCompteByIdResponse_QNAME, GetCompteByIdResponse.class, null, value);
    }

}
