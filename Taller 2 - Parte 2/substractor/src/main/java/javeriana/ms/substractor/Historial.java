package javeriana.ms.substractor;

public class Historial {
    
    public String fecha;
    public String user;
    public String operation;
    
    public Historial(String fecha, String user, String operation) {
        this.fecha = fecha;
        this.user = user;
        this.operation = operation;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    
    
    
}
