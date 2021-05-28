import java.util.List;

public class TableSym {
    private String type;
    private String kind;
    private List<String> paramTypes;
    private SymTable structInfo;

    public TableSym(String type, String kind) {
        this.type = type;
        this.kind = kind;
        paramTypes = null;
        structInfo = null;
    }

    public TableSym(String type, String kind, List<String> parTypes) {
        this.type = type;
        this.kind = kind;
        paramTypes = parTypes;
    }

    public TableSym(SymTable sinfo) {
        type = "Struct";
        kind = "Struct";
        paramTypes = null;
        structInfo = sinfo;
    }

    public String getType() {
        return type;
    }

    public String getKind() {
        return kind;
    }

    public List<String> getParamTypes() {
        return paramTypes;
    }

    public SymTable getStructInfo() {
        return structInfo;
    }

    public String toString() {
        return type;
    }
}
