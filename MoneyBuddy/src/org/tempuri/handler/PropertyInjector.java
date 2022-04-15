package org.tempuri.handler;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class PropertyInjector implements SOAPHandler<SOAPMessageContext> {
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		
		System.out.println("Client executing SOAP Handler");
		
		
		
		Boolean outboundProperty = (Boolean)
				context.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		     if (outboundProperty.booleanValue()) {
		         System.out.println("\nOutbound message:");
		     } else {
		         System.out.println("\nInbound message:");
		     }

		     System.out.println("** Response: "+context.getMessage().toString());
		
		

		/*try {
		
			SOAPMessage soapMessagg = context.getMessage();
			
		SOAPEnvelope envelope = soapMessagg.getSOAPPart().getEnvelope();
		 SOAPElement nameSpace = envelope.addNamespaceDeclaration("cch","http://records.txdps.state.tx.us/cch" );
		 SOAPHeader header = envelope.addHeader();
		 
		 SOAPElement security =
		         header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
		 security.addAttribute(envelope.createName("S:mustUnderstand") , "1");
		  
		 SOAPElement usernameToken =
		         security.addChildElement("UsernameToken", "wsse");
		 usernameToken.addAttribute(new QName("wsu:Id"), "UsernameToken-2");
		 usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
		  
		 SOAPElement username =
		         usernameToken.addChildElement("Username", "wsse");
		 username.addTextNode("abc");
		 
		 SOAPElement password =
		         usernameToken.addChildElement("Password", "wsse");
		 password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
		 password.addTextNode("123");
		 
		SOAPElement nonce =
		        usernameToken.addChildElement("Nonce", "wsse");
		nonce.setAttribute("EncodingType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
		nonce.addTextNode("I7JFUNelmF6cViOKuY6UFw==");
		 
		 //Print out the outbound SOAP message to System.out
		soapMessagg.writeTo(System.out);
		 
		Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// If it is an outgoing message
		if (outboundProperty.booleanValue()) {

			try {
				SOAPMessage soapMessagg = context.getMessage();
				SOAPEnvelope soapEnvelope = soapMessagg.getSOAPPart().getEnvelope();
				
				// Grab the header of the SOAP envelop
				SOAPHeader soapHeader = soapEnvelope.getHeader();

				// Attach a new header if there is none...
				if (soapHeader == null) {
					System.out.println(" Soap header was null ");
					soapHeader = soapEnvelope.addHeader();
				}
				
				
				// add the property to the header
				QName qname = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "UsernameToken", "wsu");
				
				// Create a new HeaderElement in order to place the new property
				SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);

				soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				soapHeaderElement.addTextNode("RANDOM");
				soapMessagg.saveChanges();

				// Output the message to the Console -- for debug   
				soapMessagg.writeTo(System.out);

			} catch (SOAPException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
*/
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		
		return Collections.emptySet();
		
		
		/* // throw new UnsupportedOperationException("Not supported yet.");
        final QName securityHeader = new QName(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                "Security", "wsse");
 
        final HashSet headers = new HashSet();
        headers.add(securityHeader);
 
        return headers;*/
		
		/*return null;*/
	}
}
