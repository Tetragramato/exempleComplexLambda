package com.tetragramato;

import com.tetragramato.model.complexe.Operation;
import com.tetragramato.model.complexe.Quittance;
import com.tetragramato.model.flat.Prime;
import com.tetragramato.model.type.TypeOperation;
import com.tetragramato.model.type.TypeQuittance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //Appel du test
        buildImputationsWithLanbda();
    }

    public static void buildImputationsWithLanbda() {

        //Construction des fixtures du Test
        List<Operation> operations = TestFixture.buildTestCaseOperations();

        //Tri des Opérations par Quittances : une quittance a plusieurs opérations
        Map<Quittance, List<Operation>> quittancesFiltered = operations.stream().collect(Collectors.groupingBy(Operation::getQuittance));

        //On créé une liste de Prime : une Prime est une représentation à plat de la Quittance.
        //Une prime est une quittance de type PRIME
        //Une prime a un totalDue, qui est l'addition de toutes les opérations de type CREDIT
        //Une prime a un totalAPercevoir, qui est l'addition de toutes les opérations de type DEBIT
        quittancesFiltered.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getTypeQuittance().equals(TypeQuittance.PRIME))
                .map(new Function<Map.Entry<Quittance, List<Operation>>, Prime>() {
                    @Override
                    public Prime apply(Map.Entry<Quittance, List<Operation>> quittanceListEntry) {
                        Prime prime = new Prime();
                        prime.setIdImputation(quittanceListEntry.getKey().getIdQuittance());
                        prime.setTotalDue(quittanceListEntry.getValue()
                                .stream()
                                .filter(op -> op.getTypeOperation().equals(TypeOperation.CREDIT))
                                .map(Operation::getMontant)
                                .reduce(BigDecimal.ZERO, BigDecimal::add));
                        prime.setTotalAPercevoir(quittanceListEntry.getValue()
                                .stream()
                                .filter(op -> op.getTypeOperation().equals(TypeOperation.DEBIT))
                                .map(Operation::getMontant)
                                .reduce(BigDecimal.ZERO, BigDecimal::add));
                        prime.setLibelle(quittanceListEntry.getKey().getLibelle());
                        //Au final, on a bien une liste de Prime "à plat" d'après la structure complexe de quittance + opérations
                        System.out.println("\nPrime ID : [" + prime.getIdImputation() + "], total due : [" + prime.getTotalDue() + "], total à percevoir : [" + prime.getTotalAPercevoir() + "], libellé : [" + prime.getLibelle() + "]\n");
                        return prime;

                    }
                }).collect(Collectors.toList());

        //On créé une liste de Commission : une Commission est une représentation à plat de la Quittance.
        //Une Commission est une quittance de type COMMISSION
        //Une Commission a un totalDue, qui est l'addition de toutes les opérations de type CREDIT
        //Une Commission a un totalAPercevoir, qui est l'addition de toutes les opérations de type DEBIT
        quittancesFiltered.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getTypeQuittance().equals(TypeQuittance.COMMISSION))
                .map(new Function<Map.Entry<Quittance, List<Operation>>, Prime>() {
                    @Override
                    public Prime apply(Map.Entry<Quittance, List<Operation>> quittanceListEntry) {
                        Prime prime = new Prime();
                        prime.setIdImputation(quittanceListEntry.getKey().getIdQuittance());
                        prime.setTotalDue(quittanceListEntry.getValue()
                                .stream()
                                .filter(op -> op.getTypeOperation().equals(TypeOperation.CREDIT))
                                .map(Operation::getMontant)
                                .reduce(BigDecimal.ZERO, BigDecimal::add));
                        prime.setTotalAPercevoir(quittanceListEntry.getValue()
                                .stream()
                                .filter(op -> op.getTypeOperation().equals(TypeOperation.DEBIT))
                                .map(Operation::getMontant)
                                .reduce(BigDecimal.ZERO, BigDecimal::add));
                        prime.setLibelle(quittanceListEntry.getKey().getLibelle());
                        //Au final, on a bien une liste de Commission "à plat" d'après la structure complexe de quittance + opérations
                        System.out.println("\nCommission ID : [" + prime.getIdImputation() + "], total due : [" + prime.getTotalDue() + "], total à percevoir : [" + prime.getTotalAPercevoir() + "], libellé : [" + prime.getLibelle() + "]\n");
                        return prime;

                    }
                }).collect(Collectors.toList());

    }
}
