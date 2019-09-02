import java.util.HashMap;

public class Registry {
    private static HashMap<String, HashMap<String, NamedObject>> registry;

    static {
        setRegistry(new HashMap<String, HashMap<String, NamedObject>>());
    }

    public static HashMap<String, HashMap<String, NamedObject>> getRegistry() {
        return registry;
    }

    public static void setRegistry(HashMap<String, HashMap<String, NamedObject>> registry) {
        Registry.registry = registry;
    }

    public void Registry() {}

    public void add(String category, NamedObject namedObject) {
        if (!getRegistry().containsKey(category)) {
            getRegistry().put(category, new HashMap<String, NamedObject>());
        }
        getRegistry().get(category).put(namedObject.getName(), namedObject);
    }

    public NamedObject get(String category, String name) {
        return getRegistry().get(category).get(name);
    }
}
