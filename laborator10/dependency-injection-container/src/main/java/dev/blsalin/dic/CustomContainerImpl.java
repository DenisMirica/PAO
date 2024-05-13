package dev.blsalin.dic;

import java.io.Closeable;
import java.util.Map;
import java.util.function.Function;
import java.util.HashMap;

public class CustomContainerImpl implements CustomContainer {

    private final Map<String, Object> instances = new HashMap<>();
    private final Map<Class<?>, Function<CustomContainer, ?>> factoryMethods = new HashMap<>();

    @Override
    public <T> boolean addInstance(T instance) {
        if (instance == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        return addInstance(instance, instance.getClass().getSimpleName());
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (instance == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        if (customName == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        if (instances.containsKey(customName)) {
            throw new IllegalStateException("Instances cannot be redeclared");
        }
        instances.put(customName, instance);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        for (Object instance : instances.values()) {
            if (type.isInstance(instance)) {
                return type.cast(instance);
            }
        }
        for (Map.Entry<Class<?>, Function<CustomContainer, ?>> entry : factoryMethods.entrySet()) {
            if (type.isAssignableFrom(entry.getKey())) {
                T instance = (T) entry.getValue().apply(this);
                if (instance != null) {
                    instances.put(type.getSimpleName(), instance);
                    return instance;
                }
            }
        }
        throw new IllegalStateException("Cannot provide instance");
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null || customName == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        Object instance = instances.get(customName);
        if (instance == null) {
            for (Map.Entry<Class<?>, Function<CustomContainer, ?>> entry : factoryMethods.entrySet()) {
                if (type.isAssignableFrom(entry.getKey())) {
                    T newInstance = (T) entry.getValue().apply(this);
                    if (newInstance != null) {
                        instances.put(customName, newInstance);
                        return newInstance;
                    }
                }
            }
            throw new IllegalStateException("Cannot provide instance");
        } else {
            if (!type.isInstance(instance)) {
                throw new IllegalStateException("Invalid type for object");
            }
            return type.cast(instance);
        }
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if (type == null || factoryMethod == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        factoryMethods.put(type, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }

        if (!factoryMethods.containsKey(type)) {
            throw new IllegalStateException("Cannot provide instance");
        }

        Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factoryMethods.get(type);

        T newInstance = factoryMethod.apply(this);

        if (newInstance != null) {
            return newInstance;
        }

        throw new IllegalStateException("Cannot provide instance");
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }

        if (!factoryMethods.containsKey(type)) {
            throw new IllegalStateException("Cannot provide instance");
        }

        Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factoryMethods.get(type);

        if (parameters == null || parameters.isEmpty()) {
            T newInstance = factoryMethod.apply(this);
            if (newInstance != null) {
                return newInstance;
            }
        } else {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                addInstance(entry.getValue(), entry.getKey());
            }
            T newInstance = factoryMethod.apply(this);
            if (newInstance != null) {
                return newInstance;
            }
        }

        throw new IllegalStateException("Cannot provide instance");
    }



    @Override
    public void close() throws Exception {
        for (Object instance : instances.values()) {
            if (instance instanceof Closeable) {
                ((Closeable) instance).close();
            }
        }
        instances.clear();
    }
}
