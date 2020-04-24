package mp.users;

import java.io.Serializable;

public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String msg;

    public Notificacion(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
