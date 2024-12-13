package m;

import java.util.Date;

public class Treino {
    private String tipo;
    private Date data;
    private String horario;

    public Treino(String tipo, Date data, String horario) {
        this.tipo = tipo;
        this.data = data;
        this.horario = horario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Treino de " + tipo + " em " + data.toString() + " às " + horario;
    }
}
