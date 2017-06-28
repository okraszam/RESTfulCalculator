package com.application.rest;


import com.application.mathoperations.CalculatorEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static com.application.mathoperations.Operations.*;


@Path("/")
public class RESTCalculatorInterface {

    private Logger LOG = LoggerFactory.getLogger(RESTCalculatorInterface.class);
    String calculatorPath = "http://localhost:8080/RESTCalculatorApp/";

    public RESTCalculatorInterface() {
    }

    @Inject
    CalculatorEngine calculatorEngine;

    @GET
    @Path("/operation={operation}&firstInt={firstInt}&secondInt={secondInt}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response calculateService(@PathParam("operation") String operation,
                                     @PathParam("firstInt") int firstInt,
                                     @PathParam("secondInt") int secondInt) {

        String cleanOperaiton = operation.trim().toUpperCase();
        LOG.info("Starting to calculate two ints with choosen operation");

        if (cleanOperaiton.equals("ADD")) {
            return Response.ok("Result of adding numbers: " + firstInt
                                       + " and " + secondInt + " is: "
                                       + calculatorEngine.calculate(ADD, firstInt, secondInt)).build();
        } else if (cleanOperaiton.equals("SUB")) {
            return Response.ok("Result of substracting numbers: " + firstInt
                                       + " and " + secondInt + " is: "
                                       + calculatorEngine.calculate(SUB, firstInt, secondInt)).build();
        } else if (cleanOperaiton.equals("MUL")) {
            return Response.ok("Result of multiplicating numbers: " + firstInt
                                       + " and " + secondInt + " is: "
                                       + calculatorEngine.calculate(MUL, firstInt, secondInt)).build();
        } else if (cleanOperaiton.equals("DIV")) {
            return Response.ok("Result of dividing numbers: " + firstInt
                                       + " and " + secondInt + " is: "
                                       + calculatorEngine.calculate(DIV, firstInt, secondInt)).build();
        } else {
            return Response.ok("It is wrong operation").build();
        }

    }

}
