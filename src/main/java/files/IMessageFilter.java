package files;

public interface IMessageFilter {
    /*
    public boolean getRubberyLang();
    public boolean getBase64();
    public boolean getSuperImp();
    public boolean getText();
    */

    public String getRubberyLang(String message);
    public String getBase64(String message);
    public String getSuperImp(String message);
}
