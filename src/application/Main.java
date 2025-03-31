package application;

import entities.contracts.HourContractEntitie;
import entities.department.DepartmentEntitie;
import entities.enums.WorkerLevel;
import entities.workers.WorkerEntitie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        WorkerEntitie workerOne = new WorkerEntitie("Fernanda Cassia", 1000.00,
                                    WorkerLevel.MID_LEVEL,
                                    new DepartmentEntitie("QA"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dtOne = formatter.parse("20/01/2020");
            Date dtTwo = formatter.parse("30/02/2024");
            Date dtTree = formatter.parse("10/01/2020");
            Date dtFour = formatter.parse("04/01/2021");

            HourContractEntitie contractOne = new HourContractEntitie(dtOne, 10.0, 2);
            HourContractEntitie contractError = new HourContractEntitie(dtOne, 10.0, 2);

            workerOne.AddContract(contractOne);
            workerOne.AddContract(new HourContractEntitie(dtTwo, 10.0, 1));
            workerOne.AddContract(new HourContractEntitie(dtTree, 15.0, 2));
            workerOne.AddContract(new HourContractEntitie(dtFour, 10.0, 1));

            workerOne.RemoveContract(contractOne);//Remover
            workerOne.Income(2020,1);

//            workerOne.Income(2000,1);// ok
//            workerOne.Income(2006,1);// ok

//            workerOne.Income(1999,1); // Error
//            workerOne.Income(2007,1); // Error

//            workerOne.AddContract(contractError);
//            workerOne.AddContract(contractError); // Error
//            workerOne.Income(2020,1);

//            workerOne.RemoveContract(contractError); // Error
//            workerOne.Income(2020,1);

            System.out.println(workerOne);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}