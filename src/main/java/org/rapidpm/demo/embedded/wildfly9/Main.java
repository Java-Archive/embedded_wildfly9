package org.rapidpm.demo.embedded.wildfly9;

import org.rapidpm.demo.embedded.wildfly9.rest.PeopleResource;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.container.DependencyDeployment;
import org.wildfly.swarm.jaxrs.JaxRsDeployment;
import org.wildfly.swarm.weld.WeldFraction;

/**
 * Created by sven on 24.05.15.
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("args = " + args);

    Container container = new Container();

//    container.subsystem(new MessagingFraction()
//            .server(
//                new MessagingServer()
//                    .enableInVmConnector()
//                    .topic("my-topic")
//                    .queue("my-queue")
//            )
//    );



    // Start the container
//    container.subsystem(new WeldFraction());
    try {
      container.start();


      JaxRsDeployment appDeployment = new JaxRsDeployment();
      appDeployment.addResource(PeopleResource.class);

      // Deploy your JAX-RS app
      container.deploy(appDeployment);
    } catch (Exception e) {
      System.out.println("e = " + e);
    }

    // Create an MSC deployment
//    ServiceDeployment deployment = new ServiceDeployment();
//    deployment.addService(new MyService("/jms/topic/my-topic" ) );

    // Deploy the services
//    container.deploy( deployment );
  }
}
