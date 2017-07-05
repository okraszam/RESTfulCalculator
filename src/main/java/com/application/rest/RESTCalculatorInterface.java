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
    @Path("/")
    @Produces (MediaType.TEXT_PLAIN)
    public Response calculatorGreeter() {

        return Response.ok("Welcome to RESTCalculator, v0.2 :"
                                   + "\n\nPlease chose the way you want to use application:"
                                   + "\n1. Check user guide: {your local URL}/RESTCalculatorApp/readguide"
                                   + "\n2. Use Calculator: {your local URL}/RESTCalculatorApp/useit/{specify operation query}").build();

    }

    @GET
    @Path("/readguide")
    @Produces (MediaType.TEXT_PLAIN)
    public Response calculatorGuide() {

        return Response.ok("RESTCalculator v0.2, guide :"
                                   + "\n\nTo perform operation on two numbers you have to fill adres below:"
                                   + "\n{your local URL}/RESTCalculatorApp/useit/operation={operation}&firstInt={firstInt}&secondInt={secondInt}"
                                   + "\nwhere:"
                                   + "\n{your local URL} - is your localhost adress with choosen port, by default is should be: " + calculatorPath
                                   + "\n{operation} - now you can chose between ADDing, SUBstrancing, MULtipling, DIViding"
                                   + "\n{firstInt} - int value"
                                   + "\n{secondInt} - int value (remeber that you can't divide by 0)"
                                   + "\n* if values are not int's -> Calculator will round them to the nearest 1"
                                   + "\nand <ENTER>."
                                   + "\nI recomend to use application like Postman, it has nice interface and options."
                                   + "\n\nWelcome screen -> {your local URL}/RESTCalculatorApp/").build();

    }

    @GET
    @Path("/useit/operation={operation}&firstInt={firstInt}&secondInt={secondInt}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response calculateService(@PathParam("operation") String operation,
                                     @PathParam("firstInt") Float firstInt,
                                     @PathParam("secondInt") Float secondInt) {

        Integer firstInteger = Math.round(firstInt);
        Integer secondInteger = Math.round(secondInt);

        String cleanOperaiton = operation.trim().toUpperCase();
        LOG.info("Starting to calculate two ints with choosen operation");

        if (cleanOperaiton.equals("ADD")) {
            return Response.ok("Result of adding numbers: " + firstInteger
                                       + " and " + secondInteger + " is: "
                                       + calculatorEngine.calculate(ADD, firstInteger, secondInteger)).build();
        } else if (cleanOperaiton.equals("SUB")) {
            return Response.ok("Result of substracting numbers (first - second): " + firstInteger
                                       + " and " + secondInteger + " is: "
                                       + calculatorEngine.calculate(SUB, firstInteger, secondInteger)).build();
        } else if (cleanOperaiton.equals("MUL")) {
            return Response.ok("Result of multiplicating numbers: " + firstInteger
                                       + " and " + secondInteger + " is: "
                                       + calculatorEngine.calculate(MUL, firstInteger, secondInteger)).build();
        } else if (cleanOperaiton.equals("DIV")) {
            if (secondInteger == 0) {
                return Response.ok("You can't divide by 0, please re-enter your query.").build();
            } else {
                return Response.ok("Result of dividing numbers (first / second): " + firstInteger
                                           + " and " + secondInteger + " is: "
                                           + calculatorEngine.calculate(DIV, firstInteger, secondInteger)).build();
            }
        } else {
            return Response.ok("It is wrong operation, please re-enter your query.").build();
        }

    }

}
