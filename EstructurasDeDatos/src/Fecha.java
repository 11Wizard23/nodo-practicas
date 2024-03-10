import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
public class Fecha {

    private Integer dia;
    private Integer diaSemana;
    private Integer mes;
    private Integer anno;

    DateFormatSymbols dfs;
    GregorianCalendar greg;
    public Fecha(){
        this.dfs = new DateFormatSymbols(Locale.forLanguageTag("es-CO"));
        this.greg = new GregorianCalendar();
        this.diaSemana = this.greg.get(Calendar.DAY_OF_WEEK);
        this.dia = this.greg.get(Calendar.DAY_OF_MONTH);
        this.mes = this.greg.get(Calendar.MONTH);
        this.anno = this.greg.get(Calendar.YEAR);
    }

    public Fecha(Integer anno, Integer mes, Integer dia){
        this();
        this.greg.set(anno, mes - 1, dia);
        this.diaSemana = this.greg.get(Calendar.DAY_OF_WEEK);
        this.dia = this.greg.get(Calendar.DAY_OF_MONTH);
        this.mes = this.greg.get(Calendar.MONTH);
        this.anno = this.greg.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return "Fecha: " + this.getDiaS()+ " " + this.dia + " de " + this.getMesS() + " del " + this.getAnno() +  " (" + this.getDia() + "/" + this.getMes() + "/" + this.getAnno() + ")";
    }

    public String getDiaS (){
        return this.dfs.getWeekdays()[this.diaSemana];
    }

    public String getMesS(){
        return this.dfs.getMonths()[this.mes];
    }


    public Integer getDia() {
        return dia;
    }

    public Integer getDiaSemana() {
        return diaSemana + 1;
    }

    public Integer getMes() {
        return mes + 1;
    }

    public Integer getAnno() {
        return anno;
    }
}
