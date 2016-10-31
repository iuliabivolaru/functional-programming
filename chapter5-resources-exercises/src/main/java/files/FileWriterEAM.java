/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.AutoCloseable;
import java.util.function.Consumer;
import java.util.function.Function;

public class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close called automatically...");
        writer.close();
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }
    //...

    public static <V> V use(final String fileName,
                            final Function<FileWriterEAM, V> block) throws IOException {

        final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
        try {
            return block.apply(writerEAM);
        } finally {
            writerEAM.close();
        }
    }

    public static <T, V> Function<T,V> wrapExceptions(UseInstance<T, V, IOException> block) {
        return (T arg) -> {
            try {
                return block.accept(arg);
            } catch (IOException ioex) {
                throw new UncheckedIOException(ioex);
            }
        };
    }

    public static void main(final String[] args) throws IOException {

        System.out.println("//" + "START:EAM_USE_OUTPUT");

        UseInstance<FileWriterEAM, String, IOException> lamdaForWriter = writerEAM -> {
            writerEAM.writeStuff("sweet");
            return "sweet";
        };
        String value = FileWriterEAM.use("eam.txt", wrapExceptions(lamdaForWriter));

        System.out.println("//" + "END:EAM_USE_OUTPUT");

        FileWriterEAM.use("eam2.txt", writerEAM -> {
            writerEAM.writeStuff("how");
            writerEAM.writeStuff("sweet");
        });

    }

}
