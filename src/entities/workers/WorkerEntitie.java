package entities.workers;

import entities.contracts.HourContractEntitie;
import entities.department.DepartmentEntitie;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class WorkerEntitie {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private DepartmentEntitie department;

    private List<HourContractEntitie> contracts = new ArrayList<>();
    private String incomeSearching;

    public WorkerEntitie(String name, WorkerLevel level, DepartmentEntitie department) {
        this.name = name;
        this.level = level;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public DepartmentEntitie getDepartment() {
        return department;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void AddContract(HourContractEntitie contract){
        if(contracts.contains(contract)){
            throw new Error("This contract already exist");
        }
        contracts.add(contract);
    }

    public void RemoveContract(HourContractEntitie contract){
        if(!contracts.contains(contract)){
            throw new Error("This contract doesn't exist! Please, try another contract.");
        }
        contracts.remove(contract);
    }

    public Double Income (Integer year, Integer month) throws ParseException {
        SimpleDateFormat monthYearFormat = new SimpleDateFormat("MM/yyyy");
        int currentYear = Year.now().getValue();

        if(year < 2000 || year > currentYear+1){
            throw new Error("You can't use years below 2000 or greater than 1 years the current year");
        }

        incomeSearching = String.format("%02d/%d", month, year);

        this.baseSalary = contracts.stream()
                .filter(c -> monthYearFormat.format(c.getDate()).equals(incomeSearching))
                .mapToDouble(HourContractEntitie::TotalValue)
                .sum();
        return this.baseSalary;
    }

    @Override
    public String toString() {
        return  "{Name: " + this.name + ",\nDepartment: " + this.department.getName() +
                ",\nIncome for " + incomeSearching + ": " + this.baseSalary +
                ",\nWorker Level: "+ level.getWorkerNivel() +"}";
    }
}
