package leib.demo.zip;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {
    public static void main(String[] args) {
        String xsdPath = "/Users/lixuedan/Desktop/student.xsd" ;
        String xmlPath = "/Users/lixuedan/Desktop/student.xml" ;
        boolean isValid = validateXMLSchema(xsdPath,xmlPath);

        if(isValid){
            System.out.println(xsdPath + " is valid against " + xmlPath);
        } else {
            System.out.println(xsdPath + " is not valid against " + xmlPath);
        }

    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }catch(SAXException e1){
            System.out.println("SAX Exception: "+e1.getMessage());
            return false;
        }

        return true;

    }
}