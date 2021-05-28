/**
 * Tests the SymTable and Sym classes
 */
public class MyP1 {

    /**
     * Tests non-boundary input and getType() response for Sym Object
     */
    private void symTest1() {
        Sym normSym = new Sym("int");
        String res = normSym.getType();

        if (res.compareTo("int") != 0) {
            System.out.println("symTest1 failed: Created Sym object returned "
                    + res + " instead of expected: int");
        }
    }

    /**
     * Tests boundary input of empty string and getType response for Sym Object
     */
    private void symTest2() {
        Sym weirdSym = new Sym("");
        String res = weirdSym.getType();

        if (res.compareTo("") != 0) {
            System.out.println("symTest2 failed: Created Sym object returned "
                    + res + " instead of expected: \"\"");
        }
    }

    /**
     * Tests input of string of numbers and getType() response for Sym Object
     */
    private void symTest3() {
        Sym weirdSym = new Sym("123");
        String res = weirdSym.getType();

        if (res.compareTo("123") != 0) {
            System.out.println("symTest3 failed: Created Sym object returned "
                    + res + " instead of expected: 123");
        }
    }

    /**
     * Tests non-boundary input and toString() response for Sym Object
     */
    private void symTest4() {
        Sym normSym = new Sym("int");
        String res = normSym.toString();

        if (res.compareTo("int") != 0) {
            System.out.println("symTest4 failed: Created Sym object returned "
                    + res + " instead of expected: int");
        }
    }

    /**
     * Tests boundary input of empty string and toString response for Sym Object
     */
    private void symTest5() {
        Sym weirdSym = new Sym("");
        String res = weirdSym.toString();

        if (res.compareTo("") != 0) {
            System.out.println("symTest5 failed: Created Sym object returned "
                    + res + " instead of expected: \"\"");
        }
    }

    /**
     * Tests input of string of numbers and toString() response for Sym Object
     */
    private void symTest6() {
        Sym weirdSym = new Sym("123");
        String res = weirdSym.toString();

        if (res.compareTo("123") != 0) {
            System.out.println("symTest6 failed: Created Sym object returned "
                    + res + " instead of expected: 123");
        }
    }

