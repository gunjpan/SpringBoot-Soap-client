package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.Add;
import hello.wsdl.AddResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

  public AddResponse add(int a, int b) {

    Add request = new Add();
    request.setIntA(a);
    request.setIntB(b);
//    request.add(3)

    log.info("Requesting to add " + request.getIntA() + " and " + request.getIntB());

    AddResponse response = (AddResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, new SoapActionCallback("http://tempuri.org/Add"));

    log.info("response" + response.getAddResult());

    return response;
  }

}
