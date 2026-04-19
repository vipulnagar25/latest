package di;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleDIContainer {

    private Map<Class<?>, Object> container = new HashMap<>();

    public void register(Class<?> clazz) throws Exception {

        if (clazz.isAnnotationPresent(Component.class)) {

            Object instance = clazz.getDeclaredConstructor().newInstance();
            container.put(clazz, instance);
        }
    }

    public void injectDependencies() throws Exception {

        for (Object object : container.values()) {

            Field[] fields = object.getClass().getDeclaredFields();

            for (Field field : fields) {

                if (field.isAnnotationPresent(Inject.class)) {

                    Object dependency = container.get(field.getType());

                    field.setAccessible(true);
                    field.set(object, dependency);
                }
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return clazz.cast(container.get(clazz));
    }
}