package hello;

import hello.wsdl.AddResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner lookup(CalculatorClient calculatorClient) {
    return args -> {
      int a = 10;
      int b = 20;

      AddResponse response = calculatorClient.add(a, b);
      log.info("response is:" + response.getAddResult());
      System.err.println(response.getAddResult());
    };
  }

}
