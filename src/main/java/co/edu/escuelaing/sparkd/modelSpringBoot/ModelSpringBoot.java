/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.sparkd.modelSpringBoot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rojas
 */

public class ModelSpringBoot {
    
    private Map<String, Method> beans = new HashMap<>();
    public void start(String[] args) throws Exception {
        int mapped = 0;
        for (Method m : Class.forName(args[0]).getMethods()) {
            if (m.isAnnotationPresent(RequestMapping.class)) {
                System.out.println("Si esta anotado con RequestMapping");
                try {
                    beans.put(m.getAnnotation(RequestMapping.class).value(),m);
                    //beans.put("Get the value ",m);
                    mapped++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    
                }}}
       // System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
    public String invoke(String path){
        try {
            return beans.get(path).invoke(null).toString();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModelSpringBoot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ModelSpringBoot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ModelSpringBoot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error";
    }

}

