package common.tcs.handson;

import common.tcs.Producer;
import common.tcs.handson.employee.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final String LIFE_MESSAGE = "Intermediary does not have Life License ";
    private static final String MEDICAL_MESSAGE = "Intermediary does not have Medical License ";
    private static final String BOTH_MESSAGE = "Intermediary does not have Both Life and Medical License ";
    private static final String POSITIVE = "POSITIVE";
    private static final String SELECTED_NONE = "Select Life or Medical";

    private static boolean life, medical;
    private static boolean isLifeLicenseExists, isMedicalLicenseExists;
    private static boolean isShowLife, isShowMedical, isShowBoth, isShowSelection;
    private static List<Producer> producerList = new ArrayList<>();
    private static int j = 1, f = 0, p = 0;
    private static String output;

    public static void main(String[] args) {

        System.out.println("<-----------Test Case 1------------->");
        checkConditions(0, true, true, POSITIVE);
        System.out.println("<-----------Test Case 2------------->");
        checkConditions(1, true, true, MEDICAL_MESSAGE);
        System.out.println("<-----------Test Case 3------------->");
        checkConditions(2, true, true, LIFE_MESSAGE);
        System.out.println("<-----------Test Case 4------------->");
        checkConditions(3, true, true, BOTH_MESSAGE);

        System.out.println("<-----------Test Case 5------------->");
        checkConditions(0, true, false, POSITIVE);
        System.out.println("<-----------Test Case 6------------->");
        checkConditions(1, true, false, POSITIVE);
        System.out.println("<-----------Test Case 7------------->");
        checkConditions(2, true, false, LIFE_MESSAGE);
        System.out.println("<-----------Test Case 8------------->");
        checkConditions(3, true, false, BOTH_MESSAGE);

        System.out.println("<-----------Test Case 9------------->");
        checkConditions(0, false, true, POSITIVE);
        System.out.println("<-----------Test Case 10------------->");
        checkConditions(1, false, true, MEDICAL_MESSAGE);
        System.out.println("<-----------Test Case 11------------->");
        checkConditions(2, false, true, POSITIVE);
        System.out.println("<-----------Test Case 12------------->");
        checkConditions(3, false, true, BOTH_MESSAGE);

        System.out.println("<-----------Test Case 13------------->");
        checkConditions(0, false, false, SELECTED_NONE);
        System.out.println("<-----------Test Case 14------------->");
        checkConditions(1, false, false, SELECTED_NONE);
        System.out.println("<-----------Test Case 15------------->");
        checkConditions(2, false, false, SELECTED_NONE);
        System.out.println("<-----------Test Case 16------------->");
        checkConditions(3, false, false, SELECTED_NONE);

/*

        System.out.println("<-----------Test Case 5------------->");
        checkConditions(0, true, true, POSITIVE);

        System.out.println("<-----------Test Case 6------------->");
        checkConditions(1, true, false, POSITIVE);

        System.out.println("<-----------Test Case 7------------->");
        checkConditions(2, false, true, POSITIVE);

        System.out.println("<-----------Test Case 8------------->");
        checkConditions(3, false, false, SELECTED_NONE);


        System.out.println("<-----------Test Case 9------------->");
        checkConditions(0, true, true, POSITIVE);

        System.out.println("<-----------Test Case 10------------->");
        checkConditions(1, true, false, POSITIVE);

        System.out.println("<-----------Test Case 11------------->");
        checkConditions(2, false, true, POSITIVE);

        System.out.println("<-----------Test Case 12------------->");
        checkConditions(3, false, false, SELECTED_NONE);


        System.out.println("<-----------Test Case 13------------->");
        checkConditions(0, true, true, POSITIVE);

        System.out.println("<-----------Test Case 14------------->");
        checkConditions(1, true, false, POSITIVE);

        System.out.println("<-----------Test Case 15------------->");
        checkConditions(2, false, true, POSITIVE);

        System.out.println("<-----------Test Case 16------------->");
        checkConditions(3, false, false, SELECTED_NONE);
*/

        System.out.println("P : " + p);
        System.out.println("f : " + f);
    }

    private static Stream<String> getPermutations() {
        //do permutation;
        return Stream.empty();
    }

    private static char getLowerAsciiChar(char[] chars) {
        char ans = 1000;
        for (char c : chars)
            if ((('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) && (c < ans))
                ans = c;
        return ans;
    }


    private static void checkConditions(int n, boolean l, boolean m, String expected) {
        life = l;
        medical = m;
        System.out.println("Life : " + life);
        System.out.println("Medical : " + medical);

        isShowLife = false;
        isShowMedical = false;
        isShowBoth = false;
        isShowSelection = !life && !medical;

        producerList.clear();
        switch (n) {
            case 0: {
                producerList.add(new Producer(true, "123", "123"));
                break;
            }
            case 1: {
                producerList.add(new Producer(true, "123", null));
                break;
            }
            case 2: {
                producerList.add(new Producer(true, null, "123"));
                break;
            }
            default: {
                producerList.add(new Producer(true, null, null));
                break;
            }
        }

        Producer servicingProducer;
        Optional<Producer> servicingProducerOptional = producerList.stream().filter(e -> e.isServicingAgent).findFirst();

        if (servicingProducerOptional.isPresent())
            servicingProducer = servicingProducerOptional.get();
        else
            return;

        if (servicingProducer.lifeLicense != null
                && servicingProducer.medicalLicense != null) {
            isLifeLicenseExists = true;
            isMedicalLicenseExists = true;
        } else if (servicingProducer.lifeLicense != null) {
            isLifeLicenseExists = true;
            isMedicalLicenseExists = false;
        } else if (servicingProducer.medicalLicense != null) {
            isLifeLicenseExists = false;
            isMedicalLicenseExists = true;
        } else {
            isLifeLicenseExists = false;
            isMedicalLicenseExists = false;
        }
        System.out.println("isLifeLicenseExists : " + isLifeLicenseExists);
        System.out.println("isMedicalLicenseExists : " + isMedicalLicenseExists);


        if (!isLifeLicenseExists && !isMedicalLicenseExists) {
            if (life || medical) {
                isShowBoth = true;
            }
        } else {
            if (life && !isLifeLicenseExists) {
                isShowLife = true;
            }
            if (medical && !isMedicalLicenseExists) {
                isShowMedical = true;
            }
        }


        if (isShowLife)
            output = LIFE_MESSAGE;
        else if (isShowMedical)
            output = MEDICAL_MESSAGE;
        else if (isShowBoth)
            output = BOTH_MESSAGE;
        else if (isShowSelection)
            output = SELECTED_NONE;
        else
            output = POSITIVE;
        System.out.println(output);
        System.out.println();
        if (output.equals(expected)) {
            System.out.println("Passed");
            p++;
        } else {
            System.out.println("Failed");
            f++;
        }

    }

    private static void checkValidations() {

        Producer servicingProducer;
        Optional<Producer> servicingProducerOptional = producerList.stream().filter(e -> e.isServicingAgent).findFirst();

        if (servicingProducerOptional.isPresent())
            servicingProducer = servicingProducerOptional.get();
        else
            return;

        if (servicingProducer.lifeLicense != null
                && servicingProducer.medicalLicense != null) {
            isLifeLicenseExists = true;
            isMedicalLicenseExists = true;
        } else if (servicingProducer.lifeLicense != null) {
            isLifeLicenseExists = true;
            isMedicalLicenseExists = false;
        } else if (servicingProducer.medicalLicense != null) {
            isLifeLicenseExists = false;
            isMedicalLicenseExists = true;
        } else {
            isLifeLicenseExists = false;
            isMedicalLicenseExists = false;
        }

        if (!isLifeLicenseExists && !isMedicalLicenseExists) {
            isShowLife = false;
            isShowMedical = false;
            isShowBoth = true;
        } else if (!isLifeLicenseExists) {
            if (life)
                isShowLife = true;
            isShowMedical = false;
            isShowBoth = false;
        } else if (!isMedicalLicenseExists) {
            isShowLife = false;
            if (medical)
                isShowMedical = true;
            isShowBoth = false;
        }
    }

    private static void show() {

        if (isShowLife)
            output = LIFE_MESSAGE;
        else if (isShowMedical)
            output = MEDICAL_MESSAGE;
        else if (isShowBoth)
            output = BOTH_MESSAGE;
        else if (isShowSelection)
            output = SELECTED_NONE;
        else
            output = POSITIVE;
        System.out.println(output);
    }

    void streams() {

        List<Employee> employees = new ArrayList<>();

        //filter
        List<Employee> employeeListStartWithS =
                employees.stream().filter(e -> e.getName().startsWith("s")).
                        collect(Collectors.toList());

        //map
        List<String> employeeNames =
                employees.stream().map(employee -> employee.getName()).
                        collect(Collectors.toList());

        // Map vs FlatMap
        List<Integer> odds = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> evens = Arrays.asList(2, 4, 6, 8);

        //map
        List<Stream<Integer>> combinedByMap =
                Stream.of(odds,
                        evens).map(Collection::stream).collect(Collectors.
                        toList());
        combinedByMap.forEach(System.out::println);
        //java.util.stream.ReferencePipeline$Head@3feba861
        //java.util.stream.ReferencePipeline$Head@5b480cf9

        // Flat map
        List<Integer> combinedByFlatMap =
                Stream.of(odds,
                        evens).flatMap(Collection::stream).collect(Collectors.
                        toList());
        combinedByFlatMap.forEach(System.out::println);
        // 1 3 5 7 9 2 4 6 8

        //peek
        List<Employee> updateEmployees =
                employees.stream().peek(e -> e.setSalary(e.getSalary() + 100)).
                        collect(Collectors.toList());

        //sorted
        List<Employee> sortedEmployeeNames =
                employees.stream().sorted().collect(Collectors.toList());

        //Common Mistakes
        //1. trying to collect primitive data as list
        // compiler error
        // IntStream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        //2. accessing streams second time
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        IntStream intStream = IntStream.of(1, 1, 1, 1, 1);
        intStream.forEach(System.out::print);
        intStream.forEach(System.out::print);

        //3. Creating infinite loops
        IntStream.iterate(0, i -> i + 1).forEach(System.out::println);

    }
}
