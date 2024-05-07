package com.github.mcengine.items;

import java.lang.reflect.Method;
import org.bukkit.inventory.ItemStack;

public class manager {
    public static ItemStack getItem(String className, String item) {
        try {
            Class<?> clazz = Class.forName("com.github.mcengine.items." + className);
            Method method = clazz.getMethod(item);
            return (ItemStack) method.invoke(null);
        } catch (Exception e) {
            return null;
        }
    }
}