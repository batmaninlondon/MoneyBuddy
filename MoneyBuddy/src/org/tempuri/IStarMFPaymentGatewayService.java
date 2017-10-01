
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.PasswordRequest;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.RequestParam;
import org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.Response;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IStarMFPaymentGatewayService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    com.microsoft.schemas._2003._10.serialization.arrays.ObjectFactory.class,
    org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.ObjectFactory.class,
    org.tempuri.ObjectFactory.class
})
public interface IStarMFPaymentGatewayService {


    /**
     * 
     * @param param
     * @return
     *     returns org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.Response
     */
    @WebMethod(operationName = "GetPassword", action = "http://tempuri.org/IStarMFPaymentGatewayService/GetPassword")
    @WebResult(name = "GetPasswordResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetPassword", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetPassword")
    @ResponseWrapper(localName = "GetPasswordResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetPasswordResponse")
    public Response getPassword(
        @WebParam(name = "Param", targetNamespace = "http://tempuri.org/")
        PasswordRequest param);

    /**
     * 
     * @param param
     * @return
     *     returns org.datacontract.schemas._2004._07.starmfpaymentgatewayservice.Response
     */
    @WebMethod(operationName = "PaymentGatewayAPI", action = "http://tempuri.org/IStarMFPaymentGatewayService/PaymentGatewayAPI")
    @WebResult(name = "PaymentGatewayAPIResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "PaymentGatewayAPI", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PaymentGatewayAPI")
    @ResponseWrapper(localName = "PaymentGatewayAPIResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PaymentGatewayAPIResponse")
    public Response paymentGatewayAPI(
        @WebParam(name = "Param", targetNamespace = "http://tempuri.org/")
        RequestParam param);

}