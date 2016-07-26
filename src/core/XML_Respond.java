/**
 *   File Name: XML_Respond.java<br>
 *
 *   Yutaka<br>
 *   Created: Jul 13, 2016
 *   
 */

package core;

import java.text.DecimalFormat;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * XML_Respond Conversion app
 * <p>
 * 	convetsionType: one to another
 *	inputType: 		kg, in, etc.
 *	outputType: 	lb, sm, etc.
 *	inputValue: 	10, 10, etc.  
 *	outputValue: 	22, 25.4, etc.
 * <p>
 * kg_to_lb_xml creates xml respond
 * lb_to_kg_xml creates xml respond
 * sm_to_in_xml creates xml respond
 * in_to_kg_xml creates xml respond
 * 
 * @author      Tony Olyva
 * @version     1.10.5
 * @since       1.0
 *
 */

@Path("/")

public class XML_Respond {
	
	public DecimalFormat df = new DecimalFormat("####0.00");

	public static String convetsionType;
	public static String inputType;
	public static String outputType;
	public static String inputValue;
	public static String outputValue;
	
    @GET 
    @Path("xml/kg=>lb/{input}")
    @Produces("application/xml")
    public Response kg_to_lb_xml(
                 @DefaultValue("1")
                 @PathParam("input") Double input) throws ParserConfigurationException, TransformerException {
  
    	convetsionType = "kg to lb";
		Double kg = input;
        Double lb = kg * 2.2046;
        inputType = "kg";
        outputType = "lb";
		inputValue = String.valueOf(df.format(kg));
		outputValue = String.valueOf(df.format(lb));
             
                XMLbuilder kglb = new XMLbuilder(); 
                String xml = "<xml1>value</xml1>";
                 
                return Response.status(200).entity(kglb.xml_builder()).build();
    } 
    
    @GET 
    @Path("xml/lb=>kg/{input}")
    @Produces("application/xml")
    public Response lb_to_kg_xml(
                 @DefaultValue("1")
                 @PathParam("input") Double input) throws ParserConfigurationException, TransformerException {
  
    	convetsionType = "lb to kg";
		Double lb = input;
        Double kg = lb / 2.2046;
        inputType = "lb";
        outputType = "kg";
		inputValue = String.valueOf(df.format(lb));
		outputValue = String.valueOf(df.format(kg));
             
                XMLbuilder lbkg = new XMLbuilder(); 
                String xml = "<xml1>value</xml1>";
                 
                return Response.status(200).entity(lbkg.xml_builder()).build();
    }
    
    @GET 
    @Path("xml/sm=>in/{input}")
    @Produces("application/xml")
    public Response sm_to_in_xml(
                 @DefaultValue("1")
                 @PathParam("input") Double input) throws ParserConfigurationException, TransformerException {
  
    	convetsionType = "sm to in";
		Double sm = input;
        Double in = sm * 2.54;
        inputType = "sm";
        outputType = "in";
		inputValue = String.valueOf(df.format(sm));
		outputValue = String.valueOf(df.format(in));
             
                XMLbuilder smin = new XMLbuilder(); 
                String xml = "<xml1>value</xml1>";
                 
                return Response.status(200).entity(smin.xml_builder()).build();
    }

    @GET 
    @Path("xml/in=>sm/{input}")
    @Produces("application/xml")
    public Response in_to_sm_xml(
                 @DefaultValue("1")
                 @PathParam("input") Double input) throws ParserConfigurationException, TransformerException {
  
    	convetsionType = "in to sm";
		Double in = input;
        Double sm = in / 2.54;
        inputType = "in";
        outputType = "sm";
		inputValue = String.valueOf(df.format(in));
		outputValue = String.valueOf(df.format(sm));
             
                XMLbuilder insm = new XMLbuilder(); 
                String xml = "<xml1>value</xml1>";
                 
                return Response.status(200).entity(insm.xml_builder()).build();
    }
     
    
}
