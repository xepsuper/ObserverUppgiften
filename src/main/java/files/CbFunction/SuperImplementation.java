package files.CbFunction;

import files.IMessageFilter;
import files.MessageDecorator;

public class SuperImplementation extends MessageDecorator {

    public SuperImplementation(IMessageFilter tempSelection) {
        super(tempSelection);
    }

    public String getSuperImp (String message){
        int length = message.length();
        String outString = "";
        for(int i = 0; i < length; i++){
            char letter = message.charAt(i);
            outString += letter+" ";
        }
        return outString;
    }
}
