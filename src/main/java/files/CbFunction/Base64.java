package files.CbFunction;

import files.IMessageFilter;
import files.MessageDecorator;

import java.security.PEMEncoder;


public class Base64 extends MessageDecorator {
    public Base64(IMessageFilter tempSelection) {
        super(tempSelection);

    }
    public String getBase64(String message) {
        Base64.getEncoder().encodeToString(message.getBytes());

    return null;

    }




}