    /**
     * Tests normal functionality of addDecl method for SymTable Object
     */
    private void tableTest1() {
        SymTable normTable = new SymTable();
        try {
            normTable.addDecl("num", new Sym("int"));
        } catch (EmptySymTableException e) {
            System.out.println("tableTest1 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest1 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests normal functionality of addScope method for SymTable Object
     */
    private void tableTest2() {
        SymTable normTable = new SymTable();
        try {
            normTable.addScope();
        } catch (Exception e) {
            System.out.println("tableTest2 failed: Created SymTable object" +
                    " threw " + e.getClass().getName() + " unexpectedly");
        }
    }

    /**
     * Tests normal functionality of lookupLocal method for SymTable Object
     */
    private void tableTest3() {
        SymTable normTable = new SymTable();
        try {
            normTable.addDecl("num", new Sym("int"));
            Sym result = normTable.lookupLocal("num");
            if (result.getType().compareTo("int") != 0) {
                System.out.println("tableTest3 failed: Created SymTable object"
                        + " did not return correct Sym after addDecl()," +
                        " lookupLocal(), and getType() calls");
            }
        } catch (EmptySymTableException e) {
            System.out.println("tableTest3 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest3 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests normal functionality of lookupGlobal method for SymTable Object
     */
    private void tableTest4() {
        SymTable normTable = new SymTable();
        try {
            normTable.addDecl("num", new Sym("int"));
            Sym result = normTable.lookupGlobal("num");
            if (result.getType().compareTo("int") != 0) {
                System.out.println("tableTest4 failed: Created SymTable object"
                       + " did not return correct Sym after addDecl(), " +
                        "lookupGlobal(), and getType() calls");
            }
        } catch (EmptySymTableException e) {
            System.out.println("tableTest4 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest4 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests normal functionality of removeScope method for SymTable Object
     */
    private void tableTest5() {
        SymTable normTable = new SymTable();
        try {
            normTable.removeScope();
        } catch (EmptySymTableException e) {
            System.out.println("tableTest5 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        }
    }

    /**
     * Tests normal functionality of print method for SymTable Object
     */
    private void tableTest6() {
        SymTable normTable = new SymTable();
        try {
            normTable.addDecl("num", new Sym("int"));
            normTable.addDecl("bool", new Sym("boolean"));
            normTable.addScope();
            normTable.addDecl("dec", new Sym("float"));
            System.out.println("Testing print() output");
            System.out.println("Received output:");
            normTable.print();
            System.out.println("Expected output:");
            System.out.println("{dec=float}");
            System.out.println("{bool=boolean, num=int}");

        } catch (EmptySymTableException e) {
            System.out.println("tableTest6 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest6 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests functionality of addDecl method when given empty strings
     * for name and type
     */
    private void tableTest7() {
        SymTable weirdTable = new SymTable();
        try {
            weirdTable.addDecl("", new Sym(""));
        } catch (EmptySymTableException e) {
            System.out.println("tableTest7 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest7 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests whether addDecl throws a DuplicateSymException
     * when given duplicate Sym objects
     */
    private void tableTest8() {
        SymTable weirdTable = new SymTable();
        try {
            weirdTable.addDecl("num", new Sym("int"));
            weirdTable.addDecl("num", new Sym("float"));
            System.out.println("tableTest8 failed: Created SymTable object" +
                    " failed to throw a DuplicateSymException when given" +
                    " two Syms with the same name");
        } catch (EmptySymTableException e) {
            System.out.println("tableTest8 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            // Correct result
        }
    }

    /**
     * Tests whether the SymTable objects holds up
     * when given a large number of addDecl calls
     */
    private void tableTest9() {
        SymTable weirdTable = new SymTable();
        try {
            for (int i = 0; i < 1000000; i++) {
                weirdTable.addDecl("" + i, new Sym("float"));
            }
        } catch (EmptySymTableException e) {
            System.out.println("tableTest9 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest9 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        } catch (Exception e) {
            System.out.println("tableTest9 failed: Created SymTable object" +
                    " threw an exception when given a large" +
                    " number of addDecl calls");
        }
    }

    /**
     * Tests whether the SymTable objects holds up
     * when given a large number of addScope calls
     */
    private void tableTest10() {
        SymTable weirdTable = new SymTable();
        try {
            for (int i = 0; i < 1000000; i++) {
                weirdTable.addScope();
            }
        } catch (Exception e) {
            System.out.println("tableTest10 failed: Created SymTable object" +
                    " threw an exception when given a large" +
                    " number of addScope calls");
        }
    }

    /**
     * Tests whether the SymTable object correctly throws an
     * EmptySymTableException when lookupLocal called on an empty table
     */
    private void tableTest11() {
        SymTable weirdTable = new SymTable();
        try {
            weirdTable.removeScope();
            weirdTable.lookupLocal("name");
            System.out.println("tableTest11 failed: Created SymTable object" +
                    " failed to throw an EmptySymTableException when" +
                    " lookupLocal called on a table after removeScope");
        } catch (EmptySymTableException e) {
            // Correct result
        }
    }

    /**
     * Tests whether lookupLocal correctly returns null when no match is found
     */
    private void tableTest12() {
        SymTable weirdTable = new SymTable();
        try {
            weirdTable.addDecl("num", new Sym("int"));
            weirdTable.addDecl("asdf", new Sym("float"));
            Sym result = weirdTable.lookupLocal("name");
            if (result != null) {
                System.out.println("tableTest12 failed: Created SymTable" +
                        " returned a Sym object with lookupLocal when there" +
                        " was no matching Sym object in the table");
            }
        } catch (EmptySymTableException e) {
            System.out.println("tableTest12 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest12 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests whether lookupGlobal will return the correct
     * Sym Object when there are multiple scopes
     */
    private void tableTest13() {
        SymTable weirdTable = new SymTable();
        Sym test = new Sym("int");
        try {
            weirdTable.addDecl("num", test);
            weirdTable.addDecl("name", new Sym("float"));
            weirdTable.addScope();
            weirdTable.addDecl("asdf", new Sym("boolean"));
            Sym result = weirdTable.lookupGlobal("num");
            if (result != test) {
                System.out.println("tableTest13 failed: Created SymTable" +
                        " object returned incorrect Sym or returned null when" +
                        " lookupGlobal was called");
            }
        } catch (EmptySymTableException e) {
            System.out.println("tableTest13 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest13 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests whether lookupGlobal returns first instance of Sym object that
     * matches when there are matching Syms in multiple scopes
     */
    private void tableTest14() {
        SymTable weirdTable = new SymTable();
        Sym test = new Sym("int");
        try {
            weirdTable.addDecl("num", new Sym("boolean"));
            weirdTable.addDecl("name", new Sym("float"));
            weirdTable.addScope();
            weirdTable.addDecl("num", test);
            Sym result = weirdTable.lookupGlobal("num");
            if (result != test) {
                System.out.println("tableTest14 failed: Created SymTable" +
                        " object returned incorrect Sym or returned null when" +
                        " lookupGlobal was called");
            }
        } catch (EmptySymTableException e) {
            System.out.println("tableTest14 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        } catch (DuplicateSymException e) {
            System.out.println("tableTest14 failed: Created SymTable object" +
                    " threw a DuplicateSymException unexpectedly");
        }
    }

    /**
     * Tests whether the removeScope method would
     * correctly throw an EmptySymTableException
     */
    private void tableTest15() {
        SymTable weirdTable = new SymTable();
        try {
            weirdTable.removeScope();
            weirdTable.removeScope();
            System.out.println("tableTest15 failed: Created SymTable object" +
                    " failed to throw EmptySymTableException when removeScope" +
                    " was called on an empty SymTable");
        } catch (EmptySymTableException e) {
            // Correct result
        }
    }

    /**
     * Tests whether the SymTable object can handle
     * a large number of addScope and removeScope calls consecutively
     */
    private void tableTest16() {
        SymTable weirdTable = new SymTable();
        try {
            for (int i = 0; i < 1000000; i++) {
                weirdTable.addScope();
            }
            for (int i = 1; i < 1000000; i++) {
                weirdTable.removeScope();
            }
        } catch (EmptySymTableException e) {
            System.out.println("tableTest14 failed: Created SymTable object" +
                    " threw an EmptySymTableException unexpectedly");
        }
    }

    public static void main(String[] args) {
        // Test Object
        MyP1 tester = new MyP1();
        // Sym tests
        tester.symTest1();
        tester.symTest2();
        tester.symTest3();
        tester.symTest4();
        tester.symTest5();
        tester.symTest6();

        // SymTable tests
        tester.tableTest1();
        tester.tableTest2();
        tester.tableTest3();
        tester.tableTest4();
        tester.tableTest5();
        tester.tableTest6();
        tester.tableTest7();
        tester.tableTest8();
        tester.tableTest9();
        tester.tableTest10();
        tester.tableTest11();
        tester.tableTest12();
        tester.tableTest13();
        tester.tableTest14();
        tester.tableTest15();
        tester.tableTest16();
    }
}
