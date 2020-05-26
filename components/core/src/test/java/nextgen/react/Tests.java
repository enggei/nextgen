package nextgen.react;

import nextgen.react.st.App;
import nextgen.react.st.ReactFactory;
import nextgen.react.st.ReactGenerator;
import org.junit.Test;

public class Tests {

    @Test
    public void testApp() {

        final ReactGenerator reactGenerator = new ReactGenerator();

        final App app = ReactFactory.newApp()
                .addComponents(ReactFactory.newAppComponents()
                        .setName("App"));

        System.out.println(reactGenerator.generate(app));
    }
}
