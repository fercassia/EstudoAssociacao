package entities.contracts;
import java.util.Date;

public class HourContractEntitie {
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContractEntitie(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public Double TotalValue(){
        return valuePerHour * hours;
    }
}
