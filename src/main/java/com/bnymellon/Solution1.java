package com.bnymellon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Enum operations problem- fetch enum value by name and vice versa
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int codeFromDB = scan.nextInt();
        try {
            System.out.println(EmpCode.getEnum(codeFromDB));
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        scan.close();
    }
}

// complete the enum definition
enum EmpCode {
    ASSOCIATE(10001),
    SENIOR_ASSOCIATE(10002),
    MANAGER(10003),
    SENIOR_MANAGER(10004);


    private int code;

    EmpCode(int code) {
        this.code = code;
    }

    private static final Map<Integer, EmpCode> map = new HashMap<>();

    static {
        for (EmpCode empCode : EmpCode.values()) {
            map.put(empCode.code, empCode);
        }
    }


    // also implement this method properly
    public static EmpCode getEnum(int code) {

        EmpCode empCode = map.get(code);
        if (empCode == null)
            throw new IllegalArgumentException("Value not found");
        return empCode;


    } // end of public enum EmpCode
}
