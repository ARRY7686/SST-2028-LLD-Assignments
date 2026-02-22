public abstract class NotificationSender {

    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    public final void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("notification cannot be null");
        }

        Notification normalized = normalize(n);

        validate(normalized);  
        doSend(normalized);   
    }

    protected Notification normalize(Notification n) {
        return new Notification(
                n.subject == null ? "" : n.subject,
                n.body == null ? "" : n.body,
                n.email,
                n.phone
        );
    }

    protected abstract void validate(Notification n);
    protected abstract void doSend(Notification n);
}