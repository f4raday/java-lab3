package Loaders;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SummationLoader extends ClassLoader{

    private static final String JAR_PATH = "C:\\DATA\\Projects\\Java\\lab01\\out\\artifacts\\lab01.jar";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            JarFile jarLib = new JarFile(JAR_PATH);
            JarEntry jarEntry;
            jarEntry = jarLib.getJarEntry(
                    name.replace(".", "/") + ".class");
            InputStream libInputStream = jarLib.getInputStream(jarEntry);

            byte[] classBytes = new byte[(int) jarEntry.getSize()];
            if (libInputStream.read(classBytes) != classBytes.length) {
                throw new IOException("No....");
            }

            return defineClass(name, classBytes, 0, classBytes.length);

        } catch (IOException e) {
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }


}
