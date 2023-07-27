package co.com.bancolombia.utils;

import co.com.bancolombia.exceptions.ParamNotFoundException;
import org.gradle.api.logging.Logger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {

    private static final String SEPARATOR = "/";
    private static final String PARAM_START = "{{";
    private static final String PARAM_END = "}}";

    private static final int PARAM_LENGTH = 2;


    public static String getVersionPlugin() {
        return Constants.PLUGIN_VERSION;
    }

    public static String joinPath(String... args) {
        return String.join(SEPARATOR, args);
    }

    public static String extractDir(String path) {
        int index = path.lastIndexOf(SEPARATOR);
        if (index != -1) {
            return path.substring(0, index);
        } else {
            return null;
        }
    }

    public static String formatTaskOptions(List<?> options) {
        return "["
                + options.stream().map(Object::toString).sorted().collect(Collectors.joining("|"))
                + "]";
    }

    public static String fillPath(String path, Map<String, Object> params) throws ParamNotFoundException{

        while (path.contains(PARAM_START)) {
            String key = path.substring(path.indexOf(PARAM_START) + PARAM_LENGTH, path.indexOf(PARAM_END));
            if (params.containsKey(key)) {
                path = path.replace(PARAM_START + key + PARAM_END, params.get(key).toString());
            }else {
                throw new ParamNotFoundException(key);
            }
        }
        return path;
    }

    public static String capitalize(String data) {
        char[] c = data.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        return new String(c);
    }
}
