package reflectionHelper;

/**
 * Created by clr on 06.12.2016.
 */
public enum Types {
    BYTE,
    BOOLEAN,
    SHORT,
    CHAR,
    INT,
    FLOAT,
    LONG,
    DOUBLE,
    STRING;

    public static Types getType(Class<?> clazz) {
        String className = clazz.getSimpleName().toUpperCase();
        return Types.valueOf(className);
    }
}
