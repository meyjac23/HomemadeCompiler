import java.util.*;

/**
 * Table keeps track of all of the identifiers in the source program
 * @author Jake Meyer
 * @version 1.0
 */
public class SymTable {

    // List of all of the scopes in the program, current scope is at top of list
    private LinkedList<HashMap<String, Sym>> scopes;

    /**
     * Initialize scopes list and add a single empty HashMap
     * to the front of the list
     */
    public SymTable() {
        scopes = new LinkedList<>();
        scopes.push(new HashMap<>());
    }

    /**
     * Add a declaration to the current scope,
     * assuming that no exceptions have been thrown
     * @param name the identifier's ID, if you will
     * @param sym Object that holds information on the identifier's type
     * @throws DuplicateSymException Same name cannot appear twice in the map
     * @throws NullPointerException Neither parameter can have a value of 'null'
     * @throws EmptySymTableException The scopes list cannot be empty
     */
    public void addDecl(String name, Sym sym) throws DuplicateSymException,
            EmptySymTableException
    {
        HashMap<String, Sym> currScope = scopes.peek();

        if (scopes.isEmpty()) throw new EmptySymTableException();
        if (name == null || sym == null) throw new NullPointerException();
        if (currScope.containsKey(name)) throw new DuplicateSymException();

        currScope.put(name, sym);
    }

    /**
     * Add a new HashMap to the scopes list when encountering a new scope
     */
    public void addScope() {
        scopes.push(new HashMap<>());
    }

    /**
     * Check the current scope for the identifier 'name'
     * @param name the identifier's ID, if you will
     * @return Sym object if found, otherwise null
     * @throws EmptySymTableException The scopes list cannot be empty
     */
    public Sym lookupLocal(String name) throws EmptySymTableException {
        if (scopes.isEmpty()) throw new EmptySymTableException();

        HashMap<String, Sym> currScope = scopes.peek();
        return currScope.getOrDefault(name, null);
    }

    /**
     * Check every scope for the identifier 'name' and
     * return the first successful result
     * @param name the identifier's ID, if you will
     * @return Sym object if found, otherwise null
     * @throws EmptySymTableException The scopes list cannot be empty
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException {
        if (scopes.isEmpty()) throw new EmptySymTableException();

        HashMap<String, Sym> currScope;
        for (HashMap<String, Sym> scope : scopes) {
            currScope = scope;
            if (currScope.containsKey(name)) return currScope.get(name);
        }
        return null;
    }

    /**
     * Remove the current scope (i.e. the first in the scopes list)
     * @throws EmptySymTableException The scopes list cannot be empty
     */
    public void removeScope() throws EmptySymTableException {
        if (scopes.isEmpty()) throw new EmptySymTableException();

        scopes.pop();
    }

    /**
     * Use for debugging purposes. Prints contents of each scope.
     */
    public void print() {
        System.out.print("\nSym Table\n");
        for (HashMap<String, Sym> scope: scopes){
            System.out.println(scope.toString());
        }
        System.out.println();
    }
}
