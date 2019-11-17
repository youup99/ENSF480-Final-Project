public class Email{
    private String toEmail;
    private String fromEmail;
    private String subject;
    private String body;

    public Email(String toEmail, String fromEmail, String subject, String body){
        this.toEmail = toEmail;
        this.fromEmail = fromEmail;
        this.subject = subject;
        this.body = body;
    }
}