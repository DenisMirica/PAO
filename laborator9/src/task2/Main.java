package task2;

public class Main {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounterImpl();

        wordCounter.parse("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Etiam sit amet nisl purus in mollis nunc sed id. In ornare quam viverra orci. Laoreet non curabitur gravida arcu ac tortor dignissim convallis aenean. Habitant morbi tristique senectus et netus et malesuada. Vitae suscipit tellus mauris a diam maecenas sed enim ut. Lacus luctus accumsan tortor posuere ac ut consequat. Eleifend mi in nulla posuere. Purus sit amet volutpat consequat. Ut sem viverra aliquet eget.\n" +
                "\n" +
                "Aliquet porttitor lacus luctus accumsan. Sapien faucibus et molestie ac feugiat sed. Sed risus pretium quam vulputate dignissim suspendisse. Senectus et netus et malesuada fames ac turpis egestas. Ullamcorper velit sed ullamcorper morbi. Ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam. Enim facilisis gravida neque convallis a. Sed felis eget velit aliquet. Ac orci phasellus egestas tellus rutrum tellus pellentesque. Sed felis eget velit aliquet. Ut porttitor leo a diam sollicitudin tempor id eu. Amet cursus sit amet dictum sit amet. Scelerisque purus semper eget duis. Egestas maecenas pharetra convallis posuere morbi leo urna molestie at.\n" +
                "\n" +
                "A diam maecenas sed enim. Turpis tincidunt id aliquet risus feugiat in. Duis convallis convallis tellus id interdum. Ac feugiat sed lectus vestibulum. Accumsan tortor posuere ac ut consequat semper viverra. Tortor vitae purus faucibus ornare. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor. Vestibulum lectus mauris ultrices eros. Amet nisl suscipit adipiscing bibendum est ultricies integer. Suspendisse potenti nullam ac tortor vitae. Egestas maecenas pharetra convallis posuere. Magna sit amet purus gravida quis blandit turpis. Ac tincidunt vitae semper quis lectus nulla at. Vitae sapien pellentesque habitant morbi tristique senectus et. Risus at ultrices mi tempus imperdiet nulla malesuada.\n" +
                "\n" +
                "Urna condimentum mattis pellentesque id nibh tortor id. Lobortis mattis aliquam faucibus purus in massa tempor nec. Viverra accumsan in nisl nisi scelerisque eu ultrices vitae auctor. Praesent elementum facilisis leo vel fringilla est ullamcorper. Et malesuada fames ac turpis egestas. Lacinia at quis risus sed. Ullamcorper eget nulla facilisi etiam dignissim diam quis enim. Urna nunc id cursus metus. Feugiat pretium nibh ipsum consequat. Viverra maecenas accumsan lacus vel facilisis volutpat. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt vitae. Varius morbi enim nunc faucibus a pellentesque sit amet porttitor. Lobortis feugiat vivamus at augue eget arcu dictum. Aliquam etiam erat velit scelerisque in dictum non. Id ornare arcu odio ut sem.\n" +
                "\n" +
                "Senectus et netus et malesuada fames ac turpis egestas. Morbi tristique senectus et netus et. Arcu risus quis varius quam quisque id diam vel quam. Metus vulputate eu scelerisque felis imperdiet proin. Commodo odio aenean sed adipiscing diam donec adipiscing tristique risus. Sit amet consectetur adipiscing elit ut. Interdum consectetur libero id faucibus nisl tincidunt. Sapien et ligula ullamcorper malesuada. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Morbi blandit cursus risus at ultrices mi. Varius morbi enim nunc faucibus a pellentesque. Donec enim diam vulputate ut pharetra sit amet. Cursus mattis molestie a iaculis at erat. Id diam maecenas ultricies mi eget. Adipiscing elit duis tristique sollicitudin.");

        System.out.println("Count of 'Lorem': " + wordCounter.getCount("Lorem"));
        System.out.println("Count of 'ipsum': " + wordCounter.getCount("ipsum"));
        System.out.println("Count of 'dolor': " + wordCounter.getCount("dolor"));
        System.out.println("Unique words: " + wordCounter.getUniqueWords());

        System.out.println("Word counts:");
        wordCounter.printWordCounts();

        wordCounter.reset();
        System.out.println("After reset:");
        wordCounter.printWordCounts();
    }
}
