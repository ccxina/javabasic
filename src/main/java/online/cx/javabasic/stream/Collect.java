package online.cx.javabasic.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Cao Xin
 * @since 2021/3/11
 * 流的收集
 */
public class Collect {

    public static void main(String[] args) {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        Map<String, String> stringMap = locales.collect(Collectors.toMap(Locale::getDisplayLanguage, l -> l.getDisplayLanguage(l), (t1, t2)-> t1));
        System.out.println(stringMap);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> setMap = locales
                .collect(Collectors.toMap(
                            Locale::getDisplayCountry,
                            l -> Collections.singleton(l.getDisplayLanguage()),
                            (a, b) -> {
                                Set<String> union = new HashSet<>(a);
                                union.addAll(b);
                                return union;
                            },
                            TreeMap::new
                        ));
        System.out.println(setMap);
    }
}
