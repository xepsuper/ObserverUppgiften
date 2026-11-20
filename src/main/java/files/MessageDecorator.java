package files;

public abstract class MessageDecorator implements IMessageFilter{

    protected IMessageFilter tempSelection;
    public MessageDecorator(IMessageFilter tempSelection){
        this.tempSelection = tempSelection;
    }


    public String getRubberyLang(String message) {
       return tempSelection.getRubberyLang(message);
    }

    public String getBase64(String message) {
       return tempSelection.getBase64(message);
    }

    public String getSuperImp(String message) {
       return tempSelection.getSuperImp(message);
    }
}
