package files.CbFunction;

import files.IMessageFilter;
import files.MessageDecorator;

public class Base64 extends MessageDecorator {
    public Base64(IMessageFilter tempSelection) {
        super(tempSelection);

    }
    public String getBase64(String message) {
        return java.util.Base64.getEncoder().encodeToString(message.getBytes());
    }




}
