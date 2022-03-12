package com.reactive;

import rx.Observable;
import rx.observables.MathObservable;


//Mediante el control de flujo de datos con ReactiveX en java, determine las siguientes operaciones para el flujo de datos:
//[2, 5, 6, 8, 10, 35,  2, 10]
//
//- Promedio
//- Filtrado de valores mayores o iguales a 10
//- Sumatoria de valores.
public class Data {
    public static void main(String[] args) {

        Integer[] data = {2, 5, 6, 8, 10, 35, 2, 10};

        Observable<Integer> dataObs = Observable.from(data);

        System.out.println("-----Promedio-----");

        MathObservable.averageInteger(dataObs).subscribe((prom) -> {
            System.out.println(prom);
        });
        System.out.println("-----Filtro mayor o igual a 10-----");

        Observable filterObs = Observable.from(data).filter(i -> i >= 10);

        filterObs.subscribe((fil) -> {
            System.out.println(fil);
        });

        System.out.println("-----Sumatoria-----");

        MathObservable.sumInteger(dataObs).subscribe((sum) -> {
            System.out.println(sum);
        });
    }
}
