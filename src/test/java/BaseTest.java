import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseTest {
    @DataProvider(name = "dp")
    public Object[][] getData(Method fileName) {
        String path = new File(System.getProperty("user.dir")).getPath()+"/testdata";
        System.out.println("filename is " + path + "/" + fileName.getName() + ".txt");
        List<String> arrayList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path + "/" + fileName.getName() + ".txt"))) {
            arrayList = stream
                    .filter(s -> !s.contains("#"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][] array = new Object[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            String row = arrayList.get(i);
            array[i] = Arrays.stream(row.split(" ")).toArray();
        }
        System.out.println(Arrays.deepToString(array));
        return array;
    }

}

