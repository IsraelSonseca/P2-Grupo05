package mp.users;

import java.io.Serializable;

public class Notificacion implements Serializable {

    private String msg;

    public Notificacion(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
