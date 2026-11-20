package files;

public class MessageFilter implements IMessageFilter{

    @Override
    public String getRubberyLang(String message) {
        return "Rubbery Lang: ";
    }

    @Override
    public String getBase64(String message) {
        return "Base64: ";
    }

    @Override
    public String getSuperImp(String message) {
        return "Super Implementation: ";
    }
}
