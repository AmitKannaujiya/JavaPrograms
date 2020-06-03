package javaConcept.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExamples {
    public static void main(final String[] args) throws IOException {
        final StreamsExamples obj = new StreamsExamples();
        System.out.println("################## IntStream ###################");
        obj.inteStream();
        System.out.println("################## Stream ###################");
        obj.stringStream();
        obj.fileStrem();
        obj.reduceStrem();
         
    }



    private void reduceStrem() {
        double d = Stream.of(3.4, 5.6, 7.8, 9.0).reduce(0.0, (Double d1, Double d2) -> d1 + d2);
        System.out.println(d);
    }

    private void fileStrem() throws IOException {
        // Path currentRelativePath = Paths.get("src//javaConcept//streams//words.txt");
        // String s = currentRelativePath.toAbsolutePath().toString();
        // System.out.println("Current relative path is: " + s);
        System.out.println("############### First Example ###############");
        final Stream<String> stream = Files.lines(Paths.get("src//javaConcept//streams//words.txt"));
        System.out.println(stream.filter(str -> str.startsWith("A")).count());
        stream.close();
        System.out.println("############### Second Example ###############");
        final List<String> list = Files.lines(Paths.get(
                "src//javaConcept//streams//words.txt"))
            .filter(x -> x.contains("it")).collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    private void stringStream() {
        System.out.println("############### First Example ###############");
        Stream.of("Kannu", "Amit", "Vijay", "Seema", "Ashish", "Aman").filter(s -> s.startsWith("A")).sorted()
                .forEach(System.out::println);
        System.out.println("############### Second Example ###############");
        Arrays.stream(new String[] { "Amit", "Vijay", "Seema", "Ashish" }).sorted((i, j) -> j.compareTo(i))
                .forEach(System.out::println);

        Arrays.stream(new int[] { 2, 3, 4, 1, 2, 3, 1, 4 }).sorted().forEach(System.out::println);
        Arrays.stream(new int[] {}).average().ifPresent(System.out::println);

        Arrays.stream(new String[] { "Kannu", "Amit", "Vijay", "Seema", "Ashish", "Aman" }).map(String::toLowerCase)
                .filter(str -> str.startsWith("a")).forEach(System.out::println);
    }

    private void inteStream() {
        System.out.println("############### First Example ###############");
        IntStream.range(1, 10).forEach(i -> System.out.println(i));
        System.out.println("############### Second Example ###############");
        IntStream.range(1, 10)
                // .skip(5)
                .forEach(System.out::println);
        System.out.println("############### Third Example ###############");

        System.out.println(IntStream.range(2, 5).sum());
        System.out.println("############### Fourth Example ###############");

        IntSummaryStatistics intSummaryStates = IntStream.of(3,2,6,78,8,23).summaryStatistics();
        System.out.println(intSummaryStates);

    }
}